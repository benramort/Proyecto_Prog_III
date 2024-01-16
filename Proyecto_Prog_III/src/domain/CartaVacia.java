package domain;

import java.nio.file.Path;

import javax.swing.ImageIcon;

public class CartaVacia extends Carta {
	
	public CartaVacia() { //TODO optimizr
		super(0, "", "", new Saga("", ""), 0, 0, 0);
	}
	
	@Override
	public ImageIcon getRecursoGrafico() {
		Path path = Path.of("resources/img/bloqueado.png");
		return new ImageIcon(path.toAbsolutePath().toString());
	}

}
