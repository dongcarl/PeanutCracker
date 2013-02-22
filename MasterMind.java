package PeanutCracker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * Editted with Aptana Studio 3
 * Creator: dongcarl
 * Editor: Buck
 * Date: 2/1/13
 * Time: 2:56 PM
 */

//TODO write a zeros function
public class MasterMind implements Operator
{
	Double substitute;
	String modFunction;
	public static ArrayList<Double> xPoints = new ArrayList<Double>();
	public static ArrayList<Double> yPoints = new ArrayList<Double>();
	public static ArrayList<Function> Functions = new ArrayList<Function>();
	public static ArrayList<Window> Windows = new ArrayList<Window>();

	public static void main(String[] args)
	{
		/*
		 * A series to test Mastermind class from inputing a function through graphing
		 */
		//array list of elements that will make up the function
		ArrayList<Element> jake = new ArrayList<Element>();
		//make a series of monomial to add to the above list
		jake.add(new Monomial(1, 3));
		jake.add(new Monomial(1,0));
		//add the arraylist of elements to the function
		Function terry = new Function(jake);
		//make a new window with range -5 to 5 in the x value, testing every 1 unit
		Window witherspoon = new Window(-5, 5, 1, -5, 5, .05);
		MasterMind mindy = new MasterMind(terry, 0, witherspoon);
	}
	public MasterMind(Function func, int operation, Window walrus)
	{
		//on creation, add a new function, a new window
		Functions.add(func);
		Windows.add(walrus);
		//generates an arraylist of the x points of a function
		ArrayList<Double> x = processXPoints(func, walrus);
		//generates an arraylist of the y points of the function
		ArrayList<Double> y = processFunction(func, operation, walrus);
		//make sure the lists are the same size
		while (x.size()>y.size()) x.remove(x.size()-1);
		while (y.size()>x.size()) y.remove(y.size()-1);
		//now prepare and send the data to the graphing classes
		mailToGraph(x, y, walrus);
	}
	public static ArrayList<Double> getZeroes(Function func, int operation, Window walrus)
	{
		//not really used
		//returns the xcoordinates of any zeroes
		//if a zero is predicted between two points, then  it is aproximated by a linearization connecting the two points
		//this is only as accurate as the resolution, because it can miss zeroes if there is no change in sign or exact match
		ArrayList<Double> x = processXPoints(func, walrus);
		ArrayList<Double> y = processFunction(func, operation, walrus);
		ArrayList<Double> zero = new ArrayList<Double>();
		for (int i = 0; i<x.size()-1 && i<y.size()-1; i++)
		{
			if (y.get(i) == 0 )
			{
				zero.add(x.get(i));
			}
			else if (y.get(i)<0 && y.get(i+1)>0 || y.get(i)>0 && y.get(i+1)<0)
			{
				//a zero is somewhere between two points on a continuous function (one positive, one negative)
				double y1 = y.get(i);
				double y2 = y.get(i+1);
				double x1 = x.get(i);
				double x2 = x.get(i+1);
				//the ratio of the distance from x1 to the estimated zero vs x2 to the estimated zero is 
				//	proportional to distance from y1 to 0 vs y2 to 0 ---> Math.abs(y1/y2)
				//	when the estimate is a line
				double xd = Math.abs(x2-x1);
				double estd = xd*Math.abs(y1/y2);
				double estimate = x1+estd;
				//add the linear estimate
				zero.add(estimate);
			}
		}
		return zero;
	}
	public static Window optimizeWindow(ArrayList<Double> x, ArrayList<Double> y, Window walrus)
	{
		//sets the window to include the maximum and minimum points of the function within the x range
		double xmax = walrus.getXmax();
		double xmin = walrus.getXmin();
		double xres = walrus.getXres();
		double ymax = walrus.getYmax();
		double ymin = walrus.getYmin();
		double yres = walrus.getYres();
		for (Double xp : x)
		{
			if ((xp*1.1)<xmin)
			{
				xmin = xp*1.1;
			}
			if ((xp*1.1)>xmax)
			{
				xmax = xp*1.1;
			}
			xres = walrus.getXres()*((xmax-xmin)/(walrus.getXmax()-walrus.getXmin()));
		}
		for (Double yp : y)
		{
			if ((yp*1.1)<xmin)
			{
				ymin = yp*1.1;
			}
			if ((yp*1.1)>xmax)
			{
				ymax = yp*1.1;
			}
			xres = walrus.getYres()*((ymax-ymin)/(walrus.getYmax()-walrus.getYmin()));
		}
		Window wammy = new Window(xmax, xmin, xres, ymax, ymin, yres);
		return wammy;
	}
	public static void mailToGraph(ArrayList<Double> xpoints, ArrayList<Double> ypoints, Window w)
	{
		//make a new graph frame with the coordinates xpoints, ypoints, window w
		new GraphFrame(xpoints, ypoints, w);
	}
	public static ArrayList<Double> processXPoints(Function func, Window walrus)
	{
		//generate a list of the x coordinates of the function for the window
		xPoints = new ArrayList<Double>();
		for (double x = walrus.getXmin(); x<=walrus.getXmax(); x+=walrus.getXres())
		{
			xPoints.add(x);
		}
		return xPoints;
	}
	public static ArrayList<Double> processFunction(Function func, int operation, Window walrus)
	{
		//Operation 0 = none, 1 = integrate, -1 = derive
		//generate a list of the ypoints by subsituting each x point
		ArrayList<Double> yPoints = new ArrayList<Double>();
		walrus.getXmin();
		walrus.getXmax();
		walrus.getXres(); //units per pixel
		double xrange = walrus.getXmax()-walrus.getXmin();
		double xcount = xrange/walrus.getXres();
		for (double x = walrus.getXmin(); x<=walrus.getXmax(); x+=walrus.getXres())
		{
			yPoints.add((double) substitute(func,x));
		}
		if (operation == 0)
		{
			//if the operation is do nothing, return the y points
			return yPoints;
		}
		else if (operation == 1)
		{
			//now I'm looking to estimate the integral
			ArrayList<Double> integral = new ArrayList<Double>();
			double width = walrus.getXres();
			double sum = 0;
			for (Double y : yPoints)
			{
				//add the height times the xstep to the accumulator function
				sum += y*width;
				integral.add(sum);
			}
			//return the integral
			return integral;
		}
		else if (operation == -1)
		{
			//now estimating the slope/derivative
			ArrayList<Double> derivative = new ArrayList<Double>();
			double width = walrus.getXres();
			double slope = 0;
			for (int i = 0; i < yPoints.size() - 1 ; i++)
			{
				//look at the change in rise and run for an approximate secant
				double rise = yPoints.get(i+1)-yPoints.get(i);
				slope = rise/width;
				derivative.add(slope);
			}
			return derivative;
		}
		else if (operation != 0)
		{
			//entertaining error message
			System.out.println("Bad operation passed, function evaluated as operation = 0. Please try again.\n    - Sincerely MGMT");
		}
		return yPoints;
	}
	public Function operate(Function dave)
	{
		//called so that the function operates on itself, and it should return a new function with no operation
		//this will be moved to the mastermind class
		if (dave.checkOp())
		{
			Function carl = dave;
			if (carl.getOperator() == Operators.SUBSTITUTION)
			{
				double frank = substitute(carl,substitute);
				Constant fred = new Constant(frank);
				carl = new Function();
				carl.add(fred);
			}
			else if (carl.getOperator() == Operators.DERIVATIVE)
			{
				carl = differentiate(carl);
			}
			else if (carl.getOperator() == Operators.INTEGRAL)
			{
				carl = integrate(carl);
			}
			carl.setOperator(Operators.NONE);
			return carl;
		}
		else
		{
			return dave;
		}
	}
	private static double substitute(Function mode, double replace)
	{
		//substitutes and evaluates the function for the given variable in place of "x"
		Function mod = mode;
		System.out.println(mod);
		double sum = 0.0;
		int count = 0;
		for (Element e : mod)
		{
			count++;
			Constant charlie = e.substitute(replace);
			sum += charlie.getValue();
			//System.out.println("charlie sum #"+count+" = "+sum);
			//should return a constant function with one element e
		}
		return sum;
	}
	private Function integrate(Function mode)
	{
		//finding the integral of the function
		//generalized with symbolic calculations
		Function mod = mode;
		for (Element e:mod)
		{
			e = e.derive();
		}
		return mod;
	}
	private Function differentiate(Function mode)
	{
		//finding the derivative of the function
		//generalized with symbolic calculations		
		Function mod = mode;
		for (Element e:mod)
		{
			e = e.derive();
		}
		return mod;
	}
}