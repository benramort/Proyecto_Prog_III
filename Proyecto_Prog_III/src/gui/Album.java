package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;

import javax.swing.*;
import javax.swing.border.*;

import db.BasesDeDatos;
import domain.Carta;
import domain.CartaVacia;
import domain.Saga;
import domain.Usuario;
import interfaces.Datos;



public class Album extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private PanelPorcentaje pPorcentaje;
	private JPanel pCartas;
	public JLabel lMonedasAlbum;
	
	
	public Album(JFrame ventanaAnterior, Usuario usuario, Datos datos) {
		double escala = 1;
		this.usuario = usuario;
//		this.datos = datos;
		
		//Formato ventana
		setTitle("Universal Cards Collection");
		setSize((int) (1500/escala), (int) (1000/escala));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().setBackground(new Color(255, 255, 255));
		//Crear contenedores
		JPanel pIzquierdo = new JPanel();
		JPanel pDerecho = new JPanel();
		pCartas = new JPanel(new GridLayout(0, 4, 0, 0));
		//TODO espacio vertical de cartas
		JPanel pBotones = new JPanel();
		JPanel pMonedas = new JPanel();
		pPorcentaje = new PanelPorcentaje(0, 300, 300, Color.BLACK);
		JPanel pPorcentaje2 = new JPanel();
		JPanel pPorcentaje3 = new JPanel();
		JPanel pBuscar = new JPanel();
		JPanel pPrecioMin = new JPanel();
		JPanel pPrecioMax = new JPanel();
		JPanel pSaga = new JPanel();
		JPanel pBuscarSuperior = new JPanel();
		JPanel pBotonCerrarFiltros = new JPanel();
		
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

		pBotonCerrarFiltros.setLayout(new FlowLayout(FlowLayout.CENTER));
		Border bordePanelBuscarBorder = BorderFactory.createLineBorder(Color.BLACK);
		pBuscar.setBorder(bordePanelBuscarBorder);
		pBuscar.setLayout(new BoxLayout(pBuscar, BoxLayout.Y_AXIS));
		pBuscarSuperior.setLayout(new BorderLayout());
		pPrecioMin.setMaximumSize(new Dimension(400, 800));
		pPrecioMin.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPrecioMax.setMaximumSize(new Dimension(400, 800));
		pPrecioMax.setLayout(new FlowLayout(FlowLayout.CENTER));
		pSaga.setLayout(new FlowLayout(FlowLayout.CENTER));

		//Crear componentes
		JButton bIdle = new JButton();
		JButton bMercado = new JButton();
		JButton bTienda = new JButton();
		JButton bAjustes = new JButton();
		JButton bSalir = new JButton();
		JButton bBuscar = new JButton();
		JScrollPane spCartas = new JScrollPane();
		lMonedasAlbum = new JLabel(String.valueOf(usuario.getMonedas())); //TODO cambiar cuando se cierra el modo idle
		JLabel lImagenMonedas = new JLabel();
		
		Path path1 = Path.of("resources/img/idle.png");
		ImageIcon imagen1 = new ImageIcon(path1.toAbsolutePath().toString());
		ImageIcon imagenIdle = new ImageIcon(imagen1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		Path path2 = Path.of("resources/img/ajustes.png");
		ImageIcon imagen2 = new ImageIcon(path2.toAbsolutePath().toString());
		ImageIcon imagenAjustes = new ImageIcon(imagen2.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		Path path3 = Path.of("resources/img/lupa.png");
		ImageIcon imagen3 = new ImageIcon(path3.toAbsolutePath().toString());
		ImageIcon imagenLupa = new ImageIcon(imagen3.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		Path path4 = Path.of("resources/img/mercado.png");
		ImageIcon imagen4 = new ImageIcon(path4.toAbsolutePath().toString());
		ImageIcon imagenMercado = new ImageIcon(imagen4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		Path path5 = Path.of("resources/img/tienda.png");
		ImageIcon imagen5 = new ImageIcon(path5.toAbsolutePath().toString());
		ImageIcon imagenTienda = new ImageIcon(imagen5.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		Path path6 = Path.of("resources/img/salir.png");
		ImageIcon imagen6 = new ImageIcon(path6.toAbsolutePath().toString());
		ImageIcon imagenSalir = new ImageIcon(imagen6.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		Path path7 = Path.of("resources/img/moneda.png");
		ImageIcon imagen7 = new ImageIcon(path7.toAbsolutePath().toString());
		ImageIcon imagenMoneda = new ImageIcon(imagen7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		JTextField tfBuscar = new JTextField("Buscar:");
		JLabel lPrecioMin = new JLabel("Precio mínimo: ");
		JSpinner spSelPrecioMin = new JSpinner();
		JLabel lPrecioMax = new JLabel("Precio máximo:");
		JSpinner spSelPrecioMax = new JSpinner();
		JLabel lSaga = new JLabel("Saga");		
		Saga[] listaSagas = {
				new Saga("",""),
				new Saga("GodOfWar", "God Of War"),
				new Saga("SuperMario", "Super Mario"),
				new Saga("TheLegendOfZelda", "The Legend Of Zelda"),
				new Saga("Portal", "Portal"),
				new Saga("TheLastOfUs", "The Last Of Us")	
		};
		ComboBoxModel<Saga> comboBoxModel = new DefaultComboBoxModel<>(listaSagas);
		JComboBox<Saga> cbSelSaga = new JComboBox<Saga>(comboBoxModel);
		JLabel lCerrarFiltros = new JLabel("X");
		
		Path pathLogo = Path.of("resources/img/logo chiquito.png");
		ImageIcon logoPequeño = new ImageIcon(pathLogo.toAbsolutePath().toString());
		
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
		spCartas.setViewportView(pCartas);
		spCartas.setBorder(null);
		spCartas.getVerticalScrollBar().setUnitIncrement(15);
		spCartas.setBackground(new Color(255, 255, 255));
		tfBuscar.setMaximumSize(new Dimension(200, 100));
		spSelPrecioMin.setPreferredSize(new Dimension(100, 25));
		spSelPrecioMax.setPreferredSize(new Dimension(100, 25));
		spSelPrecioMin.setModel(new SpinnerNumberModel(0, 0, 999999999, 100));
		spSelPrecioMax.setModel(new SpinnerNumberModel(0, 0, 999999999, 100));
		cbSelSaga.setMinimumSize(new Dimension(500, 100));
		
		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
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
		pDerecho.add(spCartas, BorderLayout.CENTER);
//		pCartas.add(spCartas);
		pMonedas.add(lMonedasAlbum);
		pMonedas.add(lImagenMonedas);
		pIzquierdo.add(pPorcentaje3, BorderLayout.CENTER);
		pPorcentaje3.add(Box.createVerticalGlue());
		pPorcentaje3.add(pPorcentaje2);
		pPorcentaje2.add(pPorcentaje);
		pPorcentaje3.add(Box.createVerticalGlue());
		
		
		pBuscar.add(pBuscarSuperior);
		pBuscar.add(tfBuscar);
		pBuscar.add(Box.createVerticalStrut(10));
		pBuscar.add(pSaga);
		pBuscarSuperior.add(pBotonCerrarFiltros, BorderLayout.EAST);
		pBotonCerrarFiltros.add(lCerrarFiltros);
		pPrecioMin.add(lPrecioMin);
		pPrecioMin.add(spSelPrecioMin);
		pPrecioMax.add(lPrecioMax);
		pPrecioMax.add(spSelPrecioMax);
		pSaga.add(lSaga);
		pSaga.add(cbSelSaga);
		cbSelSaga.setPreferredSize(new Dimension(100, 50));
		pPorcentaje2.add(pBuscar);
		pBuscar.setVisible(false);
		pBuscar.setPreferredSize(new Dimension(200, 120));
		
		cargarCartas();
		
		
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
				Album.this.revalidate();
			}
			
			
			
		});
		
		
		
		
		setVisible(true);
		
		System.out.println(Toolkit.getDefaultToolkit().getScreenResolution());
	
		bIdle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							new Entrenamiento(
									Album.this, usuario, datos);
						}
					});
				}
		});
		
		bMercado.addActionListener(new ActionListener() {
			
			@Override

			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new Mercado(Album.this, datos, usuario);

					}
				});
			}
		});
		
		bTienda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new Tienda(Album.this, usuario, datos);
					}
				});
			}
		});
		
		bSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						int resp = JOptionPane.showConfirmDialog( Album.this, "¿Seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION );
						if (resp==JOptionPane.OK_OPTION) {
							if(datos instanceof BasesDeDatos) {
								((BasesDeDatos) datos).cerrarConexion();
							}
							Album.this.dispose();
						}
						
					}
				});
			}
		});
		
		bBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPorcentaje.setVisible(false);
				pBuscar.setVisible(true);
			}
		});
		
		pBotonCerrarFiltros.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				pBotonCerrarFiltros.setBackground(new Color(238, 238, 238));
				lCerrarFiltros.setForeground(Color.BLACK);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				pBotonCerrarFiltros.setBackground(Color.RED);
				lCerrarFiltros.setForeground(Color.WHITE);				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pBuscar.setVisible(false);
				pPorcentaje.setVisible(true);
				
			}
		});
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				datos.guardarUsuario(usuario);
				if(datos instanceof BasesDeDatos) {
					((BasesDeDatos) datos).cerrarConexion();
				}
			}
		});
		
