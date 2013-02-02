package PeanutCracker;

import com.sun.org.apache.xerces.internal.impl.dtd.XMLEntityDecl;

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
	public static int numY = 0;
	public static int numX = 0;
	public static double deltaY;
	public static double deltaX;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i<XArray.size()-1; i++)
		{

			double X = XArray.get(i);
			double Y = YArray.get(i);
			double M = MArray.get(i);

			double maxX = deltaX/((double)numX);
			double maxY = deltaY/((double)numY);

			paintLine(X, Y, M, maxX, maxY, g2d);


		}

	}



	public void paintLine(double X, double Y, double M, double maxX, double maxY, Graphics2D g2d)
	{
		double XStart = X;
		double YStart = Y;

		double XEnd = X;
		double YEnd = Y;

		System.out.println(XStart+", "+YStart+", "+XEnd+", "+XEnd);

		if(M==0)
		{
			double l = (maxX*0.75)/2;
			XStart = XStart-l;
			XEnd = XEnd+l;
		}

		else{
			double l = (sqrt(maxX * maxX + maxY * maxY))*0.75;

			double changeX = (sqrt((l*l)/(1+M*M)))/2;
			double changeY = (M*changeX)/2;

			if (M<0)
			{
				XStart = XStart-changeX;
				YStart = YStart-changeY;

				XEnd = XEnd+changeX;
				YEnd = YEnd+changeY;

			}

			else //m>0
			{
				XStart = XStart-changeX;
				YStart = YStart+changeY;

				XEnd = XEnd+changeX;
				YEnd = YEnd-changeY;
			}
		}

		System.out.println(XStart + ", " + YStart + ", " + XEnd + ", " + YEnd);

		g2d.drawLine((int)XStart, (int)YStart, (int)XEnd, (int)YEnd);

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

			System.out.println(XTemp.toString());
			System.out.println(YTemp.toString());

			System.out.println(XArray.toString());
			System.out.println(YArray.toString());


			int xi = 0;
			numX++;
			while(XTemp.get(xi).equals(XTemp.get(xi+1)))
			{
				numX++;
				xi++;
			}
			System.out.println(numX);

			int yi = 0;
			numY++;
			while(YTemp.get(yi).equals(YTemp.get(yi + 1)))
			{
				numY++;
				yi++;
			}
			System.out.println(numY);

			deltaX = 500;
			deltaY = 500;



		}
	}
}