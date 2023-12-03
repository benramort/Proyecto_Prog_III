package comportamientos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BasesDeDatos implements Datos {
	
	private static Logger logger = Logger.getLogger(Ficheros.class.getName());
	
	private Connection conn;
	
	public BasesDeDatos() {
		configurarLogger();
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data/datos.db");
			logger.info("Conexión exitosa con la base de datos");
		} catch (ClassNotFoundException ex) {
			logger.warning("No se ha podido cargar el driver de la base de datos");
		} catch (SQLException ex) {
			logger.warning("No se ha podido conectar con la base de datos");
		}
	}

	@Override
	public void cargarModeloCartas() {
		
	}

	@Override
	public void cargarUsuarios() {
		
	}

	@Override
	public void configurarLogger() {
		try (FileInputStream is = new FileInputStream("data/logger.properties")) {
			LogManager.getLogManager().readConfiguration(is);
		} catch (FileNotFoundException ex) {
			logger.info("No se ha encontrado la configuracion del logger. Usando configuracion por defercto");
			ex.printStackTrace();
		} catch (IOException ex) {
			logger.info("No se ha podido cargar del fichero de configuración del logger. Usando configuración por defecto");
		}
		logger.fine("El logger se ha configurado correctamente");
	}

	@Override
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carta> getModeloCartas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario cargarUsuario(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario comprobarUsuario(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void cerrarConexion() {
		try {
			conn.close();
		} catch (SQLException e) {
			logger.info("Error en el cierre de la conexión a la base de datos, probablemente queden recursos abiertos");
		}
	}
	
	public static void main(String[] args) {
		
		BasesDeDatos bd = new BasesDeDatos();
		bd.cerrarConexion();
		
	}

}
