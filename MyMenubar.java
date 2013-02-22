package PeanutCracker;

import com.dessci.mathflow.sdk.license.LicenseException;
import com.dessci.mathflow.sdk.license.LicenseSource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import static org.mentaregex.Regex.match;

/**
* Created with IntelliJ IDEA.
* User: dongcarl
* Date: 2/21/13
* Time: 9:55 PM
* To change this template use File | Settings | File Templates.
*/
public class MyMenubar extends JMenuBar
{

	private String data;
	ArrayList<JMenu> jMenus = new ArrayList<JMenu>();
	ArrayList<JMenuItem> fileMenuItems = new ArrayList<JMenuItem>();


	public MyMenubar()
	{
		super();
		addItems();

		for(JMenu i: jMenus)
		{
			this.add(i);
		}

		for(JMenuItem v: fileMenuItems)
		{
			jMenus.get(0).add(v);
		}
	}

	private void addItems()
	{
		jMenus.add(new JMenu("File"));
			fileMenuItems.add(new JMenuItem("Open and Add..."));
			fileMenuItems.add(new JMenuItem("Save..."));
			fileMenuItems.add(new JMenuItem("Add Function..."));
	}
}
