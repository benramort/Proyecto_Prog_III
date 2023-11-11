import static org.junit.Assert.assertEquals;

import org.junit.Test;

import comportamientos.Carta;

public class CartaTest {
	
	@Test
	public void testGetNombreInterno() {
		Carta c;
		assertEquals(c.getNombreInterno(), c.nombreInterno);
	}
	
	@Test
	public void testGetNombreVisible() {
		Carta c;
		assertEquals(c.getNombreVisible(), c.nombreVisible);
	}
	
}
