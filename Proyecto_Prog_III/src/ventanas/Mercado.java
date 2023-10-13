package ventanas;

import java.awt.*;
import javax.swing.*;

public class Mercado extends JFrame {
	
	public Mercado(JFrame ventanaAnterior) {
		//Formato ventana
		setTitle("Mercado");
		setSize(1000,1000);
		setLocationRelativeTo(ventanaAnterior);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pIzquierdo = new JPanel();
		JPanel pSuperior = new JPanel();
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
		
		pSuperior.setBackground(Color.blue);
		pSuperior.setLayout(new BoxLayout(pSuperior, BoxLayout.Y_AXIS));
		pSuperior.add(Box.createVerticalGlue());
		
		
		pPrecio1.setMaximumSize(new Dimension(400, 800));
		pPrecio1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pPrecio2.setMaximumSize(new Dimension(400, 800));
		pPrecio2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pSaga.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pCentral.setLayout(new BoxLayout(pCentral, BoxLayout.Y_AXIS));
		pCentral.add(Box.createVerticalGlue());
		
		pBotonHome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pMonedas.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pInferior.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Crear componentes
		
			//Componentes pSuperior
		JButton BotonHome = new JButton("HOME");
		JLabel CantidadMonedas = new JLabel("XXXX");
		JLabel Monedas = new JLabel("Monedas");
		
			//Componentes pCentral
		JTextField buscar = new JTextField(1);
		JLabel PrecioMin = new JLabel("Precio mínimo");
		JSpinner selPrecioMin = new JSpinner();
		JLabel PrecioMax = new JLabel("Precio máximo");
		JSpinner selPrecioMax = new JSpinner();
		JLabel Saga = new JLabel("Saga");
		JComboBox selSaga = new JComboBox();
		
			//Botón de abajo
		JButton botonVender = new JButton("Vender");
		
		//Formato componentes
		buscar.setMaximumSize(new Dimension(100,100));
		selPrecioMin.setPreferredSize(new Dimension(100, 25));
		selPrecioMax.setPreferredSize(new Dimension(100, 25));
		botonVender.setPreferredSize(new Dimension(150,70));
		BotonHome.setPreferredSize(new Dimension(100,30));
		
		//Añadir componentes a contenedores
		getContentPane().add(pIzquierdo,BorderLayout.WEST);
		
		pIzquierdo.add(pSuperior,BorderLayout.NORTH);
		pIzquierdo.add(pCentral,BorderLayout.CENTER);
		pIzquierdo.add(pInferior, BorderLayout.SOUTH);
		
		pSuperior.add(pBotonHome, BorderLayout.WEST);
		pSuperior.add(pMonedas);
		
		pBotonHome.add(BotonHome);
		pMonedas.add(CantidadMonedas);
		pMonedas.add(Monedas);
		
		pCentral.add(buscar);
		pCentral.add(pPrecio1);
		pCentral.add(pPrecio2);
		pCentral.add(pSaga);
		
		pPrecio1.add(PrecioMin);
		pPrecio1.add(selPrecioMin);
		pPrecio2.add(PrecioMax);
		pPrecio2.add(selPrecioMax);
		pSaga.add(Saga);
		pSaga.add(selSaga);
		
		pInferior.add(botonVender);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Mercado(null);
	}
	
}
