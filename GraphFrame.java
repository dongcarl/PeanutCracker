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
	public static ArrayList<Double> XArray;
	public static ArrayList<Double> YArray;

	public GraphFrame()
	{
		initUI();
	}

	private void initUI()
	{
		GraphPanel gpnl = new GraphPanel(XArray, YArray);
		add(gpnl);

		setSize(800, 800);
		setTitle("Lines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String arg[])
	{
		XArray.add(100.0);
		XArray.add(200.0);
		XArray.add(300.0);
		XArray.add(400.0);

		YArray.add(100.0);
		YArray.add(200.0);
		YArray.add(300.0);
		YArray.add(400.0);


		GraphFrame ex = new GraphFrame();
		ex.setVisible(true);
	}
}
