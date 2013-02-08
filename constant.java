package PeanutCracker;

public class constant extends Element 
{
	double value;
	public constant(String nam, double val)
	{
		name = nam;
		value = val;
	}
	public constant(String nam)
	{
		this(nam, 0);
	}
	public constant(double val)
	{
		this("constant",val);
	}
	public constant()
	{
		this("constant");
	}
	public Element derive()
	{
		return new constant(0.0);
	}
	public Element substitute()
	{
		return this;
	}
	public double getValue()
	{
		return value;
	}
}
