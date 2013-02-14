package PeanutCracker;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial extends Element
{
	//a list of polyElements, mostly just a container
	ArrayList<Monomial> subElements = new ArrayList<Monomial>();
	public static void main(String[] args)
	{
		//testing sorting and such things
		ArrayList<Monomial> QB = new ArrayList<Monomial>();
		Monomial one = new Monomial(1,16);
		Monomial two = new Monomial(2,4);
		Monomial three = new Monomial(3,3);
		Monomial four = new Monomial(-6,-2);
		QB.add(three); QB.add(four); QB.add(one); QB.add(two);
		Polynomial alex = new Polynomial(QB);
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
	public Polynomial(ArrayList<Monomial> addlist)
	{
		name = "polynomial";
		subElements = addlist;
	}
	public Polynomial()
	{
		name = "polynomial";
		subElements = new ArrayList<Monomial>();
	}
	public void sortElements()
	{
		//sorts so that the biggest power is first
		Collections.sort(subElements);
		Collections.reverse(subElements);
	}
	public void addElement(Monomial p)
	{
		subElements.add(p);
		this.sortElements();
	}
	public Polynomial derive()
	{
		ArrayList<Monomial> walter = new ArrayList<Monomial>();
		Monomial walt;
		for (Element p:subElements)
		{
			walt = (Monomial) (p.derive());
			walter.add(walt);
		}
		return new Polynomial(walter);
	}
	public Polynomial integrate()
	{
		ArrayList<Monomial> freder = new ArrayList<Monomial>();
		Monomial fred;
		for (Element p:subElements)
		{
			fred = (Monomial) (p.integrate());
			freder.add(fred);
		}
		return new Polynomial(freder);
	}
	public Constant substitute(double replace)
	{
		//substitutes and evaluates the function for the given variable in place of "x"
		double sum = 0.0;
		for (Element p:subElements)
		{
			Constant charlie = p.substitute(replace);
			sum += charlie.getValue();
			//should return a constant function with one element e
		}
		Constant mary = new Constant(sum);
		return mary;
	}
	public String printME()
	{
		String outer = "";
		for (Monomial p : subElements)
		{
			outer+= p.getConstant()+"x^"+p.getPower()+" + ";
		}
		outer = outer.substring(0,outer.length()-3);
		return outer;
	}
}