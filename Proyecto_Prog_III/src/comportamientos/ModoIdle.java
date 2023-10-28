package comportamientos;

import ventanas.CartaEntrenando;

public class ModoIdle extends Thread {
	
	CartaEntrenando cartaEnt1;
	CartaEntrenando cartaEnt2;
	CartaEntrenando cartaEnt3;
	int monedasGeneradas;
	//TODO cambiar monedas por minuto a monedas por segundo
	
	public ModoIdle(CartaEntrenando cartaEnt1, CartaEntrenando cartaEnt2, CartaEntrenando cartaEnt3 ) {
		this.cartaEnt1 = cartaEnt1;
		this.cartaEnt2 = cartaEnt2;
		this.cartaEnt3 = cartaEnt3;
	}
	
	@Override
	public void run() {
		int contadorSeg = 0;
		double minutosCarta1 = (cartaEnt1.getCarta().getResistencia()*5)/(double) 100;
		double minutosCarta2 = (cartaEnt2.getCarta().getResistencia()*5)/100;
		double minutosCarta3 = (cartaEnt3.getCarta().getResistencia()*5)/100;
		for(;;) {
//			if(contadorSeg == 60) {
//				monedasGeneradas += cartaEnt1.getCarta().getMonedasPorMinuto() + cartaEnt2.getCarta().getMonedasPorMinuto() + cartaEnt3.getCarta().getMonedasPorMinuto();
//				contadorSeg = 0;
////				contadorMin++;
//			}
			if(contadorSeg % minutosCarta1*60 == 0) {
				//TODO mirar 0.1
				cartaEnt1.setPorcentajeStamina(cartaEnt1.getPorcentajeStamina()-1);
			}
//			if(minutosCarta2 % contadorMin == 0 && minutosCarta2 % contadorMin < 0.0001) {
//				//TODO mirar 0.1
//				cartaEnt2.setPorcentajeStamina(cartaEnt2.getPorcentajeStamina()-1);
//			}
//			if(minutosCarta3 % contadorMin == 0 && minutosCarta3 % contadorMin < 0.0001) {
//				//TODO mirar 0.1
//				cartaEnt3.setPorcentajeStamina(cartaEnt3.getPorcentajeStamina()-1);
//			}
			System.out.println("Stamina - " + cartaEnt1.getCarta().getResistencia());
			System.out.println("MinutosCarta - " + minutosCarta1);
			System.out.println("ContadorMSeg - " + contadorSeg);
//			System.out.println("Tiempo - " + tiempo);
			System.out.println("Resto - " + minutosCarta1*60 % contadorSeg);
			System.out.println("Porcentaje stamina - " + cartaEnt1.getPorcentajeStamina());
			System.out.println();
			System.out.println();
//			System.out.println(cartaEnt2.getPorcentajeStamina());
//			System.out.println(cartaEnt3.getPorcentajeStamina());
			
			contadorSeg++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			
			}
		}
	}
	
	public static void main(String[] args) {
		Datos datos = new Ficheros();
		datos.getModeloCartas();
		Carta carta1 = new Carta("mario", new Saga("SuperMario"));
		Carta carta2 = new Carta("yoshi", new Saga("SuperMario"));
		Carta carta3 = new Carta("luigi", new Saga("SuperMario"));
		ModoIdle modoIdle = new ModoIdle(new CartaEntrenando(carta1), new CartaEntrenando(carta2), new CartaEntrenando(carta3));
		modoIdle.start();
	}
}
