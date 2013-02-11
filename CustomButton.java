package PeanutCracker;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.*;

public class CustomButton extends JButton
{
	private BufferedImage bufImg;

	public CustomButton(BufferedImage bufImg)
	{
		super(new ImageIcon(bufImg));
		this.bufImg = bufImg;
	}
}
