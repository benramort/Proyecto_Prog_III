import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import comportamientos.Carta;
import comportamientos.Saga;

public class CartaTest {
	
	private Carta carta;
	private Saga saga;
	
	@Before
	public void preparatorio() {
		saga = new Saga("SuperMario", "Super Mario");
		carta = new Carta(1, "yoshi", "Yoshi", saga, 20, 30, 40);
	}
	
	//TODO test de constructores
	
	@Test
	public void testGetNombreInterno() {
		assertEquals("yoshi", carta.getNombreInterno());
	}
	
	@Test
	public void testGetNombreVisible() {
		assertEquals("Yoshi", carta.getNombreVisible());
	}
	
//	@Test
//	public void testGetRecursoGrafico() {
//		Path path = Path.of("img/yoshi.png");
//		ImageIcon ii = new ImageIcon(path.toAbsolutePath().toString());
//		ii.equals(ii);
//		assertEquals(ii, carta.getRecursoGrafico());
//	}
	
	@Test
	public void testGetSaga() {
		assertEquals(saga, carta.getSaga());
	}
	
	@Test
	public void testGetMonedasPorMinuto() {
		assertEquals(20, carta.getMonedasPorMinuto());
	}
	
	@Test
	public void testGetResistencia() {
		assertEquals(30, carta.getResistencia());
	}
	
	@Test
	public void testGetRecuperacion() {
		assertEquals(40, carta.getRecuperacion());
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, carta.getId());
	}
	
	@Test
	public void testEquals() {
		Carta cartaIgual = new Carta(1);
		Carta cartaDiferernte = new Carta(2);
		assertTrue(carta.equals(cartaIgual));
		assertFalse(carta.equals(cartaDiferernte));
		assertFalse(carta.equals(Color.BLACK));
	}
	
	@Test
	public void testCompareTo() {
		Carta cartaMenor = new Carta(0);
		Carta cartaIgual = new Carta(1);
		Carta cartaMayor = new Carta(2);
		List<Carta> listaOrdenada = new ArrayList<>();
		listaOrdenada.add(cartaMenor);
		listaOrdenada.add(cartaIgual);
		listaOrdenada.add(cartaMayor);
		List<Carta> listaDesordenada = new ArrayList<>();
		listaDesordenada.add(cartaMenor);
		listaDesordenada.add(cartaIgual);
		listaDesordenada.add(cartaMayor);
		listaDesordenada.sort(null);
		assertEquals(listaOrdenada, listaDesordenada);
	}
	
	@Test
	public void testToString() {
		assertEquals("1 - yoshi", carta.toString());
	}
	
	@Test
	public void testDeLinea() {
		String str = "1;yoshi;Yoshi;SuperMario;Super Mario;25;60;80";
		Carta carta2 = Carta.deLinea(str);
		assertEquals(carta, carta2);
	}
	
	
	
	
}
