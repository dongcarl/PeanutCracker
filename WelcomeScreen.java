package PeanutCracker;

import com.dessci.mathflow.sdk.license.LicenseException;
import com.dessci.mathflow.sdk.license.LicenseSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/8/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class WelcomeScreen extends JFrame implements MouseListener
{
	public JButton got;
	public JButton guide;

	public WelcomeScreen()
	{
		this.setSize(270, 60);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;

		// Move the window
		this.setLocation(x, y);

		setLayout(new FlowLayout());

		got = new JButton("I Got This");
		got.setName("I GOT THIS");
		got.addMouseListener(this);
		add(got);


		guide = new JButton("Guide Me Master");
		guide.setName("GUIDE ME MASTER");
		guide.addMouseListener(this);
		add(guide);



	}



	@Override
	public void mouseClicked(MouseEvent e)
	{
		Component theChosenOne = e.getComponent();

		if (theChosenOne.getName() == "I GOT THIS")
		{
			this.dispose();
			GraphFrame newFrame = new GraphFrame();
			newFrame.setVisible(true);
		}

		else if (theChosenOne.getName() == "GUIDE ME MASTER")
		{
			this.dispose();
			newEditorFrame editorDialog = null;
			try
			{
				editorDialog = new newEditorFrame(this, "dessci.lic", LicenseSource.FLEXLM_LIC);
			} catch (LicenseException e1)
			{
				e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			}
			editorDialog.setVisible(true);
		}

		else
		{
			System.out.println("WHADDAYA WANT FROM ME!");
		}//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{


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