import java.util.Random;

import comportamientos.BasesDeDatos;
import comportamientos.Venta;
import comportamientos.Datos;
import comportamientos.Ficheros;

public class VentasAlAzar {
	
	private static Datos datos = new Ficheros("modeloCartas","usuarios");
	
	public static void main(String[] args) {
		datos.cargarUsuarios();
		datos.cargarModeloCartas();
		System.out.println(datos.getUsuarios());
		System.out.println(datos.getModeloCartas());
		generarCartasAlAzar();
		datos.cargarVentas();
		System.out.println(datos.getVentas());
	}
	
	private static void generarCartasAlAzar() {
		Random r = new Random();
//		ventas = new ArrayList<Venta>();
		for (int i = 0; i < 10 ; i++) {
			datos.cargarUsuarios();
			Venta venta = new Venta();
			venta.setCarta(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())));
			venta.setPrecio(r.nextInt(100, 200));
			datos.cargarUsuarios();
			venta.setUsuario(datos.getUsuarios().get(r.nextInt(datos.getUsuarios().size())));
//			ventas.add(venta);
			datos.getVentas().add(venta);
			datos.guardarVenta(venta);
		}
		
	}

}
