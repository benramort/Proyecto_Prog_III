package ventanas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelPorcentaje extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int grados = 0;
	private BufferedImage buffer;
	private Graphics2D graficos;
	private int anchura;
	private int altura;
	
	public PanelPorcentaje(double porcentaje, int anchura, int altura) {
		if (porcentaje > 100) {
			this.grados = 360;
		} else {
			calcularGrados(porcentaje);
		}
		buffer = new BufferedImage(anchura, altura, BufferedImage.TYPE_4BYTE_ABGR);
		graficos = buffer.createGraphics();
		this.altura = altura;
		this.anchura = anchura;
	}
	
	private void calcularGrados(double porcentaje) {
		System.out.println("Porcentaje:" +  porcentaje);
		grados = (int) (porcentaje * 360 / 100);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		dibujar();
		((Graphics2D) g).drawImage(buffer, null, 0, 0);
		System.out.println("Pintado");
	}
	
	public void dibujar() {
		graficos.setStroke(new BasicStroke(3));
		graficos.setColor(Color.BLACK);
		graficos.drawRect(0, 0, anchura, altura);
		System.out.println(grados);
		int anchuraArco = 200;
		graficos.fillArc(anchura/2-anchuraArco/2, altura/2-anchuraArco/2, anchuraArco, anchuraArco, 90, -grados);
		graficos.setColor(getBackground());
		anchuraArco = (int) (anchuraArco *0.65);
		graficos.fillArc(anchura/2-anchuraArco/2, altura/2-anchuraArco/2, anchuraArco, anchuraArco, 0, 360);
		graficos.setColor(Color.BLACK);
	}
	
	
	
	

}
