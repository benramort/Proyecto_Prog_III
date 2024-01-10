package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import comportamientos.Carta;
import comportamientos.Datos;
import comportamientos.Usuario;


public class CompraCarta {
	Carta carta;
	int precio;
	Datos datos;
	Usuario usuario;
	JFrame ventana;

	
	
	public CompraCarta(Carta carta, int precio, Datos datos, Usuario usuario, JFrame ventana) {
		this.carta = carta;
		this.precio = precio;
		this.datos = datos;
		this.usuario = usuario;
		this.ventana = ventana;
	}
	
	public void gestionarCompra() {
		int monedasUsuario = 0;
		int monedas = usuario.getMonedas();
		int respuesta = JOptionPane.showConfirmDialog(((Mercado) ventana), "¿Seguro que quieres comprar esta carta?", "Confirmar compra", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.OK_OPTION) {
			int monedasRestantes = monedas - precio;
			if (monedasRestantes < 0) {
				 JOptionPane.showMessageDialog(((Mercado) ventana), "No tienes monedas suficientes", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				monedasUsuario = usuario.getMonedas() - precio;
				usuario.setMonedas(monedasUsuario);
			} 									
		}
	}
}
