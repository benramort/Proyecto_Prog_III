package ventanas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelPorcentaje extends JPanel{  //TODO caso en el qe sea 100%

/**
*
*/
private static final long serialVersionUID = 1L;

private int grados = 0;
private BufferedImage buffer;
private Graphics2D graficos;
private int anchura;
private int altura;
private Color color = Color.BLACK;
private Color color2 = new Color(255, 200, 10);
private int porcentaje;

public PanelPorcentaje(double porcentaje, int anchura, int altura) {
if (porcentaje > 100) {
this.porcentaje = (int) Math.round(porcentaje);
} else {
this.porcentaje = (int) Math.round(porcentaje);
}
calcularGrados(porcentaje);
buffer = new BufferedImage(anchura, altura, BufferedImage.TYPE_4BYTE_ABGR);
graficos = buffer.createGraphics();
this.altura = altura;
this.anchura = anchura;
}

public PanelPorcentaje(double porcentaje, int anchura, int altura, Color color) {
this(porcentaje, anchura, altura);
this.color = color;
}

public PanelPorcentaje(double porcentaje, int anchura, int altura, Color color1, Color color2) {
this(porcentaje, anchura, altura, color1);
this.color2 = color2;
}

public void setPorcentaje(int porcentaje) {
if (porcentaje > 100) {
this.porcentaje = (int) Math.round(porcentaje);
} else {
this.porcentaje = (int) Math.round(porcentaje);
}
calcularGrados(porcentaje);
}

private void calcularGrados(double porcentaje) {
// System.out.println("Porcentaje:" +  porcentaje);
grados = (int) (porcentaje * 360 / 100);
}

@Override
public void paint(Graphics g) {
super.paint(g);
dibujar();
((Graphics2D) g).drawImage(buffer, null, 0, 0);
// System.out.println("Pintado");
}

public void dibujar() {
if (porcentaje >= 100) {
graficos.setStroke(new BasicStroke(3));
graficos.setColor(color2);

int anchuraArco = 200;
graficos.fillArc(anchura/2-anchuraArco/2, altura/2-anchuraArco/2, anchuraArco, anchuraArco, 90, -grados);
graficos.setColor(getBackground());
anchuraArco = (int) (anchuraArco *0.65);
graficos.fillArc(anchura/2-anchuraArco/2, altura/2-anchuraArco/2, anchuraArco, anchuraArco, 0, 360);
graficos.setColor(color2);
graficos.setFont(new Font("Arial", Font.BOLD, 50));
String str = porcentaje + "%";
graficos.drawString(str, anchura/2-62, altura/2+17);

return;
}

graficos.setStroke(new BasicStroke(3));
graficos.setColor(color);
//graficos.drawRect(0, 0, anchura, altura);
// System.out.println("Porcentaje:"+porcentaje);

int anchuraArco = 200;
graficos.fillArc(anchura/2-anchuraArco/2, altura/2-anchuraArco/2, anchuraArco, anchuraArco, 90, -grados);
graficos.setColor(getBackground());
anchuraArco = (int) (anchuraArco *0.65);
graficos.fillArc(anchura/2-anchuraArco/2, altura/2-anchuraArco/2, anchuraArco, anchuraArco, 0, 360);
graficos.setColor(color);
graficos.setFont(new Font("Arial", Font.BOLD, 50));
String str = porcentaje + "%";
if (str.length() == 2) {
graficos.drawString(str, anchura/2-35, altura/2+17);
} else {
graficos.drawString(str, anchura/2-45, altura/2+17);
}


// graficos.setColor(Color.RED);
// graficos.drawOval(anchura/2-10, anchura/2-10, 20, 20);

}





}
