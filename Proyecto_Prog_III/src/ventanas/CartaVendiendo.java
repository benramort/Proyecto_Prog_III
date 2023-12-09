package ventanas;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


import comportamientos.Carta;

public class CartaVendiendo extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int precio;
	public Carta carta;
	public PanelCarta pCarta;
	public JLabel lPrecio;
//	public int indice;

	public CartaVendiendo(Carta carta) {
		this.carta = carta;
//		this.indice = indice;

		//Formato Panel
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		//Creacion contenedores
		JPanel pPrincipal = new JPanel();
		//Formato contenedores
		pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));
		//Creacion componentes
		lPrecio = new JLabel();
		pCarta = new PanelCarta(carta);

		//Formato componentes


		//Añadir componentes a contenedores
		this.add(pPrincipal);
		pPrincipal.add(pCarta);
		pPrincipal.add(Box.createVerticalStrut(20));
		pPrincipal.add(lPrecio);
		setOpaque(false);

	}

	public Carta getCarta() {
		return carta;
	}
	
	

	public void setCarta(Carta carta) {
		this.carta = carta;
		pCarta = new PanelCarta(carta);
		repaint();
	}
}


