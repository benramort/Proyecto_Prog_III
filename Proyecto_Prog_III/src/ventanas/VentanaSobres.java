package ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import comportamientos.Carta;
import comportamientos.Usuario;

public class VentanaSobres extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VentanaSobres (JFrame ventanaAnterior) {
		Random numeroAleatorio = new Random();
		List<String> nombres = new ArrayList<String>();
		nombres .add("img/mario.png");
		nombres .add("img/kratos.png");
		nombres .add("img/luigi.png");
		
		///Formato Ventana
		setSize(1500,1000);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		setLocationRelativeTo(ventanaAnterior);
		//Crear Contenedores
		JPanel pCentro = new JPanel();
		JScrollPane sc = new JScrollPane(pCentro);
		
		//Formato Contenedores
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBorder(null);
		
		for (int i = 0; i < 3; i++) {
			//Crear Contenedores
			JPanel pCarta = new JPanel();
			JLabel lImagenSobre = new JLabel(new ImageIcon(nombres.get(i)));
			//Formato Contenedores
			pCarta.setLayout(new BorderLayout());
			//Añadir componentes a contenedores
			Carta c = new Carta(numeroAleatorio.nextInt(5));
			pCarta.add(lImagenSobre, BorderLayout.CENTER);
			
			
		}
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
