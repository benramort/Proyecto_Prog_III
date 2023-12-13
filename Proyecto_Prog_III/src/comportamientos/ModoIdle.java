package comportamientos;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ventanas.CartaEntrenando;
import ventanas.Entrenamiento;

public class ModoIdle extends Thread {
	
	CartaEntrenando cartaEnt1;
	CartaEntrenando cartaEnt2;
	CartaEntrenando cartaEnt3;
	
	boolean generarMonedasCarta1 = true;
	boolean generarMonedasCarta2 = true;
	boolean generarMonedasCarta3 = true;
	
	double monedasPorMinutoCarta1;
	double monedasPorMinutoCarta2;
	double monedasPorMinutoCarta3;
	
	int monedasGeneradas;
	
	JFrame ventana;

	public ModoIdle(CartaEntrenando cartaEnt1, CartaEntrenando cartaEnt2, CartaEntrenando cartaEnt3, JFrame ventana) {
		this.cartaEnt1 = cartaEnt1;
		this.cartaEnt2 = cartaEnt2;
		this.cartaEnt3 = cartaEnt3;
		this.ventana = ventana;
		monedasPorMinutoCarta1 = cartaEnt1.getCarta().getMonedasPorMinuto();
		monedasPorMinutoCarta2 = cartaEnt2.getCarta().getMonedasPorMinuto();
		monedasPorMinutoCarta3 = cartaEnt3.getCarta().getMonedasPorMinuto();
	}
	@Override
	public void run() {
		
		((Entrenamiento) ventana).bClear.setEnabled(false);
		
		double contadorSeg = 0;
		double minutosCarta1 = (cartaEnt1.getCarta().getResistencia()*5)/(double)100; //1 de estamina son +-5 minutos
		double minutosCarta2 = (cartaEnt2.getCarta().getResistencia()*5)/(double)100;
		double minutosCarta3 = (cartaEnt3.getCarta().getResistencia()*5)/(double)100;
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				cartaEnt1.getPbStamina().setValue((int) cartaEnt1.getPorcentajeStamina());
				cartaEnt2.getPbStamina().setValue((int) cartaEnt2.getPorcentajeStamina());
				cartaEnt3.getPbStamina().setValue((int) cartaEnt3.getPorcentajeStamina());
				
				cartaEnt1.setPorcentajeStamina(cartaEnt1.getPorcentajeStamina());
				cartaEnt2.setPorcentajeStamina(cartaEnt2.getPorcentajeStamina());
				cartaEnt3.setPorcentajeStamina(cartaEnt3.getPorcentajeStamina());				
			}
		});

		
