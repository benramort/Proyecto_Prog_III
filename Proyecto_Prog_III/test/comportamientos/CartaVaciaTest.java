package comportamientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

public class CartaVaciaTest {
	CartaVacia cartaVacia;
	Carta carta;
	ImageIcon recursoGrafico;
	
	@Before
	public void preparatorio(){
		carta = new Carta(0, null, null, new Saga("", ""), 0,0,0);
		cartaVacia = new CartaVacia();
		
	}
	
	@Test
	public void cartaAEntenar() {
		assertEquals(carta,cartaVacia);
		assertNotNull(cartaVacia);
	}
	
	@Test
    public void testGetRecursoGrafico() {
        recursoGrafico = cartaVacia.getRecursoGrafico();
        assertNotNull(recursoGrafico);
        assertEquals("res/bloqueado.png", recursoGrafico.getDescription());
    }
	
}
