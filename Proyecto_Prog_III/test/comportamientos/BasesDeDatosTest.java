package comportamientos;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasesDeDatosTest {
	
	BasesDeDatos db;
	
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
					+ "	MONEDAS INTEGER\r\n"
					+ "	CARTAS_SIN_STAMINA TEXT,\r\n"
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
			
//			stmt.executeUpdate("INSERT INTO ")
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
	public void test() {
		
	}
	
	public static void main(String[] args) {
		
	}
	
	

}
