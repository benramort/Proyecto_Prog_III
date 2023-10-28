package comportamientos;

import ventanas.CartaEntrenando;

public class ModoIdle extends Thread {
	
	CartaEntrenando carta1 = new CartaEntrenando();
	CartaEntrenando carta2 = new CartaEntrenando();
	CartaEntrenando carta3 = new CartaEntrenando();
	int monedasGeneradas;
	//TODO cambiar monedas por minuto a monedas por segundo
	
	@Override
	public void run() {
		int contadorSeg = 0;
		int contadorMin = 0;
		double minutosCarta1 = (carta1.getCarta().getResistencia()*5)/100;
		for(;;) {
			if(contadorSeg == 60) {
				monedasGeneradas += carta1.getCarta().getMonedasPorMinuto() + carta2.getCarta().getMonedasPorMinuto() + carta3.getCarta().getMonedasPorMinuto();
				contadorSeg = 0;
				contadorMin++;
			}
			if(contadorMin % minutosCarta1 >= 0 && contadorMin % minutosCarta1 < 0.0001) {
				//TODO mirar 0.1
				carta1.setPorcentajeStamina(carta1.getPorcentajeStamina()-1);
			}
			
			contadorSeg++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
			}
		}
	}
}
