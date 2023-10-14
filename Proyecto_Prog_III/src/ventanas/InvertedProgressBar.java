package ventanas;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;

public class InvertedProgressBar extends JProgressBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvertedProgressBar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvertedProgressBar(BoundedRangeModel newModel) {
		super(newModel);
		// TODO Auto-generated constructor stub
	}

	public InvertedProgressBar(int orient, int min, int max) {
		super(orient, min, max);
		// TODO Auto-generated constructor stub
	}

	public InvertedProgressBar(int min, int max) {
		super(min, max);
		// TODO Auto-generated constructor stub
	}

	public InvertedProgressBar(int orient) {
		super(orient);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void paintComponent(Graphics g) { // Fuente: https://stackoverflow.com/questions/3505795/right-to-left-backwards-jprogressbar - Respuesta de Tikhon Jelvis
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(-1, 1); //Flips over y-axis
		g2d.translate(-getWidth(), 0); //Moves back to old position.
		super.paintComponent(g2d);
	}

}
