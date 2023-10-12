package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;


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
		//Crear componentes
		JButton bIdle = new JButton("IDLE");
		JButton bMercado = new JButton("MERCADO");
		JButton bTienda = new JButton("TIENDA");
		JButton bAjustes = new JButton("AJUSTES");
		JButton bSalir = new JButton("SALIR");
		JButton bFiltros = new JButton("FILTROS");
		//Formato componentes
		bIdle.setPreferredSize(new Dimension(150,  100));
		bMercado.setPreferredSize(new Dimension(150,  100));
		bTienda.setPreferredSize(new Dimension(150,  100));
		bAjustes.setPreferredSize(new Dimension(150,  100));
		bSalir.setPreferredSize(new Dimension(150,  100));
		bFiltros.setPreferredSize(new Dimension(150,  100));
		//Añadir componentes a contenedores
		this.getContentPane().add(pIzquierdo, BorderLayout.WEST);
		this.getContentPane().add(pCartas, BorderLayout.CENTER);
		pIzquierdo.add(pBotones, BorderLayout.SOUTH);
		pBotones.add(bIdle);
		pBotones.add(bMercado);
		pBotones.add(bTienda);
		pBotones.add(bAjustes);
		pBotones.add(bSalir);
		pBotones.add(bFiltros);
		
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
