package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class IniciarSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new IniciarSesion();//En la versión final hacerlo con invokelater
	}
	
	public IniciarSesion() {
		//Formato ventana
		setTitle("Iniciar sesión");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Por qué exit on close??
		
		//Crear contenedores
		JPanel pInferior = new JPanel();
		JPanel pInferiorBox = new JPanel();
		pInferiorBox.setLayout(new BoxLayout(pInferiorBox, BoxLayout.Y_AXIS));
		JPanel pUsuario = new JPanel();
		JPanel pContrasena = new JPanel();
		JPanel pBotonera = new JPanel();
		
		JPanel pTexto = new JPanel();
		pTexto.setLayout(new BoxLayout(pTexto, BoxLayout.Y_AXIS));
		JPanel pCampos = new JPanel();
		pCampos.setLayout(new BoxLayout(pCampos, BoxLayout.Y_AXIS));
		
		//Formato de contenedores
		
		
		//Crear componentes
		JLabel lUsuario = new JLabel("Usuario:");
		JTextField tfUsuario = new JTextField(15);
		JLabel lContrasena = new JLabel("Contraseña:");
		JPasswordField pfContrasena = new JPasswordField(15);
		
		//Formato componentes
		Font fuente = new Font("Arial", Font.BOLD, 15);
		lUsuario.setFont(fuente);
		lContrasena.setFont(fuente);
		
		//Añadir componentes a contenedores
		add(pInferior, BorderLayout.SOUTH);
//		pInferior.add(pInferiorBox);
//		pInferiorBox.add(pUsuario);
//		pInferiorBox.add(pContrasena);
//		pUsuario.add(lUsuario);
//		pUsuario.add(tfUsuario);
//		pContrasena.add(lContrasena);
//		pContrasena.add(pfContrasena);
		
		pInferior.add(pTexto);
		pTexto.add(lUsuario);
		pTexto.add(Box.createVerticalStrut(5));
		pTexto.add(lContrasena);
		pInferior.add(pCampos);
		pCampos.add(tfUsuario);
		pCampos.add(Box.createVerticalStrut(5));
		pCampos.add(pfContrasena);
		
		setVisible(true);
		
		
	}
	
	

}
