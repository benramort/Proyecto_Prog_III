package comportamientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasesDeDatosTest {
	
	BasesDeDatos db;
//	List<Carta> cartas;
//	List<Usuario> usuarios;
	
	@BeforeClass
	public static void preparatorioUnico() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	@Before
	public void preparatorio() {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:data/prueba.db")) {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE USUARIOS(\r\n"
					+ "	ID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
					+ "	USERNAME TEXT NOT NULL,\r\n"
					+ "	PASSWORD TEXT,\r\n"
					+ "	CARTAS TEXT,\r\n"
					+ "	MONEDAS INTEGER,\r\n"
					+ "	CARTAS_SIN_STAMINA TEXT\r\n"
					+ ")");
			
			stmt.executeUpdate("CREATE TABLE MODELO_CARTAS (\r\n"
					+ "ID INTEGER PRIMARY KEY NOT NULL,\r\n"
					+ "NOMBRE_INTERNO TEXT,\r\n"
					+ "NOMBRE_VISIBLE TEXT,\r\n"
					+ "SAGA_INTERNO TEXT,\r\n"
					+ "SAGA_VISIBLE TEXT,\r\n"
					+ "MONEDAS_MINUTO INTEGER,\r\n"
					+ "RESISTENCIA INTEGER,\r\n"
					+ "RECUPERACION INTEGER\r\n"
					+ ");");
			
//			cartas = new ArrayList<Carta>();
//			Saga saga1 = new Saga("saga1", "Saga 1");
//			cartas.add(new Carta(0, "carta1", "Carta 1", saga1, 50,50,50));
			stmt.executeUpdate("INSERT INTO MODELO_CARTAS (ID, NOMBRE_INTERNO, NOMBRE_VISIBLE, SAGA_INTERNO, SAGA_VISIBLE, MONEDAS_MINUTO, RESISTENCIA, RECUPERACION) "
					+ "VALUES (0, 'carta1', 'Carta 1', 'saga1', 'Saga 1', 50,50,50)");
//			Saga saga2 = new Saga("saga2", "Saga 2");
//			cartas.add(new Carta(1, "carta2", "Carta 2", saga2, 5,5,5));
			stmt.executeUpdate("INSERT INTO MODELO_CARTAS (ID, NOMBRE_INTERNO, NOMBRE_VISIBLE, SAGA_INTERNO, SAGA_VISIBLE, MONEDAS_MINUTO, RESISTENCIA, RECUPERACION) "
					+ "VALUES (1, 'carta2', 'Carta 2', 'saga2', 'Saga 2', 5,5,5)");
//			cartas.add(new Carta(2, "carta3", "Carta 3", saga1, 90,90,90));
			stmt.executeUpdate("INSERT INTO MODELO_CARTAS (ID, NOMBRE_INTERNO, NOMBRE_VISIBLE, SAGA_INTERNO, SAGA_VISIBLE, MONEDAS_MINUTO, RESISTENCIA, RECUPERACION) "
					+ "VALUES (2, 'carta3', 'Carta 3', 'saga1', 'Saga 1', 90,90,90)");
			
			
			stmt.executeUpdate("INSERT INTO USUARIOS (USERNAME, PASSWORD, CARTAS, MONEDAS,CARTAS_SIN_STAMINA) "
					+ "VALUES ('usuario1', 'contrasena', '1,0,0,',10, '')");
			stmt.executeUpdate("INSERT INTO USUARIOS (USERNAME, PASSWORD, CARTAS, MONEDAS, CARTAS_SIN_STAMINA) "
					+ "VALUES ('usuario2', 'contrasena', '1,1,1,',20, '1=2023-12-29T12:14:14.9581759+01:00[Europe/Madrid],2=2023-12-29T12:14:14.9581759+01:00[Europe/Madrid],')");
			
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		db = new BasesDeDatos("prueba.db");
	}
	
	@After
	public void cierre() {
		db.cerrarConexion();
		
		File myObj = new File("data/prueba.db"); 
	    if (myObj.delete()) { 
	      System.out.println("Deleted the file: " + myObj.getName());
	    } else {
	      System.out.println("Failed to delete the file.");
	    } 
	}
	
	@Test
	public void testGetModeloCartas() {
//		db.cargarModeloCartas();
//		System.out.println(db.getModeloCartas().size());
		List<Carta> cartas;
		cartas = new ArrayList<Carta>();
		Saga saga1 = new Saga("saga1", "Saga 1");
		Saga saga2 = new Saga("saga2", "Saga 2");
		cartas.add(new Carta(0, "carta1", "Carta 1", saga1, 50,50,50));
		cartas.add(new Carta(1, "carta2", "Carta 2", saga2, 5,5,5));
		cartas.add(new Carta(2, "carta3", "Carta 3", saga1, 90,90,90));
		
		assertEquals(cartas, db.getModeloCartas());
	}
	
	@Test
	public void testGetUsuarios() { //TODO mejorar este test
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("usuario1", "contrasena", null, 10));
		usuarios.add(new Usuario("usuario2", "contrasena", null, 20));
		db.cargarUsuarios();
		assertEquals(usuarios, db.getUsuarios());
	}
	
	@Test
	public void testGuardarUsuario() {
		
	}
	
	@Test
	public void testCargarUsuario() {
		Map<Carta, Integer> cartas = Usuario.cargarCartas("1,1,1,", db);
		Map<Carta, ZonedDateTime> cartasSinStamina = Usuario.cargarSinStamina("1=2023-12-29T12:14:14.9581759+01:00[Europe/Madrid],2=2023-12-29T12:14:14.9581759+01:00[Europe/Madrid],", db);
		Usuario usuarioExistente = new Usuario("usuario2", "contrasena", db, 20);
		Usuario usuarioCargado = db.cargarUsuario("usuario2");
		assertEquals(usuarioExistente, usuarioCargado);
		assertEquals(cartas, usuarioCargado.getCartas());
		assertEquals(cartasSinStamina, usuarioCargado.getCartasSinStamina());
		assertNull(db.cargarUsuario("usuario3"));
		
	}
	

}
