package gui;

import java.util.List;
import java.util.Random;

import domain.Carta;
import interfaces.Datos;

public class JTableCartas{
	//TODO esto se usa?
	static Random r = new Random();
	String[] cabeceras = {"Carta", "Precio", "Usuario"};
	
	public static List<Carta> crearCartas(List<Carta> cartas, Datos datos) {
		for (int i = 0; i < 5; i++) {
			cartas.add(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())));
		}
		return cartas;
	}
	
}

