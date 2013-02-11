package PeanutCracker;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/6/13
 * Time: 9:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayBrainTest
{
	public static void main(String args[])
	{
		Window wind = new Window(1.0, 9.0, 10.0, 20.0);

		ArrayList<Double> X = new ArrayList<Double>();

		ArrayList<Double> Y = new ArrayList<Double>();


		X.add(10.0);                    Y.add(2.0);
		X.add(3.0);                     Y.add(5.0);
		X.add(21.0);                    Y.add(3.14);
		X.add(13.0);                    Y.add(6.0);
		X.add(3.5);                     Y.add(7.5);
		X.add(8.0);                     Y.add(8.6);
		X.add(4.0);                     Y.add(11.0);
		X.add(8.0);                     Y.add(10.5);
		X.add(13.0);                    Y.add(15.0);
		X.add(12.0);                    Y.add(17.0);
		X.add(1212.0);                  Y.add(1213.0);
		X.add(10.0);                    Y.add(11.0);
		X.add(1.0);                     Y.add(17.0);

		System.out.println(X.toString());

		//[3.0, 4.0, 8.0, 1.0]
		//[5.0, 11.0, 10.5, 17.0]



		System.out.println(Y.toString());


		DisplayBrain brain = new DisplayBrain(X, Y, wind);
	}
}
