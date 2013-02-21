package PeanutCracker;

import com.sun.xml.internal.ws.transport.http.HttpMetadataPublisher;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/14/13
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{
	public Runner()
	{
		WelcomeScreen newWelcome = new WelcomeScreen();
		newWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newWelcome.setVisible(true);
	}

	public static void main(String args[])
	{
		WelcomeScreen newWelcome = new WelcomeScreen();
		newWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newWelcome.setVisible(true);
	}
}
