package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import comportamientos.Carta;

public class VentanaPrueba extends JFrame {
	
	public static void main(String[] args) {
		new VentanaPrueba();
	}
	
	public VentanaPrueba() {
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
//		PanelPorcentaje p = new PanelPorcentaje(78, 300, 300, Color.BLACK);
//		p.setBackground(Color.CYAN);
//		add(p, BorderLayout.CENTER);
//		p.setPorcentaje(30);
		
		Carta carta = new Carta("yoshi");
		System.out.println("Hoila");

		PanelCarta p = new PanelCarta(carta);
		add(p, BorderLayout.CENTER);
		p.setBackground(Color.BLUE);
		
		JButton bt = new JButton("Mostrar stats");
		add(bt, BorderLayout.SOUTH);
		
//		JLayeredPane lp = new JLayeredPane();
//		
//		JLabel l = new JLabel("Hola");
//		lp.add(l, Integer.valueOf(0));
//		add(lp);
//		lp.setPreferredSize(new Dimension(200,200));
//		lp.setBackground(Color.RED);
//		lp.setOpaque(true);
//		l.setBounds(0, 0, 100, 100);
		
		bt.addActionListener(new ActionListener()  {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (p.isMostrandoStats() == true) {
					p.mostrarStats(false);
				} else {
					p.mostrarStats(true);
				}
			}
			
		});
		
		setVisible(true);
	}

}
