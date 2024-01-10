package comportamientos;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

import excepciones.DataException;

public class DatosFactory {
	
	public static Datos getDatos() throws DataException {
		Path path = Path.of("data/datos.properties");
		try (FileInputStream is = new FileInputStream(path.toAbsolutePath().toString())){
			Properties properties = new Properties();
			properties.load(is);
			String fuente = properties.getProperty("FuenteDatos");
			
			if (fuente.equals("Ficheros")) {
				return new Ficheros();
			}
			if (fuente.equals("BaseDeDatos")) {
				return new BasesDeDatos("datos.db");
			}
			throw new DataException();
			
			//Excepción de que no hay datos
			
		} catch (IOException ex) {
//			ex.printStackTrace(); //TODO logger
			// Misma excepcion
			throw new DataException();
		}

	}
	
	public static void main(String[] args) {
		Datos datos;
		try {
			datos = getDatos();
			System.out.println(datos.getClass().getSimpleName());
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
