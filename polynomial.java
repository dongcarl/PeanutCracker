package PeanutCracker;

import java.util.ArrayList;

public class polynomial extends Element 
{
	//a list of polyElements, mostly just a container
	ArrayList<Element> subElements = new ArrayList<Element>();
	public polynomial(ArrayList<Element> addlist)
	{
		subElements = addlist;
	}
	public polynomial()
	{
		subElements = new ArrayList<Element>();
	}
	public void sortElements()
	{
		//sort elements by power
	}
	public Element derive()
	{
		for (Element p:subElements)
		{
			p = (polyElement) (p.derive());
		}
		return new polynomial(subElements);
	}
	public Element integrate()
	{
		for (Element p:subElements)
		{
			p = p.integrate();
		}
		return new polynomial(subElements);
	}
	public constant substitute(double replace)
	{
		//substitutes and evaluates the function for the given variable in place of "x"
		double sum = 0.0;
		for (Element p:subElements)
		{
			constant charlie = p.substitute(replace);
			sum += charlie.getValue();
			//should return a constant function with one element e
		}
		constant mary = new constant(sum);
		return mary;
	}
}
