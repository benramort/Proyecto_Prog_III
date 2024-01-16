package setUp;
import java.util.Random;

import db.BasesDeDatos;
import domain.Venta;
import interfaces.Datos;
import io.Ficheros;

public class VentasAlAzar {
	
	private static Datos ficheros = new Ficheros("modeloCartas","usuarios", "ventas");
	private static Datos baseDeDatos = new BasesDeDatos("datos.db");
	
	public static void main(String[] args) {
		ficheros.cargarUsuarios();
		ficheros.cargarModeloCartas();
		System.out.println(ficheros.getUsuarios());
		System.out.println(ficheros.getModeloCartas());
		generarCartasAlAzar();
		ficheros.cargarVentas();
		System.out.println(ficheros.getVentas());
	}
	
	private static void generarCartasAlAzar() {
		Random r = new Random();
//		ventas = new ArrayList<Venta>();
		for (int i = 0; i < 10 ; i++) {
			ficheros.cargarUsuarios();
			Venta venta = new Venta();
			venta.setCarta(ficheros.getModeloCartas().get(r.nextInt(ficheros.getModeloCartas().size())));
			venta.setPrecio(r.nextInt(100, 200));
			ficheros.cargarUsuarios();
			venta.setUsuario(ficheros.getUsuarios().get(r.nextInt(ficheros.getUsuarios().size())));
//			ventas.add(venta);
			ficheros.getVentas().add(venta);
			ficheros.guardarVenta(venta);
			
		}
		
		for (int i = 0; i < 10 ; i++) {
			baseDeDatos.cargarUsuarios();
			Venta venta = new Venta();
			venta.setCarta(baseDeDatos.getModeloCartas().get(r.nextInt(baseDeDatos.getModeloCartas().size())));
			venta.setPrecio(r.nextInt(100, 200));
			baseDeDatos.cargarUsuarios();
			System.out.println(baseDeDatos.getUsuarios());
			venta.setUsuario(baseDeDatos.getUsuarios().get(r.nextInt(baseDeDatos.getUsuarios().size())));
//			ventas.add(venta);
			baseDeDatos.getVentas().add(venta);
			baseDeDatos.guardarVenta(venta);
			
		}
		
		
	}

}
