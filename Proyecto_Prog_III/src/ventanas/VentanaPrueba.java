package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import comportamientos.Carta;

public class VentanaPrueba extends JFrame {
	
	public static void main(String[] args) {
		new VentanaPrueba();
	}
	
	public VentanaPrueba() {
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
//		PanelPorcentaje p = new PanelPorcentaje(78, 300, 300, Color.BLACK);
//		p.setBackground(Color.CYAN);
//		add(p, BorderLayout.CENTER);
//		p.setPorcentaje(30);
		
		Carta carta = new Carta("yoshi");
		System.out.println("Hoila");

		
		setVisible(true);
	}

}
