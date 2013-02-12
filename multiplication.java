package PeanutCracker;

public class multiplication extends Element
{
	//element a multiplied by element b
	private Element left;
	private Element right;
	private boolean reduceable;

	public multiplication()
	{
		left = new constant();
		right = new constant();
	}
	public multiplication(Element l, Element r)
	{
		left = l;
		right = r;
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
	public boolean checkRedux()
	{
		if (left.getName().equals("constant") || right.getName().equals("constant")) return true;
		else return false;
	}
	public Element getReduction()
	{
		if (reduceable)
		{
			if (left.getName().equals("constant") && right.getName().equals("constant"))
			{
				return new constant(left.substitute(1).getValue()+right.substitute(1).getValue());
			}
			else if (left.getName().equals("constant"))
			{
				double value = left.substitute(1).getValue();
				Element redux = right;
				redux.multiConstant(value);
				return redux;
			}
			else if (right.getName().equals("constant"))
			{
				double value = right.substitute(1).getValue();
				Element redux = left;
				redux.multiConstant(value);
				return redux;
			}
			else
			{
				//not sure what other conditions result in multiplication
				return this;
			}
		}
		else
		{
			return this;
		}
	}
}
