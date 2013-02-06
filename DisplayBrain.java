package PeanutCracker;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayBrain
{
	public DisplayBrain(ArrayList<Double> X, ArrayList<Double>Y, Window wind)
	{
		ArrayList<Double> Xtemp = X;
		ArrayList<Double> Ytemp = Y;

		ArrayList<Double> Xfinal = X;
		ArrayList<Double> Yfinal = Y;

		Collections.sort(Xtemp);
		Collections.sort(Ytemp);


											double Ymax = wind.getYmax();

		double Xmin = wind.getXmin();										double Xmax = wind.getXmax();

											double Ymin = wind.getYmin();


		for (int i = 0; i<Xtemp.size(); i++)
		{
			if(Xtemp.get(i)<Xmin || Xtemp.get(i)>Xmax)
			{
				int ind = Xfinal.indexOf(Xtemp.get(i));
				Xfinal.remove(ind);
				Yfinal.remove(ind);
			}
			else // Xmin<=Xtemp.get(i)<=Xmax
			{}
		}

		for (int i = 0; i<Ytemp.size(); i++)
		{
			if(Ytemp.get(i)<Ymin || Ytemp.get(i)>Ymax)
			{
				int ind = Yfinal.indexOf(Xtemp.get(i));
				Yfinal.remove(ind);
				Xfinal.remove(ind);
			}
			else // Ymin<=Ytemp.get(i)<=Ymax
			{}
		}

	GraphPanel Graph = new GraphPanel(Xfinal, Yfinal);

	}

	public DisplayBrain(ArrayList<Double> X, ArrayList<Double> Y, ArrayList<Double> M, Window wind)
	{

		ArrayList<Double> Xtemp = X;
		ArrayList<Double> Ytemp = Y;
		ArrayList<Double> Mtemp = M;

		ArrayList<Double> Xfinal = X;
		ArrayList<Double> Yfinal = Y;
		ArrayList<Double> Mfinal = M;


		Collections.sort(Xtemp);
		Collections.sort(Ytemp);


											double Ymax = wind.getYmax();

		double Xmin = wind.getXmin();										double Xmax = wind.getXmax();

											double Ymin = wind.getYmin();


		for (int i = 0; i<Xtemp.size(); i++)
		{
			if(Xtemp.get(i)<Xmin || Xtemp.get(i)>Xmax)
			{
				int ind = Yfinal.indexOf(Xtemp.get(i));
				Yfinal.remove(ind);
				Xfinal.remove(ind);
				Mfinal.remove(ind);

			}
			else // Xmin<=Xtemp.get(i)<=Xmax
			{}
		}

		for (int i = 0; i<Ytemp.size(); i++)
		{
			if(Ytemp.get(i)<Ymin || Ytemp.get(i)>Ymax)
			{
				int ind = Yfinal.indexOf(Xtemp.get(i));
				Yfinal.remove(ind);
				Xfinal.remove(ind);
				Mfinal.remove(ind);
			}
			else // Ymin<=Ytemp.get(i)<=Ymax
			{}
		}

		if (X.size()!=Y.size()!=M.size())
		{

		}


		FieldPanel Graph = new FieldPanel(Xtemp, Ytemp, Mtemp);

	}
}
