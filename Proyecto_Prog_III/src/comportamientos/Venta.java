package comportamientos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Venta {
	
	private Carta carta;
	private int precio;
	private Usuario usuario;	
	private ZonedDateTime fechaHora;
	
	public Venta() {
		fechaHora = ZonedDateTime.now();
	}
	
	public Venta(Carta carta, int precio, Usuario usuario) {
		this.carta = carta;
		this.precio = precio;
		this.usuario = usuario;
		fechaHora = ZonedDateTime.now();
	}
	
	public Venta(Carta carta, int precio, Usuario usuario, ZonedDateTime fechaHora) {
		this(carta, precio, usuario);
		this.fechaHora = fechaHora;
	}

	public Carta getCarta() {
		return carta;
	}

	public int getPrecio() {
		return precio;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public ZonedDateTime getFechaHora() {
		return fechaHora;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void venderCarta(Datos datos, List<Venta> ventasCondicionales) {
//		System.out.println(""+c+"-"+u+"-"+precio);
//		Venta v = new Venta(c, precio, u);
		ventasCondicionales.add(this);
		datos.getVentas().add(this);
		datos.guardarVenta(this);
		usuario.getCartas().replace(carta, usuario.getCartas().get(carta)-1);
//		System.out.println(u.getCartas().get(c));
	}
	
	public String aLinea() {
		
		return carta.getId()+";"+precio+";"+usuario.getNombre()+";"+DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(fechaHora);
	}
	
	public static Venta deLinea(Datos datos, String s) throws NumberFormatException, DateTimeParseException {
		String[] tokens = s.split(";");
		Carta carta = datos.getModeloCartas().get(Integer.parseInt(tokens[0])-1);
		Usuario usuario = null;
		for (Usuario u : datos.getUsuarios()) {
			if (u.getNombre().equals(tokens[2])) {
				usuario = u;
				break;
			}
		}
		LocalDateTime localTime = LocalDateTime.parse(tokens[3], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return new Venta(carta, Integer.parseInt(tokens[1]), usuario, ZonedDateTime.of(localTime, ZoneId.systemDefault()));
	}
	
	@Override
	public String toString() {
		return carta.toString() +"-"+ usuario.toString() +"-"+ precio;
	}
	
//	@Override
//	public boolean equals(Object o) {
//		if (o instanceof Venta) {
//			Venta v = (Venta) o;
//			if (!carta.equals(v.getCarta())) return false;
//			if (!usuario.equals(v.getUsuario())) return false;
//			if (precio != v.getPrecio()) return false;
//			if (!usuario.)
//		}
//	}

}
