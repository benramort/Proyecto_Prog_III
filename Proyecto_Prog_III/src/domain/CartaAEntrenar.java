package domain;

import java.nio.file.Path;

import javax.swing.ImageIcon;

public class CartaAEntrenar extends Carta{
	
	public CartaAEntrenar() { //TODO optimizr
		super(0, "", "", new Saga("", ""), 0,0,0);
	}
	
	@Override
	public ImageIcon getRecursoGrafico() {
		Path path = Path.of("resources/img/seleccion.png");
		return new ImageIcon(path.toAbsolutePath().toString());
	}

}

