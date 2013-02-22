package PeanutCracker;

public class Logarithm extends Element 
{
	//equivalent to log base base of (x) times constant
	double base = Math.E;
	double constant = 1;
	public Logarithm(double bas, double constan)
	{
		name = "logarithm";
		base = bas;
		constant = constan;
	}
	public Logarithm(double bas)
	{
		this(bas, 1);
	}
	public Logarithm()
	{
		this(Math.E);
	}
	public Element derive()
	{
		//TODO fix method
		return null;
	}
	public Element integrate()
	{
		//TODO fix method
				return null;
	}
	public Constant substitute(double d)
	{
		return new Constant((Math.pow(base, d)*constant));
	}
}
