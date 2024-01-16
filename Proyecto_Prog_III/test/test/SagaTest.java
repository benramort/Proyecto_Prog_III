package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domain.Saga;

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
	
	@Test
	public void testGetNombreVisible() {
		assertEquals("Super Mario", saga.getNombreVisible());
	}
	
	//TODO test recurso grafico

}
