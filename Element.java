package PeanutCracker;

public abstract class Element
{
	public String name;
	public double value;
	public double constant;
	
	public Element none()
	{
		return this;
	}
	public abstract Element derive();
	public abstract Constant substitute(double replace);
	public abstract Element integrate();
	public String getName()
	{
		return name;
	}
	public double getConstant()
	{
		return constant;
	}
	public void multiConstant(double con)
	{
		constant = constant*con;
	}
}
