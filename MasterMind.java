package PeanutCracker;

import java.io.ObjectStreamException;
import java.util.ArrayList;

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
	ArrayList<Double> xpoints = new ArrayList<Double>();
	public static void main(String[] args)
	{
		MasterMind cake = new MasterMind();
		ArrayList<Element> jake = new ArrayList<Element>();
		Polynomial polly = new Polynomial();
		polly.addElement(new Monomial(1, 1));
		//polly.addElement(new Monomial(3, 6));
		//polly.addElement(new Monomial(3, 1));
		//polly.addElement(new Monomial(.5 , (int) .5));
		jake.add(polly);
		Function terry = new Function(jake);
		Window witherspoon = new Window();
		ArrayList<Double> values = processFunction(terry, 0, witherspoon);
		double dou = 0;
		int val = 0;
		System.out.println("values");
		for (Double d : values)
		{
			dou = (double) d;
			val = (int) dou;
			System.out.print(" "+val);
		}
		ArrayList<Double> derivs = processFunction(terry, -1, witherspoon);
		System.out.println("\nslopes");
		for (Double e : derivs)
		{
			dou = (double) e;
			val = (int) dou;
			System.out.print(" "+val);
		}
		ArrayList<Double> integs = processFunction(terry, 1, witherspoon);
		System.out.println("\nintegs");
		for (Double f : integs)
		{
			dou = (double) f;
			val = (int) dou;
			System.out.print(" "+val);
		}
	}
	public MasterMind()
	{
		//The constructor takes in a ControlCenter to pass messages to
	}
	public static ArrayList<Double> processFunction(Function func, int operation, Window walrus)
	{
		//Operation 0 = none, 1 = integrate, -1 = derive
		ArrayList<Double> yPoints = new ArrayList<Double>();
		walrus.getXmin();
		walrus.getXmax();
		walrus.getXres(); //units per pixel
		double xrange = walrus.getXmax()-walrus.getXmin();
		double xcount = xrange/walrus.getXres();
		for (double x = walrus.getXmin(); x<=walrus.getXmax(); x+=walrus.getXres())
		{
			yPoints.add(substitute(func,x));
		}
		if (operation == 0)
		{
			return yPoints;
		}
//		return yPoints;
		else if (operation == 1)
		{
			//now I'm looking to estimate the integral
			System.out.println("\nYou are now in the twilight zone");
			ArrayList<Double> integral = new ArrayList<Double>();
			double width = walrus.getXres();
			double sum = 0;
			for (Double y : yPoints)
			{
				sum += y;
				System.out.print(" "+sum);
				integral.add(sum);
			}
		}
		else if (operation == -1)
		{
			//now estimating the slope
			System.out.println("\nYou are now in the twifright zone");
			ArrayList<Double> derivative = new ArrayList<Double>();
			double width = walrus.getXres();
			double slope = 0;
			for (int i = 0; i < yPoints.size() - 1 ; i++)
			{
				double rise = yPoints.get(i+1)-yPoints.get(i);
				slope = rise/width;
				System.out.print(""+slope);
				derivative.add(slope);
			}
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
	public static ArrayList<ArrayList<Double>> getPoints(Function mode, Window wind)
	{
		ArrayList<ArrayList<Double>> setup = new ArrayList<ArrayList<Double>>(2);
		ArrayList<Double> xpoints = new ArrayList<Double>();
		ArrayList<Double> ypoints = new ArrayList<Double>();
		double xmi = wind.xmin;
		double xma = wind.xmax;
		double xdif = xma-xmi;
		double xcount = xdif*wind.xres;
		double xval;
		for (int i = 0; i<=xcount; i++)
		{
			xval = xma+(i*(xdif/xcount));
			xpoints.add(xval);
			ypoints.add(substitute(mode, xval));
		}
		setup.add(xpoints);
		setup.add(ypoints);
		return setup;
	}
	private static double substitute(Function mode, double replace)
	{
		//substitutes and evaluates the function for the given variable in place of "x"
		Function mod = mode;
		double sum = 0.0;
		for (Element e:mod)
		{
			Constant charlie = e.substitute(replace);
			sum += charlie.getValue();
			//should return a constant function with one element e
		}
		return sum;
	}
	private Function integrate(Function mode)
	{
		Function mod = mode;
		for (Element e:mod)
		{
			e = e.derive();
		}
		return mod;
	}
	private Function differentiate(Function mode)
	{
		Function mod = mode;
		for (Element e:mod)
		{
			e = e.derive();
		}
		return mod;
	}
}