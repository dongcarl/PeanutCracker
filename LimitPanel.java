package PeanutCracker;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/15/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class LimitPanel extends JFrame
{
	public static int FullFont = 18;
	public static int SubSuperFont = (int)(((double)FullFont)*(58.0/100.0));
	public static int SymbolFont = (int)(((double)FullFont)*(150.0/100.0));







	public static void main (String args[])
	{
		LimitPanel shit = new LimitPanel();
		shit.setVisible(true);
	}

	public LimitPanel()
	{



		System.out.println(SubSuperFont);
		System.out.println(SymbolFont);

		JTextField function  = new JTextField(10);
		Font currentFont = function.getFont();
		System.out.println(currentFont.getFontName());
		function.setFont(new Font(currentFont.getFontName(), 0, FullFont));

		JLabel limLabel = new JLabel("Lim");
		limLabel.setFont(new Font(currentFont.getFontName(), 0, SymbolFont));
		limLabel.setHorizontalAlignment(JLabel.LEFT);

		JTextField variable  = new JTextField(1);
		variable.setFont(new Font(currentFont.getFontName(), 0, SubSuperFont));

		JLabel equals = new JLabel("=");
		equals.setFont(new Font(currentFont.getFontName(), 0, SubSuperFont));

		JTextField toLimit  = new JTextField(1);
		toLimit.setFont(new Font(currentFont.getFontName(), 0, SubSuperFont));


		Box newBox3 = Box.createHorizontalBox();
		newBox3.add(variable);
		newBox3.add(equals);
		newBox3.add(toLimit);

		Box newBox2 = Box.createVerticalBox();
		newBox2.add(limLabel);
		newBox2.add(newBox3);

		Box newBox = Box.createHorizontalBox();
		newBox.add(newBox2);
		newBox.add(function);

		JPanel panel = new JPanel();
		panel.add(newBox);
		panel.setSize(panel.getPreferredSize());




		this.add(panel);
	}
}
