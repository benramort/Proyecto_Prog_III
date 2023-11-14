package ventanas;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import comportamientos.Carta;

public class CartaEntrenando extends JPanel{
/**
*
*/
private static final long serialVersionUID = 1L;
	
	public JProgressBar pbStamina = new JProgressBar(0, 100);
	public Carta carta;
	public double porcentajeStamina = 100;

	public CartaEntrenando(Carta carta) {
		this.carta = carta;

		//Formato Panel
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		//Creacion contenedores
		JPanel pPrincipal = new JPanel();
		//Formato contenedores
		pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));
		//Creacion componentes
		PanelCarta pCarta = new PanelCarta(carta);

		//Formato componentes
		pbStamina.setPreferredSize(new Dimension(250, 30));
		pbStamina.setStringPainted(true);

		//Añadir componentes a contenedores
		this.add(pPrincipal);
		pPrincipal.add(pCarta);
		pPrincipal.add(Box.createVerticalStrut(20));
		pPrincipal.add(pbStamina);
		setOpaque(false);

	}

	public Carta getCarta() {
		return carta;
	}

	public double getPorcentajeStamina() {
		return porcentajeStamina;
	}

	public void setPorcentajeStamina(double porcentajeStamina) {
		this.porcentajeStamina = porcentajeStamina;
	}

	public JProgressBar getPbStamina() {
		return this.pbStamina;
	}

}
