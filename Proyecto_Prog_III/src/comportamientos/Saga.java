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
	
	public Saga(String nombre) {
		this(nombre,nombre);
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

	
}
