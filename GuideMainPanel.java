package PeanutCracker;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/10/13
 * Time: 8:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuideMainPanel extends JPanel
{
	public GuideMainPanel()
	{

		JRadioButton cart = new JRadioButton("Cartesian");
		cart.setName("Cartesian");
															HintTextField funcInput = new HintTextField("Input Function Here");							JButton submit = new JButton("Submit");
															submit.setName("Submit");
		JRadioButton polar = new JRadioButton("Polar");
		polar.setName("Polar");






		JButton para = new JButton("Parametric");		JButton lim = new JButton("Limit");  		JButton deriv = new JButton("Derivative"); 	JButton integ = new JButton("Integrate");  	JButton diff = new JButton("Differential");
		para.setName("Parametric");						lim.setName("Limit");                       deriv.setName("Derivative");               	integ.setName("Integrate");                 diff.setName("Differential");


		this.add(cart);
		this.add(polar);
		this.add(submit);
		this.add(para);
		this.add(lim);
		this.add(deriv);
		this.add(integ);
		this.add(diff);
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
