package PeanutCracker;

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
	ControlCenter communication;
	ArrayList<Double> xpoints = new ArrayList<Double>();
	public static void main(String[] args)
	{
		MasterMind cake = new MasterMind(new ControlCenter());
		ArrayList<Element> jake = new ArrayList<Element>();
		polynomial polly = new polynomial();
		polly.addElement(new Monomial(15, 4));
		polly.addElement(new Monomial(3, 6));
		polly.addElement(new Monomial(3, 1));
		polly.addElement(new Monomial(.5 , (int) .5));
		jake.add(polly);
		Function terry = new Function(jake);
		terry = cake.operate(terry);
		Window witherspoon = new Window();
		ArrayList<ArrayList<Double>> masm = getPoints(terry, witherspoon);
		ArrayList<Double> xp = masm.get(0);
		ArrayList<Double> yp = masm.get(1);
		for (int i = 0; i < xp.size(); i++)
		{
			double xpoint = xp.get(i);
			double ypoint = yp.get(i);
			System.out.print(""+xpoint+","+ypoint+" ");
		}
	}
	public MasterMind(ControlCenter cathy)
	{
		//The constructor takes in a ControlCenter to pass messages to
		communication = cathy;
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
				constant fred = new constant(frank);
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
			constant charlie = e.substitute(replace);
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
