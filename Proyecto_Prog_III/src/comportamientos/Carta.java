package comportamientos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Carta {
	
	String nombre;
	ImageIcon recursoGrafico;
	
	int monedasPorMinuto = 50;
	int resistencia = 50;
	int recuperacion = 50;
	
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.recursoGrafico = new ImageIcon("img/"+nombre+".png");
	}

	public String getNombre() {
		return nombre;
	}

	public ImageIcon getRecursoGrafico() {
		return recursoGrafico;
	}

	public int getMonedasPorMinuto() {
		return monedasPorMinuto;
	}

	public int getRecuperacion() {
		return recuperacion;
	}
	

}
