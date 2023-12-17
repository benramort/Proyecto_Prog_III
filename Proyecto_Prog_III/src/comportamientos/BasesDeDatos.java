package comportamientos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BasesDeDatos implements Datos {
	
	private static Logger logger = Logger.getLogger(Ficheros.class.getName());
	
	private List<Carta> modeloCartas = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();
//	private Set<Saga> sagas = new HashSet<>(); TODO optimizar creación de sagasxddd
	
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
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MODELO_CARTAS");
			while (rs.next()) {
				int id = rs.getInt(1);
				String nombreInterno = rs.getString(2);
				String nombreVisible = rs.getString(3);
				String sagaInterno = rs.getString(4);
				String sagaVisible = rs.getString(5);
				int monedasPorMinuto = rs.getInt(6);
				int resistencia = rs.getInt(7);
				int recuperacion = rs.getInt(8);
				Saga saga = new Saga(sagaInterno, sagaVisible);
				Carta carta = new Carta(id, nombreInterno, nombreVisible, saga, monedasPorMinuto, resistencia, recuperacion);
//				System.out.println(carta);
				modeloCartas.add(carta);
			}
			stmt.close();
		} catch (SQLException e) {
			logger.warning("No se han podido cargar los modelos de cartas");
		}
		
	}

	@Override
	public void cargarUsuarios() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS");
			while (rs.next()) {
//				int id = rs.getInt(1);
				String nom = rs.getString(2);
				String pass = rs.getString(3);
				String cartasString = rs.getString(4);
				int monedas = rs.getInt(5);
				Map<Carta, Integer> cartas = Usuario.cargarCartas(cartasString, this);
//				Usuario usuario = new Usuario(nom, pass, this, cartas, monedas);
//				usuarios.add(usuario);
			}
			stmt.close();
		} catch (SQLException e) {
			logger.warning("No se han podido cargar los modelos de cartas");
		}
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
		return usuarios;
	}

	@Override
	public List<Carta> getModeloCartas() {
		return modeloCartas;
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		try {
			PreparedStatement insert = conn.prepareStatement("INSERT INTO usuarios VALUES (?, ?, ?, ?, ?)");
			insert.setInt(1,0);
			insert.setString(2, usuario.getNombre());
			insert.setString(3, usuario.getContrasena());
			insert.setObject(4, usuario.getCartas());
			insert.setInt(5, usuario.getMonedas());
			
			insert.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("No se han podido insertar los datos");
		}
		
	}

	@Override
	public Usuario cargarUsuario(String nombre) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM USUARIOS WHERE USERNAME = ?");
			prepStmt.setString(1, nombre);
			ResultSet rs = prepStmt.executeQuery();
			rs.next();
//			int id = rs.getInt(1);
			String nom = rs.getString(2);
			String pass = rs.getString(3);
			String cartasString = rs.getString(4);
			int monedas = rs.getInt(5);
			Map<Carta, Integer> cartas = Usuario.cargarCartas(cartasString, this);
//			Usuario usuario = new Usuario(nom, pass, this, cartas, monedas);
			prepStmt.close();
//			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		bd.cargarModeloCartas();
		bd.cargarUsuarios();
		System.out.println(bd.getModeloCartas());
		System.out.println(bd.getUsuarios());
		System.out.println(bd.cargarUsuario("benat"));
		bd.cerrarConexion();
		
	}

}
