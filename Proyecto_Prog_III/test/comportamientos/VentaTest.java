package comportamientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.Carta;
import domain.Saga;
import domain.Usuario;
import domain.Venta;
import interfaces.Datos;

public class VentaTest {

	Venta venta;
	Datos datos;
	Carta carta = new Carta(4, "mario", "Mario", new Saga("SuperMario", "Super Mario"), 50, 80, 20);
	Usuario usuario = new Usuario("Iker", "abc123", datos, 10000);
	
	@Before
	public void preparatorio() {
		venta = new Venta(carta, 500, usuario);		
	}
	
	@Test
	public void testGetCarta() {
		assertEquals(carta, venta.getCarta());
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(500, venta.getPrecio());
	}
	
	@Test
	public void testGetUsuario() {
		assertEquals(usuario, venta.getUsuario());
	}
	
	@Test
	public void testToString() {
		assertEquals("4 - mario-Iker-500", venta.toString());
	}
	
	@Test
	public void testEquals() {
		Venta venta2 = new Venta(carta, 500, usuario);
		assertTrue(venta.equals(venta2));
		venta2.setCarta(new Carta(5, "luigi", "Luigi", new Saga("SuperMario", "Super Mario"), 50, 30, 60));
		assertFalse(venta.equals(venta2));
		venta2.setCarta(carta);
		venta2.setPrecio(400);
		assertFalse(venta.equals(venta2));
		venta2.setPrecio(500);
		venta2.setUsuario(new Usuario("usuarioRandom", "abc123", datos, 100000));
		assertFalse(venta.equals(venta2));
	}
	
	@Test
	public void testVenderCarta() {
		
	}
	
}
