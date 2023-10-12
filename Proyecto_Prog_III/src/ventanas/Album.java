package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.*;


public class Album extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Album(JFrame ventanaAnterior) {
		//Formato ventana
		setTitle("Universal Cards Collection");
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pIzquierdo = new JPanel();
		JPanel pCartas = new JPanel();
		JPanel pBotones = new JPanel();
		//Formato contenedores
		pIzquierdo.setLayout(new BorderLayout());
		pBotones.setLayout(new GridLayout(2, 3));
		
		Border bordePanelIzquierdo = BorderFactory.createLineBorder(Color.BLACK);
		pIzquierdo.setBorder(bordePanelIzquierdo);
		//Crear componentes
		JButton bIdle = new JButton();
		JButton bMercado = new JButton();
		JButton bTienda = new JButton();
		JButton bAjustes = new JButton();
		JButton bSalir = new JButton();
		JButton bBuscar = new JButton();
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/idle.png"));
		ImageIcon imagenIdle = new ImageIcon(imagen.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("/ajustes.png"));
		ImageIcon imagenAjustes = new ImageIcon(imagen2.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("/lupa.png"));
		ImageIcon imagenLupa = new ImageIcon(imagen3.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		ImageIcon imagen4 = new ImageIcon(getClass().getResource("/mercado.png"));
		ImageIcon imagenMercado = new ImageIcon(imagen4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		ImageIcon imagen5 = new ImageIcon(getClass().getResource("/tienda.png"));
		ImageIcon imagenTienda = new ImageIcon(imagen5.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		ImageIcon imagen6 = new ImageIcon(getClass().getResource("/salir.png"));
		ImageIcon imagenSalir = new ImageIcon(imagen6.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		
		//Formato componentes
		bIdle.setIcon(imagenIdle);
		bAjustes.setIcon(imagenAjustes);
		bBuscar.setIcon(imagenLupa);
		bMercado.setIcon(imagenMercado);
		bTienda.setIcon(imagenTienda);
		bSalir.setIcon(imagenSalir);
		bIdle.setPreferredSize(new Dimension(150,  100));
		bMercado.setPreferredSize(new Dimension(150,  100));
		bTienda.setPreferredSize(new Dimension(150,  100));
		bAjustes.setPreferredSize(new Dimension(150,  100));
		bSalir.setPreferredSize(new Dimension(150,  100));
		bBuscar.setPreferredSize(new Dimension(150,  100));
		//Añadir componentes a contenedores
		this.getContentPane().add(pIzquierdo, BorderLayout.WEST);
		this.getContentPane().add(pCartas, BorderLayout.CENTER);
		pIzquierdo.add(pBotones, BorderLayout.SOUTH);
		pBotones.add(bIdle);
		pBotones.add(bMercado);
		pBotones.add(bTienda);
		pBotones.add(bBuscar);
		pBotones.add(bAjustes);
		pBotones.add(bSalir);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Album(null);
				
			}
		});
	}
}
