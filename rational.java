package PeanutCracker;

import java.util.ArrayList;

public class Rational extends Division 
{
	Polynomial top;
	Polynomial bottom;
	
	public Rational(Polynomial tops, Polynomial bottoms)
	{
		name = "bottom";
		top = tops;
		bottom = bottoms;
	}
	public Rational(Polynomial tops)
	{
		ArrayList<Monomial> QB = new ArrayList<Monomial>();
		Monomial one = new Monomial(1,1);
		QB.add(one);
		Polynomial barry = new Polynomial(QB);
		top = tops;
		bottom = barry;
	}
	public Polynomial derive()
	{
		//TODO fix method
		//derive a rational function
		return null;
	}
	public Polynomial integrate()
	{
		//TODO fix method
		//integrate a rational function
		return null;
	}
	public Constant substitute(double replace)
	{
		//substitutes and evaluates the function for the given variable in place of "x"
		Constant t = top.substitute(replace);
		Constant b = bottom.substitute(replace);
		double div = t.getValue()/b.getValue();
		Constant mary = new Constant(div);
		return mary;
	}
}
