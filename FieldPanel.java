package PeanutCracker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.sqrt;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class FieldPanel extends JPanel
{
	public static ArrayList<Double> XArray;
	public static ArrayList<Double> YArray;
	public static ArrayList<Double> MArray;
	public static int numY;
	public static int numX;
	public static double deltaY;
	public static double deltaX;


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i<XArray.size()-1; i++)
		{

			double x = XArray.get(i);
			double y = YArray.get(i);
			double m = MArray.get(i);

			double maxX = deltaX/((double)numX);
			double maxY = deltaY/((double)numY);

			double XStart = x;
			double YStart = y;

			double XEnd = x;
			double YEnd = y;

			if(m==0)
			{
				double l = (maxX*0.75)/2;
				XStart = XStart-l;
				XEnd = XEnd+l;
			}

			else{
				double l = (sqrt(maxX * maxX + maxY * maxY))*0.75;

				double changeX = (sqrt((l*l)/(1+m*m)))/2;
				double changeY = (m*changeX)/2;

				if (m<0)
				{
					XStart = XStart-changeX;
					YStart = YStart+changeY;

					XEnd = XEnd+changeX;
					YEnd = YEnd-changeY;

				}

				else //m>0
				{
					XStart = XStart-changeX;
					YStart = YStart-changeY;

					XEnd = XEnd+changeX;
					YEnd = YEnd+changeY;
				}
			}
		}

	}

	public FieldPanel(ArrayList X, ArrayList Y, ArrayList M)
	{
		super();

		if ((X.size()!=Y.size())||(X.size()!=M.size())||(M.size()!=Y.size()))
		{
			System.out.println("Number of X's, Y's, and M's not the same!");
		}

		else
		{
			XArray = X;
			YArray = Y;
			MArray = M;

			ArrayList<Double> XTemp = X;
			ArrayList<Double> YTemp = Y;

			Collections.sort(XTemp);
			Collections.sort(YTemp);

			int xi = 0;
			numX++;
			while(XTemp.get(xi)==XTemp.get(xi+1))
			{
				numX++;
				xi++;
			}

			int yi = 0;
			numY++;
			while(YTemp.get(yi)==YTemp.get(yi+1))
			{
				numY++;
				yi++;
			}

			deltaX = Window.getXmax()-Window.getXmin();
			deltaY = Window.getYmax()-Window.getYmin();

		}
	}
}