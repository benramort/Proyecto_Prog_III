package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import comportamientos.Carta;
import comportamientos.CartaVacia;
import comportamientos.Datos;
import comportamientos.Usuario;

public class VentanaSeleccion extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VentanaSeleccion(JFrame ventanaAnterior, Usuario usuario, Datos datos) {
		double escala = 1;
//		this.usuario = usuario;
//		this.datos = datos;
		int cartasObtenidas = 0;
		
		//Formato ventana
		setTitle("Universal Cards Collection");
		setSize((int) (1500/escala), (int) (1000/escala));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pCentral = new JPanel();
		JPanel pCartas = new JPanel(new GridLayout(0, 4, 0, 0));
		//TODO espacio vertical de cartas
		//Formato contenedores
		

		//Crear componentes
		JScrollPane spCartas = new JScrollPane();

		
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		
		//Formato componentes
		spCartas.setViewportView(pCartas);
		spCartas.setBorder(null);
		spCartas.getVerticalScrollBar().setUnitIncrement(15);
	
		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		this.getContentPane().add(pCentral, BorderLayout.CENTER);
		pCentral.add(spCartas, BorderLayout.CENTER);
//		pCartas.add(spCartas);		

		
		
		//Configurar escuchadores
		MouseListener hoverCartas = new MouseAdapter() {
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
		};
		
		spCartas.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				GridLayout gl = (GridLayout) pCartas.getLayout();
//				System.out.println(spCartas.getWidth());
				if (spCartas.getWidth() < 500) {
					gl.setColumns(1);
				} else if (spCartas.getWidth() < 800) {
					gl.setColumns(2);
				} else if (spCartas.getWidth() < 1000) {
					gl.setColumns(3);
				} else if (spCartas.getWidth() < 1200) {
					gl.setColumns(4);
				} else {
					gl.setColumns(5);
				}
				VentanaSeleccion.this.revalidate();
			}
			
			
			
		});
		
		//Gestion de cartas
		 
		for (Carta c: usuario.getCartas().keySet()) {
			if (usuario.getCartas().get(c) != 0) {
				PanelCarta p = new PanelCarta(c);
				p.addMouseListener(hoverCartas);
				pCartas.add(p);
				p.setPreferredSize(new Dimension(235, 335)); //TODO espacio vertical
//				p.setOpaque(true);
				p.setBackground(Color.RED);
				System.out.println("Cargada carta "+c.getId());
				cartasObtenidas++;
			} else {
				PanelCarta p = new PanelCarta(new CartaVacia());
//				p.addMouseListener(hoverCartas);
				pCartas.add(p);
//				System.out.println("Cargada carta "+c.getId());
			}
		}
		
		
		setVisible(true);
		
		System.out.println(Toolkit.getDefaultToolkit().getScreenResolution());
		

	}
}
