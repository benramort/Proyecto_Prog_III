package ventanas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import comportamientos.Carta;
import comportamientos.Datos;

public class JTableCartas{
	static Random r = new Random();
	String[] cabeceras = {"Carta", "Precio", "Usuario"};
	
	public static List<Carta> crearCartas(List<Carta> cartas, Datos datos) {
		for (int i = 0; i < 5; i++) {
			cartas.add(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())));
		}
		return cartas;
	}
	
}

