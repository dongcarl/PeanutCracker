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
	public static ArrayList<Double> XArray;
	public static ArrayList<Double> YArray;


	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i<XArray.size()-1; i++)
		{
			int x1 = (XArray.get(i)).intValue();
			int y1 = (YArray.get(i)).intValue();

			int x2 = (XArray.get(i+1)).intValue();
			int y2 = (YArray.get(i+1)).intValue();

			g2d.drawLine(x1, y1, x2, y2);
		}
	}

	public GraphPanel(ArrayList X, ArrayList Y)
	{
		super();
		/*
		Checks if the ArrayLists of X and Y are the same size
		if it is, set the XArray and YArray to X and Y
		if not, prints out the message.
		*/

		if (X.size()!=Y.size())
		{
			System.out.println("Number of X's and Y's not the same!");
		}

		else
		{
			XArray = X;
			YArray = Y;
		}
	}
}
