package ventanas;

import java.awt.*;
import javax.swing.*;

public class Mercado extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Mercado(JFrame ventanaAnterior) {
		//Formato ventana
		setTitle("Mercado");
		setSize(1000,1000);
		setLocationRelativeTo(ventanaAnterior);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pIzquierdo = new JPanel();
		JPanel pDerecho = new JPanel();
		JPanel pIzqSuperior = new JPanel();
		JPanel pDerSuperior = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pInferior = new JPanel();
		JPanel pBotonHome = new JPanel();
		JPanel pMonedas = new JPanel();
		JPanel pPrecio1 = new JPanel();
		JPanel pPrecio2 = new JPanel();
		JPanel pSaga = new JPanel();
		JPanel pBotonVender = new JPanel();
		
		
		//Formato contenedores
		pIzquierdo.setLayout(new BorderLayout());
		pBotonHome.setLayout(new BorderLayout());
		
		pDerecho.setLayout(new BorderLayout());
		pDerSuperior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		pIzqSuperior.setLayout(new BoxLayout(pIzqSuperior, BoxLayout.Y_AXIS));
		pIzqSuperior.add(Box.createVerticalGlue());
		
		
		pPrecio1.setMaximumSize(new Dimension(400, 800));
		pPrecio1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pPrecio2.setMaximumSize(new Dimension(400, 800));
		pPrecio2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pSaga.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pCentral.setLayout(new BoxLayout(pCentral, BoxLayout.Y_AXIS));
		pCentral.add(Box.createVerticalGlue());
		
		pBotonHome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInferior.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Crear componentes
		JButton bBotonHome = new JButton("ÁLBUM");
		JLabel lMonedas = new JLabel("XXXXXXXXXX");
		JLabel lImagenMonedas = new JLabel();
		JTextField tfBuscar = new JTextField(1);
		JLabel lPrecioMin = new JLabel("Precio mínimo");
		JSpinner spSelPrecioMin = new JSpinner();
		JLabel lPrecioMax = new JLabel("Precio máximo");
		JSpinner spSelPrecioMax = new JSpinner();
		JLabel lSaga = new JLabel("Saga");
		JComboBox cbSelSaga = new JComboBox();
		JButton botonVender = new JButton("Vender");
		
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		//Formato componentes
		lImagenMonedas.setIcon(imagenMoneda);
		tfBuscar.setMaximumSize(new Dimension(100,100));
		spSelPrecioMin.setPreferredSize(new Dimension(100, 25));
		spSelPrecioMax.setPreferredSize(new Dimension(100, 25));
		botonVender.setPreferredSize(new Dimension(150,70));
		bBotonHome.setPreferredSize(new Dimension(100,30));
		cbSelSaga.setMinimumSize(new Dimension(200, 200));
		
		//Añadir componentes a contenedores
		getContentPane().add(pIzquierdo,BorderLayout.WEST);
		getContentPane().add(pDerecho, BorderLayout.CENTER);
		
		pDerecho.add(pDerSuperior, BorderLayout.NORTH);
		pDerSuperior.add(pMonedas);
		pMonedas.add(lMonedas);
		pMonedas.add(lImagenMonedas);
		
		pIzquierdo.add(pIzqSuperior,BorderLayout.NORTH);
		pIzquierdo.add(pCentral,BorderLayout.CENTER);
		pIzquierdo.add(pInferior, BorderLayout.SOUTH);
		
		pIzqSuperior.add(pBotonHome, BorderLayout.WEST);
		
		pBotonHome.add(bBotonHome);
		
		pCentral.add(tfBuscar);
		pCentral.add(pPrecio1);
		pCentral.add(pPrecio2);
		pCentral.add(pSaga);
		
		pPrecio1.add(lPrecioMin);
		pPrecio1.add(spSelPrecioMin);
		pPrecio2.add(lPrecioMax);
		pPrecio2.add(spSelPrecioMax);
		pSaga.add(lSaga);
		pSaga.add(cbSelSaga);
		
		pInferior.add(botonVender);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Mercado(null);
				
			}
		});
		
	}
	
}
