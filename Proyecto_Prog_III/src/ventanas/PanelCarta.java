package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;
import comportamientos.Carta;

public class PanelCarta extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ANCHO_FOTO = 228;
	public static final int ALTO_FOTO = 328;
	
	Carta carta;
	
	public PanelCarta(Carta carta) {
		this.carta = carta;
//		
		JLayeredPane lp = new JLayeredPane();
		lp.setPreferredSize(new Dimension(1000,1000));
		add(lp);
		
		ImageIcon imagen = new ImageIcon(carta.getRecursoGrafico().getImage().getScaledInstance(ANCHO_FOTO, ALTO_FOTO, Image.SCALE_DEFAULT));
		
		JLabel lImagen = new JLabel(imagen);
		lImagen.setBounds(0,0,ANCHO_FOTO,ALTO_FOTO);
		
		lp.add(lImagen, Integer.valueOf(0));
		
		JPanel pInferior = new JPanel();
		JPanel pTexto = new JPanel();
		pTexto.setLayout(new BoxLayout(pTexto, BoxLayout.Y_AXIS));
		JPanel pProgressBar = new JPanel();
		pProgressBar.setLayout(new BoxLayout(pProgressBar, BoxLayout.Y_AXIS));
		
		pInferior.setBounds(70, 240, 0, 0);
		pInferior.setSize(new Dimension(ANCHO_FOTO-80, 70));
		pInferior.setBackground(Color.GREEN);
		
		lp.add(pInferior, Integer.valueOf(1));
		
		
		
	}
	
	

}

