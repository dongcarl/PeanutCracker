package PeanutCracker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/8/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class WelcomeScreen extends JFrame implements MouseListener
{
	public WelcomeScreen()
	{
		JFrame Welcome = new JFrame();
		Welcome.setVisible(true);
		Welcome.setLayout(new FlowLayout());
		Welcome.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JButton got = new JButton("I Got This");
		got.setName("I GOT THIS");

		JButton guide = new JButton("Guide Me Master");
		guide.setName("GUIDE ME MASTER");


	}

	public static void main (String args[])
	{
		WelcomeScreen welcome = new WelcomeScreen();

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

		if (theChosenOne.getName() == "I GOT THIS")
		{
			GraphFrame newFrame = new GraphFrame();
			this.setVisible(false);

		}

		else if (theChosenOne.getName() == "GUIDE ME MASTER")
		{
			GuideFrame newGuide = new GuideFrame();
			this.setVisible(false);
		}

		else
		{
			System.out.println("WHADDAYA WANT FROM ME!");
		}

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}
}