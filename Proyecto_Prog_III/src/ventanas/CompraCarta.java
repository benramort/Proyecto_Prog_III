package ventanas;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import comportamientos.Datos;
import comportamientos.Usuario;
import comportamientos.Venta;


public class CompraCarta {
	
	Venta venta;
	Datos datos;
	Usuario usuario;
	JFrame ventana;
	List<Venta> ventasParciales;

	
	
	public CompraCarta(List<Venta> ventasParciales, Venta venta, Datos datos, Usuario usuario, JFrame ventana) {
		this.venta = venta;
		this.datos = datos;
		this.usuario = usuario;
		this.ventana = ventana;
		this.ventasParciales = ventasParciales;
	}
	
	public void gestionarCompra() {
		int monedasUsuario = 0;
		int monedas = usuario.getMonedas();
		int respuesta = JOptionPane.showConfirmDialog(((Mercado) ventana), "¿Seguro que quieres comprar esta carta?", "Confirmar compra", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.OK_OPTION) {
			int monedasRestantes = monedas - venta.getPrecio();
			if (monedasRestantes < 0) {
				 JOptionPane.showMessageDialog(((Mercado) ventana), "No tienes monedas suficientes", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				monedasUsuario = usuario.getMonedas() - venta.getPrecio();
				usuario.setMonedas(monedasUsuario);
				datos.getVentas().remove(venta);
				ventasParciales.remove(venta);
				usuario.getCartas().put(venta.getCarta(), usuario.getCartas().get(venta.getCarta()) + 1);
			} 									
		}
	}
}
