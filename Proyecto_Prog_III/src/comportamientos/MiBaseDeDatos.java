package comportamientos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MiBaseDeDatos {
	

	public static List<Carta> modeloCartas = new ArrayList<>();
	public static Set<Usuario> usuarios = new TreeSet<Usuario>(); //Esto tiene sentido que sea un list

	private static Logger logger = Logger.getLogger(MiBaseDeDatos.class.getName());
	
	public static Usuario cargarUsuario() {
		return new Usuario();
	}
	
//	public static List<Venta> cargarMercado() {
//		
//	}
	
	public static void cargarModeloCartas() {
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
	
	public static void cargarUsuarios() {
		try (Scanner scanner = new Scanner(new FileInputStream("data/usuarios.csv"))) {
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				try {
					Usuario u = Usuario.deLinea(linea);
					usuarios.add(u);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException ex) {
			logger.warning("No se han podido cargar los usuarios");
		}
	}
	
	public static void configurarLogger() {
		try (FileInputStream is = new FileInputStream("data/logger.properties")) {
			LogManager.getLogManager().readConfiguration(is);
		} catch (FileNotFoundException ex) {
			logger.info("No se ha encontrado la configuracion del logger. Usando configuracion por defercto");
			ex.printStackTrace();
		} catch (IOException ex) {
			logger.info("No se ha podido cargar el fichero de configuración del logger. Usando configuración por defecto");
		}
		logger.fine("El logger se ha configurado correctamente");
//		logger.warning("Pruebarññ");
		//TODO guardar usuario/información del sistema en el logger
		//TODO qué es el mensaje raro del logger (sun.awt.windows.WToolkit <clinit>)
		
	}
	
	public static void main(String[] args) {
		configurarLogger();
		cargarModeloCartas();
		cargarUsuarios();
		for (Carta c: modeloCartas) {
			System.out.println(c);
		}
	}

}
