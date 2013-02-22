package PeanutCracker;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/21/13
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyTestFrame extends JFrame
{
	public static String data = "[<mo>+</mo><mn>1</mn><msup><mrow><mi>x</mi></mrow><mrow><mn>2</mn></mrow></msup>, <mo>-</mo><mn>1</mn><msup><mrow><mi>x</mi></mrow><mrow><mn>3</mn></mrow></msup>, <mo>-</mo><mn>1</mn><msup><mrow><mi>x</mi></mrow><mrow><mn>0</mn></mrow></msup>]";
	public static void main(String args[])
	{
		MyTestFrame test = new MyTestFrame();
	}

	public MyTestFrame()
	{
		this.setBounds(0, 0, 500, 500);

		UIinit();

		this.setVisible(true);
	}

	private void UIinit()
	{
		this.add(new MyMenubar());
	}


}
