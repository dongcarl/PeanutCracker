package PeanutCracker;

import java.util.ArrayList;

public class rational extends division 
{
	polynomial top;
	polynomial bottom;
	
	public rational(polynomial tops, polynomial bottoms)
	{
		top = tops;
		bottom = bottoms;
	}
	public rational(polynomial tops)
	{
		ArrayList<polyElement> QB = new ArrayList<polyElement>();
		polyElement one = new polyElement(1,1);
		QB.add(one);
		polynomial barry = new polynomial(QB);
		top = tops;
		bottom = barry;
	}
	public polynomial derive()
	{
		//derive a rational function
	}
	public polynomial integrate()
	{
		//integrate a rational function
	}
	public constant substitute(double replace)
	{
		//substitutes and evaluates the function for the given variable in place of "x"
		constant t = top.substitute(replace);
		constant b = bottom.substitute(replace);
		double div = t.getValue()/b.getValue();
		constant mary = new constant(div);
		return mary;
	}
}
