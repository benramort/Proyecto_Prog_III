package comportamientos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CartaAEntrenarTest {
	CartaAEntrenar cartaAEntrenar;
	Carta carta;
	
	@Before
	public void preparatorio(){
		carta = new Carta(0, null, null, new Saga("", ""), 0,0,0);
		cartaAEntrenar = new CartaAEntrenar();
	}
	
	@Test
	public void cartaAEntenar() {
		assertEquals(carta,cartaAEntrenar);
	}
	
	
	
}
