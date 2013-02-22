package PeanutCracker;

import java.util.ArrayList;

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

//		ArrayList<Double> Xtemp = X;
//		ArrayList<Double> Ytemp = Y;
//
//
//		ArrayList<Double> Xfinal = new ArrayList<Double>();
//		ArrayList<Double> Yfinal = new ArrayList<Double>();
//
//		for(int i = 0; i<Xtemp.size(); i++)
//		{
//			Xfinal.add(Xtemp.get(i));
//		}
//
//		for(int i = 0; i<Ytemp.size(); i++)
//		{
//			Yfinal.add(Ytemp.get(i));
//		}
//
//		System.out.println("before: "+ Xfinal.toString());
//		System.out.println(Yfinal.toString());
//
//		Collections.sort(Xtemp);
//		Collections.sort(Ytemp);
//
//		System.out.println("after: "+Xfinal.toString());
//		System.out.println(Yfinal.toString());
//
//											double Ymax = wind.getYmax();
//
//		double Xmin = wind.getXmin();										double Xmax = wind.getXmax();
//
//											double Ymin = wind.getYmin();
//
//		System.out.println();
//
//		for (int i = 0; i<Xtemp.size(); i++)
//		{
//			if(Xtemp.get(i)<Xmin || Xtemp.get(i)>Xmax)
//			{
//				int ind = Xfinal.indexOf(Xtemp.get(i));
//				Xfinal.set(ind, 0.0);
//				Yfinal.set(ind, 0.0);
//			}
//			else // Xmin<=Xtemp.get(i)<=Xmax
//			{}
//			System.out.println(Xfinal.toString());
//			System.out.println(Yfinal.toString());
//
//		}
//
//		for (int i = 0; i<Ytemp.size(); i++)
//		{
//			if(Ytemp.get(i)<Ymin || Ytemp.get(i)>Ymax)
//			{
//				int ind = Yfinal.indexOf(Xtemp.get(i));
//				Yfinal.set(ind, 0.0);
//				Xfinal.set(ind, 0.0);
//			}
//			else // Ymin<=Ytemp.get(i)<=Ymax
//			{}
//			System.out.println(Xfinal.toString());
//			System.out.println(Yfinal.toString());
//
//		}
//
//
//		for (int i=0; i<Xfinal.size(); i++)
//		{
//			if(Xfinal.get(i)==0.0)
//			{
//				Xfinal.remove(i);
//			}
//
//			else{}
//		}
//
//		for (int i=0; i<Yfinal.size(); i++)
//		{
//			if(Yfinal.get(i)==0.0)
//			{
//				Yfinal.remove(i);
//			}
//
//			else{}
//		}
//
//
//
//		System.out.println(Xfinal.toString());
//		System.out.println(Yfinal.toString());
//
////	GraphPanel Graph = new GraphPanel(Xfinal, Yfinal);

	}

	public DisplayBrain(ArrayList<Double> X, ArrayList<Double> Y, ArrayList<Double> M, Window wind)
	{

//		ArrayList<Double> Xtemp = X;
//		ArrayList<Double> Ytemp = Y;
//		ArrayList<Double> Mtemp = M;
//
//		ArrayList<Double> Xfinal = X;
//		ArrayList<Double> Yfinal = Y;
//		ArrayList<Double> Mfinal = M;
//
//
//		Collections.sort(Xtemp);
//		Collections.sort(Ytemp);
//
//
//											double Ymax = wind.getYmax();
//
//		double Xmin = wind.getXmin();										double Xmax = wind.getXmax();
//
//											double Ymin = wind.getYmin();
//
//
//		for (int i = 0; i<Xtemp.size(); i++)
//		{
//			if(Xtemp.get(i)<Xmin || Xtemp.get(i)>Xmax)
//			{
//				int ind = Yfinal.indexOf(Xtemp.get(i));
//				Yfinal.remove(ind);
//				Xfinal.remove(ind);
//				Mfinal.remove(ind);
//
//			}
//			else // Xmin<=Xtemp.get(i)<=Xmax
//			{}
//		}
//
//		for (int i = 0; i<Ytemp.size(); i++)
//		{
//			if(Ytemp.get(i)<Ymin || Ytemp.get(i)>Ymax)
//			{
//				int ind = Yfinal.indexOf(Xtemp.get(i));
//				Yfinal.remove(ind);
//				Xfinal.remove(ind);
//				Mfinal.remove(ind);
//			}
//			else // Ymin<=Ytemp.get(i)<=Ymax
//			{}
//		}
//
//
//		FieldPanel Graph = new FieldPanel(Xtemp, Ytemp, Mtemp);

	}
}
