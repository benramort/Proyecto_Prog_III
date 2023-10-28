package ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import comportamientos.*;

public class VentanaSobres extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VentanaSobres (JFrame ventanaAnterior) {
		List<String> nombres = new ArrayList<String>();
		
		///Formato Ventana
		setSize(750,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		setLocationRelativeTo(ventanaAnterior);
		//Crear Contenedores
		JPanel pCentro = new JPanel();
//		JScrollPane sc = new JScrollPane(pCentro);
//		JPanel pCarta = new JPanel();
		//Formato Contenedores
//		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		sc.setBorder(null);
		
		Datos datos = new Ficheros();
		
		
		for (int i = 0; i < 3; i++) {
			pCentro.add(new PanelCarta(datos.getModeloCartas().get(0)));
		}
		
		
		getContentPane().add(pCentro, BorderLayout.CENTER );
		setVisible(true);
	}


public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			new VentanaSobres (null);
			
		}
	});
}
}
