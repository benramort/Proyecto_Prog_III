package comportamientos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ventanas.VentanaSobres;

public class Compra {
	
	JLabel lNombreSobre;
	JLabel lPrecioSobre;
	Datos datos;
	Usuario usuario;
	JFrame ventana;

	
	
	public Compra(JLabel lNombreSobre,JLabel lPrecioSobre,  Datos datos, Usuario usuario, JFrame ventana) {
		this.lNombreSobre = lNombreSobre;
		this.lPrecioSobre = lPrecioSobre;
		this.datos = datos;
		this.usuario = usuario;
		this.ventana = ventana;
	}
	
	public void gestionarCompra() {
		int numCartasPorSobre = 0;
		int monedasUsuario = 0;
		int monedas = usuario.getMonedas();
		int respuesta = JOptionPane.showConfirmDialog(lNombreSobre, "¿Seguro que quieres comprar este sobre??", "Confirmar compra", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.OK_OPTION) {
			if(lNombreSobre.getText() == ("Sobre Ultimate")) {
				numCartasPorSobre = 4;
				int monedasRestantes = monedas - Integer.parseInt(lPrecioSobre.getText());
				if (monedasRestantes < 0) {
					 JOptionPane.showMessageDialog(lNombreSobre, "No tienes monedas suficientes", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					new VentanaSobres(ventana, datos, numCartasPorSobre, usuario);
					monedasUsuario = usuario.getMonedas() - Integer.parseInt(lPrecioSobre.getText());
					usuario.setMonedas(monedasUsuario);
				}
				//usuario.getMonedas() = usuario.getMonedas() - Integer.parseInt(lPrecioSobre.getText());
			}else if(lNombreSobre.getText() == ("Megasobre")) {
				numCartasPorSobre = 3;
				int monedasRestantes = monedas - Integer.parseInt(lPrecioSobre.getText());
				if (monedasRestantes < 0) {
					 JOptionPane.showMessageDialog(lNombreSobre, "No tienes monedas suficientes", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					new VentanaSobres(ventana, datos, numCartasPorSobre, usuario);
					monedasUsuario = usuario.getMonedas() - Integer.parseInt(lPrecioSobre.getText());
					usuario.setMonedas(monedasUsuario);
				}
			}else if(lNombreSobre.getText() == ("Sobre Oro Premium")) {
				numCartasPorSobre = 2;
				int monedasRestantes = monedas - Integer.parseInt(lPrecioSobre.getText());
				if (monedasRestantes < 0) {
					 JOptionPane.showMessageDialog(lNombreSobre, "No tienes monedas suficientes", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					new VentanaSobres(ventana, datos, numCartasPorSobre, usuario);
					monedasUsuario = usuario.getMonedas() - Integer.parseInt(lPrecioSobre.getText());
					usuario.setMonedas(monedasUsuario);
				}
			}else {
				numCartasPorSobre = 1;
				int monedasRestantes = monedas - Integer.parseInt(lPrecioSobre.getText());
				if (monedasRestantes < 0) {
					 JOptionPane.showMessageDialog(lNombreSobre, "No tienes monedas suficientes", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					new VentanaSobres(ventana, datos, numCartasPorSobre, usuario);
					monedasUsuario = usuario.getMonedas() - Integer.parseInt(lPrecioSobre.getText());
					usuario.setMonedas(monedasUsuario);
				}
			}									
		}
	}
	
}
