package comportamientos;

import ventanas.CartaEntrenando;

public class ModoIdle extends Thread {
	
	CartaEntrenando cartaEnt1;
	CartaEntrenando cartaEnt2;
	CartaEntrenando cartaEnt3;
	
	boolean generarMonedasCarta1 = true;
	boolean generarMonedasCarta2 = true;
	boolean generarMonedasCarta3 = true;
	
	int monedasGeneradas;

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
		
		cartaEnt1.setPorcentajeStamina(100);
		cartaEnt2.setPorcentajeStamina(100);
		cartaEnt3.setPorcentajeStamina(100);
		
		while(generarMonedasCarta1 == true || generarMonedasCarta2 == true || generarMonedasCarta3 == true && !isInterrupted()){
			for(;;) {
				//TODO hacer que cuando el porcentaje de stamina de alguna de las 
				//cartas sea < 0, parar la generacion de monedas de esa carta y no guardar 
				//el porcentaje de stamina negativo
				if(contadorSeg != 0 && contadorSeg % (double)60 == (double)0) {
					if(generarMonedasCarta1 == true && generarMonedasCarta2 == true && generarMonedasCarta3 == true) {
						monedasGeneradas += cartaEnt1.getCarta().getMonedasPorMinuto() + cartaEnt2.getCarta().getMonedasPorMinuto() + cartaEnt3.getCarta().getMonedasPorMinuto();						
					} else if(generarMonedasCarta1 == true && generarMonedasCarta2 == true && generarMonedasCarta3 == false) {
						monedasGeneradas += cartaEnt1.getCarta().getMonedasPorMinuto() + cartaEnt2.getCarta().getMonedasPorMinuto();
					} else if(generarMonedasCarta1 == true && generarMonedasCarta2 == false && generarMonedasCarta3 == true) {
						monedasGeneradas += cartaEnt1.getCarta().getMonedasPorMinuto() + cartaEnt3.getCarta().getMonedasPorMinuto();
					} else if(generarMonedasCarta1 == true && generarMonedasCarta2 == false && generarMonedasCarta3 == false) {
						monedasGeneradas += cartaEnt1.getCarta().getMonedasPorMinuto();
					} else if(generarMonedasCarta1 == false && generarMonedasCarta2 == true && generarMonedasCarta3 == true) {
						monedasGeneradas += cartaEnt2.getCarta().getMonedasPorMinuto() + cartaEnt3.getCarta().getMonedasPorMinuto();
					} else if(generarMonedasCarta1 == false && generarMonedasCarta2 == true && generarMonedasCarta3 == false) {
						monedasGeneradas += cartaEnt2.getCarta().getMonedasPorMinuto();
					} else if(generarMonedasCarta1 == false && generarMonedasCarta2 == false && generarMonedasCarta3 == true) {
						monedasGeneradas += cartaEnt3.getCarta().getMonedasPorMinuto();
					} else {
						break;
					}
				}
				if(contadorSeg != 0 && contadorSeg % (minutosCarta1*(double)60) == (double)0) {
					cartaEnt1.setPorcentajeStamina(cartaEnt1.getPorcentajeStamina()-1);
					cartaEnt1.getPbStamina().setValue((int) cartaEnt1.getPorcentajeStamina());
					if((double)cartaEnt1.getPorcentajeStamina() == 0) {
						generarMonedasCarta1 = false;
					}
				}
				if(contadorSeg != 0 && contadorSeg % (minutosCarta2*(double)60) == (double)0) {
					cartaEnt2.setPorcentajeStamina(cartaEnt2.getPorcentajeStamina()-1);
					cartaEnt2.getPbStamina().setValue((int) cartaEnt2.getPorcentajeStamina());
					if((double)cartaEnt2.getPorcentajeStamina() == 0) {
						generarMonedasCarta2 = false;
					}
				}
				if(contadorSeg != 0 && contadorSeg % (minutosCarta3*(double)60) == (double)0) {
					cartaEnt3.setPorcentajeStamina(cartaEnt3.getPorcentajeStamina()-1);
					cartaEnt3.getPbStamina().setValue((int) cartaEnt3.getPorcentajeStamina());
					if((double)cartaEnt3.getPorcentajeStamina() == 0) {
						generarMonedasCarta3 = false;
					}
				}
//
//			System.out.println("Stamina - " + cartaEnt1.getCarta().getResistencia());
//			System.out.println("MinutosCarta - " + minutosCarta3);
//			System.out.println("ContadorSeg - " + contadorSeg);
//			System.out.println("Resto - " + contadorSeg % (minutosCarta1*60));
//			System.out.println("Porcentaje stamina - " + cartaEnt1.getPorcentajeStamina());
//			System.out.println(cartaEnt2.getPorcentajeStamina());
//			System.out.println(cartaEnt3.getPorcentajeStamina());
//			System.out.println(generarMonedasCarta1);
//			System.out.println(generarMonedasCarta2);
//			System.out.println(generarMonedasCarta3);

				contadorSeg++;
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
	public void setGenerarMonedasCarta1(boolean generarMonedasCarta1) {
		this.generarMonedasCarta1 = generarMonedasCarta1;
	}
	public void setGenerarMonedasCarta2(boolean generarMonedasCarta2) {
		this.generarMonedasCarta2 = generarMonedasCarta2;
	}
	public void setGenerarMonedasCarta3(boolean generarMonedasCarta3) {
		this.generarMonedasCarta3 = generarMonedasCarta3;
	}
	public int getMonedasGeneradas() {
		return monedasGeneradas;
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