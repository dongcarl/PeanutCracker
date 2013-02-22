package PeanutCracker;

import com.dessci.mathflow.sdk.editor.SimpleEditorFrame;
import com.dessci.mathflow.sdk.license.LicenseException;
import webeq3.util.EquationUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mentaregex.Regex.match;
import static org.mentaregex.Regex.matches;

/**
* Created with IntelliJ IDEA.
* User: dongcarl
* Date: 2/15/13
* Time: 10:11 PM
* To change this template use File | Settings | File Templates.
*/
public class newEditorFrame extends SimpleEditorFrame implements MouseListener
{

	public static Function currentFunc;
	@Override
	protected void closeEditorWindow()
	{
		System.out.println("raw data" + getMathML());

		String normalizedResult = Normalizer.normalize(getMathML());

		System.out.println("normalized: " + normalizedResult);

		ArrayList<String> polyMathMLArrayList = new ArrayList<String>(Arrays.asList(match(normalizedResult, "/(<mo>\\S+?</msup>)/g")));

		System.out.println("processed: " + polyMathMLArrayList.toString());

		ArrayList<Monomial> PolysMonomialForm = parseMathMLArrayList(polyMathMLArrayList);

		Function Polys = new Function();

		for (Monomial i: PolysMonomialForm)
		{
			Polys.add(i);
		}




		MasterMind mind = new MasterMind(Polys, 0, new Window(-10, 10, .001, -10, 10, .001));

		super.closeEditorWindow();    //To change body of overridden methods use File | Settings | File Templates.
	}


	private ArrayList<Monomial> parseMathMLArrayList(ArrayList polyArray)
	{
		ArrayList<Monomial> result = new ArrayList<Monomial>();

//		System.out.println("polyArray: " + polyArray.toString());

		for (Object i : polyArray)
		{
			String current = (String)i;
			double Coeff = 0;
			double Power = 0;
			int Sign = 0;
//			System.out.println("current: " + current);

			String[] foundCoeff = match(current, "/((?<=<mn>)\\S+?(?=</mn><msup))/g");
			if(foundCoeff.length==0)
			{
				System.out.println("coeff: splitting went wrong");
			}
			else
			{
				Coeff = Double.parseDouble(foundCoeff[0]);
				System.out.println(Coeff);
			}

			String[] foundPower = match(current, "/((?<=<mrow><mn>)\\S+?(?=</mn></mrow>))/g");

			if(foundPower.length==0)
			{
				System.out.println("power: splitting went wrong");
			}
			else
			{
				Power = (Double.parseDouble(foundPower[0]));
				System.out.println(Power);
			}

//			System.out.println("current before match: " + current);
			String[] foundSign = match(current, "/((?<=<mo>)(\\S+?)(?=</mo>))/g");

//			System.out.println("here it is0: " + foundSign[0]);
//			System.out.println("here it is1: " + foundSign[1]);


			if(foundSign.length==0)
			{
				System.out.println("sign: splitting went wrong");
			}
			else
			{
				String currentSign = foundSign[0];
				if(currentSign.equals("-"))
				{
					Sign = -1;
				}
				else if (currentSign.equals("+"))
				{
					Sign = 1;
				}
				else
				{
					System.out.println("Signage went wrong");
				}
			}

			result.add(new Monomial(Coeff, Power, Sign));
		}

		return result;
	}


	private ArrayList<String> deleteEmptiesArrayList(ArrayList<String> match)
	{
		ArrayList<String> current = match;

		while(checkIfThereIsEmpty(current))
		{
			for (int i=0; i<current.size(); i++)
			{
				if (current.get(i).equals(""))
				{
					current.remove(i);
				}
			}

		}
		return current;
	}

	private ArrayList<ArrayList<String>> extractTag(ArrayList newshit, String tag)
	{
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		ArrayList<Integer> froms = new ArrayList<Integer>();
		ArrayList<Integer> tos = new ArrayList<Integer>();
		for (int i=0; i<newshit.size(); i++)
		{
			if(newshit.get(i).equals(tag))
			{
				froms.add(i);
			}
			else if (newshit.get(i).equals("/".concat(tag)))
			{
				tos.add(i+1);
			}
		}

		for (int i=0; i<froms.size(); i++)
		{
			result.add(new ArrayList<String>(newshit.subList(froms.get(i), tos.get(i))));
		}

		return result;
	}

	private boolean checkIfThereIsEmpty(ArrayList newshit)
	{
		boolean result = false;
		for (int i=0; i<newshit.size(); i++)
		{
			if (newshit.get(i).equals(""))
			{
				result = true;
			}
		}
		return result;
	}

	public newEditorFrame(Object o, String s, int i) throws LicenseException
	{
		super(o, s, i);
		this.setMathML("<math><mrow><mrow><mi linebreak='badbreak'>f</mi><mo>&ApplyFunction;</mo><mrow><mo linebreak='badbreak'>(</mo><mrow><mi>x</mi></mrow><mo>)</mo></mrow></mrow><mo>=</mo></mrow></math>");

	}

	public String getFormatMathML() {
		return getFormattedMathML(1, 0, 0, "", EquationUtilities.ENTITY_NAMES);
	}

	public String getMathML()
	{
		return getFormattedMathML(1, 1, 0, "", 0);
	}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		e.getComponent().getName();//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
