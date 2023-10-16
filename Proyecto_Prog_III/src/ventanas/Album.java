package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pIzquierdo = new JPanel();
		JPanel pDerecho = new JPanel();
		JPanel pCartas = new JPanel();
		JPanel pBotones = new JPanel();
		JPanel pMonedas = new JPanel();
		PanelPorcentaje pPorcentaje = new PanelPorcentaje(100, 300, 300, Color.BLACK);
		JPanel pPorcentaje2 = new JPanel();
		JPanel pPorcentaje3 = new JPanel();
		//Formato contenedores
		pIzquierdo.setLayout(new BorderLayout());
		pBotones.setLayout(new GridLayout(2, 3));
		pDerecho.setLayout(new BorderLayout());
		pMonedas.setLayout(new FlowLayout((FlowLayout.RIGHT)));
		Border bordePanelIzquierdo = BorderFactory.createLineBorder(Color.BLACK);
		pIzquierdo.setBorder(bordePanelIzquierdo);
		pPorcentaje2.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPorcentaje2.setMaximumSize(new Dimension(300,300));
		pPorcentaje.setPreferredSize(new Dimension(300,300));
		pPorcentaje3.setLayout(new BoxLayout(pPorcentaje3, BoxLayout.Y_AXIS));
		


		//Crear componentes
		JButton bIdle = new JButton();
		JButton bMercado = new JButton();
		JButton bTienda = new JButton();
		JButton bAjustes = new JButton();
		JButton bSalir = new JButton();
		JButton bBuscar = new JButton();
		JScrollPane spCartas = new JScrollPane();
		JLabel lMonedas = new JLabel("XXXXXXXXXX");
		JLabel lImagenMonedas = new JLabel();
		
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
		
		ImageIcon imagen7 = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		
		//Formato componentes
		lImagenMonedas.setIcon(imagenMoneda);
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
		this.getContentPane().add(pDerecho, BorderLayout.CENTER);
		pIzquierdo.add(pBotones, BorderLayout.SOUTH);
		pBotones.add(bIdle);
		pBotones.add(bMercado);
		pBotones.add(bTienda);
		pBotones.add(bBuscar);
		pBotones.add(bAjustes);
		pBotones.add(bSalir);
		pDerecho.add(pMonedas, BorderLayout.NORTH);
		pDerecho.add(pCartas, BorderLayout.CENTER);
		pCartas.add(spCartas);
		pMonedas.add(lMonedas);
		pMonedas.add(lImagenMonedas);
		pIzquierdo.add(pPorcentaje3, BorderLayout.CENTER);
		pPorcentaje3.add(Box.createVerticalGlue());
		pPorcentaje3.add(pPorcentaje2);
		pPorcentaje2.add(pPorcentaje);
		pPorcentaje3.add(Box.createVerticalGlue());
		

		
		
		
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
