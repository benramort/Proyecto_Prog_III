package comportamientos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ventanas.VentanaSobres;

public class Compra {
	
	JLabel lNombreSobre;
	Datos datos;
	Usuario usuario;
	JFrame ventana;

	
	
	public Compra(JLabel lNombreSobre, Datos datos, Usuario usuario, JFrame ventana) {
		this.lNombreSobre = lNombreSobre;
		this.datos = datos;
		this.usuario = usuario;
		this.ventana = ventana;
	}
	
	public void gestionarCompra() {
		int numCartasPorSobre = 0;
		int respuesta = JOptionPane.showConfirmDialog(lNombreSobre, "¿Seguro que quieres comprar este sobre??", "Confirmar compra", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.OK_OPTION) {
			if(lNombreSobre.getText() == ("Sobre Ultimate")) {
				numCartasPorSobre = 4;
			}else if(lNombreSobre.getText() == ("Megasobre")) {
				numCartasPorSobre = 3;
			}else if(lNombreSobre.getText() == ("Sobre Oro Premium")) {
				numCartasPorSobre = 2;
			}else {
				numCartasPorSobre = 1;
			}
			new VentanaSobres(ventana, datos, numCartasPorSobre, usuario);									
		}
	}
	
}
