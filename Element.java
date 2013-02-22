package PeanutCracker;

public abstract class Element
{
	//the abstract element
	//elements add together to make a function
	
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
		//return the constant multiple out front of element
		return constant;
	}
	public void multiConstant(double con)
	{
		//multiply in a new constant
		constant = constant*con;
	}
}
