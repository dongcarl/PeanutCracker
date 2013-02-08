package PeanutCracker;

public class power extends Element 
{
	//this class is equivalent to a base raised to the x power times constant
	//the default base is E, default constant is 1
	double base = Math.E;
	double constant = 1;
	
	public power(double bas, double constan)
	{
		base = bas;
		constant = constan;
	}
	public power(double bas)
	{
		this(bas,1);
	}
	public power()
	{
		this(Math.E);
	}
	public Element derive()
	{
		
	}
	public Element integrate()
	{
		
	}
	public Element substitute(double d)
	{
		return new constant((Math.pow(base, d)*constant);
	}
}
