import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import comportamientos.Carta;
import comportamientos.Ficheros;

public class ConversorFicheroDB {
	
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/datos.db");
			Ficheros ficheros = new Ficheros();
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM MODELO_CARTAS");
			stmt.close();
			for (Carta c : ficheros.getModeloCartas()) {
				PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO MODELO_CARTAS VALUES (?,?,?,?,?,?,?,?)");
				prepStmt.setInt(1, c.getId());
				prepStmt.setString(2, c.getNombreInterno());
				prepStmt.setString(3, c.getNombreVisible());
				prepStmt.setString(4, c.getSaga().getNombreInterno());
				prepStmt.setString(5, c.getSaga().getNombreVisible());
				prepStmt.setInt(6,  c.getMonedasPorMinuto());
				prepStmt.setInt(7, c.getResistencia());
				prepStmt.setInt(8, c.getRecuperacion());
				prepStmt.executeUpdate();
				prepStmt.close();
			}
			conn.commit();
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
	}

}
