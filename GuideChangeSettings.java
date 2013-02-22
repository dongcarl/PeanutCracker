package PeanutCracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/12/13
 * Time: 8:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class GuideChangeSettings extends JPanel
{
	public GuideChangeSettings(String EquationType)
	{
		if (EquationType == "Simple")
		{
			// Create a list containing CheckListItem's

			JList list = new JList(new CheckListItem[] {
					new CheckListItem("min/max"),
					new CheckListItem("inflection"),
					new CheckListItem("zeros"),
					new CheckListItem("window")});

			// Use a CheckListRenderer (see below)
			// to renderer list cells

			list.setCellRenderer(new CheckListRenderer());
			list.setSelectionMode(
					ListSelectionModel.SINGLE_SELECTION);

			// Add a mouse listener to handle changing selection
			list.setVisibleRowCount(2);

			list.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent event)
				{
					JList list = (JList) event.getSource();

					// Get index of item clicked

					int index = list.locationToIndex(event.getPoint());
					CheckListItem item = (CheckListItem)
							list.getModel().getElementAt(index);

					// Toggle selected state

					item.setSelected(! item.isSelected());

					// Repaint cell

					list.repaint(list.getCellBounds(index, index));
				}
			});


		}

	}

	class CheckListItem
	{
		private String  label;
		private boolean isSelected = false;

		public CheckListItem(String label)
		{
			this.label = label;
		}

		public boolean isSelected()
		{
			return isSelected;
		}

		public void setSelected(boolean isSelected)
		{
			this.isSelected = isSelected;
		}

		public String toString()
		{
			return label;
		}
	}

// Handles rendering cells in the list using a check box

	class CheckListRenderer extends JCheckBox implements ListCellRenderer
	{
		public Component getListCellRendererComponent(
				JList list, Object value, int index,
				boolean isSelected, boolean hasFocus)
		{
			setEnabled(list.isEnabled());
			setSelected(((CheckListItem)value).isSelected());
			setFont(list.getFont());
			setBackground(list.getBackground());
			setForeground(list.getForeground());
			setText(value.toString());
			return this;
		}
	}
}

// Represents items in the list that can be selected

