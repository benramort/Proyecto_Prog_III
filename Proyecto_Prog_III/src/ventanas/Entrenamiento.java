package ventanas;

import java.awt.BorderLayout;

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
		JPanel pSuperior = new JPanel();
		JPanel pInferior = new JPanel();
		//Formato contenedores
		
		//Creacion componentes
		JButton bAlbum = new JButton("ÁLBUM");
		JLabel lMonedasGeneradas = new JLabel("Monedas generadas: " );
		JLabel lMonedasPorMinuto = new JLabel("Monedas/minuto: " );
		JButton bClear = new JButton("CLEAR");
		JProgressBar pbProgreso = new JProgressBar(0, 100);
		//Formato componentes
		
		//Añadir componentes a contenedores
		
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Entrenamiento(null);
				
			}
		});
	}
}
