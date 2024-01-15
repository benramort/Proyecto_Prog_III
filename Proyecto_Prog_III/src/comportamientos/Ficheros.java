package comportamientos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Ficheros implements Datos {
	

	private List<Carta> modeloCartas = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<Usuario>(); //Igual un mapa es más eficiente
	private List<Venta> ventas = new ArrayList<Venta>();
	
	private static Logger logger = Logger.getLogger(Ficheros.class.getName());
	
	
	public Ficheros(String nombreCartas, String nombreUsuarios) {
		cargarModeloCartas(nombreCartas);
//		configurarLogger();
		cargarUsuarios(nombreUsuarios);
	}
	
	public Ficheros() {
		cargarModeloCartas();
//		configurarLogger();
		cargarUsuarios();
	}
	
	public List<Carta> getModeloCartas() {
		return modeloCartas;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	@Override
	public List<Venta> getVentas() {
		return ventas;
	}
	
//	public static List<Venta> cargarMercado() {
//		
//	}
	
	public void cargarModeloCartas() {
		try (Scanner scanner = new Scanner(new FileInputStream("data/modeloCartas.csv"))) {
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				try {
					Carta c = Carta.deLinea(linea);
					modeloCartas.add(c);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
			modeloCartas.sort(null);
		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
			logger.severe("No se han podido cargar las cartas modelo");
		}
	}
	
	public List<Carta> cargarModeloCartas(String nombre) {
		try (Scanner scanner = new Scanner(new FileInputStream("data/"+nombre+".csv"))) {
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				try {
					Carta c = Carta.deLinea(linea);
					modeloCartas.add(c);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
			modeloCartas.sort(null);
			return modeloCartas;
		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
			logger.severe("No se han podido cargar las cartas modelo");
			return null;
		}
	}
	
	public void cargarUsuarios() {
		try (Scanner scanner = new Scanner(new FileInputStream("data/usuarios.csv"))) {
			usuarios.clear();
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				try {
					Usuario u = Usuario.deLinea(linea, this);
					usuarios.add(u);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException ex) {
			logger.warning("No se han podido cargar los usuarios");
		}
	}
	
	public List<Usuario> cargarUsuarios(String nombre) {
		try (Scanner scanner = new Scanner(new FileInputStream("data/"+nombre+".csv"))) {
			usuarios.clear();
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				try {
					Usuario u = Usuario.deLinea(linea, this);
					usuarios.add(u);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
			return usuarios;
		} catch (FileNotFoundException ex) {
			logger.warning("No se han podido cargar los usuarios");
			return null;
		}
	}
	
	@Override
	public Usuario cargarUsuario(String s) {
		cargarUsuarios();
		for (Usuario usuario: usuarios) {
			if (usuario.getNombre().equals(s)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public void guardarUsuario(Usuario usuario) { //Esto funciona
//		boolean existeUsuario = false;
		try {
			System.out.println(usuarios.size());
			for (int i=0; i<usuarios.size(); i++) {
				Usuario u = usuarios.get(i);
				System.out.println(i + 1 + "/" + usuarios.size());
				if (u == usuario) {
					usuarios.remove(i);
					System.out.println("Monedas del usuario"+usuario.getMonedas());
					System.out.println("Usuario eliminado");
//					usuarios.add(usuario);
				}
			}
			usuarios.add(usuario);
			System.out.println(usuarios);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		guardarUsuarios();
		
	}
	
	public void guardarUsuarios() {
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("data/usuarios.csv"));
			for (Usuario u : usuarios) {
				String linea = u.aLinea();
				ps.println(linea);
			}
			ps.close();
		} catch (IOException e) {
			logger.warning("No se pudo guardar el usuario");
		}
	}

	
	public void cargarVentas() {
		try (Scanner scanner = new Scanner(new FileInputStream("data/ventas.csv"))){
			while (scanner.hasNextLine()) {
				try {
					String line = scanner.nextLine();
					Venta.deLinea(this, line);
				} catch (NumberFormatException ex) {
					logger.info("La venta no se ha podido cargar");
				}
			}
		} catch (IOException ex) {
			
		}
	}

	public void guardarVenta(Venta v) { //Sería más óptimo guardar todo al final, pero funciona mejor así para bases de datos
		try (PrintStream ps = new PrintStream(new FileOutputStream("data/ventas.csv", true))) {
			ps.println(v.aLinea());
		} catch (IOException ex) {
			logger.info("No se ha podido guardar la venta");
		}
	}
	
	public void configurarLogger() {
		try (FileInputStream is = new FileInputStream("data/logger.properties")) {
			LogManager.getLogManager().readConfiguration(is);
		} catch (FileNotFoundException ex) {
			logger.info("No se ha encontrado la configuracion del logger. Usando configuracion por defercto");
			ex.printStackTrace();
		} catch (IOException ex) {
			logger.info("No se ha podido cargar del fichero de configuración del logger. Usando configuración por defecto");
		}
		logger.info("El logger se ha configurado correctamente");
	}
	
	public static void main(String[] args) {
		Datos datos = new Ficheros();
//		datos.cargarUsuarios();
		for (Carta u: datos.getModeloCartas()) {
			System.out.println(u);
		}
//		datos.guardarUsuario(new Usuario("1", "1", datos, 0));
	}

}
