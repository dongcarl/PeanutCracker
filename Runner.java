package PeanutCracker;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/14/13
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{

	//This class creates a new Welcome Screen. Always start here.

	public static void main(String args[])
	{
		WelcomeScreen newWelcome = new WelcomeScreen();
		newWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newWelcome.setVisible(true);
	}
}