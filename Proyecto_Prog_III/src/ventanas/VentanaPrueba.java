package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import comportamientos.Carta;
import comportamientos.Saga;

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
		
		Carta carta = new Carta("yoshi",new Saga("SuperMario"));
		System.out.println("Hoila");

		PanelCarta p = new PanelCarta(carta);
		JPanel p2 = new JPanel();
		p2.add(p);
		add(p2, BorderLayout.CENTER);
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
		
		p.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				PanelCarta p = (PanelCarta) e.getSource();
				p.mostrarStats(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				PanelCarta p = (PanelCarta) e.getSource();
				p.mostrarStats(false);
			}
			
		});
		
		setVisible(true);
	}

}
