package PeanutCracker;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
* Created with IntelliJ IDEA.
* User: dongcarl
* Date: 2/1/13
* Time: 2:23 PM
* To change this template use File | Settings | File Templates.
*/
public class GraphPanel extends JPanel
{
	public static ArrayList<ArrayList<Double>> XArray = new ArrayList<ArrayList<Double>>();
	public static ArrayList<ArrayList<Double>> YArray = new ArrayList<ArrayList<Double>>();

	public static double numHeight;
	public static double Ymax;

	public static int step;


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

			for (int i = 0; i<XArray.size(); i++)
			{
				plot(XArray.get(i), YArray.get(i), g2d);
			}
	}

	public GraphPanel()
	{
		super();
	}

	public static void addGraph(ArrayList X, ArrayList Y)
	{

		if (X.size()!=Y.size())
		{
			System.out.println("Number of X's and Y's not the same!");
		}

		else
		{
			addToArray(X, Y);
		}
	}

	public static void addToArray(ArrayList x, ArrayList y)
	{
		XArray.add(x);
		YArray.add(y);
	}


	public static void plot(ArrayList x, ArrayList y, Graphics2D g2d)
	{
		for (int i = 0; i<x.size()-1; i++)
		{
			int x1 = ((Double)(x.get(i))).intValue();
			int y1 = ((Double)(y.get(i))).intValue();

			int x2 = ((Double)(x.get(i+1))).intValue();
			int y2 = ((Double)(y.get(i+1))).intValue();

			g2d.drawLine(x1, y1, x2, y2);
		}

	}
}
