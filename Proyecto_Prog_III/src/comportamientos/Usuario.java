package comportamientos;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Usuario {
	
	//Igual hace falta un id
	private String nombre;
	private String contrasena;
	private int monedas;
	private Map<Carta,Integer> cartas; //Las cartas se ordenan naturalmente, y se almacena el número de cartas que tiene ese usuario. Si no tiene esa carta hay que añadirla con 0
//	private RegistroTemporal registroTemporal;
	private Map<Carta,ZonedDateTime> cartasSinStamina = new TreeMap<>();

	
	public Usuario(String nombre, String contrasena, Datos datos, int monedas) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.monedas = monedas;
		cartas = new TreeMap<Carta, Integer>();
		for (Carta c: datos.getModeloCartas()) {
			cartas.put(c, 0);
		}
	}
	
	public Usuario(String nombre, String contrasena, Datos datos, Map<Carta, Integer> cartas,int monedas) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.monedas = monedas;
		this.cartas = cartas;
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
//		System.out.println(s);
		return new Usuario(tokens[0], tokens[1], datos, cargarCartas(tokens[2], datos), Integer.parseInt(tokens[3])); //TODO gestionar excepciones
		
	}
	
	public static Map<Carta,Integer> cargarCartas(String s, Datos datos) {
		String[] tokens = s.split(",");
		if (tokens.length != datos.getModeloCartas().size()) {
			System.out.println(tokens.length);
			System.out.println(datos.getModeloCartas().size());
			return null; //TODO hacer algo con este error
		}
		Map<Carta,Integer> mapa = new TreeMap<>();
		for (int i=0; i<datos.getModeloCartas().size(); i++) {
			mapa.put(datos.getModeloCartas().get(i), Integer.parseInt(tokens[i]));
		}
		return mapa;
	}
	
	public String aLinea() {
		String nombre = this.getNombre() + ";";
		String contrasena = this.getContrasena() + ";";
		String monedas = this.getMonedas() + "";
		String cartasObtenidas = "";
		for(Integer cantidadCarta : cartas.values()) {
			cartasObtenidas += cantidadCarta + ",";
		}
		cartasObtenidas += ";";
		return nombre + contrasena + cartasObtenidas + monedas;
	}
	
	public void nuevaCartaSinStamina(Carta carta) {
		cartasSinStamina.put(carta, ZonedDateTime.now());
	}
	
	public void actualizarCartasSinStamina() {
		for (Entry<Carta, ZonedDateTime> entry : cartasSinStamina.entrySet()) {
			long minutos = entry.getValue().until(ZonedDateTime.now(), ChronoUnit.MINUTES);
			if (minutos > entry.getKey().getRecuperacion()*20) { //1 de estamina equivale a 20 minutos
				cartasSinStamina.remove(entry.getKey());
			}
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Usuario) {
			Usuario u = (Usuario) o;
			return this.getNombre().equals(u.getNombre());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
//	public static void main(String[] args) {
//		Map<Carta,ZonedDateTime> cartasSinStamina = new TreeMap<>();
//		cartasSinStamina.put(new CartaAEntrenar(), ZonedDateTime.now());
//		cartasSinStamina.put(new CartaVacia(), ZonedDateTime.now());
//		System.out.println(cartasSinStamina);
//		for (Entry<Carta, ZonedDateTime> entry : cartasSinStamina.entrySet()) {
//			cartasSinStamina.remove(entry.getKey());
//		}
//		System.out.println(cartasSinStamina);
//	}


	

}
