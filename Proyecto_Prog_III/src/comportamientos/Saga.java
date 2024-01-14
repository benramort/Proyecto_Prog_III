package comportamientos;

import java.nio.file.Path;

import javax.swing.ImageIcon;

public class Saga {
	
	private String nombreInterno; //String en camelCase con la primera en mayuscula
	private String nombreVisible;
	private ImageIcon recursoGrafico;
	
	public Saga(String nombreInterno, String nombreVisible) { //TODO todas las cartas crean un objeto saga
		this.nombreInterno = nombreInterno;
		this.nombreVisible = nombreVisible;
		Path path = Path.of("img/logo"+nombreInterno+".png");
		this.recursoGrafico = new ImageIcon(path.toAbsolutePath().toString());
	}

	public String getNombreInterno() {
		return nombreInterno;
	}

	public String getNombreVisible() {
		return nombreVisible;
	}

	public ImageIcon getRecursoGrafico() {
		return recursoGrafico;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Saga) {
			return nombreInterno.equals(((Saga) o).getNombreInterno());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%s",nombreVisible);
	}
	
}
