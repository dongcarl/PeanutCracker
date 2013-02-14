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

	public ParseBrain()
	{
		preParen.add("ln"); preParen.add("sin"); preParen.add("cos"); preParen.add("tan");  
			preParen.add("arcsin"); preParen.add("arccos"); preParen.add("arctan"); 
			preParen.add("*"); preParen.add("/"); preParen.add("+"); preParen.add("-");
			preParen.add("=");
	}
	public static void main(String[] args)
	{
		String testInputString = "10*(1+x^2)+ln(x)";
		System.out.println(testInputString);
		parse(testInputString);
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
	private static void scanCopySplit(String str)
	{
		scan(str);
		copySplit(str);
	}
	private static void scan(String str)
	{
		//scan the first string for elements (paren, +, -)
		//first scan for parentheses
		int i = 0;
		int parenLevel = 0;
		int startParen = -1;
		int endParen = -1;
		boolean parenInProgress = false;
		sparen = new ArrayList<Integer>();
		eparen = new ArrayList<Integer>();
		while (i < str.length())
		{
			if (str.substring(i,i+1).equals("("))
			{
				parenLevel = parenLevel+1;
			}
			if (str.substring(i,i+1).equals(")"))
			{
				parenLevel = parenLevel-1;
			}
			if (parenLevel == 0 && parenInProgress == false)
			{
				//happens during no paren
				startParen = i;
				parenInProgress = true;
			}
			else if (parenLevel == 0 && parenInProgress == true)
			{
				endParen = i;
				parenInProgress = false;
				sparen.add(startParen);
				eparen.add(endParen);
				setPreElement(str, startParen);
				startParen = -1;
				endParen = -1;
			}
			i++;
		}
		//now look for + and - to finish split scan
		for (int f = 0 ; f < str.length() ; f++)
		{
			if (str.substring(f,f+1).equals("+"))
			{
				operations.add(i);
			}
			else if (str.substring(f,f+1).equals("-"))
			{
				operations.add(-i);
			}
		}
	}
	public static void setPreElement(String str, int index)
	{
		for (String func : preParen)
		{
			String add = "+";
			if (index>func.length())
			{
				String ssub = str.substring(index-func.length(),index);
				if (ssub.equals(func))
				{
					add = func;
				}
			}
			pparen.add(add);
		}
	}
	public static void copySplit(String inputString)
	{
		//split into strings that represent one element (parens and others)
		//aka parens, then anything between
		//look for the first element, either to plus or to minus or to paren
		//then end? or next element, either paren or plus or minus, repeat
		ArrayList<Integer> sparenCopy = sparen;
		ArrayList<Integer> eparenCopy = eparen;
		ArrayList<Integer> opCopy = operations;
		splits = new ArrayList<String>();
		int i = 0;
		int pLevel = 0;
		int opLevel = 0;
		int splitsLevel = 0;
		while (i < inputString.length())
		{
			if (pLevel>=sparenCopy.size() || pLevel>=eparenCopy.size() || opLevel >= opCopy.size())
			{
				break;
			}
			//find the earliest item in the list (sparen or operation)
			if (sparenCopy.get(pLevel)<opCopy.get(opLevel))
			{
				splits.add(inputString.substring(i,Math.abs(eparenCopy.get(pLevel)+1)));
				System.out.println("Just added split - "+splits.get(splitsLevel));
				i = eparenCopy.get(pLevel)+1;
				pLevel++;
				splitsLevel++;
			}
			else
			{
				splits.add(inputString.substring(i,opCopy.get(opLevel)+1));
				System.out.println("just added split - "+splits.get(splitsLevel));
				i = opCopy.get(opLevel)+1;
				opLevel++;
				splitsLevel++;
			}
		}
		
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
					return new Logarithm();
				}
			}
			System.out.println("Converted to constant("+cons+")");
			return new Constant(cons);
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
				return new Monomial(1,power);
			}
			else
			{
				System.out.println("Converted to polyElement x");
				return new Monomial(1,1);
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
