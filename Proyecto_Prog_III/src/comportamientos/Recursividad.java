package comportamientos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursividad {
	
	public static void main(String[] args) {
		BasesDeDatos db = new BasesDeDatos("datos.db");
//		db.cargarModeloCartas();
		List<Carta> cartas = db.getModeloCartas();
		Collections.shuffle(cartas);
		System.out.println(cartas);
		System.out.println(getCartasOrdenadas(cartas));
	}
	
	public static List<Carta> getCartasOrdenadas(List<Carta> cartas) {
		if (cartas.size() <= 1) {
			return cartas;
		} else {
			List<Carta> cartas1 = getCartasOrdenadas(cartas.subList(0, cartas.size()/2));
			List<Carta> cartas2 = getCartasOrdenadas(cartas.subList(cartas.size()/2, cartas.size()));
			return merge(cartas1, cartas2);
		}
	}
	
	private static List<Carta> merge(List<Carta> lista1, List<Carta> lista2) {
		List<Carta> resultado = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		while (i1 < lista1.size() || i2 < lista2.size()) {
			if (i2 >= lista2.size()) {
//				System.out.println("Añadiendo de L1");
				resultado.add(lista1.get(i1));
				i1++;
			} else if (i1 >= lista1.size() || lista1.get(i1).getId() > lista2.get(i2).getId()) {
//				System.out.println("Añadiendo de L2");
				resultado.add(lista2.get(i2));
				i2++;
			} else {
//				System.out.println("Añadiendo de L1");
				resultado.add(lista1.get(i1));
				i1++;
			}
		}
		return resultado;
	}

}
