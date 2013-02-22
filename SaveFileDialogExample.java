package PeanutCracker; /**
 * @(#)SaveFileDialogExample.java 1.0
 * This code is written by www.codejava.net
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveFileDialogExample extends JFrame {

	private JButton buttonBrowse;

	public SaveFileDialogExample() {
		super("Save File Dialog Example");
		setLayout(new FlowLayout());
		buttonBrowse = new JButton("Save...");
		buttonBrowse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				showSaveFileDialog();
			}
		});
		getContentPane().add(buttonBrowse);
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new SaveFileDialogExample();
			}
		});
	}

	private void showSaveFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");

		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION)
		{
			File fileToSave = fileChooser.getSelectedFile();
			System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}
	}
}