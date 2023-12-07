package comportamientos;

public class Venta {
	
	private Carta carta;
	private int precio;
	private Usuario usuario;	
	
	public Venta() {
		
	}
	
	public Venta(Carta carta, int precio, Usuario usuario) {
		this.carta = carta;
		this.precio = precio;
		this.usuario = usuario;
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

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
