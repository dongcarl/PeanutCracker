package PeanutCracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/21/13
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyMenubar extends JMenuBar implements ActionListener
{

	private String data;
	ArrayList<JMenu> jMenus = new ArrayList<JMenu>();
	ArrayList<JMenuItem> fileMenuItems = new ArrayList<JMenuItem>();


	public MyMenubar(String input)
	{
		super();

		this.data = input;

		addItems();
		addListeners();

		for(JMenu i: jMenus)
		{
			this.add(i);
		}

		for(JMenuItem v: fileMenuItems)
		{
			jMenus.get(0).add(v);
		}
	}

	private void addListeners()
	{
		for(JMenu i: jMenus)
		{
			i.addActionListener(this);
		}

		for(JMenuItem v: fileMenuItems)
		{
			v.addActionListener(this);
		}
	}

	private void addItems()
	{
		jMenus.add(new JMenu("File"));
			fileMenuItems.add(new JMenuItem("Save"));


	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == fileMenuItems.get(0))
		{
			System.out.println("actionlistener working");
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(GraphFrame.gpnl);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				File fileToSave = fc.getSelectedFile();

				String filePath = fileToSave.getPath();
				if(!filePath.toLowerCase().endsWith(".pcr"))
				{
					fileToSave = new File(filePath + ".pcr");
				}

				Path file = fileToSave.toPath();
				byte[] buf = data.getBytes();
				try
				{
					Files.write(file, buf);
				} catch (IOException e1)
				{
					e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				}

//				try
//				{
//					fileToSave.createNewFile();
//				}
//				catch (IOException e1)
//				{
//					e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//				}
			}
			//Handle save button action.
		}

	}
}
