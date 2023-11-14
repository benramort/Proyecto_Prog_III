package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import comportamientos.Carta;
import comportamientos.ModoIdle;
import comportamientos.Saga;
import comportamientos.Usuario;

public class Entrenamiento extends JFrame{

/**
*
*/
private static final long serialVersionUID = 1L;

	Carta carta1 = new Carta("mario", new Saga("SuperMario"));
	Carta carta2 = new Carta("mario", new Saga("SuperMario"));
	Carta carta3 = new Carta("mario", new Saga("SuperMario"));
	Usuario usuario;
	
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
		CartaEntrenando cartaEnt1 = new CartaEntrenando(carta1);
		CartaEntrenando cartaEnt2 = new CartaEntrenando(carta2);
		CartaEntrenando cartaEnt3 = new CartaEntrenando(carta3);
		JButton bEntrenar = new JButton("ENTRENAR");
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
	
		bEntrenar.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				bEntrenar.setVisible(false);
				bRecogerMonedas.setVisible(true);
				ModoIdle modoIdle = new ModoIdle(cartaEnt1, cartaEnt2, cartaEnt3);
				modoIdle.start();
				bRecogerMonedas.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					bRecogerMonedas.setVisible(false);
					usuario.setMonedas(usuario.getMonedas() + modoIdle.getMonedasGeneradas());
					bEntrenar.setVisible(true);						
					
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
	
	}
	}