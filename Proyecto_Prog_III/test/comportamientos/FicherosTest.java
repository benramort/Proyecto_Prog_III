package comportamientos;

import static org.junit.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import comportamientos.Ficheros;

import org.junit.Before;
import org.junit.Test;

public class FicherosTest {
	Ficheros f;
	
	@Before
	public void preparatorio() {
		List<Carta> modeloCartas = new ArrayList<>();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Saga saga1 = new Saga("nombreInternoSaga1", "nombreVisibleSaga1");
		Saga saga2 = new Saga("nombreInternoSaga2", "nombreVisibleSaga2");
		Saga saga3 = new Saga("nombreInternoSaga3", "nombreVisibleSaga3");
		modeloCartas.add(new Carta(1, "nombreInterno1", "nombreVisible1", saga1, 1, 1, 1));
		modeloCartas.add(new Carta(2, "nombreInterno2", "nombreVisible2", saga2, 2, 2, 2));
		modeloCartas.add(new Carta(3, "nombreInterno3", "nombreVisible3", saga3, 3, 3, 3));
		usuarios.add(new Usuario("nombre1", "contrasena1", null, 10));
		usuarios.add(new Usuario("nombre2", "contrasena2", null, 20));
		usuarios.add(new Usuario("nombre3", "contrasena3", null, 30));
		
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
				String linea = c.aLinea();
				ps.println(linea);
			}
			ps.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		f = new Ficheros("ficherosusuariostest", "ficherosmodelocartastest");
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
		
		assertEquals(cartas, f.getModeloCartas());
	}
	
	@Test
	public void testGetUsuarios() { //TODO mejorar este test
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("nombre1", "contrasena1", null, 10));
		usuarios.add(new Usuario("nombre2", "contrasena2", null, 20));
		usuarios.add(new Usuario("nombre3", "contrasena3", null, 30));
		assertEquals(usuarios, f.getUsuarios());
	}
}
