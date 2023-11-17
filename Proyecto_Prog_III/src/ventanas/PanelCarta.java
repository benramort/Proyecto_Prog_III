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
	public static final int ANCHO_SAGA = 91;
	public static final int ALTO_SAGA = 39;
	
	Carta carta;
	boolean mostrandoStats = true;
	JPanel pInferior;
	JLabel lSaga;
	JLayeredPane lp;
	
	
	public PanelCarta(Carta carta) {
		this.carta = carta;
//		
		lp = new JLayeredPane();
		lp.setPreferredSize(new Dimension(228,328));
		add(lp);
		setMaximumSize(new Dimension(235,335));
		setOpaque(false);
		
		ImageIcon imagen = new ImageIcon(carta.getRecursoGrafico().getImage().getScaledInstance(ANCHO_FOTO, ALTO_FOTO, Image.SCALE_DEFAULT));
		
		JLabel lImagen = new JLabel(imagen);
		lImagen.setBounds(0,0,ANCHO_FOTO,ALTO_FOTO);
		
		lp.add(lImagen, Integer.valueOf(0));
		
		pInferior = new JPanel();
		JPanel pTexto = new JPanel();
		pTexto.setLayout(new BoxLayout(pTexto, BoxLayout.Y_AXIS));
		JPanel pProgressBar = new JPanel();
		pProgressBar.setLayout(new BoxLayout(pProgressBar, BoxLayout.Y_AXIS));
		
		JLabel lGeneracion = new JLabel("Gen.:");
		lGeneracion.setForeground(Color.WHITE);
		JLabel lResistencia = new JLabel("Res.:");
		lResistencia.setForeground(Color.WHITE);
		JLabel lRecuperacion = new JLabel("Rec.:");
		lRecuperacion.setForeground(Color.WHITE);
		
		JProgressBar pbGeneracion = new InvertedProgressBar(0, 100);
		JProgressBar pbResistencia = new InvertedProgressBar(0, 100);
		JProgressBar pbRecuperacion = new InvertedProgressBar(0, 100);
		
		ImageIcon logoSaga = new ImageIcon(carta.getSaga().getRecursoGrafico().getImage().getScaledInstance(ANCHO_SAGA, ALTO_SAGA, Image.SCALE_DEFAULT));
		lSaga = new JLabel(logoSaga);
		
		pInferior.setBounds(70, 260, ANCHO_FOTO-80, 70);
//		pInferior.setSize(new Dimension(ANCHO_FOTO-80, 70));
//		pInferior.setBackground(Color.GREEN);
		pInferior.setOpaque(false);
		pTexto.setOpaque(false);
		pProgressBar.setOpaque(false);
		pProgressBar.setPreferredSize(new Dimension(110,50));
		
//		lGeneracion.setToolTipText("Generación");
//		lResistencia.setToolTipText("Resistencia");
//		lRecuperacion.setToolTipText("Recuperación");
		
		pbGeneracion.setOpaque(false);
		pbGeneracion.setValue(carta.getMonedasPorMinuto());
		pbGeneracion.setForeground(Color.YELLOW);
		pbGeneracion.setBorderPainted(false);
//		pbGeneracion.setToolTipText("Generación");
		
		pbResistencia.setOpaque(false);
		pbResistencia.setValue(carta.getResistencia());
		pbResistencia.setForeground(Color.YELLOW);
		pbResistencia.setBorderPainted(false);
//		pbResistencia.setToolTipText("Resistencia");
		
		pbRecuperacion.setOpaque(false);
		pbRecuperacion.setValue(carta.getRecuperacion());
		pbRecuperacion.setForeground(Color.YELLOW);
		pbRecuperacion.setBorderPainted(false);
//		pbRecuperacion.setToolTipText("Recuperación");
		
		lSaga.setBounds(130, 2, ANCHO_SAGA, ALTO_SAGA);
		
		lp.add(pInferior, Integer.valueOf(1));
		pInferior.add(pTexto);
		pTexto.add(lGeneracion);
		pTexto.add(Box.createVerticalStrut(1));
		pTexto.add(lResistencia);
		pTexto.add(Box.createVerticalStrut(1));
		pTexto.add(lRecuperacion);
		
		pInferior.add(pProgressBar);
		pProgressBar.add(pbGeneracion);
		pProgressBar.add(Box.createVerticalStrut(3));
		pProgressBar.add(pbResistencia);
		pProgressBar.add(Box.createVerticalStrut(3));
		pProgressBar.add(pbRecuperacion);
		
		lp.add(lSaga, Integer.valueOf(1));
		
		mostrarStats(false);
		
	}
	
	public void mostrarStats(boolean flag) { 
		pInferior.setVisible(flag);
		lSaga.setVisible(flag);
		lp.repaint();
		mostrandoStats = flag;
	}
	
	public boolean isMostrandoStats() {
		return mostrandoStats;
	}
	
	public Carta getCarta() {
		return this.carta;
	}
	
	

}

