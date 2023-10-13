package ventanas;

import javax.swing.*;
import comportamientos.Carta;

public class PanelCarta extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Carta carta;
	
	public PanelCarta(Carta carta) {
		this.carta = carta;
	}

}

