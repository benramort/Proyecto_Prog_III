package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import domain.Carta;
import domain.CartaAEntrenar;
import domain.Saga;

public class CartaAEntrenarTest {
	CartaAEntrenar cartaAEntrenar;
	Carta carta;
	ImageIcon recursoGrafico;
	
	@Before
	public void preparatorio(){
		carta = new Carta(0, "", "", new Saga("", ""), 0,0,0);
		cartaAEntrenar = new CartaAEntrenar();
		
	}
	
	@Test
	public void cartaAEntenar() {
		assertEquals(carta,cartaAEntrenar);
		assertNotNull(cartaAEntrenar);
	}
	
	
	
}
