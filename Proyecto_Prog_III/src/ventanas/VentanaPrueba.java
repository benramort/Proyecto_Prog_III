package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrueba extends JFrame {
	
	public static void main(String[] args) {
		new VentanaPrueba();
	}
	
	public VentanaPrueba() {
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		PanelPorcentaje p = new PanelPorcentaje(78, 300, 300, Color.BLACK);
		p.setBackground(Color.CYAN);
		add(p, BorderLayout.CENTER);
		
		setVisible(true);
	}

}
