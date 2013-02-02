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
		ArrayList<Double> MArray = new ArrayList<Double>();


		XArray.add(100.0);            		YArray.add(100.0);                  MArray.add(1.0);
		XArray.add(100.0);                  YArray.add(200.0);                  MArray.add(1.0);
		XArray.add(100.0);             		YArray.add(300.0);                  MArray.add(1.0);
		XArray.add(100.0);            		YArray.add(400.0);                  MArray.add(1.0);

		XArray.add(200.0);            		YArray.add(100.0);                  MArray.add(-1.0);
		XArray.add(200.0);                  YArray.add(200.0);                  MArray.add(-1.0);
		XArray.add(200.0);             		YArray.add(300.0);                  MArray.add(-1.0);
		XArray.add(200.0);            		YArray.add(400.0);                  MArray.add(-1.0);

		XArray.add(300.0);            		YArray.add(100.0);                  MArray.add(0.5);
		XArray.add(300.0);                  YArray.add(200.0);                  MArray.add(0.5);
		XArray.add(300.0);             		YArray.add(300.0);                  MArray.add(0.5);
		XArray.add(300.0);            		YArray.add(400.0);                  MArray.add(0.5);

		XArray.add(400.0);            		YArray.add(100.0);                  MArray.add(-0.5);
		XArray.add(400.0);                  YArray.add(200.0);                  MArray.add(-0.5);
		XArray.add(400.0);             		YArray.add(300.0);                  MArray.add(-0.5);
		XArray.add(400.0);            		YArray.add(400.0);                  MArray.add(-0.5);



		System.out.println(XArray.toString());
		System.out.println(YArray.toString());
		System.out.println(MArray.toString());



		GraphFrame ex = new GraphFrame(XArray, YArray, MArray);
		ex.setSize(500, 500);
		ex.setTitle("Lines");
		ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ex.setVisible(true);
	}

	public GraphFrame(ArrayList<Double> XArray, ArrayList<Double> YArray)
	{
		GraphPanel gpnl = new GraphPanel(XArray, YArray);
		this.add(gpnl);
	}

	public GraphFrame(ArrayList<Double> XArray, ArrayList<Double> YArray, ArrayList<Double> MArray)
	{
		FieldPanel fpnl = new FieldPanel(XArray, YArray, MArray);
		this.add(fpnl);
	}



}