//		while(generarMonedasCarta1 == true || generarMonedasCarta2 == true || generarMonedasCarta3 == true && !isInterrupted()) {

		for(;;) {
			//TODO hacer que cuando el porcentaje de stamina de alguna de las 
			//cartas sea < 0, parar la generacion de monedas de esa carta y no guardar 
			//el porcentaje de stamina negativo
			if(contadorSeg != 0 && contadorSeg % (double)60 == (double)0) {
				if(generarMonedasCarta1 == true && generarMonedasCarta2 == true && generarMonedasCarta3 == true) {
					monedasGeneradas += monedasPorMinutoCarta1 + monedasPorMinutoCarta2 + monedasPorMinutoCarta3;						
				} else if(generarMonedasCarta1 == true && generarMonedasCarta2 == true && generarMonedasCarta3 == false) {
					monedasGeneradas += monedasPorMinutoCarta1 + monedasPorMinutoCarta2;
				} else if(generarMonedasCarta1 == true && generarMonedasCarta2 == false && generarMonedasCarta3 == true) {
					monedasGeneradas += monedasPorMinutoCarta1 + monedasPorMinutoCarta3;
				} else if(generarMonedasCarta1 == true && generarMonedasCarta2 == false && generarMonedasCarta3 == false) {
					monedasGeneradas += monedasPorMinutoCarta1;
				} else if(generarMonedasCarta1 == false && generarMonedasCarta2 == true && generarMonedasCarta3 == true) {
					monedasGeneradas += monedasPorMinutoCarta2 + monedasPorMinutoCarta3;
				} else if(generarMonedasCarta1 == false && generarMonedasCarta2 == true && generarMonedasCarta3 == false) {
					monedasGeneradas += monedasPorMinutoCarta2;
				} else if(generarMonedasCarta1 == false && generarMonedasCarta2 == false && generarMonedasCarta3 == true) {
					monedasGeneradas += monedasPorMinutoCarta3;
				} else {
					break;
					
				}
			}
			if(contadorSeg != 0 && contadorSeg % (minutosCarta1*(double)60) == (double)0) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() { //TODO seguro que este runable está bien??
						cartaEnt1.setPorcentajeStamina(cartaEnt1.getPorcentajeStamina()-1);
						if(cartaEnt1.getPorcentajeStamina() <= 0) {
							cartaEnt1.setPorcentajeStamina(0);
						}
						cartaEnt1.getPbStamina().setValue((int) cartaEnt1.getPorcentajeStamina());						
					}
				});
				if((double)cartaEnt1.getPorcentajeStamina() <= 0) {
					cartaEnt1.setPorcentajeStamina(0);
					generarMonedasCarta1 = false;
					monedasPorMinutoCarta1 = 0;
					cartaEnt1.setPorcentajeStamina(0);
				}
			}
			if(contadorSeg != 0 && contadorSeg % (minutosCarta2*(double)60) == (double)0) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						cartaEnt2.setPorcentajeStamina(cartaEnt2.getPorcentajeStamina()-1);
						if(cartaEnt2.getPorcentajeStamina() <= 0) {
							cartaEnt2.setPorcentajeStamina(0);
						}
						cartaEnt2.getPbStamina().setValue((int) cartaEnt2.getPorcentajeStamina());						
					}
				});
				if((double)cartaEnt2.getPorcentajeStamina() <= 0) {
					cartaEnt2.setPorcentajeStamina(0);
					generarMonedasCarta2 = false;
					monedasPorMinutoCarta2 = 0;
					cartaEnt2.setPorcentajeStamina(0);
				}
			}
			if(contadorSeg != 0 && contadorSeg % (minutosCarta3*(double)60) == (double)0) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						cartaEnt3.setPorcentajeStamina(cartaEnt3.getPorcentajeStamina()-1);
						if(cartaEnt3.getPorcentajeStamina() <= 0) {
							cartaEnt3.setPorcentajeStamina(0);
						}
						cartaEnt3.getPbStamina().setValue((int) cartaEnt3.getPorcentajeStamina());						
					}
				});
				if((double)cartaEnt3.getPorcentajeStamina() <= 0) {
					generarMonedasCarta3 = false;
					monedasPorMinutoCarta3 = 0;
				}
			}


			//
			
			System.out.println(cartaEnt1.getCarta() + " - " + cartaEnt1.getPorcentajeStamina());
			System.out.println(cartaEnt2.getCarta() + " - " + cartaEnt2.getPorcentajeStamina());
			System.out.println(cartaEnt3.getCarta() + " - " + cartaEnt3.getPorcentajeStamina());

			contadorSeg++;

			SwingUtilities.invokeLater(() -> {
				((Entrenamiento)ventana).cambiarLabelMonedasGeneradas();
				((Entrenamiento)ventana).cambiarLabelMonedasPorMinuto();
			});			

			if ((generarMonedasCarta1 || generarMonedasCarta2 || generarMonedasCarta3) == false) break;

			if(cartaEnt1.getPorcentajeStamina() == 0 && cartaEnt2.getPorcentajeStamina() == 0 && cartaEnt3.getPorcentajeStamina() == 0) {
				((Entrenamiento) ventana).bEntrenar.setEnabled(false);
				((Entrenamiento) ventana).lError.setVisible(true);
			}
			
			try {
				Thread.sleep(1000); //TODO sleep preciso
			} catch (InterruptedException e) {
				break;
			}
		}
		//		}
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
	
	public double getMonedasPorMinuto() {
		return monedasPorMinutoCarta1 + monedasPorMinutoCarta2 + monedasPorMinutoCarta3;
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