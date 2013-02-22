package PeanutCracker;

import javax.swing.*;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/21/13
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveDialogue
{
	public static void main(String args[])
	{
		JFrame guiFrame = new JFrame();
		JFileChooser fileDialog = new JFileChooser();
		int saveChoice = fileDialog.showSaveDialog(guiFrame);

		if (saveChoice == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = fileDialog.getSelectedFile();
		}


	}
}
