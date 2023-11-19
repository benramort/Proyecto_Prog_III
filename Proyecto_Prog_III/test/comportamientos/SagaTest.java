package comportamientos;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SagaTest {
	
	Saga saga;
	
	@Before
	public void preparatorio() {
		saga = new Saga("SuperMario","Super Mario");
	}
	
	@Test
	public void testGetNombreInterno() {
		assertEquals(saga.getNombreInterno(), "SuperMario");
	}
	
	public void testGetNombreVisible() {
		assertEquals(saga.getNombreVisible(), "Super Mario");
	}
	
	//TODO test recurso grafico

}
