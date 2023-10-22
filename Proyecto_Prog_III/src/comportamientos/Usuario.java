package comportamientos;

import java.util.TreeMap;

public class Usuario{
	
	//Igual hace falta un id
	private String nombre;
	private String contrasena;
	private int monedas;
	private TreeMap<Carta,Integer> cartas; //Las cartas se ordenan naturalmente, y se almacena el número de cartas que tiene ese usuario. Si no tiene esa carta hay que añadirla con 0
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String contrasena, int monedas) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.monedas = monedas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public TreeMap<Carta, Integer> getCartas() {
		
		return cartas;
	}
	
	public static Usuario deLinea(String s) {
		String[] tokens = s.split(";");
		return new Usuario(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
		
	}
	
	
	

}
