package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import comportamientos.Carta;
import comportamientos.Saga;

public class CartaEntrenando extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CartaEntrenando() {
		//Formato Panel
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Creacion contenedores
		JPanel pPrincipal = new JPanel();
		//Formato contenedores
		pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));
		//Creacion componentes
		PanelCarta pCarta = new PanelCarta(new Carta("yoshi",new Saga("SuperMario")));
		JProgressBar pbStamina = new JProgressBar(0, 100);
		//Formato componentes
		pbStamina.setPreferredSize(new Dimension(250, 30));
		
		//Añadir componentes a contenedores
		this.add(pPrincipal);
		pPrincipal.add(pCarta);
		pPrincipal.add(Box.createVerticalStrut(20));
		pPrincipal.add(pbStamina);		
		
	}

}
