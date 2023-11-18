package excepciones;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

import org.junit.Test;

import comportamientos.DatosFactory;
import excepciones.DataException; 

public class DatosFactoryTest {
	
	@Test
	public void testGetDatos() {
		Path path = Path.of("data/datos.properties");
		try (FileInputStream is = new FileInputStream(path.toAbsolutePath().toString())){
			Properties properties = new Properties();
			properties.load(is);
			String fuente = properties.getProperty("FuenteDatos");
			
			try {
				assertEquals(fuente, DatosFactory.getDatos().getClass().getSimpleName());
			} catch (DataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Excepción de que no hay datos
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	//Poner bonito luego
}
