package ventanas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class Tienda extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Tienda (JFrame ventanaAnterior) {
			List<String> nombres = new ArrayList<String>();
			nombres.add("Megasobre");
			nombres.add("Sobre Ultimate");
			nombres.add("Sobre Oro");
			nombres.add("Sobre Oro Premium");
			
			List<String> precios = new ArrayList<String>();
			precios.add("50000");
			precios.add("125000");
			precios.add("7500");
			precios.add("15000");
			///Formato Ventana
			setSize(1500,1000);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Universal Card Collection");
			setLocationRelativeTo(ventanaAnterior);
			
			///Crear Contenedores
			JPanel pSuperior = new JPanel();
			JPanel pMonedas = new JPanel();
			JPanel pCentro = new JPanel();
			JScrollPane sc = new JScrollPane(pCentro);
			JPanel pBotonHome = new JPanel();
			JPanel pInferior = new JPanel();
			
			///Formato Contenedores
			pSuperior.setLayout(new BorderLayout());
			pInferior.setLayout(new BorderLayout());
			pMonedas.setLayout(new FlowLayout((FlowLayout.RIGHT)));
			sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sc.setBorder(null);
			
			///Crear Componentes
			JButton btAlbum = new JButton("ÁLBUM");
			JLabel lMonedas = new JLabel("XXXXXXXXXX");
			JLabel lImagenMonedas = new JLabel();
			
			ImageIcon imagen7 = new ImageIcon(getClass().getResource("/moneda.png"));
			ImageIcon imagenMoneda = new ImageIcon(imagen7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			
			///Formato componentes
			lImagenMonedas.setIcon(imagenMoneda);
			Font fuenteNombre = new Font("Arial",Font.BOLD, 32);
			btAlbum.setPreferredSize(new Dimension(90, 40));
			
			///Añadir componentes a contenedores
			pSuperior.add(pBotonHome, BorderLayout.WEST);
			pBotonHome.add(btAlbum);
			pSuperior.add(pMonedas, BorderLayout.EAST);
			add(pSuperior, BorderLayout.NORTH);
			add(pInferior, BorderLayout.SOUTH);
			pMonedas.add(lMonedas);
			pMonedas.add(lImagenMonedas);
			
			
			for (int i = 0; i < nombres.size(); i++) {
				//Crear Contenedores
				JPanel pSobre = new JPanel();
				JPanel pNombreSobre = new JPanel();
				JPanel pPrecioSobre = new JPanel();
				JLabel lImagenMonedas2 = new JLabel();
				JPanel pAbrirSobre = new JPanel();
				//Formato Contenedores
				pSobre.setLayout(new BorderLayout());
				pNombreSobre.setLayout(new FlowLayout(FlowLayout.CENTER));
				pPrecioSobre.setLayout(new FlowLayout(FlowLayout.CENTER));
				//Crear Componentes
				JButton btAbrirSobres = new JButton("ABRIR");
				JLabel lNombreSobre = new JLabel(nombres.get(i));
				JLabel lPrecioSobre = new JLabel(precios.get(i));
				JLabel lImagenSobre = new JLabel(new ImageIcon("img/logo.png"));
				ImageIcon imagenMoneda2 = new ImageIcon(imagen7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
				//Formato Componentes
				lImagenMonedas2.setIcon(imagenMoneda2);
				lNombreSobre.setFont(fuenteNombre);
				lPrecioSobre.setFont(fuenteNombre);
				//Añadir componentes a contenedores
				pNombreSobre.add(lNombreSobre);
				pPrecioSobre.add(lPrecioSobre);
				pPrecioSobre.add(lImagenMonedas2);
				pSobre.add(pNombreSobre,BorderLayout.NORTH);
				pSobre.add(lImagenSobre, BorderLayout.CENTER);
				pSobre.add(pPrecioSobre,BorderLayout.SOUTH);
				pAbrirSobre.add(btAbrirSobres);
				pCentro.add(pSobre, BorderLayout.CENTER);
				pCentro.add(pAbrirSobre, BorderLayout.SOUTH);
				//Añadir ActionListener
				btAbrirSobres.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SwingUtilities.invokeLater(new Runnable() {
							
							@Override
							public void run() {
								new VentanaSobres (null);
								
							}
						});
					}
				});
			}
				
			
			
			getContentPane().add(sc, BorderLayout.CENTER );
			
			
			setVisible(true);
			
			btAlbum.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
		}
		
			
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new Tienda (null);
					
				}
			});
		}
		}
	
