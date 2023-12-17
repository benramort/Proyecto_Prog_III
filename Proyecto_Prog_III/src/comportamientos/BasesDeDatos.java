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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
		cargarModeloCartas();
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
				System.out.println(carta);
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
				String sinStaminaString = rs.getString(6);
				Map<Carta, Integer> cartas = Usuario.cargarCartas(cartasString, this);
				Map<Carta, ZonedDateTime> cartasSinStamina = Usuario.cargarSinStamina(sinStaminaString, this);
				Usuario usuario = new Usuario(nom, pass, this, cartas, monedas, cartasSinStamina);
				usuarios.add(usuario);
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
			PreparedStatement insert = conn.prepareStatement("INSERT INTO usuarios (USERNAME, PASSWORD, CARTAS, MONEDAS) VALUES (?, ?, ?, ?)");
			//insert.setInt(1,0);
			insert.setString(1, usuario.getNombre());
			insert.setString(2, usuario.getContrasena());
			insert.setObject(3, usuario.getCartas());
			insert.setInt(4, usuario.getMonedas());
			insert.setString(5, null);
			insert.executeUpdate();
			insert.close();
		} catch (SQLException e) {
			System.out.println("No se han podido insertar los datos");
			e.printStackTrace();
		}
		
	}

	@Override
	public Usuario cargarUsuario(String nombre) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM USUARIOS WHERE USERNAME = ?");
			prepStmt.setString(1, nombre);
			ResultSet rs = prepStmt.executeQuery();
			if (rs.next()) {
//				System.out.println(rs.getString(2));
//				int id = rs.getInt(1);
				String nom = rs.getString(2);
				String pass = rs.getString(3);
				String cartasString = rs.getString(4);
				int monedas = rs.getInt(5);
				String sinStaminaString = rs.getString(6);
				System.out.println(cartasString);
				Map<Carta, Integer> cartas = Usuario.cargarCartas(cartasString, this);
				Map<Carta, ZonedDateTime> cartasSinStamina = Usuario.cargarSinStamina(sinStaminaString, this);
				Usuario usuario = new Usuario(nom, pass, this, cartas, monedas, cartasSinStamina);
				prepStmt.close();
				return usuario;
			}
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
		System.out.println(bd.getModeloCartas());
		Usuario usuario = new Usuario("Benaat", "aaaaa", bd, 10);
		bd.guardarUsuario(usuario);
		Usuario usuario2 = bd.cargarUsuario("Benaat");
		System.out.println(usuario2);
		usuario2.aLinea();
	}

}
