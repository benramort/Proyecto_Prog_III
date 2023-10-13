package comportamientos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Carta {
	
	String nombre;
	ImageIcon recursoGrafico;
	
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
	
	

}
