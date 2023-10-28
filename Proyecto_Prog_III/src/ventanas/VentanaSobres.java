package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import comportamientos.*;

public class VentanaSobres extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VentanaSobres (JFrame ventanaAnterior) {
		Random r = new Random();
		///Formato Ventana
		setSize(800,450);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		setLocationRelativeTo(ventanaAnterior);
		//Crear Contenedores
		JPanel pCentro = new JPanel();
		JPanel pCerrar = new JPanel();
		//Crear Componentes
		JButton cerrar = new JButton("CERRAR");
		
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		///Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		pCerrar.add(cerrar);
		
		Datos datos = new Ficheros();
		
		
		for (int i = 0; i < 3; i++) {
			pCentro.add(new PanelCarta(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size()))));
		}
		
		getContentPane().add(pCentro, BorderLayout.CENTER );
		getContentPane().add(pCerrar, BorderLayout.SOUTH);
		
		cerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	
		setVisible(true);
	}


//public static void main(String[] args) {
//	SwingUtilities.invokeLater(new Runnable() {
//		
//		@Override
//		public void run() {
//			new VentanaSobres (null);
//			
//		}
//	});
//}
}
