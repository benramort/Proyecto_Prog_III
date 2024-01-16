package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import domain.Compra;
import domain.Usuario;
import interfaces.Datos;
public class Tienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Datos datos;
	Usuario usuario;

	public JLabel lMonedas;
	
	public Tienda (JFrame ventanaAnterior, Usuario usuario, Datos datos) {
		List<String> nombres = new ArrayList<String>();
		nombres.add("Sobre Oro");
		nombres.add("Sobre Oro Premium");
		nombres.add("Megasobre");
		nombres.add("Sobre Ultimate");

		List<String> precios = new ArrayList<String>();
		precios.add("7500");
		precios.add("15000");
		precios.add("50000");
		precios.add("125000");
		///Formato Ventana
		setSize(1500,1000);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Universal Card Collection");
		setLocationRelativeTo(ventanaAnterior);

		///Crear Contenedores
		JPanel pSuperior = new JPanel();
		JPanel pMonedas = new JPanel();
		JPanel pCentro = new JPanel();

		JPanel pBotonHome = new JPanel();
		JPanel blCentro = new JPanel();
		JScrollPane sc = new JScrollPane(blCentro);

		///Formato Contenedores
		pSuperior.setLayout(new BorderLayout());
		pMonedas.setLayout(new FlowLayout((FlowLayout.RIGHT)));
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBorder(null);
		blCentro.setLayout(new BoxLayout(blCentro, BoxLayout.Y_AXIS));
		pCentro.setMaximumSize(new Dimension(5000,50));;

		///Crear Componentes
		JButton btAlbum = new JButton("ÁLBUM");
		lMonedas = new JLabel(String.valueOf(usuario.getMonedas()));
		JLabel lImagenMonedas = new JLabel();

		Path path7 = Path.of("resources/img/moneda.png");
		ImageIcon imagen7 = new ImageIcon(path7.toAbsolutePath().toString());
		ImageIcon imagenMoneda = new ImageIcon(imagen7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		Path pathLogo = Path.of("resoruces/img/logo chiquito.png");
		ImageIcon logoPequeño = new ImageIcon(pathLogo.toAbsolutePath().toString());
		///Formato componentes
		lImagenMonedas.setIcon(imagenMoneda);
		Font fuenteNombre = new Font("Arial",Font.BOLD, 32);
		btAlbum.setPreferredSize(new Dimension(90, 40));

		///Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		pSuperior.add(pBotonHome, BorderLayout.WEST);
		pBotonHome.add(btAlbum);
		pSuperior.add(pMonedas, BorderLayout.EAST);
		add(pSuperior, BorderLayout.NORTH);
		pMonedas.add(lMonedas);
		pMonedas.add(lImagenMonedas);
		blCentro.add(Box.createVerticalGlue());
		blCentro.add(pCentro);
		blCentro.add(Box.createVerticalGlue());


		for (int i = 0; i < nombres.size(); i++) {
			//Crear Contenedores
			JPanel pSobre = new JPanel();
			JPanel pNombreSobre = new JPanel();
			JPanel pPrecioSobre = new JPanel();
			JLabel lImagenMonedas2 = new JLabel();
			//Formato Contenedores
			pSobre.setLayout(new BorderLayout());
			pNombreSobre.setLayout(new FlowLayout(FlowLayout.CENTER));
			pPrecioSobre.setLayout(new FlowLayout(FlowLayout.CENTER));
			//Crear Componentes
			JLabel lNombreSobre = new JLabel(nombres.get(i));
			JLabel lPrecioSobre = new JLabel(precios.get(i));
			Path pathSobre = Path.of("resources/img/sobre.png");
			ImageIcon imagenSobre = new ImageIcon(pathSobre.toAbsolutePath().toString());
			ImageIcon imagenSobre2 = new ImageIcon(imagenSobre.getImage().getScaledInstance(400, 550, Image.SCALE_DEFAULT));
			JLabel lImagenSobre = new JLabel(imagenSobre2);
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
			pCentro.add(pSobre);
			pCentro.add(Box.createHorizontalStrut(100));
			//Añadir ActionListener
			lImagenSobre.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					Compra compra = new Compra(lNombreSobre, lPrecioSobre, datos, usuario, Tienda.this);
					compra.gestionarCompra(Tienda.this);
					
				}
			});

			getContentPane().add(sc, BorderLayout.CENTER );


			setVisible(true);

			btAlbum.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					((Album) ventanaAnterior).lMonedasAlbum.setText(usuario.getMonedas() + "");
					((Album) ventanaAnterior).cargarCartas();
					((Album) ventanaAnterior).repaint();
				}
			});
		}
		
		addWindowListener(new WindowAdapter() { //Por algun motivo este evento ocurre varias veces

			@Override
			public void windowClosing(WindowEvent e) {
				((Album) ventanaAnterior).lMonedasAlbum.setText(usuario.getMonedas() + "");
				((Album) ventanaAnterior).cargarCartas();
				((Album) ventanaAnterior).repaint();
			}

		});

	}
}
