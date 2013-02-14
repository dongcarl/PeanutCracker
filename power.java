package PeanutCracker;

public class Power extends Element 
{
	//this class is equivalent to a base raised to the x power times constant
	//the default base is E, default constant is 1
	double base = Math.E;
	double constant = 1;
	
	public Power(double bas, double constan)
	{
		name = "power";
		base = bas;
		constant = constan;
	}
	public Power(double bas)
	{
		this(bas,1);
	}
	public Power()
	{
		this(Math.E);
	}
	public Element derive()
	{
		//TODO fix method
		//ln(base) times base to the x
		return null;
	}
	public Element integrate()
	{
		//TODO fix method
		//1 divided by base to the x times lnbase
		return null;
	}
	public Constant substitute(double d)
	{
		return new Constant((Math.pow(base, d)*constant));
	}
}
