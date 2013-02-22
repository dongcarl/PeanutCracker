package PeanutCracker;

import java.util.ArrayList;

public class Paren extends Element
{
	ArrayList<Element> subElements;
	public Paren(ArrayList<Element> a)
	{
		subElements = a;
		name = "paren";
		
	}
	@Override
	public Element derive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Constant substitute(double replace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element integrate() {
		// TODO Auto-generated method stub
		return null;
	}

}
