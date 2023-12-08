package comportamientos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class CompraCarta {
	JLabel lImagenCarta;
	JLabel lPrecio;
	Datos datos;
	Usuario usuario;
	JFrame ventana;

	
	
	public CompraCarta(JLabel lImagenCarta, JLabel lPrecio, Datos datos, Usuario usuario, JFrame ventana) {
		this.lImagenCarta = lImagenCarta;
		this.lPrecio = lPrecio;
		this.datos = datos;
		this.usuario = usuario;
		this.ventana = ventana;
	}
	
	public void gestionarCompra() {
		int monedasUsuario = 0;
		int monedas = usuario.getMonedas();
		int respuesta = JOptionPane.showConfirmDialog(lImagenCarta, "¿Seguro que quieres comprar este sobre??", "Confirmar compra", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.OK_OPTION) {
			int monedasRestantes = monedas - Integer.parseInt(lPrecio.getText());
			if (monedasRestantes < 0) {
				 JOptionPane.showMessageDialog(lImagenCarta, "No tienes monedas suficientes", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				monedasUsuario = usuario.getMonedas() - Integer.parseInt(lPrecio.getText());
				usuario.setMonedas(monedasUsuario);
			} 									
		}
	}
}
