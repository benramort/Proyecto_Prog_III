package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import domain.Carta;
import domain.CartaAEntrenar;
import domain.ModoIdle;
import domain.Usuario;
import interfaces.Datos;

public class Entrenamiento extends JFrame{

/**
*
*/
private static final long serialVersionUID = 1L;

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
	ModoIdle modoIdle;
	public JButton bEntrenar;
	
	
	JLabel lMonedasGeneradas2;
	JLabel lMonedasPorMinuto2;
	
	JPanel flowLayoutCartasH;
	
	public JButton bClear;
	
	public JLabel lError;
	
	List<Carta> cartasNoMostradas = new ArrayList<>();
	
	
	public Entrenamiento(JFrame ventanaAnterior, Usuario usuario, Datos datos) {
		this.usuario = usuario;
		this.datos = datos;
		cartasNoMostradas.add(cartaEnt1.getCarta());
		cartasNoMostradas.add(cartaEnt2.getCarta());
		cartasNoMostradas.add(cartaEnt3.getCarta());
		//Formato ventana
		setTitle("Entrenamiento");
		setSize(1200, 650);
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
		JPanel pBotonAlbum = new JPanel();
		JPanel pBotonEntrenar = new JPanel();
		JPanel pError = new JPanel();
		//Formato contenedores
		pInferior.setLayout(new BorderLayout());
		pTextos.setLayout(new FlowLayout(FlowLayout.CENTER));
		pCentral.setLayout(new BorderLayout());
		pCentral.setMaximumSize(new Dimension(100000,500));
		pCartas.setLayout(new FlowLayout(FlowLayout.CENTER));
		pBotonEntrenar.setLayout(new FlowLayout(FlowLayout.CENTER));
		flowLayoutCartasH.setLayout(new FlowLayout(FlowLayout.CENTER));
		// flowLayoutCartasH.setOpaque(true);
		// flowLayoutCartasH.setBackground(Color.BLUE);
		boxLayoutCartasV.setLayout(new BoxLayout(boxLayoutCartasV, BoxLayout.Y_AXIS));
		pBotonAlbum.setLayout(new FlowLayout(FlowLayout.LEFT));
		// pBotonAlbum.setMaximumSize(new Dimension(10000,50));
		flowLayoutCartasH.setMaximumSize(new Dimension(1000,1000));
		boxLayoutCartasV.setOpaque(true);
		// boxLayoutCartasH.setOpaque(false);
		blCentro.setLayout(new BoxLayout(blCentro, BoxLayout.Y_AXIS));
		//Creacion componentes
		JButton bAlbum = new JButton("ÁLBUM");
		JLabel lMonedasGeneradas = new JLabel("Monedas generadas: " );
		lMonedasGeneradas2 = new JLabel("0");
		JLabel lMonedasPorMinuto = new JLabel("Monedas/minuto: " );
		lMonedasPorMinuto2 = new JLabel("0");
		JLabel lImagenMonedasGeneradas = new JLabel();
		JLabel lImagenMonedasPorMinuto = new JLabel();
		bClear = new JButton("CLEAR");
		Path path = Path.of("resources/img/moneda.png");
		ImageIcon imagen = new ImageIcon(path.toAbsolutePath().toString());
		ImageIcon imagenMoneda = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		bEntrenar = new JButton("ENTRENAR");
		JButton bRecogerMonedas = new JButton("RECOGER MONEDAS");
		path = Path.of("resources/img/logo chiquito.png");
		ImageIcon logoPequeño = new ImageIcon(path.toAbsolutePath().toString());
		lError = new JLabel("Todas las cartas están sin stamina");
		//Formato componentes
		bAlbum.setPreferredSize(new Dimension(90, 40));
		bEntrenar.setPreferredSize(new Dimension(150, 50));
		bRecogerMonedas.setPreferredSize(new Dimension(150, 50));
		lError.setFont(new Font("Arial", Font.BOLD, 24));
		lError.setForeground(Color.RED);
		lError.setVisible(false);
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
		pTextos.add(lMonedasGeneradas);
		pTextos.add(lMonedasGeneradas2);
		pTextos.add(lImagenMonedasGeneradas);
		lImagenMonedasGeneradas.setIcon(imagenMoneda);
		pTextos.add(Box.createHorizontalStrut(200));
		pTextos.add(lMonedasPorMinuto);
		pTextos.add(lMonedasPorMinuto2);
		pTextos.add(lImagenMonedasPorMinuto);
		lImagenMonedasPorMinuto.setIcon(imagenMoneda);
		pCentral.add(pCartas);
		pCartas.add(boxLayoutCartasV);
		// boxLayoutCartasV.add(Box.createVerticalGlue());
		// boxLayoutCartasV.setBackground(Color.BLUE);
		flowLayoutCartasH.add(cartaEnt1);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(cartaEnt2);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(cartaEnt3);
		pBotonEntrenar.add(bEntrenar);
		pBotonEntrenar.add(bRecogerMonedas);
		bRecogerMonedas.setVisible(false);
		boxLayoutCartasV.add(flowLayoutCartasH);
		boxLayoutCartasV.add(pBotonEntrenar);
		boxLayoutCartasV.add(pError);
		pError.add(lError);
		pBotonAlbum.add(bAlbum);
		add(pBotonAlbum, BorderLayout.NORTH);
		
		setVisible(true);
	
		bAlbum.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
//		if(cartaEnt1.getCarta().equals(new CartaAEntrenar()) && cartaEnt2.getCarta().equals(new CartaAEntrenar()) && cartaEnt3.getCarta().equals(new CartaAEntrenar())) {
//			bEntrenar.setEnabled(false);
//		}
		
		bEntrenar.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				bEntrenar.setVisible(false);
				bRecogerMonedas.setVisible(true);
				modoIdle = new ModoIdle(cartaEnt1, cartaEnt2, cartaEnt3, Entrenamiento.this);
				System.out.println(cartaEnt1.getCarta());
				System.out.println(cartaEnt2.getCarta());
				System.out.println(cartaEnt3.getCarta());
				System.out.println(cartaEnt1.getCarta().getResistencia());
				modoIdle.start();
				lMonedasPorMinuto2.setText(modoIdle.getMonedasPorMinuto() + "");
			}			
		});
		bRecogerMonedas.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				bRecogerMonedas.setVisible(false);
				usuario.setMonedas(usuario.getMonedas() + modoIdle.getMonedasGeneradas());
				lMonedasGeneradas2.setText("0");
				lMonedasGeneradas2.repaint();
				bEntrenar.setVisible(true);						
				modoIdle.setGenerarMonedasCarta1(false);
				modoIdle.setGenerarMonedasCarta2(false);
				modoIdle.setGenerarMonedasCarta3(false);
				//TODO hacerlo bonito
				modoIdle.interrupt();
				usuario.nuevaCartaSinStamina(cartaEnt1.getCarta());
				usuario.nuevaCartaSinStamina(cartaEnt2.getCarta());
				usuario.nuevaCartaSinStamina(cartaEnt3.getCarta());
				if(modoIdle.isInterrupted()) {
					bClear.setEnabled(true);
				}
			}
		});
		
		cartaEnt1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaSeleccionEntrenar(Entrenamiento.this, usuario, datos, 1, cartasNoMostradas);
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
						new VentanaSeleccionEntrenar(Entrenamiento.this, usuario, datos, 2, cartasNoMostradas);
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
						new VentanaSeleccionEntrenar(Entrenamiento.this, usuario, datos, 3, cartasNoMostradas);
					}
				});
			}
		});
		
		bAlbum.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Album) ventanaAnterior).lMonedasAlbum.setText(String.valueOf(usuario.getMonedas()));
			}
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				((Album) ventanaAnterior).lMonedasAlbum.setText(String.valueOf(usuario.getMonedas()));
			}
		});

		
		bClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lError.setVisible(false);
				cartaEnt1 = cartaIzq;
				cartaEnt2 = cartaCen;
				cartaEnt3 = cartaDer;
				flowLayoutCartasH.removeAll();
				flowLayoutCartasH.add(cartaEnt1);
				flowLayoutCartasH.add(Box.createHorizontalStrut(50));
				flowLayoutCartasH.add(cartaEnt2);
				flowLayoutCartasH.add(Box.createHorizontalStrut(50));
				flowLayoutCartasH.add(cartaEnt3);
				revalidate();
				repaint();
				bEntrenar.setEnabled(false);
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
		
		if((cartaEnt1.getCarta().getId() == 0 || cartaEnt2.getCarta().getId() == 0 || cartaEnt3.getCarta().getId() == 0)) {
			bEntrenar.setEnabled(false);
		}

		if(cartaEnt1.getCarta().getId() != 0 && cartaEnt2.getCarta().getId() != 0 && cartaEnt3.getCarta().getId() != 0) {
			
			bEntrenar.setEnabled(false);
		}
		

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
		revalidate();
		repaint();
		bEntrenar.setEnabled(true);
		System.out.println(cartaEnt1.getCarta());
	}
	
	public void cambiarLabelMonedasGeneradas() {
		lMonedasGeneradas2.setText(modoIdle.getMonedasGeneradas() + "");
		lMonedasGeneradas2.repaint();
	}

	public void cambiarLabelMonedasPorMinuto() {
		lMonedasPorMinuto2.setText(modoIdle.getMonedasPorMinuto() + "");
		lMonedasPorMinuto2.repaint();
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