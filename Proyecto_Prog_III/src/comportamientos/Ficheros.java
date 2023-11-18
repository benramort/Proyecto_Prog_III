package comportamientos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Ficheros implements Datos {
	

	public static List<Carta> modeloCartas = new ArrayList<>();
	public static List<Usuario> usuarios = new ArrayList<Usuario>(); //Esto tiene sentido que sea un list
	
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
	public void guardarUsuario(Usuario usuario) {
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("data/usuarios.csv", true));
			String linea = usuario.aLinea(usuario);
			ps.println(linea);
		} catch (IOException e) {
			System.out.println("No se pudo guardar el usuario");
		}
	}
	
	public void configurarLogger() {
		try (FileInputStream is = new FileInputStream("data/logger.properties")) {
			LogManager.getLogManager().readConfiguration(is);
		} catch (FileNotFoundException ex) {
			logger.info("No se ha encontrado la configuracion del logger. Usando configuracion por defercto");
			ex.printStackTrace();
		} catch (IOException ex) {
			logger.info("No se ha podido cargar el fichero de configuración del logger. Usando configuración por defecto");
		}
		logger.fine("El logger se ha configurado correctamente");
	}

}
