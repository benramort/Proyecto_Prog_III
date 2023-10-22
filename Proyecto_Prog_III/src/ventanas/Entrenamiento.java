package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Entrenamiento extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Entrenamiento(JFrame ventanaAnterior) {
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
		JPanel pBarraProgreso = new JPanel();
		JPanel pCartas = new JPanel();
		JPanel flowLayoutCartasH = new JPanel();
		JPanel boxLayoutCartasV = new JPanel();
		JPanel pBotonAlbum = new JPanel();
		JPanel pBotonEntrenar = new JPanel();
		//Formato contenedores
		pInferior.setLayout(new BorderLayout());
		pTextos.setLayout(new FlowLayout(FlowLayout.CENTER));
		pCentral.setLayout(new BorderLayout());
		pCartas.setLayout(new FlowLayout(FlowLayout.CENTER));
		pBotonEntrenar.setLayout(new FlowLayout(FlowLayout.CENTER));
		flowLayoutCartasH.setLayout(new FlowLayout(FlowLayout.CENTER));
		boxLayoutCartasV.setLayout(new BoxLayout(boxLayoutCartasV, BoxLayout.Y_AXIS));
		pBotonAlbum.setLayout(new FlowLayout(FlowLayout.LEFT));
		flowLayoutCartasH.setMaximumSize(new Dimension(1000,1000));
		boxLayoutCartasV.setOpaque(true);
//		boxLayoutCartasH.setOpaque(false);
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
		JButton bEntrenar = new JButton("ENTRENAR");
		//Formato componentes
		pbProgreso.setPreferredSize(new Dimension(1000, 30));
		bAlbum.setPreferredSize(new Dimension(90, 40));
		pbProgreso.setStringPainted(true);
		bEntrenar.setPreferredSize(new Dimension(150, 50));
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
		pCentral.add(pCartas, BorderLayout.CENTER);		
		pCartas.add(boxLayoutCartasV);
//		boxLayoutCartasV.add(Box.createVerticalGlue());
//		boxLayoutCartasV.setBackground(Color.BLUE);
		flowLayoutCartasH.add(carta1);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(carta2);
		flowLayoutCartasH.add(Box.createHorizontalStrut(50));
		flowLayoutCartasH.add(carta3);
		pBarraProgreso.add(pbProgreso);
		pBotonEntrenar.add(bEntrenar);
		boxLayoutCartasV.add(flowLayoutCartasH);
		boxLayoutCartasV.add(pBarraProgreso);
		boxLayoutCartasV.add(pBotonEntrenar);
		pBotonAlbum.add(bAlbum);
		pCentral.add(pBotonAlbum, BorderLayout.NORTH);
		
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
				Thread hiloBarraProgresoThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						bEntrenar.setEnabled(false);
						
						for(int i = 0; i <= 100; i++) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								
							}
							int valor = i;
						
							SwingUtilities.invokeLater(new Runnable() {
								
								@Override
								public void run() {
									pbProgreso.setValue(valor);
									
								}
							});
						}
						bEntrenar.setEnabled(true);
					}
		});
				hiloBarraProgresoThread.start();
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
		});
	}
}
	
