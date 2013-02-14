package PeanutCracker;

public class Constant extends Element 
{
//	public constant(String nam, double val)
//	{
//		name = nam;
//		value = val;
//	}
//	public constant(String nam)
//	{
//		this(nam, 0);
//	}
	public Constant(double val)
	{
		value = val;
		name = "constant";
	}
	public Constant()
	{
		this(0);
	}
	@Override
	public void multiConstant(double con)
	{
		value = con;
	}
	@Override
	public double getConstant()
	{
		return value;
	}
	public Element derive()
	{
		return new Constant(0.0);
	}
	public Element integrate()
	{
		return new Monomial(value, 1);
	}
	public double getValue()
	{
		return value;
	}
	public Constant substitute(double replace) 
	{
		return new Constant(value);
	}
}