//		for(PanelCarta p : (PanelCarta[]) pCartas.getComponents()) {
//			System.out.println(p.toString());
//			if(!tfBuscar.getText().isEmpty() && !p.getCarta().getNombreInterno().toUpperCase().startsWith(tfBuscar.getText().toUpperCase())) {
//				p.setVisible(false);
//				repaint();
//			}
//		}

	}
	
	public void cargarCartas() {
		//Gestion de cartas
		
		pCartas.removeAll();
//		pCartas = new JPanel();
		pCartas.setLayout(new GridLayout(0, 4, 0, 0));
		
//		System.out.println("Hola");
		int cartasObtenidas = 0;
		
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

		for (Carta c: usuario.getCartas().keySet()) {
			if (usuario.getCartas().get(c) != 0) {
				PanelCarta p = new PanelCarta(c);
				p.addMouseListener(hoverCartas);
				pCartas.add(p);
				p.setPreferredSize(new Dimension(235, 335)); //TODO espacio vertical
//				p.setOpaque(true);
				p.setBackground(Color.RED);
//				System.out.println("Cargada carta "+c.getId());
				cartasObtenidas++;
			} else {
				PanelCarta p = new PanelCarta(new CartaVacia());
				//						p.addMouseListener(hoverCartas);
				pCartas.add(p);
				//						System.out.println("Cargada carta "+c.getId());
			}
		}

//		System.out.println(pCartas.isVisible());
		pPorcentaje.setPorcentaje((int) (cartasObtenidas/(double) usuario.getCartas().size()*100));
		pCartas.revalidate();
		pCartas.repaint(); //El repaint hace que se borren las imagenes del grid
		System.out.println(pCartas.getComponentCount());
	}

}
