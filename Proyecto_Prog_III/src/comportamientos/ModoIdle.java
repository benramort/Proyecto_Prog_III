package comportamientos;

import ventanas.CartaEntrenando;

public class ModoIdle extends Thread {
	
	CartaEntrenando carta1 = new CartaEntrenando();
	CartaEntrenando carta2 = new CartaEntrenando();
	CartaEntrenando carta3 = new CartaEntrenando();
	int monedasGeneradas;
	
	@Override
	public void run() {
		int contador = 0;
		for(;;) {
			contador++;
			if(contador == 60) {
				monedasGeneradas += carta1.getCarta().getMonedasPorMinuto() + carta2.getCarta().getMonedasPorMinuto() + carta3.getCarta().getMonedasPorMinuto();
				contador = 0;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
			}
			
		}
	}
}
