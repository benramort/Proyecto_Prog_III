package domain;

import javax.swing.ImageIcon;

public class CartaAEntrenar extends Carta{
	
	public CartaAEntrenar() { //TODO optimizr
		super(0, "", "", new Saga("", ""), 0,0,0);
	}
	
	@Override
	public ImageIcon getRecursoGrafico() {
		return new ImageIcon("img/seleccion.png");
	}

}

