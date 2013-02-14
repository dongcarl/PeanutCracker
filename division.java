package PeanutCracker;

public class Division extends Element 
{
	//element a divided by element b
	Element top;
	Element bottom;
	public Division(Element t, Element b)
	{
		name = "division";
		top = t;
		bottom = b;
	}
	public Division()
	{
		this(new Constant(0),new Constant(1));
	}
	public Element getTop() 
	{
		return top;
	}
	public void setTop(Element top) 
	{
		this.top = top;
	}
	public Element getBottom() 
	{
		return bottom;
	}
	public void setBottom(Element bottom) 
	{
		this.bottom = bottom;
	}
	@Override
	public Element derive() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Constant substitute(double replace) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element integrate() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
