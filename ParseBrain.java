package PeanutCracker;

import java.util.ArrayList;

public class ParseBrain 
{
	static ArrayList<Integer> sparen = new ArrayList<Integer>(); //list of all start parens index
	static ArrayList<Integer> eparen = new ArrayList<Integer>(); //list of end parens index
	static ArrayList<Integer> iSplit = new ArrayList<Integer>(); //list of all of the split points for a function
	static ArrayList<String> splits = new ArrayList<String>(); //list of the split strings between, parentheses, +, -, etc.
	static ArrayList<Integer> operations = new ArrayList<Integer>(); //list of +, -
	static ArrayList<Integer> equals = new ArrayList<Integer>(); //list of "="
	static ArrayList<Integer> endFunc = new ArrayList<Integer>(); //the list of where we find ; to end functions
	static ArrayList<Element> funcParts = new ArrayList<Element>(); //the parts of the function to send out
	static ArrayList<String> preParen = new ArrayList<String>(); //the possible operations before each element
	static ArrayList<String> pparen = new ArrayList<String>(); //the operation before each element
	static ArrayList<Integer> finElements = new ArrayList<Integer>();

	public ParseBrain()
	{
		preParen.add("ln"); preParen.add("sin"); preParen.add("cos"); preParen.add("tan");  
		preParen.add("arcsin"); preParen.add("arccos"); preParen.add("arctan"); 
		preParen.add("*"); preParen.add("/"); preParen.add("+"); preParen.add("-");
		preParen.add("=");
	}
	public static void main(String[] args)
	{
		String testInputString = "(*10;5ln);4;3x^2";
		System.out.println(testInputString);
		parse(testInputString);
		//		for (int i = 0; i < splits.size(); i++)	funcParts.add(convertString(splits.get(i)));
	}
	public static Function parse(String rawInputString)
	{
		//takes in a raw string, and then convert it to a function
		ArrayList<Element> basicFunction = new ArrayList<Element>();
		Function jerrymander = new Function(basicFunction);
		//System.out.println("trying to fix delimiters");
		String InputString = rawInputString;//fixDelimiters(rawInputString);
		//System.out.println("Fixed delimiters "+InputString);
		scan(rawInputString);
		split(rawInputString);
		testSplits();
		//at this point, the function has been split into its basic elements parens and added components
		return jerrymander;
	}
	public static void testSplits() 
	{
		for (String str : splits)
		{
			int i = search(str,"(");
			int index = splits.indexOf(str);
			if (i == -1)
			{
				convertToElement(str, index);
			}
			else
			{
				//TODO fixParens(str, index);
			}
		}
	}
	public static void convertToElement(String str, int index)
	{
		Element newElement;
		if (str.length()==0)
		{
			newElement = new Constant(0);
		}
		int search = search(str, "ln");
		if (search!=-1)
		{
		//if it matches the natural log format [constant]ln[ignored] make it a ln
			if (search(str, "ln")==0)
			{
				newElement = new Logarithm(Math.E);
			}
			else
			{
				double con = 1;
				try 
				{
					con = Double.parseDouble(str.substring(0,search(str, "ln")));
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Syntax error");
				}
				newElement = new Logarithm(Math.E, con);
			}
		}
		search = search(str, "x^");
		if (search!=-1)
		{
			//if it matches the pattern[constant]x^[power]
			String powerString = "";
			double power;
			try
			{
				powerString = str.substring(search+2);
			}
			catch(IndexOutOfBoundsException ioobe)
			{
				power = 0;
				System.out.println("Syntax error");
			}
			try
			{
				power = Double.parseDouble(powerString);
			}
			catch(NumberFormatException nfe)
			{
				power = 0;
			}
			if (search==0)
			{
				newElement = new Monomial(1,(int) power);
			}
		}
		else
		{
			newElement = new Constant(0);
		}
		funcParts.add(index, newElement);
	}
	public static void scan(String str)
	{
		int i = 0;
		int inParen = 0;
		iSplit = new ArrayList<Integer>();
		while(i < str.length())
		{
			if (inParen == 0)
			{
				if(str.substring(i,i+1).equals("("))
				{
					inParen++;
				}
				else if(str.substring(i,i+1).equals(")"))
				{
					inParen--;
				}
				else if (str.substring(i,i+1).equals(";"))
				{
					iSplit.add(i);
					System.out.println("; found at "+i);
				}
			}
			else
			{
				if(str.substring(i,i+1).equals("("))
				{
					inParen++;
				}
				else if(str.substring(i,i+1).equals(")"))
				{
					inParen--;
				}
			}
			System.out.println("inParen = "+inParen+" , i = "+i);
			i++;
		}
	}
	public static void split(String str)
	{
		int i = 0;
		int index = 0;
		while(i<iSplit.size())
		{
			System.out.println("iSplit.get(i) = "+iSplit.get(i));
			splits.add(str.substring(index, iSplit.get(i)));
			System.out.println("string = "+str.substring(index, iSplit.get(i)));
			index = iSplit.get(i)+1;
			i++;
		}
		splits.add(str.substring(iSplit.get(i-1)+1));
		String printstr = "";
		for (String s :splits)
		{
			printstr += " + "+s;
		}
		System.out.println(str);
		String printstr2 = "";
		for (Integer im : iSplit)
		{
			printstr2 += " "+im;
		}
		System.out.println(printstr2.substring(3));
		System.out.println(printstr.substring(3));
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
