package PeanutCracker;

import java.util.ArrayList;
import java.util.Collections;

public class polynomial extends Element
{
	//a list of polyElements, mostly just a container
	ArrayList<polyElement> subElements = new ArrayList<polyElement>();
	public static void main(String[] args)
	{
		//testing sorting and such things
		ArrayList<polyElement> QB = new ArrayList<polyElement>();
		polyElement one = new polyElement(1,16);
		polyElement two = new polyElement(2,4);
		polyElement three = new polyElement(3,3);
		polyElement four = new polyElement(-6,-2);
		QB.add(three); QB.add(four); QB.add(one); QB.add(two);
		polynomial alex = new polynomial(QB);
		System.out.println("input poly");
		System.out.println(alex.printME());
		alex.sortElements();
		System.out.println("sorted poly");
		System.out.println(alex.printME());
//		alex = alex.derive();
//		System.out.println("derived poly");
//		System.out.println(alex.printME());
		alex = alex.integrate();
		System.out.println("integrated poly");
		System.out.println(alex.printME());
	}
	public polynomial(ArrayList<polyElement> addlist)
	{
		name = "polynomial";
		subElements = addlist;
	}
	public polynomial()
	{
		name = "polynomial";
		subElements = new ArrayList<polyElement>();
	}
	public void sortElements()
	{
		//sorts so that the biggest power is first
		Collections.sort(subElements);
		Collections.reverse(subElements);
	}
	public void addElement(polyElement p)
	{
		subElements.add(p);
		this.sortElements();
	}
	public polynomial derive()
	{
		ArrayList<polyElement> walter = new ArrayList<polyElement>();
		polyElement walt;
		for (Element p:subElements)
		{
			walt = (polyElement) (p.derive());
			walter.add(walt);
		}
		return new polynomial(walter);
	}
	public polynomial integrate()
	{
		ArrayList<polyElement> freder = new ArrayList<polyElement>();
		polyElement fred;
		for (Element p:subElements)
		{
			fred = (polyElement) (p.integrate());
			freder.add(fred);
		}
		return new polynomial(freder);
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
	public String printME()
	{
		String outer = "";
		for (polyElement p : subElements)
		{
			outer+= p.getConstant()+"x^"+p.getPower()+" + ";
		}
		outer = outer.substring(0,outer.length()-3);
		return outer;
	}
}