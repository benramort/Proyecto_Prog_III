package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import comportamientos.Carta;
import comportamientos.CartaAEntrenar;
import comportamientos.Datos;
import comportamientos.Usuario;

public class VentaCartas extends JFrame{
	CartaAEntrenar carta1 = new CartaAEntrenar();
	CartaAEntrenar carta2 = new CartaAEntrenar();
	CartaAEntrenar carta3 = new CartaAEntrenar();

	CartaEntrenando cartaIzq = new CartaEntrenando(carta1);
	CartaEntrenando cartaCen = new CartaEntrenando(carta2);
	CartaEntrenando cartaDer = new CartaEntrenando(carta3);
	
	CartaEntrenando cartaEnt1 = cartaIzq;
	CartaEntrenando cartaEnt2 = cartaCen;
	CartaEntrenando cartaEnt3 = cartaDer;
	Datos datos;
	Usuario usuario;
	
	JPanel flowLayoutCartasH;
	
	public JButton bClear;
	
	List<Carta> cartasNoMostradas = new ArrayList<>();
	
	
	public VentaCartas(JFrame ventanaAnterior, Usuario usuario, Datos datos) {
		this.usuario = usuario;
		this.datos = datos;
		for(Entry<Carta, Integer> e : usuario.getCartas().entrySet()) {
			if(e.getValue() == 1) {
				cartasNoMostradas.add(e.getKey());
			}
		}
		//Formato ventana
		setTitle("Vender cartas");
		setSize(1500, 1000);
		setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Creacion contenedores
		JPanel pInferior = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pBotonClear = new JPanel();
		JPanel pTextos = new JPanel();
		JPanel pCartas = new JPanel();
		JPanel blCentro = new JPanel();
		flowLayoutCartasH = new JPanel();
		JPanel boxLayoutCartasV = new JPanel();
		JPanel pBotonMercado = new JPanel();
		JPanel pBotonRecogerMonedas = new JPanel();
		//Formato contenedores
		pInferior.setLayout(new BorderLayout());
		pTextos.setLayout(new FlowLayout(FlowLayout.CENTER));
		pCentral.setLayout(new BorderLayout());
		pCentral.setMaximumSize(new Dimension(100000,500));
		pCartas.setLayout(new FlowLayout(FlowLayout.CENTER));
		flowLayoutCartasH.setLayout(new FlowLayout(FlowLayout.CENTER));
		// flowLayoutCartasH.setOpaque(true);
		// flowLayoutCartasH.setBackground(Color.BLUE);
		boxLayoutCartasV.setLayout(new BoxLayout(boxLayoutCartasV, BoxLayout.Y_AXIS));
		pBotonMercado.setLayout(new FlowLayout(FlowLayout.LEFT));
		// pBotonAlbum.setMaximumSize(new Dimension(10000,50));
		flowLayoutCartasH.setMaximumSize(new Dimension(1000,1000));
		boxLayoutCartasV.setOpaque(true);
		// boxLayoutCartasH.setOpaque(false);
		blCentro.setLayout(new BoxLayout(blCentro, BoxLayout.Y_AXIS));
		//Creacion componentes
		JButton bMercado = new JButton("MERCADO");
		bClear = new JButton("CLEAR");
		ImageIcon imagen = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
//		JButton bRecogerMonedas = new JButton("RECOGER MONEDAS");
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		//Formato componentes
		bMercado.setPreferredSize(new Dimension(90, 40));
//		bRecogerMonedas.setPreferredSize(new Dimension(150, 50));
		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		this.getContentPane().add(pInferior, BorderLayout.SOUTH);
		this.getContentPane().add(blCentro, BorderLayout.CENTER);
		blCentro.add(Box.createVerticalGlue());
		blCentro.add(pCentral);
		blCentro.add(Box.createVerticalGlue());
		pInferior.add(pBotonClear, BorderLayout.EAST);
		pBotonClear.add(bClear);
		pInferior.add(pTextos, BorderLayout.CENTER);
		pCentral.add(pCartas);
		pCartas.add(boxLayoutCartasV);
		// boxLayoutCartasV.add(Box.createVerticalGlue());
		// boxLayoutCartasV.setBackground(Color.BLUE);
		flowLayoutCartasH.add(cartaEnt1);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(cartaEnt2);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(cartaEnt3);
//		pBotonRecogerMonedas.add(bRecogerMonedas);
//		pBotonEntrenar.add(bRecogerMonedas);
		boxLayoutCartasV.add(flowLayoutCartasH);
		boxLayoutCartasV.add(pBotonRecogerMonedas);
		pBotonMercado.add(bMercado);
		add(pBotonMercado, BorderLayout.NORTH);
		
		setVisible(true);
	
		bMercado.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
//		if(cartaEnt1.getCarta().equals(new CartaAEntrenar()) && cartaEnt2.getCarta().equals(new CartaAEntrenar()) && cartaEnt3.getCarta().equals(new CartaAEntrenar())) {
//			bEntrenar.setEnabled(false);
//		}
		
//		bRecogerMonedas.addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				bRecogerMonedas.setVisible(false);
//				usuario.setMonedas(usuario.getMonedas() + modoIdle.getMonedasGeneradas());
//				lMonedasGeneradas2.setText("0");
//				lMonedasGeneradas2.repaint();
//				bEntrenar.setVisible(true);						
//				modoIdle.setGenerarMonedasCarta1(false);
//				modoIdle.setGenerarMonedasCarta2(false);
//				modoIdle.setGenerarMonedasCarta3(false);
//				//TODO hacerlo bonito
//				modoIdle.interrupt();
//				if(modoIdle.isInterrupted()) {
//					bClear.setEnabled(true);
//				}
////				System.out.println("Está interrumpido? " + modoIdle.isInterrupted());
//			}
//		});
		
		cartaEnt1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaSeleccion(VentaCartas.this, usuario, datos, 1, cartasNoMostradas);
					}
				});
			}
		});
		cartaEnt2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaSeleccion(VentaCartas.this, usuario, datos, 2, cartasNoMostradas);
					}
				});
			}
		});
		
		cartaEnt3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaSeleccion(VentaCartas.this, usuario, datos, 3, cartasNoMostradas);
					}
				});
			}
		});
		
		bMercado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Mercado) ventanaAnterior).lMonedas.setText(String.valueOf(usuario.getMonedas()));
			}
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				((Mercado) ventanaAnterior).lMonedas.setText(String.valueOf(usuario.getMonedas()));
			}
		});

		
		bClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cartaEnt1 = cartaIzq;
				cartaEnt2 = cartaCen;
				cartaEnt3 = cartaDer;
				flowLayoutCartasH.removeAll();
				flowLayoutCartasH.add(cartaEnt1);
				flowLayoutCartasH.add(Box.createHorizontalStrut(50));
				flowLayoutCartasH.add(cartaEnt2);
				flowLayoutCartasH.add(Box.createHorizontalStrut(50));
				flowLayoutCartasH.add(cartaEnt3);
