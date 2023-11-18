package comportamientos;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Usuario implements Comparator<Usuario>{
	
	//Igual hace falta un id
	private String nombre;
	private String contrasena;
	private int monedas;
	private Map<Carta,Integer> cartas; //Las cartas se ordenan naturalmente, y se almacena el número de cartas que tiene ese usuario. Si no tiene esa carta hay que añadirla con 0
//	private RegistroTemporal registroTemporal;
//	private Datos datos;
	
	public Usuario(String nombre, String contrasena, Datos datos, int monedas) {
		this.nombre = nombre;
		this.contrasena = contrasena;
//		this.datos = datos;
		this.monedas = monedas;
		cartas = new TreeMap<Carta, Integer>();
		for (Carta c: datos.getModeloCartas()) {
			cartas.put(c, 0);
		}
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
	

	public static Usuario deLinea(String s, Datos datos) {
		String[] tokens = s.split(";");
		return new Usuario(tokens[0], tokens[1], datos,Integer.parseInt(tokens[2]));
	}
	public String aLinea(Usuario usuario) {
		String nombre = usuario.getNombre() + ";";
		String contrasena = usuario.getContrasena() + ";";
		String monedas = usuario.getMonedas() + "";
		String cartasObtenidas = "";
		for(Integer cantidadCarta : cartas.values()) {
			cartasObtenidas += cantidadCarta + ",";
		}
		cartasObtenidas += ";";
		return nombre + contrasena + cartasObtenidas + monedas;
	}

	@Override
	public int compare(Usuario a, Usuario b) { //TODO esto no es compareTo()?
		return a.getNombre().compareTo(b.getNombre()) + a.getContrasena().compareTo(b.getContrasena());
	}


	

}
