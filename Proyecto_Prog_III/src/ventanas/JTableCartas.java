package ventanas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.table.AbstractTableModel;

import comportamientos.Carta;
import comportamientos.Datos;

public class JTableCartas {
	ArrayList<Carta> cartas;
	Datos datos;
	Random r = new Random();
	
	public void crearCartas(ArrayList<Carta> cartas) {
		for (int i = 0; i < 5; i++) {
			cartas.add(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())));
		}
	}
	
	class MyTableModel extends AbstractTableModel {
		private static List<Carta> cartas;

		String[] cabeceras = {"Carta", "Precio", "Usuario"};
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public MyTableModel(List<Carta> cartas) {
			this.cartas = cartas;
		}

		@Override
		public int getRowCount() {
			return cartas.size();
		}

		@Override
		public int getColumnCount() {
			return cabeceras.length;
		}

		@Override
		public String getColumnName(int column) {
			return cabeceras[column];
			
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return null;
		}

	}
}

