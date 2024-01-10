package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import comportamientos.Carta;
import comportamientos.CartaAEntrenar;
import comportamientos.Datos;
import comportamientos.Usuario;

public class VentaCartas extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CartaAEntrenar carta1 = new CartaAEntrenar();

	CartaVendiendo carta = new CartaVendiendo(carta1, "");

	CartaVendiendo cartaVen = carta;

	Datos datos;
	Usuario usuario;
	
	JPanel flowLayoutCartasH;
	Color color = new Color(255, 1, 1);
	public JButton bClear;
	
	List<Carta> cartasNoMostradas = new ArrayList<>();
	
	
	public VentaCartas(JFrame ventanaAnterior, Usuario usuario, Datos datos) {
		this.usuario = usuario;
		this.datos = datos;
		for(Entry<Carta, Integer> e : usuario.getCartas().entrySet()) {
			if(e.getValue() == 1) {
				cartasNoMostradas.add(e.getKey());
			}
		}
		//Formato ventana
		setTitle("Vender cartas");
		setSize(1500, 1000);
		setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Creacion contenedores
		JPanel pInferior = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pBotonClear = new JPanel();
		JPanel pTextos = new JPanel();
		JPanel pCartas = new JPanel();
		JPanel blCentro = new JPanel();
		flowLayoutCartasH = new JPanel();
		JPanel boxLayoutCartasV = new JPanel();
		JPanel pBotonMercado = new JPanel();
		JPanel pBotonRecogerMonedas = new JPanel();
		//Formato contenedores
		pInferior.setLayout(new BorderLayout());
		pTextos.setLayout(new FlowLayout(FlowLayout.CENTER));
		pCentral.setLayout(new BorderLayout());
		pCentral.setMaximumSize(new Dimension(100000,500));
		pCartas.setLayout(new FlowLayout(FlowLayout.CENTER));
		flowLayoutCartasH.setLayout(new FlowLayout(FlowLayout.CENTER));
//		flowLayoutCartasH.setOpaque(true);
//		flowLayoutCartasH.setBackground(color);
		boxLayoutCartasV.setLayout(new BoxLayout(boxLayoutCartasV, BoxLayout.Y_AXIS));
		pBotonMercado.setLayout(new FlowLayout(FlowLayout.LEFT));
		// pBotonAlbum.setMaximumSize(new Dimension(10000,50));
		flowLayoutCartasH.setMaximumSize(new Dimension(2000,1000));
//		boxLayoutCartasV.setOpaque(true);
		boxLayoutCartasV.setBackground(Color.BLUE);
		blCentro.setLayout(new BoxLayout(blCentro, BoxLayout.Y_AXIS));
		//Creacion componentes
		JButton bMercado = new JButton("MERCADO");
		bClear = new JButton("CLEAR");
		ImageIcon imagen = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		//Formato componentes
		bMercado.setPreferredSize(new Dimension(100, 40));
		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		this.getContentPane().add(pInferior, BorderLayout.SOUTH);
		this.getContentPane().add(blCentro, BorderLayout.CENTER);
		blCentro.add(Box.createVerticalGlue());
		blCentro.add(pCentral);
		blCentro.add(Box.createVerticalGlue());
		pInferior.add(pBotonClear, BorderLayout.EAST);
		pBotonClear.add(bClear);
		pInferior.add(pTextos, BorderLayout.CENTER);
		pCentral.add(pCartas);
		pCartas.add(boxLayoutCartasV);
		// boxLayoutCartasV.add(Box.createVerticalGlue());
		// boxLayoutCartasV.setBackground(Color.BLUE);
		boxLayoutCartasV.add(flowLayoutCartasH);
		flowLayoutCartasH.add(cartaVen);
//		pBotonRecogerMonedas.add(bRecogerMonedas);
//		pBotonEntrenar.add(bRecogerMonedas);
		pBotonMercado.add(bMercado);
		add(pBotonMercado, BorderLayout.NORTH);
		
		setVisible(true);
	
		bMercado.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
//		if(cartaEnt1.getCarta().equals(new CartaAEntrenar()) && cartaEnt2.getCarta().equals(new CartaAEntrenar()) && cartaEnt3.getCarta().equals(new CartaAEntrenar())) {
//			bEntrenar.setEnabled(false);
//		}
		
//		bRecogerMonedas.addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				bRecogerMonedas.setVisible(false);
//				usuario.setMonedas(usuario.getMonedas() + modoIdle.getMonedasGeneradas());
//				lMonedasGeneradas2.setText("0");
//				lMonedasGeneradas2.repaint();
//				bEntrenar.setVisible(true);						
//				modoIdle.setGenerarMonedasCarta1(false);
//				modoIdle.setGenerarMonedasCarta2(false);
//				modoIdle.setGenerarMonedasCarta3(false);
//				//TODO hacerlo bonito
//				modoIdle.interrupt();
//				if(modoIdle.isInterrupted()) {
//					bClear.setEnabled(true);
//				}
////				System.out.println("Está interrumpido? " + modoIdle.isInterrupted());
//			}
//		});
		
		cartaVen.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaSeleccionVender(VentaCartas.this, usuario, datos, cartasNoMostradas);
					}
				});
			}
		});
		
		
		bMercado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Mercado) ventanaAnterior).lMonedas.setText(String.valueOf(usuario.getMonedas()));
			}
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				((Mercado) ventanaAnterior).lMonedas.setText(String.valueOf(usuario.getMonedas()));
			}
		});

		
		bClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cartaVen = carta;
;
				flowLayoutCartasH.removeAll();
				flowLayoutCartasH.add(cartaVen);
//				flowLayoutCartasH.add(new JLabel("Hol"));
				revalidate();
				repaint();
				cartasNoMostradas.clear();
			}
		});
	
		// public static void main(String[] args) {
		// SwingUtilities.invokeLater(new Runnable() {
		//
		// @Override
		// public void run() {
		// new Entrenamiento(null);
		//
		// }
		// });
		// }
		
//		if((cartaEnt1.getCarta().getId() == 0 || cartaEnt2.getCarta().getId() == 0 || cartaEnt3.getCarta().getId() == 0)) {
//			bRecogerMonedas.setEnabled(false);
//		}
//
//		if(cartaEnt1.getCarta().getId() != 0 && cartaEnt2.getCarta().getId() != 0 && cartaEnt3.getCarta().getId() != 0) {
//			bRecogerMonedas.setEnabled(false);
//		}
		

	}
	
	public CartaVendiendo getCartaVen() {
		return cartaVen;
	}


	public void cambiarCartaVendiendo(Carta carta, Object precio) {
		cartaVen = new CartaVendiendo(carta, precio);
		repaint();

		flowLayoutCartasH.removeAll();
		flowLayoutCartasH.add(cartaVen);
//		flowLayoutCartasH.add(new JLabel("Hol"));
		revalidate();
		repaint();
	}

	

	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				new Entrenamiento(null, usuario);
//				
//			}
//		});
//	}
}
