package PeanutCracker;

public class constant extends Element 
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
	public constant(double val)
	{
		value = val;
		name = "constant";
	}
	public constant()
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
		return new constant(0.0);
	}
	public Element integrate()
	{
		return new polyElement(value, 1);
	}
	public double getValue()
	{
		return value;
	}
	public constant substitute(double replace) 
	{
		return new constant(value);
	}
}
