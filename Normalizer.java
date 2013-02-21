package PeanutCracker;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/21/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Normalizer
{
//	public static String data = "<math><mrow><mrow><mi linebreak='badbreak'>f</mi><mo>&ApplyFunction;</mo><mrow><mo linebreak='badbreak'>(</mo><mrow><mi>x</mi></mrow><mo>)</mo></mrow></mrow><mo>=</mo><mn>7</mn><mo>&minus;</mo><mn>4</mn><msup><mrow><mi>x</mi></mrow><mrow><mn>3</mn></mrow></msup><mo>+</mo><mn>7</mn><mo>&minus;</mo><mn>2</mn><msup><mrow><mi>x</mi></mrow><mrow><mn>2</mn></mrow></msup><mo>+</mo><mn>4</mn><mi>x</mi><mo>&minus;</mo><mn>8</mn></mrow></math>";

	public static String Normalizer(String data)
	{
		String result;

		result =  normalize(data);

		return result;
	}

	public static void main(String args[])
	{
		System.out.println(normalize("<math><mrow><mrow><mi linebreak='badbreak'>f</mi><mo>&ApplyFunction;</mo><mrow><mo linebreak='badbreak'>(</mo><mrow><mi>x</mi></mrow><mo>)</mo></mrow></mrow><mo>=</mo><msup><mrow><mi>x</mi></mrow><mrow><mn>2</mn></mrow></msup></mrow></math>"));
	}

		public static String normalize(String mathML)
	{
		String result;

		ArrayList<String> results = new ArrayList<String>();

		results.add(mathML);
		results.add(normalizeSigns(results.get(0)));
		results.add(removePrefix(results.get(1)));
		results.add(removeSuffix(results.get(2)));
		results.add(addStartSign(results.get(3)));
		results.add(normalizeFirstPower(results.get(4)));
		results.add(normalizeConstants(results.get(5)));
		results.add(addCoeffSup(results.get(6)));
		results.add(addCoeffNoSup(results.get(7)));

		System.out.println("Parsing Process: ");
		for(String i: results)
		{
			System.out.println(i);
		}

		System.out.println(results.get(results.size()-1));

		result = results.get(results.size()-1);

		return result;
	}

	private static String addCoeffNoSup(String s)
	{
		String result;

		result = s.replaceAll("<mo>(\\+|\\-)</mo><mi>([a-z]+?)</mi>(?=(<mo>|\\z))", "<mo>$1</mo><mn>1</mn><msup><mrow><mi>$2</mi></mrow><mrow><mn>1</mn></mrow></msup>");

		return result;
	}

	private static String addCoeffSup(String s)
	{
		String result;

		result = s.replaceAll("</mo><msup>", "</mo><mn>1</mn><msup>");

		return result;
	}


	private static String normalizeConstants(String s)
	{
		String result;

		result = s.replaceAll("<mo>(\\+|\\-)</mo><mn>(\\d+?)</mn>(?=(<mo>|\\z))", "<mo>$1</mo><mn>$2</mn><msup><mrow><mi>x</mi></mrow><mrow><mn>0</mn></mrow></msup>");

		return result;
	}

	private static String normalizeFirstPower(String s)
	{
		String result;

		result = s.replaceAll("<mo>(\\+|\\-)</mo><mn>(\\d+?)</mn><mi>([a-z]+?)</mi>", "<mo>$1</mo><mn>$2</mn><msup><mrow><mi>$3</mi></mrow><mrow><mn>1</mn></mrow></msup>");

		return result;
	}

	private static String addStartSign(String s)
	{
		String result;

		result = s.replaceAll("\\A<(?!mo>)", "<mo>+</mo><");

		return result;
	}

	private static String removeSuffix(String s)
	{
		String result;

		result = s.replaceAll("</mrow></math>\\Z", "");

		return result;
	}

	private static String removePrefix(String s)
	{
		String result;

		result = s.replaceAll("<math><mrow><mrow><mi linebreak='badbreak'>f</mi><mo>&ApplyFunction;</mo><mrow><mo linebreak='badbreak'>\\x{0028}</mo><mrow><mi>x</mi></mrow><mo>\\x{0029}</mo></mrow></mrow><mo>=</mo>", "");

		return result;
	}

	private static String normalizeSigns(String s)
	{
		String result;

		result = s.replaceAll("&minus;", "-");

		return result;
	}

}
