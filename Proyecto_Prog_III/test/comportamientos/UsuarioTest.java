package comportamientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario usuarioNuevo;
	private Usuario usuarioExistente;
	public static BasesDeDatos datos;
	
	@BeforeClass
	public static void preparatorioUnico() {
		datos = new BasesDeDatos("datos.db");
	}
	
	@Before
	public void preparatorio() {
//		Datos datos = new BasesDeDatos();
		usuarioNuevo = new Usuario("nombre","contraseña",datos,30);
		TreeMap<Carta,Integer> mapaCartas = new TreeMap<>();
		int contador = 0;
		for (Carta c : datos.getModeloCartas()) {
			mapaCartas.put(c, contador++);
		}
		Map<Carta, ZonedDateTime> cartasSinStamina = new TreeMap<>();
		for (Carta c : datos.getModeloCartas()) {
			cartasSinStamina.put(c, ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()));
		}
		usuarioExistente = new Usuario("nombre","contraseña",datos,mapaCartas,30,cartasSinStamina);
	}
	
	@AfterClass
	public static void finalizar() {
		datos.cerrarConexion();
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("nombre", usuarioNuevo.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		usuarioNuevo.setNombre("nombre2");
		assertEquals("nombre2",usuarioNuevo.getNombre());
	}
	
	@Test
	public void testGetContrasena() {
		assertEquals("contraseña", usuarioNuevo.getContrasena());
	}
	
	@Test
	public void testSetContrasena() {
		usuarioNuevo.setContrasena("contraseña2");
		assertEquals("contraseña2",usuarioNuevo.getContrasena());
	}
	
	@Test
	public void testGetMonedas() {
		assertEquals(30, usuarioNuevo.getMonedas());
	}
	
	@Test
	public void testSetMonedas() {
		usuarioNuevo.setMonedas(23);
		assertEquals(23,usuarioNuevo.getMonedas());
	}
	
	@Test
	public void testGetCartas() {
		TreeMap<Carta,Integer> mapaCartas = new TreeMap<>();
		int contador = 0;
		for (Carta c : datos.getModeloCartas()) {
			mapaCartas.put(c, contador++);
			//assertEquals(contador++, (Integer) usuarioExistente.getCartas().get(c)); ??
		}
		assertEquals(mapaCartas, usuarioExistente.getCartas());
		
	}
	
	@Test
	public void testGetCartasSinStamina() {
		Map<Carta, ZonedDateTime> cartasSinStamina = new TreeMap<>();
		for (Carta c : datos.getModeloCartas()) {
			cartasSinStamina.put(c, ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()));
		}
		assertEquals(cartasSinStamina, usuarioExistente.getCartasSinStamina());
	}
	
	@Test
	public void testDeLineaALinea() {
		String linea = usuarioExistente.aLinea();
		Usuario usuarioDeLinea = Usuario.deLinea(linea, datos);
		assertEquals(usuarioExistente, usuarioDeLinea);
	}
	
	//TODO cargarCartas y cargarSinStamina
	
	@Test
	public void testNuevaCartaSinStamina() {
		Carta carta = datos.getModeloCartas().get(0);
		usuarioNuevo.nuevaCartaSinStamina(carta);
		assertTrue(usuarioNuevo.getCartasSinStamina().keySet().contains(carta));
		assertEquals(1, usuarioNuevo.getCartasSinStamina().size());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEquals() {
		assertFalse(usuarioExistente.equals(""));
//		assertFalse(usuarioExistente.equals(usuarioNuevo));
		TreeMap<Carta,Integer> mapaCartas = new TreeMap<>();
		int contador = 0;
		for (Carta c : datos.getModeloCartas()) {
			mapaCartas.put(c, contador++);
		}
		Map<Carta, ZonedDateTime> cartasSinStamina = new TreeMap<>();
		for (Carta c : datos.getModeloCartas()) {
			cartasSinStamina.put(c, ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()));
		}
		Usuario usuarioExistente2 = new Usuario("nombre","contraseña",datos,mapaCartas,30,cartasSinStamina);
		assertTrue(usuarioExistente.equals(usuarioExistente2));
		usuarioExistente2.setNombre("otroNombre");
		assertFalse(usuarioExistente.equals(usuarioExistente2));
		usuarioExistente2.setNombre("nombre");
		usuarioExistente2.setContrasena("otraContraseña");
		assertFalse(usuarioExistente.equals(usuarioExistente2));
		usuarioExistente2.setContrasena("contraseña");
		usuarioExistente2.setMonedas(0);
//		assertFalse(usuarioExistente.equals(usuarioExistente2));
//		usuarioExistente2.setMonedas(30);
////		usuarioExistente2.getCartasSinStamina().clear();
////		assertFalse(usuarioExistente.equals(usuarioExistente2));
//		cartasSinStamina = new TreeMap<>(); //Resetear las cartas sin stamina
//		for (Carta c : datos.getModeloCartas()) { 
//			cartasSinStamina.put(c, ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()));
//		}
//		usuarioExistente2 = new Usuario("nombre","contraseña",datos,mapaCartas,30,cartasSinStamina);
//		usuarioExistente2.getCartas().clear();
//		assertFalse(usuarioExistente.equals(usuarioExistente2));
//		
	}
	
	@Test
	public void testToString() {
		assertEquals(usuarioExistente.getNombre(), usuarioExistente.toString());
	}
	
	
	
	

}
