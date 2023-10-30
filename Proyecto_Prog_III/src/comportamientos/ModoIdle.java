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
		double minutosCarta1 = (cartaEnt1.getCarta().getResistencia()*5)/(double)100;
		double minutosCarta2 = (cartaEnt2.getCarta().getResistencia()*5)/(double)100;
		double minutosCarta3 = (cartaEnt3.getCarta().getResistencia()*5)/(double)100;
		cartaEnt1.getPbStamina().setValue((int) cartaEnt1.getPorcentajeStamina());
		cartaEnt2.getPbStamina().setValue((int) cartaEnt2.getPorcentajeStamina());
		cartaEnt3.getPbStamina().setValue((int) cartaEnt3.getPorcentajeStamina());
		for(;;) {
			//TODO hacer que las barras de stamina se pinten al pulsar el boton entrenar
			//TODO hacer que cuando el porcentaje de stamina de alguna de las 
			//cartas sea < 0, parar la generacion de monedas de esa carta y no guardar 
			//el porcentaje de stamina negativo
			if(contadorSeg != 0 && contadorSeg % (double)60 == (double)0) {
				monedasGeneradas += cartaEnt1.getCarta().getMonedasPorMinuto() + cartaEnt2.getCarta().getMonedasPorMinuto() + cartaEnt3.getCarta().getMonedasPorMinuto();
			}
			if(contadorSeg != 0 && contadorSeg % (minutosCarta1*(double)60) == (double)0) {
				cartaEnt1.setPorcentajeStamina(cartaEnt1.getPorcentajeStamina()-1);
				cartaEnt1.getPbStamina().setValue((int) cartaEnt1.getPorcentajeStamina());
			}
			if(contadorSeg != 0 && contadorSeg % (minutosCarta2*(double)60) == (double)0) {
				cartaEnt2.setPorcentajeStamina(cartaEnt2.getPorcentajeStamina()-1);
				cartaEnt2.getPbStamina().setValue((int) cartaEnt2.getPorcentajeStamina());			
			}
			if(contadorSeg != 0 && contadorSeg % (minutosCarta3*(double)60) == (double)0) {
				cartaEnt3.setPorcentajeStamina(cartaEnt3.getPorcentajeStamina()-1);
				cartaEnt3.getPbStamina().setValue((int) cartaEnt3.getPorcentajeStamina());			
			}
//			System.out.println("Stamina - " + cartaEnt1.getCarta().getResistencia());
//			System.out.println("MinutosCarta - " + minutosCarta3);
//			System.out.println("ContadorSeg - " + contadorSeg);
//			System.out.println("Resto - " + contadorSeg % (minutosCarta1*60));
//			System.out.println("Porcentaje stamina - " + cartaEnt1.getPorcentajeStamina());
//			System.out.println(cartaEnt2.getPorcentajeStamina());
//			System.out.println(cartaEnt3.getPorcentajeStamina());
			
			contadorSeg++;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}

//	public static void main(String[] args) {
//		Datos datos = new Ficheros();
//		datos.getModeloCartas();
//		Carta carta1 = new Carta("mario", new Saga("SuperMario"));
//		Carta carta2 = new Carta("mario", new Saga("SuperMario"));
//		Carta carta3 = new Carta("mario", new Saga("SuperMario"));
//		ModoIdle modoIdle = new ModoIdle(new CartaEntrenando(carta1), new CartaEntrenando(carta2), new CartaEntrenando(carta3));
//		modoIdle.start();
//	}
}