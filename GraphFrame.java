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
		ex.setSize(500, 500);
		ex.setTitle("Lines");
		ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ex.setVisible(true);
	}

	public GraphFrame()
	{
		this.add(gpnl);
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuitem = new JMenuItem("Save...");
		menu.add(menuitem);
		menubar.add(menu);
		this.setJMenuBar(menubar);
	}

	public GraphFrame(ArrayList X, ArrayList Y)
	{
		new GraphFrame();
		addFunc(X, Y);
	}

	public static void addFunc(ArrayList X, ArrayList Y)
	{
		gpnl.addGraph(X, Y);
		gpnl.revalidate();

	}




}
