package domain;



import java.nio.file.Path;

import javax.swing.ImageIcon;



public class Carta implements Comparable<Carta>{

	private String nombreInterno;
	private String nombreVisible;
	private Saga saga;
	private ImageIcon recursoGrafico;
	
	int id;
	int monedasPorMinuto = 0;
	int resistencia = 0;
	int recuperacion = 0;

	public Carta(int id) {
		this.id = id;
	}

	public Carta(int id, String nombreInterno, String nombreVisible, Saga saga,
			int monedasPorMinuto, int resistencia, int recuperacion) {
		
		this.nombreInterno = nombreInterno;
		this.nombreVisible = nombreVisible;
		this.saga = saga;
		Path path = Path.of("img/"+nombreInterno+".png");
//		System.out.println(path.toString());
		this.recursoGrafico = new ImageIcon(path.toAbsolutePath().toString());
		this.id = id;
		this.monedasPorMinuto = monedasPorMinuto;
		this.resistencia = resistencia;
		this.recuperacion = recuperacion;
	}



//	public Carta(String nombreInterno, String nombreVisible, Saga saga) {
//		this.nombreInterno = nombreInterno;
//		this.nombreVisible = nombreVisible;
//		this.saga = saga;
//		Path path = Path.of("img/"+nombreInterno+".png");
//		this.recursoGrafico = new ImageIcon(path.toAbsolutePath().toString());
//	}
//
//	
//
//	public Carta(String nombre, Saga saga) {
//		this(nombre, nombre, saga);
//	}

	public String getNombreInterno() {
		return nombreInterno;
	}

	

	public String getNombreVisible() {
		return nombreVisible;
	}



	public ImageIcon getRecursoGrafico() {
//		System.out.println("Solicitando recurso grafico de " + nombreVisible);
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
	public boolean equals(Object o) { //TODO igual hay que completar
		if (o instanceof Carta) {
			Carta c = (Carta) o;
			if (id != c.getId()) return false;
			if (!nombreInterno.equals(c.getNombreInterno())) return false;
			if (!nombreVisible.equals(c.getNombreVisible())) return false;
			if (!saga.equals(c.getSaga())) return false;
			if (monedasPorMinuto != c.getMonedasPorMinuto()) return false;
			if (resistencia != c.getResistencia()) return false;
			if (recuperacion != c.getRecuperacion()) return false;
			return true;
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
//		System.out.println("Carta a convertir:" + s);
		String[] tokens = s.split(";");
		Saga saga = new Saga(tokens[3],tokens[4]); //TODO esto crea una saga por carta, se puede optimizar
		return new Carta(Integer.parseInt(tokens[0]), tokens[1], tokens[2], saga, Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));
	}
	
	public static String aLinea(Carta s) {
		String nombreInterno = s.getNombreInterno() + ";";
		String nombreVisible = s.getNombreVisible() + ";";
		String id = s.getId() + ";";
		String saganombreInterno = s.getSaga().getNombreInterno() + ";";
		String saganombreVisible = s.getSaga().getNombreVisible() + ";";
		String monedasPorMinuto = s.getMonedasPorMinuto() + ";";
		String resistencia = s.getResistencia() + ";";
		String recuperacion = s.getRecuperacion() + ";";
		
		return id + nombreInterno + nombreVisible + saganombreInterno + saganombreVisible + monedasPorMinuto + resistencia + recuperacion;
	}
}