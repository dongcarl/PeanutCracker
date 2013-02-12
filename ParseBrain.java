package PeanutCracker;

import java.util.ArrayList;
import java.util.Collections;

public class ParseBrain 
{
	//TODO I need to rewrite so that each paren is split up into its own thing, so that I don't miss things like ln(x), etc.
	//then split paren groups by multiplication, division
	//then split paren groups by addition, subtraction, into elements within the parens
	//then merge parens
	static ArrayList<Integer> sparen = new ArrayList<Integer>(); //list of all start parens index
	static ArrayList<Integer> eparen = new ArrayList<Integer>(); //list of end parens index
	static ArrayList<Integer> iSplit = new ArrayList<Integer>(); //list of all of the split points for a function
	static ArrayList<String> splits = new ArrayList<String>(); //list of the split strings between, parentheses, +, -, etc.
	static ArrayList<Integer> operations = new ArrayList<Integer>(); //list of *, /, +, -
	static ArrayList<Integer> equals = new ArrayList<Integer>();
	static ArrayList<Integer> endFunc = new ArrayList<Integer>();
	static ArrayList<Element> funcParts = new ArrayList<Element>();

	public static void main(String[] args)
	{
		String testInputString = "((165x^2/ln(x+1))*x^2)";
		System.out.println(testInputString);
		parse(testInputString);
		System.out.println("splits: "+printSplits());
		for (int i = 0; i < splits.size(); i++)	funcParts.add(convertString(splits.get(i)));
	}
	public static Function parse(String rawInputString)
	{
		//takes in a raw string, and then convert it to a function
		ArrayList<Element> basicFunction = new ArrayList<Element>();
		Function jerrymander = new Function(basicFunction);

		System.out.println("trying to fix delimiters");
		String InputString = fixDelimiters(rawInputString);
		System.out.println("Fixed delimiters "+InputString);
		scanCopySplit(InputString);

		return jerrymander;
	}
	private static void scan(String inputString)
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
	public static void copySplit(String inputString)
	{
		assembleISplit();
		String copyFull = new String(inputString);
		splits = new ArrayList<String>();
		for (int j = 0; j<iSplit.size()-1; j++)
		{
			int startIndex = iSplit.get(j)+1;
			int endIndex = copyFull.length();
			try
			{
				endIndex = iSplit.get(j+1);
			}
			catch (IndexOutOfBoundsException noobex)
			{
				System.out.println("index out of bounds exception caught");
				endIndex =  iSplit.get(j);
			}
			//System.out.println(startIndex+" "+endIndex);
			String cutString = copyFull.substring(startIndex, Math.max(startIndex,endIndex));
			splits.add(cutString);
		}
		//System.out.println("Splits finished");

	}
	public static void assembleISplit()
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
	public static String fixDelimiters(String str1)
	{
		String str = str1;
		//System.out.println("1");
		if (str.length() <= 1)
		{
			//	System.out.println("2");
			return str1;
		}
		else
		{
			//fix paren count
			//split numbers and x with a *
			int l = str.length();
			for (int i = 0 ; i < l-1; i++)
			{
				//		System.out.println("4 "+i);
				//		System.out.println(str.length()-1);
				String numQ = str.substring(i,i+1);
				String xQ = str.substring(i+1,i+2);
				if (numQ.equals("0") || numQ.equals("1") || numQ.equals("2") || numQ.equals("3") || numQ.equals("4") || 
						numQ.equals("5") || numQ.equals("6") || numQ.equals("7") || numQ.equals("8") || numQ.equals("9"))
				{
					if (xQ.equals("x"))
					{
						str = str.substring(0, i+1)+"*"+str.substring(i+1);
					}
				}
			}
			return str;
		}
	}
	public static void scanCopySplit(String inputString)
	{
		scan(inputString);
		copySplit(inputString);
	}
	public static String printSplits()
	{
		String fial = "";
		for (String str : splits)
		{
			fial = fial + " | "+str;
		}
		return fial.substring(2);
	}
	public static Element convertString(String str)
	{
		if (search(str, "x") == -1)
		{
			//if the string str doesn't have an x in it
			double cons = 0;
			try
			{
				cons = Double.parseDouble(str);
			}
			catch(NumberFormatException nfe)
			{
				if (search(str, "ln") != -1)
				{
					System.out.println("Converted to logarithm loge(x)");
					return new logarithm();
				}
			}
			System.out.println("Converted to constant("+cons+")");
			return new constant(cons);
		}
		else
		{
			if (search(str, "x^") != -1)
			{
				int startIndex = search(str, "x^")+2;
				String substr = str.substring(startIndex);
				int power;
				try
				{
					power = Integer.parseInt(substr);
				}
				catch(NumberFormatException nfe)
				{
					power = 0;
				}
				System.out.println("Converted to polyElement x^"+power);
				return new polyElement(1,power);
			}
			else
			{
				System.out.println("Converted to polyElement x");
				return new polyElement(1,1);
			}
		}
	}
	public static int search(String str, String target)
	{
		if (target.length()>str.length())
		{
			return -1;
		}
		else
		{
			for (int i = 0; i<=str.length()-target.length(); i++)
			{
				if (str.substring(i,i+target.length()).equals(target))
				{
					return i;
				}
			}
			return -1;
		}
	}
	public static int search(String str, String target, int startIndex)
	{
		if (target.length()>str.length())
		{
			return -1;
		}
		else
		{
			for (int i = startIndex; i<=str.length()-target.length(); i++)
			{
				if (str.substring(i,i+target.length()).equals(target))
				{
					return i;
				}
			}
			return -1;
		}
	}
}
