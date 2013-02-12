package PeanutCracker;

public class division extends Element 
{
	//element a divided by element b
	Element top;
	Element bottom;
	public division(Element t, Element b)
	{
		name = "division";
		top = t;
		bottom = b;
	}
	public division()
	{
		this(new constant(0),new constant(1));
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
	public constant substitute(double replace) 
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
