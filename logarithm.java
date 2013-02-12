package PeanutCracker;

public class logarithm extends Element 
{
	//equivalent to log base base of (x) times constant
	double base = Math.E;
	double constant = 1;
	public logarithm(double bas, double constan)
	{
		name = "logarithm";
		base = bas;
		constant = constan;
	}
	public logarithm(double bas)
	{
		this(bas, 1);
	}
	public logarithm()
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
	public constant substitute(double d)
	{
		return new constant((Math.pow(base, d)*constant));
	}
}
