package PeanutCracker;

public abstract class Element
{
	public String name;
	public double value;
	
	public Element none()
	{
		return this;
	}
	public abstract Element derive();
	public abstract constant substitute(Double d);
	public abstract Element integrate();
}
