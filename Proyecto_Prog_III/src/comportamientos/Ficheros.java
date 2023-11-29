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
	

	public static List<Carta> modeloCartas = new ArrayList<>();
	public static List<Usuario> usuarios = new ArrayList<Usuario>(); //Igual un mapa es más eficiente
	
	private static Logger logger = Logger.getLogger(Ficheros.class.getName());
	
	
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
	public Usuario comprobarUsuario(String nombre) {
		if(cargarUsuario(nombre) == null) {
			return null;
		} else {
			return cargarUsuario(nombre);
		}
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
			logger.info("No se pudo guardar el usuario");
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
		logger.fine("El logger se ha configurado correctamente");
	}
	
	public static void main(String[] args) {
		Datos datos = new Ficheros();
//		datos.cargarUsuarios();
		for (Usuario u: datos.getUsuarios()) {
			System.out.println(u.aLinea());
		}
		datos.guardarUsuario(new Usuario("1", "1", datos, 0));
	}

}
