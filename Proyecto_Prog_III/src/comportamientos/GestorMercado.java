package comportamientos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorMercado {
	
	private List<Venta> ventas;
	private Datos datos;
	//TODO quitar esta clase
	
	public GestorMercado(Datos datos) {
		this.datos = datos;
//		generarCartasAlAzar();
		ventas = datos.getVentas();
	}

	private void generarCartasAlAzar() {
		Random r = new Random();
		ventas = new ArrayList<Venta>();
		for (int i = 0; i < 10 ; i++) {
			datos.cargarUsuarios();
			Venta venta = new Venta();
			venta.setCarta(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())));
			venta.setPrecio(r.nextInt(100, 200));
			datos.cargarUsuarios();
			venta.setUsuario(datos.getUsuarios().get(r.nextInt(datos.getUsuarios().size())));
			ventas.add(venta);
		}
	}
	
	public List<Venta> getVentas() {
		return ventas;
	}
	
	public void venderCarta(Carta c, Usuario u, int precio) {
		System.out.println(""+c+"-"+u+"-"+precio);
		Venta v = new Venta(c, precio, u);
		ventas.add(v);
		datos.guardarVenta(v);
		u.getCartas().replace(c, u.getCartas().get(c)-1);
		System.out.println(u.getCartas().get(c));
	}

}
