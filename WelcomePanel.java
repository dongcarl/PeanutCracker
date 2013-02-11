package PeanutCracker;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/8/13
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class WelcomePanel extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		ImageIcon imageicon = new ImageIcon("biface.png");
		Image image = imageicon.getImage();

		g.drawImage(image, 0, 0, null);
	}
}
