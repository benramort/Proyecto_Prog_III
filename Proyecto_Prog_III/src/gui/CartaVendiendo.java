package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Carta;

public class CartaVendiendo extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Object precio;
	public Carta carta;
	public PanelCarta pCarta;
	public JLabel lPrecio;
//	public int indice;

	public CartaVendiendo(Carta carta, Object precio) {
		this.carta = carta;
		this.precio = precio;
//		this.indice = indice;

		//Formato Panel
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		//Creacion contenedores
		JPanel pPrincipal = new JPanel();
		//Formato contenedores
		pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));
		//Creacion componentes
		lPrecio = new JLabel(precio + "");
		pCarta = new PanelCarta(carta);
		//Formato componentes
		pCarta.setPreferredSize(new Dimension(300, 350));
		pCarta.setMinimumSize(new Dimension(300, 350));
		lPrecio.setPreferredSize(new Dimension(300, 35));
		lPrecio.setHorizontalAlignment(JLabel.CENTER);
		lPrecio.setFont(new Font("Arial", Font.BOLD, 15));
//		lPrecio.setBackground(Color.RED);
//		lPrecio.setOpaque(true);
		//Añadir componentes a contenedores
		this.add(pPrincipal);
		pPrincipal.add(pCarta);
		pPrincipal.add(Box.createVerticalStrut(10));
		pPrincipal.add(lPrecio);
		pPrincipal.setPreferredSize(new Dimension(250, 400));

	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
		pCarta = new PanelCarta(carta);
		repaint();
	}
	
	public JLabel getLPrecio() {
		return lPrecio;
	}
}


