package comportamientos;

import java.util.Map;
import java.util.TreeMap;

public class Usuario{
	
	//Igual hace falta un id
	private String nombre;
	private String contrasena;
	private int monedas;
	private Map<Carta,Integer> cartas; //Las cartas se ordenan naturalmente, y se almacena el número de cartas que tiene ese usuario. Si no tiene esa carta hay que añadirla con 0
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String contrasena) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		monedas = 0;
		cartas = new TreeMap<Carta, Integer>();
		for (Carta c: Ficheros.modeloCartas) {
			cartas.put(c, 0);
		}
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

	public Map<Carta, Integer> getCartas() {
		return cartas;
	}
	
	public static Usuario deLinea(String s) {
		String[] tokens = s.split(";");
		return new Usuario(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
		
	}
	
	
	

}
