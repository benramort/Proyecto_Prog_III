package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*;

public class Tienda extends JFrame{
	
	public Tienda() {
		///Formato Ventana
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		
		///Crear Contenedores
		JPanel pSuperior = new JPanel();
		JPanel pMonedas = new JPanel();
		JPanel pCentro = new JPanel();
		JScrollPane sc = new JScrollPane(pCentro);
		
		///Formato Contenedores
		pSuperior.setLayout(new BorderLayout());
		pMonedas.setLayout(new FlowLayout((FlowLayout.RIGHT)));
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBorder(null);
		
		///Crear Componentes
		JButton btHome = new JButton("HOME");
		JLabel lMonedas = new JLabel("XXXXXXXXXX");
		JLabel lImagenMonedas = new JLabel();
		
		ImageIcon imagen7 = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		///Formato componentes
		lImagenMonedas.setIcon(imagenMoneda);
		
		///Añadir componentes a contenedores
		pSuperior.add(btHome, BorderLayout.WEST);
		pSuperior.add(pMonedas, BorderLayout.EAST);
		add(pSuperior, BorderLayout.NORTH);
		pMonedas.add(lMonedas);
		pMonedas.add(lImagenMonedas);
		
		getContentPane().add(sc, BorderLayout.CENTER );
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Tienda();
				
			}
		});
	}
}
