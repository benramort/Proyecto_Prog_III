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
		double contadorSeg = 0;
		double minutosCarta1 = (cartaEnt1.getCarta().getResistencia()*5)/(double) 100;
		double minutosCarta2 = (cartaEnt2.getCarta().getResistencia()*5)/100;
		double minutosCarta3 = (cartaEnt3.getCarta().getResistencia()*5)/100;
		for(;;) {
			//TODO actualizar barras de stamina en la ventana entrenamiento
			if(contadorSeg != 0 && contadorSeg % (double)60 == (double)0) {
				monedasGeneradas += cartaEnt1.getCarta().getMonedasPorMinuto() + cartaEnt2.getCarta().getMonedasPorMinuto() + cartaEnt3.getCarta().getMonedasPorMinuto();
			}
			if(contadorSeg % (minutosCarta1*(double)60) == (double)0) {
				cartaEnt1.setPorcentajeStamina(cartaEnt1.getPorcentajeStamina()-1);
				cartaEnt1.getPbStamina().setValue((int) cartaEnt1.getPorcentajeStamina());
				cartaEnt1.getPbStamina().repaint();
			}
			if(contadorSeg % (minutosCarta2*(double)60) == (double)0) {
				cartaEnt2.setPorcentajeStamina(cartaEnt2.getPorcentajeStamina()-1);
				cartaEnt2.getPbStamina().setValue((int) cartaEnt2.getPorcentajeStamina());			
				cartaEnt2.getPbStamina().repaint();
			}
			if(contadorSeg % (minutosCarta3*(double)60) == (double)0) {
				cartaEnt3.setPorcentajeStamina(cartaEnt3.getPorcentajeStamina()-1);
				cartaEnt3.getPbStamina().setValue((int) cartaEnt3.getPorcentajeStamina());			
				cartaEnt3.getPbStamina().repaint();
			}
//			System.out.println("Stamina - " + cartaEnt1.getCarta().getResistencia());
//			System.out.println("MinutosCarta - " + minutosCarta1);
//			System.out.println("ContadorSeg - " + contadorSeg);
//			System.out.println("Tiempo - " + tiempo);
//			System.out.println("Resto - " + contadorSeg % minutosCarta1*60);
//			System.out.println("Porcentaje stamina - " + cartaEnt1.getPorcentajeStamina());
//			System.out.println();
//			System.out.println();
//			System.out.println(cartaEnt2.getPorcentajeStamina());
//			System.out.println(cartaEnt3.getPorcentajeStamina());
			
			contadorSeg++;
			try {
				Thread.sleep(100);
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
