package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*;

public class Entrenamiento extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Entrenamiento(JFrame ventanaAnterior) {
		//Formato ventana
		setTitle("Entrenamiento");
		setSize(1500, 1000);
		setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Creacion contenedores
		JPanel pInferior = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pBotonClear = new JPanel();
		JPanel pTextos = new JPanel();
		JPanel pBarraProgreso = new JPanel();
		JPanel pCartas = new JPanel();
		JPanel boxLayoutCartasH = new JPanel();
		JPanel boxLayoutCartasV = new JPanel();
		JPanel pBotonAlbum = new JPanel();
		//Formato contenedores
		pInferior.setLayout(new BorderLayout());
		pTextos.setLayout(new FlowLayout(FlowLayout.CENTER));
		pCentral.setLayout(new BorderLayout());
		pCartas.setLayout(new FlowLayout(FlowLayout.CENTER));
		boxLayoutCartasH.setLayout(new BoxLayout(boxLayoutCartasH, BoxLayout.X_AXIS));
		boxLayoutCartasV.setLayout(new BoxLayout(boxLayoutCartasV, BoxLayout.Y_AXIS));
		pBotonAlbum.setLayout(new FlowLayout(FlowLayout.LEFT));
		boxLayoutCartasH.setMaximumSize(new Dimension(1000,1000));
		boxLayoutCartasV.setOpaque(true);
		boxLayoutCartasV.setBackground(Color.BLUE);
//		boxLayoutCartasH.setOpaque(false);
		boxLayoutCartasH.setBackground(Color.RED);
		//Creacion componentes
		JButton bAlbum = new JButton("ÁLBUM");
		JLabel lMonedasGeneradas = new JLabel("Monedas generadas: " );
		JLabel lMonedasGeneradas2 = new JLabel("XXXXXX");
		JLabel lMonedasPorMinuto = new JLabel("Monedas/minuto: " );
		JLabel lMonedasPorMinuto2 = new JLabel("XXXXXX" );
		JLabel lImagenMonedasGeneradas = new JLabel();
		JLabel lImagenMonedasPorMinuto = new JLabel();
		JButton bClear = new JButton("CLEAR");
		JProgressBar pbProgreso = new JProgressBar(0, 100);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		CartaEntrenando carta1 = new CartaEntrenando();
		CartaEntrenando carta2 = new CartaEntrenando();
		CartaEntrenando carta3 = new CartaEntrenando();
		//Formato componentes
		pbProgreso.setPreferredSize(new Dimension(1000, 30));
		bAlbum.setPreferredSize(new Dimension(90, 40));
		//Añadir componentes a contenedores
		this.getContentPane().add(pInferior, BorderLayout.SOUTH);
		this.getContentPane().add(pCentral, BorderLayout.CENTER);
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
		pBarraProgreso.add(pbProgreso);
		pCentral.add(pBarraProgreso, BorderLayout.SOUTH);
		pCentral.add(pCartas, BorderLayout.CENTER);		
		pCartas.add(boxLayoutCartasV);
		boxLayoutCartasV.add(Box.createHorizontalGlue());
//		boxLayoutCartasV.setBackground(Color.BLUE);
		boxLayoutCartasH.add(carta1);
		boxLayoutCartasH.add(Box.createHorizontalStrut(50));
		boxLayoutCartasH.add(carta2);
		boxLayoutCartasH.add(Box.createHorizontalStrut(50));
		boxLayoutCartasH.add(carta3);
//		pCartas.add(Box.createVerticalStrut(900));
		boxLayoutCartasV.add(boxLayoutCartasH);
		pBotonAlbum.add(bAlbum);
		pCentral.add(pBotonAlbum, BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	
	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				new Entrenamiento(null);
//				
//			}
//		});
//	}
}
