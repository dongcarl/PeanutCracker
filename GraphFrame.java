package PeanutCracker;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphFrame extends JFrame
{

	public static void main(String arg[])
	{
		ArrayList<Double> XArray = new ArrayList<Double>();
		ArrayList<Double> YArray = new ArrayList<Double>();

		XArray.add(100.0);            		YArray.add(100.0);
		XArray.add(150.0);                  YArray.add(200.0);
		XArray.add(300.0);             		YArray.add(300.0);
		XArray.add(400.0);            		YArray.add(400.0);



		System.out.println(XArray.toString());
		System.out.println(YArray.toString());


		GraphFrame ex = new GraphFrame(XArray, YArray);
		ex.setSize(800, 800);
		ex.setTitle("Lines");
		ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ex.setVisible(true);
	}

	public GraphFrame(ArrayList<Double> XArray, ArrayList<Double> YArray)
	{
		GraphPanel gpnl = new GraphPanel(XArray, YArray);
		this.add(gpnl);
	}



}