//				flowLayoutCartasH.add(new JLabel("Hol"));
				revalidate();
				repaint();
				cartasNoMostradas.clear();
			}
		});
	
		// public static void main(String[] args) {
		// SwingUtilities.invokeLater(new Runnable() {
		//
		// @Override
		// public void run() {
		// new Entrenamiento(null);
		//
		// }
		// });
		// }
		
//		if((cartaEnt1.getCarta().getId() == 0 || cartaEnt2.getCarta().getId() == 0 || cartaEnt3.getCarta().getId() == 0)) {
//			bRecogerMonedas.setEnabled(false);
//		}
//
//		if(cartaEnt1.getCarta().getId() != 0 && cartaEnt2.getCarta().getId() != 0 && cartaEnt3.getCarta().getId() != 0) {
//			bRecogerMonedas.setEnabled(false);
//		}
		

	}
	
	public CartaEntrenando getCartaEnt1() {
		return cartaEnt1;
	}

	public CartaEntrenando getCartaEnt2() {
		return cartaEnt2;
	}

	public CartaEntrenando getCartaEnt3() {
		return cartaEnt3;
	}

	public void cambiarCartaEntrenando(Carta carta, int indice) {
		switch (indice) {
		case 1: 
			cartaEnt1 = new CartaEntrenando(carta);
			cartasNoMostradas.add(cartaEnt1.getCarta());
			break;
		case 2: 
			cartaEnt2 = new CartaEntrenando(carta);
			cartasNoMostradas.add(cartaEnt2.getCarta());
			break;
		case 3: 
			cartaEnt3 = new CartaEntrenando(carta);
			cartasNoMostradas.add(cartaEnt3.getCarta());
			break;
		default: 
		//TODO hacer una excepcion
		}
		flowLayoutCartasH.removeAll();
		flowLayoutCartasH.add(cartaEnt1);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(cartaEnt2);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(cartaEnt3);
//		flowLayoutCartasH.add(new JLabel("Hol"));
		revalidate();
		repaint();
	}

	

	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				new Entrenamiento(null, usuario);
//				
//			}
//		});
//	}
}
