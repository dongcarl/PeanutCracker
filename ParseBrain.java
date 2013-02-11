package PeanutCracker;

import java.util.ArrayList;
import java.util.Collections;

public class ParseBrain 
{
	ArrayList<Integer> sparen = new ArrayList<Integer>(); //list of all start parens index
	ArrayList<Integer> eparen = new ArrayList<Integer>(); //list of end parens index
	ArrayList<Integer> iSplit = new ArrayList<Integer>(); //list of all of the split points for a function
	ArrayList<String> splits = new ArrayList<String>(); //list of the split strings between, parentheses, +, -, etc.
	ArrayList<Integer> operations = new ArrayList<Integer>(); //list of *, /, +, -
	ArrayList<Integer> equals = new ArrayList<Integer>();
	ArrayList<Integer> endFunc = new ArrayList<Integer>();

	public Function parse(String rawInputString)
	{
		//takes in a raw string, and then convert it to a function
		ArrayList<Element> basicFunction = new ArrayList<Element>();
		Function jerrymander = new Function(basicFunction);
		scanCopySplit(rawInputString);
		return jerrymander;
	}
	private void scan(String inputString)
	{
		for (int i = 0; i < inputString.length(); i++)
		{
			String str = inputString.substring(i,i+1);
			if (str.equals("("))
			{
				sparen.add(i);
			}
			else if (str.equals(")"))
			{
				eparen.add(i);
			}
			else if (str.equals("="))
			{
				equals.add(i);
			}
			else if (str.equals("/") || str.equals("+") || str.equals("-") || str.equals("*"))
			{
				operations.add(i);
			}
			else if (str.equals(";"))
			{
				endFunc.add(i);
			}
		}
	}
	public void copySplit()
	{
		assembleISplit();
		
	}
	public void assembleISplit()
	{
		//assemble list
		for (int j : sparen)
		{
			iSplit.add(j);
		}
		for (int j : eparen)
		{
			iSplit.add(j);
		}
		for (int j : operations)
		{
			iSplit.add(j);
		}
		for (int j : equals)
		{
			iSplit.add(j);
		}
		for (int j : endFunc)
		{
			iSplit.add(j);
		}
		Collections.sort(iSplit);
	}
	public void scanCopySplit(String inputString)
	{
		scan(inputString);
		copySplit();
	}
}
