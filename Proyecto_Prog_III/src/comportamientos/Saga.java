package comportamientos;

import javax.swing.ImageIcon;

public class Saga {
	
	String nombreInterno; //String en camel case con la primera en mayuscula
	String nombreVisible;
	ImageIcon recursoGrafico;
	
	public Saga(String nombreInterno, String nombreVisible) { //TODO todas las cartas crean un objeto saga
		this.nombreInterno = nombreInterno;
		this.nombreVisible = nombreVisible;
		recursoGrafico = new ImageIcon("img/logo"+nombreInterno+".png");
	}
	
	public Saga(String nombre) {
		this(nombre,nombre);
	}

	public String getNombreInterno() {
		return nombreInterno;
	}

	public String getNombreVisible() {
		return nombreVisible;
	}

	public ImageIcon getRecursoGrafico() {
		return recursoGrafico;
	}

	
}
