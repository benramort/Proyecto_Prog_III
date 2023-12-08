package ventanas;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;



public class RendererJTableCartas extends DefaultTableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if(value instanceof JLabel) {
			JLabel label = (JLabel) value;
			return label;
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		
	}

}
