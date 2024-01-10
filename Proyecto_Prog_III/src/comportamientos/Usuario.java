package comportamientos;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.util.TreeMap;

public class Usuario {
	
	//Igual hace falta un id
	private String nombre;
	private String contrasena;
	private int monedas;
	private Map<Carta,Integer> cartas; //Las cartas se ordenan naturalmente, y se almacena el número de cartas que tiene ese usuario. Si no tiene esa carta hay que añadirla con 0
//	private RegistroTemporal registroTemporal;
	private Map<Carta,ZonedDateTime> cartasSinStamina;

	
	public Usuario(String nombre, String contrasena, Datos datos, int monedas) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.monedas = monedas;
		cartas = new TreeMap<Carta, Integer>();
		if (datos != null) {
			for (Carta c: datos.getModeloCartas()) {
				cartas.put(c, 0);
			}
		}
		this.cartasSinStamina = new TreeMap<>(); 
	}
	
	public Usuario(String nombre, String contrasena, Datos datos, Map<Carta, Integer> cartas,int monedas, Map<Carta, ZonedDateTime> cartasSinStamina) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.monedas = monedas;
		this.cartas = cartas;
		this.cartasSinStamina = cartasSinStamina;
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
	
	public Map<Carta, ZonedDateTime> getCartasSinStamina() {
		return cartasSinStamina;
	}
	

	public static Usuario deLinea(String s, Datos datos) {
		String[] tokens = s.split(";");
//		System.out.println(s);
		return new Usuario(tokens[0], tokens[1], datos, cargarCartas(tokens[2], datos), Integer.parseInt(tokens[3]), cargarSinStamina(tokens[4], datos)); //TODO gestionar excepciones
		
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
	
	public static Map<Carta, ZonedDateTime> cargarSinStamina(String s, Datos datos) {
		Map<Carta, ZonedDateTime> mapa = new TreeMap<>();
		if(s.isEmpty()) {
			return mapa;
		}
		String[] tokens = s.split(",");
		
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		for (String token : tokens) {
			String[] splitToken = token.split("=");
			int indiceCarta = Integer.parseInt(splitToken[0]);
			ZonedDateTime fechaHora = ZonedDateTime.parse(splitToken[1], DateTimeFormatter.ISO_ZONED_DATE_TIME);
			mapa.put(datos.getModeloCartas().get(indiceCarta-1), fechaHora);  //Solución un poco cogido por pinzas
		}
		return mapa;
	}
	
	public String aLinea() {
		String nombre = this.getNombre() + ";";
		String contrasena = this.getContrasena() + ";";
		String monedas = this.getMonedas() + ";";
		String cartasObtenidas = "";
		for(Integer cantidadCarta : cartas.values()) {
			cartasObtenidas += cantidadCarta + ",";
		}
		cartasObtenidas += ";";
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String cartasSinStamina = "";
		for (Entry<Carta, ZonedDateTime> entry : this.cartasSinStamina.entrySet()) {
			cartasSinStamina += entry.getKey().getId() + "=" + entry.getValue().format(DateTimeFormatter.ISO_ZONED_DATE_TIME)+",";
		}
		return nombre + contrasena + cartasObtenidas + monedas + cartasSinStamina;
	}
	
	public void nuevaCartaSinStamina(Carta carta) {
		cartasSinStamina.put(carta, ZonedDateTime.now());
	}
	
	public void actualizarCartasSinStamina() {
		List<Carta> aEliminar = new ArrayList<>();
		for (Entry<Carta, ZonedDateTime> entry : cartasSinStamina.entrySet()) {
			long minutos = entry.getValue().until(ZonedDateTime.now(), ChronoUnit.MINUTES);
			System.out.println(entry.getKey() + ":" + minutos);
			if (minutos >= (100-entry.getKey().getRecuperacion()*1)) { //1 de estamina equivale a 20 minutos TODO poner por 20
//				cartasSinStamina.remove(entry.getKey());
				aEliminar.add(entry.getKey());
			}
		}
		for (Carta carta : aEliminar) {
			cartasSinStamina.remove(carta);
		}
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Usuario) {
			Usuario u = (Usuario) o;
			if(!this.getNombre().equals(u.getNombre())) return false;
			if(!this.getContrasena().equals(u.getContrasena())) return false;
			if(this.getMonedas() != u.getMonedas()) return false;
//			if(!this.getCartasSinStamina().equals(u.getCartasSinStamina())) return false;
//			if(!this.getCartas().equals(u.getCartas())) return false;
			return true;
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
	
//	public static void main(String[] args) {
//		Datos datos = new Ficheros();
//		Usuario usuario = new Usuario(null, null, datos, 0);
//		usuario.nuevaCartaSinStamina(datos.getModeloCartas().get(0));
//		usuario.nuevaCartaSinStamina(datos.getModeloCartas().get(1));
//		ZonedDateTime inicio = ZonedDateTime.now();
//		while (true) {
//			usuario.actualizarCartasSinStamina();
//			System.out.println(inicio.until(ZonedDateTime.now(), ChronoUnit.SECONDS));
//			System.out.println(usuario.getCartasSinStamina());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	public static void main(String[] args) {
		ZonedDateTime ahora = ZonedDateTime.now();
		String s = ahora.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
		ZonedDateTime ahora2 = ZonedDateTime.parse(s, DateTimeFormatter.ISO_ZONED_DATE_TIME);
//		syso
	}


	

}
