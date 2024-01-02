package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import comportamientos.Carta;
import comportamientos.Datos;
import comportamientos.Usuario;

public class VentanaSeleccionVender extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Carta cartaSeleccionada;
	JFrame ventanaAnterior;
	JPanel pCartas;
	
	public VentanaSeleccionVender(JFrame ventanaAnterior, Usuario usuario, Datos datos, int indice, List<Carta> cartasNoMostradas) {
		
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
		JPanel pInferior = new JPanel();
		JPanel pPrecioYBoton = new JPanel();
		JPanel pPrecio = new JPanel();
		JPanel pBotonAceptar = new JPanel();
		pCartas = new JPanel(new GridLayout(0, 4, 0, 0));
		//TODO espacio vertical de cartas
		//Formato contenedores
		pInferior.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInferior.setPreferredSize(new Dimension(1500, 100));
		pInferior.setBackground(new Color(255, 255, 255));
		pInferior.setOpaque(true);
		Border bordePInferior = BorderFactory.createLineBorder(Color.BLACK);
		pInferior.setBorder(bordePInferior);
		pInferior.setVisible(false);
		pBotonAceptar.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPrecioYBoton.setLayout(new BoxLayout(pPrecioYBoton, BoxLayout.Y_AXIS));
		pPrecio.setBackground(new Color(255, 255, 255));
		pBotonAceptar.setBackground(new Color(255, 255, 255));
		pPrecio.setLayout(new FlowLayout(FlowLayout.CENTER));
		//Crear componentes
		JScrollPane spCartas = new JScrollPane();
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		JLabel lPrecioCarta = new JLabel("Precio: ");
		JSpinner spPrecio = new JSpinner();
		JButton bAceptar = new JButton("ACEPTAR");
		//Formato componentes
		spCartas.setViewportView(pCartas);
		spCartas.setBorder(null);
		spCartas.getVerticalScrollBar().setUnitIncrement(15);
		
		spPrecio.setModel(new SpinnerNumberModel(0, 0, 1500000, 100));
		spPrecio.setPreferredSize(new Dimension(200, 30));
		lPrecioCarta.setFont(new Font("Arial", Font.BOLD, 24));
		
		bAceptar.setPreferredSize(new Dimension(100, 40));
		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		this.getContentPane().add(pCentral, BorderLayout.CENTER);
		this.getContentPane().add(pInferior, BorderLayout.SOUTH);		
		pCentral.add(spCartas, BorderLayout.CENTER);
		pInferior.add(pPrecioYBoton);
		pPrecioYBoton.add(pPrecio);
		pPrecio.add(lPrecioCarta);
		pPrecio.add(spPrecio);
		pPrecioYBoton.add(pBotonAceptar);
		pBotonAceptar.add(bAceptar);
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
				VentanaSeleccionVender.this.revalidate();
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
				p.setBackground(Color.CYAN);
				System.out.println("Cargada carta "+c.getId());
//				cartasObtenidas++;
				p.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						cartaSeleccionada = p.getCarta();
						pInferior.setVisible(true);
						p.setOpaque(true);
						p.revalidate();
						p.repaint();
						bAceptar.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								((VentanaVentaCartas) ventanaAnterior).cambiarCartaVendiendo(cartaSeleccionada, indice, spPrecio.getValue());
								((VentanaVentaCartas) ventanaAnterior).revalidate();
								((VentanaVentaCartas) ventanaAnterior).repaint();
								dispose();
							}
						});
					}
					
				});
			}
		}
		

		
		setVisible(true);
		
//		pCartas.setBackground(Color.RED);
//		pCartas.setOpaque(true);
	}
}
