package PeanutCracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
	public static void main(String args[])
	{
		GuideFrame n = new GuideFrame(new Rectangle(100, 100, 1000, 1000));
	}

	public static JPanel portalPanel;
	public GuideFrame(Rectangle bounds)
	{
		JFrame guide = new JFrame();
		guide.setTitle("Portal");
		guide.setBounds(bounds);
		guide.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


		GuideMainPanel portalPanel = new GuideMainPanel();

		guide.add(portalPanel);
		guide.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		Component theChosenOne = e.getComponent();

		System.out.println(theChosenOne);

		if (theChosenOne.getName() == "Cartesian")
		{

		}

		else if (theChosenOne.getName() == "Polar")
		{

		}

		else if (theChosenOne.getName() == "Submit")
		{

		}

		else if (theChosenOne.getName() == "Parametric")
		{

		}

		else if (theChosenOne.getName() == "Limit")
		{

		}

		else if (theChosenOne.getName() == "Derivative")
		{

		}

		else if (theChosenOne.getName() == "Integrate")
		{

		}

		else if (theChosenOne.getName() == "Differential")
		{

		}//To change body of implemented methods use File | Settings | File Templates.
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
