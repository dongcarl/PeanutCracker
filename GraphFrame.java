package PeanutCracker;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphFrame extends JFrame
{


	public static GraphPanel gpnl = new GraphPanel();

	public static void main(String arg[])
	{
		GraphFrame ex = new GraphFrame();

	}

	public GraphFrame()
	{
		this.add(gpnl);
		MyMenubar menubar = new MyMenubar(MasterMind.Functions, MasterMind.Windows);

		this.setJMenuBar(menubar);

		this.setSize(500, 500);
		this.setTitle("Lines");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public GraphFrame(ArrayList X, ArrayList Y, Window w)
	{
		new GraphFrame();
		setWindow(w);
		addFunc(X, Y);
	}

	public static void setWindow(Window w)
	{
		gpnl.setWindow(w);
	}

	public static void addFunc(ArrayList X, ArrayList Y)
	{
		gpnl.addGraph(X, Y);
		gpnl.revalidate();

	}
}