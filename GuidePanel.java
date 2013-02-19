package PeanutCracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/10/13
 * Time: 8:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuidePanel extends JPanel
{
	public static ArrayList<JButton> bList = new ArrayList<JButton>();
	public static ButtonGroup group = new ButtonGroup();
	public static Box verticalBox = Box.createVerticalBox();
	public static Box upperBox = Box.createHorizontalBox();
	public static Box lowerBox = Box.createHorizontalBox();


	public GuidePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JRadioButton cart = new JRadioButton("Cartesian");
		cart.setSelected(true);
		JRadioButton polar = new JRadioButton("Polar");

		group.add(cart);
		group.add(polar);

		verticalBox.add(cart);
		verticalBox.add(polar);


		HintTextField funcInput = new HintTextField("Input Function Here");
		JButton submit = new JButton("Submit");

		JButton para = new JButton("Parametric");
		JButton lim = new JButton("Limit");
		JButton deriv = new JButton("Derivative");
		JButton integ = new JButton("Integrate");
		JButton diff = new JButton("Differential");

		upperBox.add(verticalBox);
		upperBox.add(funcInput);
		upperBox.add(submit);

		lowerBox.add(para);
		lowerBox.add(lim);
		lowerBox.add(deriv);
		lowerBox.add(integ);
		lowerBox.add(diff);

		bList.add(submit);
		bList.add(para);
		bList.add(lim);
		bList.add(deriv);
		bList.add(integ);
		bList.add(diff);

		this.add(upperBox);
		this.add(lowerBox);


	}

	class HintTextField extends JTextField implements FocusListener
	{

		private final String hint;

		public HintTextField(final String hint) {
			super(hint);
			this.hint = hint;
			super.addFocusListener(this);
		}

		@Override
		public void focusGained(FocusEvent e) {
			if(this.getText().isEmpty()) {
				super.setText("");
			}
		}
		@Override
		public void focusLost(FocusEvent e) {
			if(this.getText().isEmpty()) {
				super.setText(hint);
			}
		}

		@Override
		public String getText() {
			String typed = super.getText();
			return typed.equals(hint) ? "" : typed;
		}
	}
}
