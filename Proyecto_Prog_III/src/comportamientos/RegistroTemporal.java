package comportamientos;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RegistroTemporal {
	
	Carta[] cartas;
	int[] stamina;
	double bonificacion;
	ZonedDateTime fechaHora;
	
	public RegistroTemporal(Carta carta1, Carta carta2, Carta carta3, double bonificacion, ZonedDateTime fechaHora) {
		cartas = new Carta[] {carta1, carta2, carta2};
		this.bonificacion = bonificacion;
		this.fechaHora = fechaHora;
	}
	
	public RegistroTemporal(int carta1, int stamina1, int carta2, int stamina2, int carta3, int stamina3, double bonificacion, ZonedDateTime fechaHora) {
		recuperarCartas(carta1, carta2, carta3);
		stamina = new int[] {stamina1, stamina2, stamina3};
		this.bonificacion = bonificacion;
		this.fechaHora = fechaHora;
	}
	
	private void recuperarCartas(int cod1, int cod2, int cod3) {
		cartas = new Carta[3];
		for (Carta c: MiBaseDeDatos.modeloCartas) {
			if (c.getId() == cod1) {
				cartas[0] = c;
			} else if (c.getId() == cod2) {
				cartas[1] = c;
			}else if (c.getId() == cod3) {
				cartas[2] = c;
			}
		}
		System.out.println(cartas[0]);
		System.out.println(cartas[1]);
		System.out.println(cartas[2]);
	}
	
	public long calculoTiempoMinutos(ZonedDateTime fechaMenor, ZonedDateTime fechaMayor) {
		return fechaMenor.until(fechaMayor, ChronoUnit.MINUTES); //De momento en minutos. Segundos: Más precisión
	}
	
	public static void main(String[] args) {
		RegistroTemporal r1 = new RegistroTemporal(null, null, null, 0, null);
		MiBaseDeDatos.cargarModeloCartas();
		r1.recuperarCartas(2,1,4);
	}

}
