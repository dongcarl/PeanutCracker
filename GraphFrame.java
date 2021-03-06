package PeanutCracker;

import com.dessci.mathflow.sdk.license.LicenseException;
import com.dessci.mathflow.sdk.license.LicenseSource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.mentaregex.Regex.match;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphFrame extends JFrame implements ActionListener
{

	//data string stores current function so that it can be saved to a .pcr file
	private String data = "<function>" + MasterMind.Functions.toString() + "</function>" + "<window>" + MasterMind.Windows.toString() + "</window>";

	//tells if GraphFrame has a graph.
	public static boolean hasGraph = false;

	//creates a new GraphPanel
	public static GraphPanel gpnl = new GraphPanel();

	//creates a new "MyMenubar"
	MyMenubar menubar;

	public static void main(String arg[])
	{
		GraphFrame ex = new GraphFrame();

	}

	//basic UI initialization
	public GraphFrame()
	{
		this.add(gpnl);
		menubar = new MyMenubar();
		this.addListeners();

		this.setJMenuBar(menubar);

		this.setSize(500, 500);
		this.setTitle("Lines");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//constructor with params passed from MasterMind, creates new GraphFrame and thus new GraphPanel
	public GraphFrame(ArrayList X, ArrayList Y, Window w)
	{
		hasGraph = true;
		new GraphFrame();
		setWindow(w);
		addFunc(X, Y);
	}

	//sets the window
	public static void setWindow(Window w)
	{
		gpnl.setWindow(w);
	}

	//adds a function
	public static void addFunc(ArrayList X, ArrayList Y)
	{
		gpnl.addGraph(X, Y);
		gpnl.revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		//action taken if "Open and Save..." is chosen:
		//	makes new JFileChooser
		//	get the selected file
		//	call backParser to parse the .pcr file into a Function and a Window class
		//  create new mastermind with this Function and Window

		if (e.getSource() == menubar.fileMenuItems.get(0))
		{
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(GraphFrame.gpnl);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				String result = null;

				File fileToSave = fc.getSelectedFile();
				System.out.println(fileToSave.toString());

				FileInputStream fin = null;
				try
				{
					fin = new FileInputStream(fileToSave);
				} catch (FileNotFoundException e1)
				{
					e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				}
				byte[] buffer = new byte[(int) fileToSave.length()];
				try
				{
					new DataInputStream(fin).readFully(buffer);
				} catch (IOException e1)
				{
					e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				}
				try
				{
					fin.close();
				} catch (IOException e1)
				{
					e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				}

				try
				{
					result = new String(buffer, "UTF-8");
				} catch (UnsupportedEncodingException e1)
				{
					e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				}

				System.out.println(result);

				Object[] output = backParser(result);

				System.out.println("backParsed Function" + (Function) output[0]);
				System.out.println("backParsed window" + (Window) output[1]);


				MasterMind newmind = new MasterMind((Function) output[0], 0, (Window) output[1]);


			}
		}

		//actions taken if "Open..." is chosen
		//	makes new JFileChooser
		//	gets current directory with filename appended
		//	save data as byte[] with the filename

		if (e.getSource() == menubar.fileMenuItems.get(1))
		{
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(GraphFrame.gpnl);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				File fileToSave = fc.getSelectedFile();

				String filePath = fileToSave.getPath();
				if (!filePath.toLowerCase().endsWith(".pcr"))
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
					e1.printStackTrace();
				}

				try
				{
					fileToSave.createNewFile();
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
			//Handle save button action.
		}

		//creates a new editor which then passes info to Mastermind

		if (e.getSource() == menubar.fileMenuItems.get(2))
		{
			newEditorFrame editorDialog = null;
			try
			{
				editorDialog = new newEditorFrame(this, "dessci.lic", LicenseSource.FLEXLM_LIC);
			} catch (LicenseException e1)
			{
				e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			}

			editorDialog.setVisible(true);
			this.setVisible(false);
		}

	}


	//the backParser
	// 1. takes a string which comes from a .pcr file
	// 2. parses it using multiple regex replacements and matches
	// 3. outputs an Object[] with the Function in index 0 and the window in index 1

	public Object[] backParser(String input)
	{
		Object[] result = new Object[2];

		ArrayList<String> resultArray = new ArrayList<String>();

		resultArray.add(input);

		String functionString = seperateChurchAndState(input)[0];
		String windowString = seperateChurchAndState(input)[1];


		Function function = FunctionParser(functionString);
		System.out.println(function);
		Window window = WindowParser(windowString);
		System.out.println(window);


		result[0] = function;
		result[1] = window;


//		System.out.println(functionString);
//		System.out.println(windowString);


		return result;
	}

	//parse the window part of the pcr file
	private static Window WindowParser(String windowString)
	{
		String carl = windowString.replaceAll("(<window>\\[|]</window>)", "");
		String buck = carl.replaceAll("<.+?>", ";");
		String oscar = buck.replaceAll("(\\A;|;\\z)", "");
		String thing = oscar.replaceAll(";;", ";");
		String[] windowParamArray = thing.split(";");
		ArrayList<Double> windowParamDouble = new ArrayList<Double>();
		for (String i : windowParamArray)
		{
			windowParamDouble.add(Double.parseDouble(i));
		}


		return new Window(windowParamDouble.get(0), windowParamDouble.get(1), windowParamDouble.get(2), windowParamDouble.get(3), windowParamDouble.get(4), windowParamDouble.get(5));


	}

	//parse the function part of the pcr file
	private static Function FunctionParser(String functionString)
	{
		Function result = new Function();
		String function = functionString.replaceAll("(<function>\\[\\[|\\]\\]</function>)", "");
		String[] functionStrings = function.split(",");
		for (String i : functionStrings)
		{
			double Coeff = Double.parseDouble(match(i, "/((?<=<coeff>).+?(?=</coeff>))/g")[0]);
			double Power = Double.parseDouble(match(i, "/((?<=<power>).+?(?=</power>))/g")[0]);
			result.add(new Monomial(Coeff, Power));
		}
		return result;

	}

	//seperates window and function parts of the .pcr file
	private static String[] seperateChurchAndState(String s)
	{
		String function = match(s, "/(<function>.+?</function>)/g")[0];
//		System.out.println(match(s, "/(<function>.+?</function>)/g")[0]);
		String window = match(s, "/(<window>.+?</window>)/g")[0];

		String[] result = new String[2];
		result[0] = function;
		result[1] = window;
		return result;
	}

	private void addListeners()
	{
		for (JMenu i : menubar.jMenus)
		{
			i.addActionListener(this);
		}

		for (JMenuItem v : menubar.fileMenuItems)
		{
			v.addActionListener(this);
		}
	}
}