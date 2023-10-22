package comportamientos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Carta implements Comparable<Carta>{
	
	String nombreInterno;
	String nombreVisible;
	Saga saga;
	ImageIcon recursoGrafico;
	int id;
	
	int monedasPorMinuto = 100;
	int resistencia = 50;
	int recuperacion = 25;
	
	
	
	
	public Carta(int id) {
		this.id = id;
	}
	
	public Carta(int id, String nombreInterno, String nombreVisible, Saga saga,
			int monedasPorMinuto, int resistencia, int recuperacion) {
		this.nombreInterno = nombreInterno;
		this.nombreVisible = nombreVisible;
		this.saga = saga;
		this.recursoGrafico = new ImageIcon("img/"+nombreInterno+".png");;
		this.id = id;
		this.monedasPorMinuto = monedasPorMinuto;
		this.resistencia = resistencia;
		this.recuperacion = recuperacion;
	}

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
	
	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Carta) {
			return id == ((Carta) o).getId();
		}
		return false;
	}

	@Override
	public int compareTo(Carta o) {
		return id - o.getId();
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s",id,nombreInterno);
	}
	
	public static Carta deLinea(String s) {
		String[] tokens = s.split(";");
		Saga saga = new Saga(tokens[3],tokens[4]); //TODO esto crea una saga por carta, se puede optimizar
		return new Carta(Integer.parseInt(tokens[0]), tokens[1], tokens[2], saga, Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));
	}
	

}
