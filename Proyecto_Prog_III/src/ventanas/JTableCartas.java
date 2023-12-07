package ventanas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import comportamientos.Carta;
import comportamientos.Datos;

public class JTableCartas implements TableModel {
	static List<Carta> cartas = new ArrayList<Carta>();
	static Datos datos;
	static Random r = new Random();
	String[] cabeceras = {"Carta", "Precio", "Usuario"};
	
	public static void crearCartas() {
		for (int i = 0; i < 5; i++) {
			cartas.add(datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())));
		}
	}
	
	public JTableCartas() {
		
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

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		crearCartas();
	}
}

