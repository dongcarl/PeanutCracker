package PeanutCracker;

import java.util.ArrayList;

public class Function extends ArrayList<Element> implements Operator
{
	/**
	 * generated serializable version UID added because it is a serializable class
	 */
	//parametric function
	//limits
	//integrals
	//differentiation
	
	private static final long serialVersionUID = -1852458274303596909L;
	//add to an interface Constants
	
	Operators operator = Operators.NONE;
	Double substitute;
	String modFunction;
	public Function()
	{
		
	}
	public Function(ArrayList<Element> func)
	{
		//create a function from an arraylist of elements, default operation is none
		this(func, Operators.NONE);
		System.out.println("single input constructor reached");
	}
	public Function(ArrayList<Element> func, Operators op)
	{
		//create a function from an arraylist of elements, operation is set
		System.out.println("two input constructor reached");
		this.setFunction(func);
		System.out.println("size of func = "+func.size());
		operator = op;
	}
	public void setFunction(ArrayList<Element> func)
	{
		//set the function to be the array list of elements
		//remove previous function
		this.removeAll(this);
		
		for(Element e: func)
		{
			//add in the pieces
			this.add(e);
		}
	}
	public void setOperator(Operators mone)
	{
		//sets the enum operator
		operator = mone;
	}
	public ArrayList<Element> getFunction()
	{
		return this;
	}
	public Operators getOperator()
	{
		return operator;
	}
	public boolean checkOp()
	{
		//check to see if Op is not none or unset
		boolean sam = true;
		if (operator == Operators.NONE)
		{
			sam = false;
		}
		return sam;
	}
	public boolean checkFunc()
	{
		//checks to see if function has elements
		boolean sam = true;
		if (this.size()==0)
		{
			sam = false;
		}
		return sam;
	}
	public String toString()
	{
		String str = "";
		for(int i = 0; i<this.size(); i++)
		{
			str += " "+" element "+i;
		}
		return str;
	}
}
