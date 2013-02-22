package PeanutCracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/10/13
 * Time: 7:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuideFrame extends JFrame implements MouseListener
{
//	public static void main(String args[])
//	{
//		GuideFrame n = new GuideFrame(new Rectangle(100, 100, 1000, 1000));
//	}

	public static JPanel portalPanel;


	public GuideFrame()
	{



		setTitle("Portal");
		setSize(510, 95);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;

// Move the window
		this.setLocation(x, y);


		GuidePanel portalPanel = new GuidePanel();
		portalPanel.setName("shit");

		add(portalPanel);


		for (final JButton j : GuidePanel.bList)
		{
			j.addMouseListener(this);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		Component theChosenOne = e.getComponent();

		System.out.println(theChosenOne.getName());

		remove(portalPanel);

		GuideChangeSettings guidance = new GuideChangeSettings(theChosenOne.getName());
		add(guidance);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}


}
