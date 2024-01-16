package comportamientos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FicherosTest {
	Ficheros f;
	private List<Venta> ventas;

	@Before
	public void preparatorio() {
		List<Carta> modeloCartas = new ArrayList<>();
		List<Usuario> usuarios = new ArrayList<>();
		ventas = new ArrayList<>();
		Saga saga1 = new Saga("nombreInternoSaga1", "nombreVisibleSaga1");
		Saga saga2 = new Saga("nombreInternoSaga2", "nombreVisibleSaga2");
		Saga saga3 = new Saga("nombreInternoSaga3", "nombreVisibleSaga3");
		Carta carta1 = new Carta(1, "nombreInterno1", "nombreVisible1", saga1, 1, 1, 1);
		Carta carta2 = new Carta(2, "nombreInterno2", "nombreVisible2", saga2, 2, 2, 2);
		Carta carta3 = new Carta(3, "nombreInterno3", "nombreVisible3", saga3, 3, 3, 3);
		modeloCartas.add(carta1);
		modeloCartas.add(carta2);
		modeloCartas.add(carta3);
		Usuario usuario1 = new Usuario("nombre1", "contrasena1", null, 10);
		Usuario usuario2 = new Usuario("nombre2", "contrasena2", null, 20);
		Usuario usuario3 = new Usuario("nombre3", "contrasena3", null, 30);
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		int precio1 = 5;
		int precio2 = 33;
		int precio3 = 10;
		Venta venta1 = new Venta(carta1,precio1,usuario1);
		Venta venta2 = new Venta(carta2,precio2,usuario2);
		Venta venta3 = new Venta(carta3,precio3,usuario3);
		ventas.add(venta1);
		ventas.add(venta2);
		ventas.add(venta3);
		
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("data/ficherosusuariostest.csv"));
			for (Usuario u : usuarios) {
				String linea = u.aLinea();
				ps.println(linea);
			}
			ps.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("data/ficherosmodelocartastest.csv"));
			for (Carta c : modeloCartas) {
				String linea = Carta.aLinea(c);
				ps.println(linea);
			}
			ps.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("data/ficherosventastest.csv"));
			for (Venta v : ventas) {
				String linea = v.aLinea();
				ps.println(linea);
			}
			ps.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		f = new Ficheros("ficherosmodelocartastest", "ficherosusuariostest", "ficherosventastest");
	}
	
	@After
	public void destruirFicheros() {
			File file = new File("data/ficherosmodelocartastest.csv");
			file.delete();
			file = new File("data/ficherosusuariostest.csv");
			file.delete();
			file = new File("data/ficherosventastest.csv");
			file.delete();	
	}
	
	@Test
	public void testGetModeloCartas() {
		List<Carta> cartas;
		cartas = new ArrayList<Carta>();
		Saga saga1 = new Saga("nombreInternoSaga1", "nombreVisibleSaga1");
		Saga saga2 = new Saga("nombreInternoSaga2", "nombreVisibleSaga2");
		Saga saga3 = new Saga("nombreInternoSaga3", "nombreVisibleSaga3");
		cartas.add(new Carta(1, "nombreInterno1", "nombreVisible1", saga1, 1,1,1));
		cartas.add(new Carta(2, "nombreInterno2", "nombreVisible2", saga2, 2,2,2));
		cartas.add(new Carta(3, "nombreInterno3", "nombreVisible3", saga3, 3,3,3));
		
		f.cargarModeloCartas();
		assertEquals(cartas, f.getModeloCartas());
	}
	
	@Test
	public void testGetUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("nombre1", "contrasena1", null, 10));
		usuarios.add(new Usuario("nombre2", "contrasena2", null, 20));
		usuarios.add(new Usuario("nombre3", "contrasena3", null, 30));
		
		f.cargarUsuarios();
		assertEquals(usuarios, f.getUsuarios());
	}
	
	@Test
	public void testGuardarUsuario() {
		Usuario usuario1 = new Usuario("nombre1", "contrasena1", null, 10);
		f.guardarUsuario(usuario1);
		Usuario usuarioPrueba = f.cargarUsuario("nombre1");
		assertEquals(usuario1, usuarioPrueba);
	}
	
	@Test
	public void testGetVentas() {
//		List<Venta> ventas = new ArrayList<>();
//		Saga saga1 = new Saga("nombreInternoSaga1", "nombreVisibleSaga1");
//		Saga saga2 = new Saga("nombreInternoSaga2", "nombreVisibleSaga2");
//		Saga saga3 = new Saga("nombreInternoSaga3", "nombreVisibleSaga3");
//		Carta carta1 = new Carta(1, "nombreInterno1", "nombreVisible1", saga1, 1, 1, 1);
//		Carta carta2 = new Carta(2, "nombreInterno2", "nombreVisible2", saga2, 2, 2, 2);
//		Carta carta3 = new Carta(3, "nombreInterno3", "nombreVisible3", saga3, 3, 3, 3);
//		int precio1 = 5;
//		int precio2 = 33;
//		int precio3 = 10;
//		Usuario usuario1 = new Usuario("nombre1", "contrasena1", null, 10);
//		Usuario usuario2 = new Usuario("nombre2", "contrasena2", null, 20);
//		Usuario usuario3 = new Usuario("nombre3", "contrasena3", null, 30);
//		Venta venta1 = new Venta(carta1,precio1,usuario1);
//		Venta venta2 = new Venta(carta2,precio2,usuario2);
//		Venta venta3 = new Venta(carta3,precio3,usuario3);
//		ventas.add(venta1);
//		ventas.add(venta2);
//		ventas.add(venta3);
		f.cargarModeloCartas();
		f.cargarUsuarios();
		f.cargarVentas();
//		f.getVentas();
		assertEquals(ventas, f.getVentas());
	}

	@Test
	public void testGuardarVentas() {
		Usuario usuario1 = new Usuario("nombre1", "contrasena1", null, 10);
		f.guardarUsuario(usuario1);
		Usuario usuarioPrueba = f.cargarUsuario("nombre1");
		assertEquals(usuario1, usuarioPrueba);
	}
	
}
