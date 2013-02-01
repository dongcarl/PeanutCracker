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

	public static ArrayList<Point2D.Double> GraphArray;

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i<GraphArray.size()-1; i++)
		{
			int x1 = (int)(GraphArray.get(i).x);
			int y1 = (int)(GraphArray.get(i).y);

			int x2 = (int)(GraphArray.get(i+1).x);
			int y2 = (int)(GraphArray.get(i+1).y);

			g2d.drawLine(x1, y1, x2, y2);
		}
	}

	public GraphPanel(ArrayList Input)
	{
		GraphArray = Input;
	}


}
