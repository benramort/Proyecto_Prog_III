package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import domain.Carta;
import domain.CartaVacia;
import domain.Saga;

public class CartaVaciaTest {
	CartaVacia cartaVacia;
	Carta carta;
	ImageIcon recursoGrafico;
	
	@Before
	public void preparatorio(){
		carta = new Carta(0, "", "", new Saga("", ""), 0,0,0);
		cartaVacia = new CartaVacia();
		
	}
	
	@Test
	public void cartaVacia() {
		assertEquals(carta,cartaVacia);
		assertNotNull(cartaVacia);
	}
	
}
