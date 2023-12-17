package ventanas;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import comportamientos.Carta;



public class RendererJTableCartas extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4341641410918335893L;


	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if(value instanceof Carta) {
			JLabel label = new JLabel(new ImageIcon(((Carta) value).getRecursoGrafico().getImage().getScaledInstance(235, 335, Image.SCALE_DEFAULT)));
			return label;
		} else {
			JLabel label2 = new JLabel(value + "");
			label2.setHorizontalAlignment(JLabel.CENTER);
			label2.setFont(new Font("Arial", Font.BOLD, 30));
			return label2;
		}
		
		
		
	}

}
