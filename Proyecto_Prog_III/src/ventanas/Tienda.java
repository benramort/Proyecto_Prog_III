package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class Tienda extends JFrame{
	
	public Tienda() {
		///Formato Ventana
		setSize(1500,1000);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		
		///Crear Contenedores
		JPanel pSuperior = new JPanel();
		JPanel pMonedas = new JPanel();
		JPanel pCentro = new JPanel();
		JScrollPane sc = new JScrollPane(pCentro);
		JPanel pSobre = new JPanel();
		JPanel pNombreSobre = new JPanel();
		JPanel pPrecioSobre = new JPanel();
		
		///Formato Contenedores
		pSuperior.setLayout(new BorderLayout());
		pMonedas.setLayout(new FlowLayout((FlowLayout.RIGHT)));
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBorder(null);
		pSobre.setLayout(new BorderLayout());
		pNombreSobre.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPrecioSobre.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		///Crear Componentes
		JButton btHome = new JButton("áLBUM");
		JLabel lMonedas = new JLabel("XXXXXXXXXX");
		JLabel lImagenMonedas = new JLabel();
		JLabel lImagenMonedas2 = new JLabel();
		JLabel lNombreSobre = new JLabel("Megasobre");
		JLabel lPrecioSobre = new JLabel("50.000");
		JLabel lImagenSobre = new JLabel(new ImageIcon("img/yoshi.png"));
		
		
		ImageIcon imagen7 = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imagenMoneda2 = new ImageIcon(imagen7.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		///Formato componentes
		lImagenMonedas.setIcon(imagenMoneda);
		lImagenMonedas2.setIcon(imagenMoneda2);
		Font fuenteNombre = new Font("Arial",Font.BOLD, 32);
		lNombreSobre.setFont(fuenteNombre);
		lPrecioSobre.setFont(fuenteNombre);
		
		///Añadir componentes a contenedores
		pSuperior.add(btHome, BorderLayout.WEST);
		pSuperior.add(pMonedas, BorderLayout.EAST);
		add(pSuperior, BorderLayout.NORTH);
		pMonedas.add(lMonedas);
		pMonedas.add(lImagenMonedas);
		pNombreSobre.add(lNombreSobre);
		pPrecioSobre.add(lPrecioSobre);
		pPrecioSobre.add(lImagenMonedas2);
		pSobre.add(pNombreSobre,BorderLayout.NORTH);
		pSobre.add(lImagenSobre, BorderLayout.CENTER);
		pSobre.add(pPrecioSobre,BorderLayout.SOUTH);
		pCentro.add(pSobre, BorderLayout.CENTER);
		
		
		getContentPane().add(sc, BorderLayout.CENTER );
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Tienda();
				
			}
		});
	}
}
