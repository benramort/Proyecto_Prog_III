package comportamientos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class MiBaseDeDatos {
	
	public static TreeSet<Carta> modeloCartas = new TreeSet<>();
	
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
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			//TODO usar el logger
		}
	}
	
	public static void main(String[] args) {
		cargarModeloCartas();
		for (Carta c: modeloCartas) {
			System.out.println(c);
		}
	}

}
