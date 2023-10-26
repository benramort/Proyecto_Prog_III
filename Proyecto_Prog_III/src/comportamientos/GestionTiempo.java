package comportamientos;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class GestionTiempo {
	
	public static long pruebaCalculoTiempo() {
		ZonedDateTime fecha1 = ZonedDateTime.of(2004, 11, 2, 6, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
		System.out.println(fecha1.getZone());
		ZonedDateTime fecha2 = ZonedDateTime.of(2004, 11, 2, 6, 30, 0, 0, ZoneId.of("Europe/Madrid"));
//		ZonedDateTime fecha2 = ZonedDateTime.
//		fecha2 = fecha2.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
		
		return fecha1.until(fecha2, ChronoUnit.HOURS);
	}
	
	public static long calculoTiempoMinutos(ZonedDateTime fechaMenor, ZonedDateTime fechaMayor) {
		return fechaMenor.until(fechaMayor, ChronoUnit.MINUTES); //De momento en minutos. Segundos: Más precisión
	}
	
	public static void main(String[] args) {
		System.out.println(pruebaCalculoTiempo());
	}

}
