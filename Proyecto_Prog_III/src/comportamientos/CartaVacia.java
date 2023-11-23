package comportamientos;

import javax.swing.ImageIcon;

public class CartaVacia extends Carta {
	
	public CartaVacia() { //TODO optimizr
		super(0, null, null, new Saga("", ""), 0, 0, 0);
	}
	
	@Override
	public ImageIcon getRecursoGrafico() {
		return new ImageIcon("img/bloqueado.png");
	}

}
