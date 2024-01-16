package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.*;
import interfaces.Datos;

public class VentanaSobres extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Random r = new Random();
	Datos datos;
	List<Carta> cartasDesbloqueadas = new ArrayList<>();
	
	public VentanaSobres (JFrame ventanaAnterior, Datos datos, int numCartasPorSobre, Usuario usuario) {
		
		///Formato Ventana
		setSize(1000,430);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		setLocationRelativeTo(ventanaAnterior);
		setResizable(false);
		//Crear Contenedores
		JPanel pCentro = new JPanel();
		JPanel pCerrar = new JPanel();
		//Crear Componentes
		JButton bCerrar = new JButton("CERRAR");
		
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		///Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		pCerrar.add(bCerrar);
		
		
		for (int i = 0; i < numCartasPorSobre; i++) {
			pCentro.add(new PanelCarta(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size()))));
			cartasDesbloqueadas.add(((PanelCarta)pCentro.getComponent(i)).getCarta());
		}
		
		for(Carta c : cartasDesbloqueadas) {
			if(usuario.getCartas().containsKey(c)) {
				usuario.getCartas().put(c, usuario.getCartas().get(c) + 1);
			}
		}
		
		getContentPane().add(pCentro, BorderLayout.CENTER );
		getContentPane().add(pCerrar, BorderLayout.SOUTH);
		
		bCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Tienda)ventanaAnterior).lMonedas.repaint();
				System.out.println("cerrando ventana");
				System.out.println(usuario.getMonedas());
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
