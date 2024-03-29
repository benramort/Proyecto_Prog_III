package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import domain.Carta;
import domain.Recursividad;
import domain.Usuario;
import domain.Venta;
import interfaces.Datos;

public class Ficheros implements Datos {
	

	private List<Carta> modeloCartas = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<Usuario>(); //Igual un mapa es más eficiente
	private List<Venta> ventas = new ArrayList<Venta>();
	
	private String nombreFicheroUsuarios = "usuarios";
	private String nombreFicheroCartas = "modeloCartas";
	private String nombreFicheroVentas = "ventas";
	
	private static Logger logger = Logger.getLogger(Ficheros.class.getName());
	
	
	public Ficheros(String nombreCartas, String nombreUsuarios, String nombreVentas) {
		nombreFicheroCartas = nombreCartas;
		nombreFicheroUsuarios = nombreUsuarios;
		nombreFicheroVentas = nombreVentas;
		
//		cargarModeloCartas();
//		configurarLogger();
//		cargarUsuarios();
	}
	
	public Ficheros() {
		cargarModeloCartas();
		configurarLogger();
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
		Path path1 = Path.of("resources/data/"+nombreFicheroCartas+".csv");
		String path1String = path1.toAbsolutePath().toString();
		try (Scanner scanner = new Scanner(new FileInputStream(path1String))) {
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				try {
					Carta c = Carta.deLinea(linea);
					modeloCartas.add(c);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
			modeloCartas = Recursividad.getCartasOrdenadas(modeloCartas);
		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
			logger.severe("No se han podido cargar las cartas modelo");
		}
	}
	
//	public List<Carta> cargarModeloCartas() {
//		try (Scanner scanner = new Scanner(new FileInputStream("data/"+nombreFicheroCartas+".csv"))) {
//			while (scanner.hasNextLine()) {
//				String linea = scanner.nextLine();
//				try {
//					Carta c = Carta.deLinea(linea);
//					modeloCartas.add(c);
//				} catch (NumberFormatException ex) {
//					ex.printStackTrace();
//				}
//			}
//			modeloCartas.sort(null);
//			return modeloCartas;
//		} catch (FileNotFoundException ex) {
////			ex.printStackTrace();
//			logger.severe("No se han podido cargar las cartas modelo");
//			return null;
//		}
//	}
	
	
	public void cargarUsuarios() {
		Path path2 = Path.of("resources/data/"+nombreFicheroUsuarios+".csv");
		String path2String = path2.toAbsolutePath().toString();
		try (Scanner scanner = new Scanner(new FileInputStream(path2String))) {
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
	
//	public List<Usuario> cargarUsuarios(String nombre) {
//		try (Scanner scanner = new Scanner(new FileInputStream("data/"+nombre+".csv"))) {
//			usuarios.clear();
//			while (scanner.hasNextLine()) {
//				String linea = scanner.nextLine();
//				try {
//					Usuario u = Usuario.deLinea(linea, this);
//					usuarios.add(u);
//				} catch (NumberFormatException ex) {
//					ex.printStackTrace();
//				}
//			}
//			return usuarios;
//		} catch (FileNotFoundException ex) {
//			logger.warning("No se han podido cargar los usuarios");
//			return null;
//		}
//	}
	
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
			logger.warning("No se ha podido guardar el usuario");
		}
		guardarUsuarios();
		
	}
	
	
	public void guardarUsuarios() {
		Path path3 = Path.of("resources/data/usuarios.csv");
		String path3String = path3.toAbsolutePath().toString();
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(path3String));
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
		Path path4 = Path.of("resources/data/"+nombreFicheroVentas+".csv");
		String path4String = path4.toAbsolutePath().toString();
		try (Scanner scanner = new Scanner(new FileInputStream(path4String))){
			ventas = new ArrayList<Venta>();
			while (scanner.hasNextLine()) {
				try {
					String line = scanner.nextLine();
					ventas.add(Venta.deLinea(this, line));
				} catch (NumberFormatException | DateTimeParseException ex) {
					logger.info("La venta no se ha podido cargar");
					ex.printStackTrace();
				}
			}
		} catch (IOException ex) {
			logger.warning("No se han podido cargar las ventas");
		}
	}
	
	
	public void guardarVenta(Venta v) { //Sería más óptimo guardar todo al final, pero funciona mejor así para bases de datos
		Path path5 = Path.of("resources/data/ventas.csv");
		String path5String = path5.toAbsolutePath().toString();
		try (PrintStream ps = new PrintStream(new FileOutputStream(path5String, true))) {
			ps.println(v.aLinea());
		} catch (IOException ex) {
			logger.info("No se ha podido guardar la venta");
		}
	}
	
	public void configurarLogger() {
		try (FileInputStream is = new FileInputStream("conf/logger.properties")) {
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
		datos.cargarUsuarios();
		for (Carta u: datos.getModeloCartas()) {
			System.out.println(u);
		}
//		datos.guardarUsuario(new Usuario("1", "1", datos, 0));
	}

}
