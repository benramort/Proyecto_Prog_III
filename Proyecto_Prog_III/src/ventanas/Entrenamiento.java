package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import comportamientos.Carta;
import comportamientos.CartaAEntrenar;
import comportamientos.Datos;
import comportamientos.Ficheros;
import comportamientos.ModoIdle;
import comportamientos.Saga;
import comportamientos.Usuario;

public class Entrenamiento extends JFrame{

/**
*
*/
private static final long serialVersionUID = 1L;

	CartaEntrenando cartaEnt1 = new CartaEntrenando(new CartaAEntrenar(), 1);
	CartaEntrenando cartaEnt2 = new CartaEntrenando(new CartaAEntrenar(), 2);
	CartaEntrenando cartaEnt3 = new CartaEntrenando(new CartaAEntrenar(), 3);
	Datos datos = new Ficheros();
	Usuario usuario = new Usuario("Beñat","contrasena",datos);
	ModoIdle modoIdle;
	JButton bEntrenar;
	
	public Entrenamiento(JFrame ventanaAnterior, Usuario usuario) {
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
		JPanel flowLayoutCartasH = new JPanel();
		JPanel boxLayoutCartasV = new JPanel();
		JPanel pBotonAlbum = new JPanel();
		JPanel pBotonEntrenar = new JPanel();
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
		JLabel lMonedasGeneradas2 = new JLabel("XXXXXX");
		JLabel lMonedasPorMinuto = new JLabel("Monedas/segundo: " );
		JLabel lMonedasPorMinuto2 = new JLabel("XXXXXX" );
		JLabel lImagenMonedasGeneradas = new JLabel();
		JLabel lImagenMonedasPorMinuto = new JLabel();
		JButton bClear = new JButton("CLEAR");
		ImageIcon imagen = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		bEntrenar = new JButton("ENTRENAR");
		JButton bRecogerMonedas = new JButton("RECOGER MONEDAS");
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		//Formato componentes
		bAlbum.setPreferredSize(new Dimension(90, 40));
		bEntrenar.setPreferredSize(new Dimension(150, 50));
		bRecogerMonedas.setPreferredSize(new Dimension(150, 50));
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
				modoIdle = new ModoIdle(cartaEnt1, cartaEnt2, cartaEnt3);
				modoIdle.start();
			}			
		});
		bRecogerMonedas.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				bRecogerMonedas.setVisible(false);
				usuario.setMonedas(usuario.getMonedas() + modoIdle.getMonedasGeneradas());
				bEntrenar.setVisible(true);						
				modoIdle.setGenerarMonedasCarta1(false);
				modoIdle.setGenerarMonedasCarta2(false);
				modoIdle.setGenerarMonedasCarta3(false);
				//TODO hacerlo bonito
				//modoIdle.interrupt();
				System.out.println(modoIdle.isInterrupted());
			}
		});
		
		cartaEnt1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaSeleccion(Entrenamiento.this, usuario, datos);
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
						new VentanaSeleccion(Entrenamiento.this, usuario, datos);
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
						new VentanaSeleccion(Entrenamiento.this, usuario, datos);
					}
				});
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
		
		if(cartaEnt1.getCarta().getId() == 0 && cartaEnt2.getCarta().getId() == 0 && cartaEnt3.getCarta().getId() == 0) {
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
			cartaEnt1.setCarta(carta);
			System.out.println(carta.getId());
		case 2: 
			cartaEnt2 = new CartaEntrenando(carta, 2);		
		case 3: 
			cartaEnt3 = new CartaEntrenando(carta, 3);		
		default: 
		//TODO hacer una excepcion
		}
		repaint();
		bEntrenar.setEnabled(true);
		System.out.println(cartaEnt1.getCarta());
	}
}