package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import comportamientos.Carta;
import comportamientos.Datos;
import comportamientos.Usuario;

public class VentanaSeleccion extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Carta cartaSeleccionada;
	JFrame ventanaAnterior;
	
	JPanel pCartas;
	
	public VentanaSeleccion(JFrame ventanaAnterior, Usuario usuario, Datos datos, int indice, List<Carta> cartasNoMostradas) {
		
		this.ventanaAnterior = ventanaAnterior;
		
		double escala = 1;
//		this.usuario = usuario;
//		this.datos = datos;
//		int cartasObtenidas = 0;
		
		//Formato ventana
		setTitle("Universal Cards Collection");
		setSize((int) (1500/escala), (int) (1000/escala));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pCentral = new JPanel();
		pCartas = new JPanel(new GridLayout(0, 4, 0, 0));
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
					gl.setColumns(5);
				VentanaSeleccion.this.revalidate();
			}	
		});
		
		//Gestion de cartas
		 
		for (Carta c: usuario.getCartas().keySet()) {
			if (usuario.getCartas().get(c) != 0) {
				PanelCarta p = new PanelCarta(c);
				if(cartasNoMostradas.contains(p.getCarta())) {
					continue;
				}
				p.addMouseListener(hoverCartas);
				pCartas.add(p);
				p.setPreferredSize(new Dimension(235, 335)); //TODO espacio vertical
//				p.setOpaque(true);
				p.setBackground(Color.RED);
				System.out.println("Cargada carta "+c.getId());
//				cartasObtenidas++;
				p.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						cartaSeleccionada = p.getCarta();
						((Entrenamiento) ventanaAnterior).cambiarCartaEntrenando(cartaSeleccionada, indice);
						if(((Entrenamiento) ventanaAnterior).cartaEnt1.getCarta().getId() == 0 || ((Entrenamiento) ventanaAnterior).cartaEnt2.getCarta().getId() == 0 || ((Entrenamiento) ventanaAnterior).cartaEnt3.getCarta().getId() == 0) {
							((Entrenamiento) ventanaAnterior).bEntrenar.setEnabled(false);
						}
						dispose();
					}
				});
			}
		}
		
		
//		Component[] cartasEntrenando = ((Entrenamiento)ventanaAnterior).flowLayoutCartasH.getComponents();
//		Component[] panelesCarta = pCartas.getComponents();
//		
//		for(Component c : cartasEntrenando) {
//			for(Component p : panelesCarta) {
//				if(((CartaEntrenando) c).getCarta().equals(((PanelCarta) p).getCarta())){
//					p.setVisible(false);
//				}
//			}
//		}
//		repaint();
		
		setVisible(true);
		
//		pCartas.setBackground(Color.RED);
//		pCartas.setOpaque(true);
	}
}
