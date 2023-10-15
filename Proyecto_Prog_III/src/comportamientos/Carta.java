package comportamientos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Carta {
	
	String nombreInterno;
	String nombreVisible;
	Saga saga;
	ImageIcon recursoGrafico;
	
	int monedasPorMinuto = 100;
	int resistencia = 50;
	int recuperacion = 25;
	
	
	public Carta(String nombreInterno, String nombreVisible, Saga saga) {
		this.nombreInterno = nombreInterno;
		this.nombreVisible = nombreVisible;
		this.saga = saga;
		this.recursoGrafico = new ImageIcon("img/"+nombreInterno+".png");
	}
	
	public Carta(String nombre, Saga saga) {
		this(nombre, nombre, saga);
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
	
	public Saga getSaga() {
		return saga;
	}

	public int getMonedasPorMinuto() {
		return monedasPorMinuto;
	}
	
	public int getResistencia() {
		return resistencia;
	}

	public int getRecuperacion() {
		return recuperacion;
	}
	

}
