package ventanas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.table.AbstractTableModel;

import comportamientos.Carta;
import comportamientos.Datos;

public class JTableCartas {
	ArrayList<Carta> cartas = new ArrayList<>();
	Datos datos;
	Random r = new Random();
	
	for (int i = 0; i < 5; i++) {
		cartas.add(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())));
	}
	
//	class MyTableModel extends AbstractTableModel {
//		String[] cabeceras = {"Carta", "Precio", "Usuario"};
//		
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		
//		private List<Person> personas;
//		
//		public MyTableModel(List<Person> personas) {
//			this.personas = personas;
//		}
//
//		@Override
//		public Object getValueAt(int row, int column) {
//			Person p = personas.get(row);
//			switch (column) {
//			case 0: return p.getName();
//			case 1: return p.getSurname();
//			case 2: return p.getBirthDate();
//			default: return null;
//			}
//		}
//
//		@Override
//		public int getRowCount() {
//			return personas.size();
//		}
//
//		@Override
//		public int getColumnCount() {
//			return cabeceras.length;
//		}
//
//		@Override
//		public String getColumnName(int column) {
//			return cabeceras[column];
//			
//		}
//
//		@Override
//		public boolean isCellEditable(int rowIndex, int columnIndex) {
//			return columnIndex == 0;
//		}
//
//		@Override
//		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//			Person p = personas.get(rowIndex);
//			p.setName(aValue.toString());
//		}
		
	}
}
