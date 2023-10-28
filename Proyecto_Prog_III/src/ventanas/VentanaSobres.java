package ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentanaSobres extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VentanaSobres (JFrame ventanaAnterior) {
		List<String> nombres = new ArrayList<String>();
		nombres.add("img/mario.png");
		nombres.add("img/kratos.png");
		nombres.add("img/luigi.png");
		
		///Formato Ventana
		setSize(1500,1000);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		setLocationRelativeTo(ventanaAnterior);
		//Crear Contenedores
		JPanel pCentro = new JPanel();
		JScrollPane sc = new JScrollPane(pCentro);
		JPanel pCarta = new JPanel();
		//Formato Contenedores
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBorder(null);
		
		
		for (int i = 0; i < 3; i++) {
			//Crear Contenedores
			JLabel lImagenSobre = new JLabel(new ImageIcon(nombres.get(i)));
			//Formato Contenedores
			pCarta.setLayout(new BorderLayout());
			//Añadir componentes a contenedores
			pCarta.add(lImagenSobre, BorderLayout.CENTER);
			pCentro.add(pCarta);
		}
		
		getContentPane().add(sc, BorderLayout.CENTER );
		
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
