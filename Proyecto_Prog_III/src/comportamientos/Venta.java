package comportamientos;

import java.time.Instant;
import java.time.ZonedDateTime;
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
	
	public void venderCarta(Datos datos) {
//		System.out.println(""+c+"-"+u+"-"+precio);
//		Venta v = new Venta(c, precio, u);
		datos.getVentas().add(this);
		datos.guardarVenta(this);
		usuario.getCartas().replace(carta, usuario.getCartas().get(carta)-1);
//		System.out.println(u.getCartas().get(c));
	}
	
	@Override
	public String toString() {
		return carta.toString() +"-"+ usuario.toString() +"-"+ precio;
	}

}
