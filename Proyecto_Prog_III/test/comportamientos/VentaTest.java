package comportamientos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
}
