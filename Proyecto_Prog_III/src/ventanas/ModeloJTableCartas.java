package ventanas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.table.AbstractTableModel;

import comportamientos.Datos;
import comportamientos.Venta;

public class ModeloJTableCartas extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Venta> ventas;
	String[] cabeceras = {"Carta", "Precio", "Usuario"};

	public ModeloJTableCartas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public int getRowCount() {
		return ventas.size();
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
		Venta v = ventas.get(rowIndex);
		switch(columnIndex) {
			case 0: return v.getCarta();
			case 1:	return v.getPrecio();
			case 2:	return v.getUsuario().getNombre();
			default: return null;
		}
	}
	
}

