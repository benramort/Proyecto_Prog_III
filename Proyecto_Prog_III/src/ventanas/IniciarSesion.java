package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//		getContentPane().setBackground(Color.WHITE);
		
		//Crear contenedores
		JPanel pInferior = new JPanel();
		JPanel pInferiorBox = new JPanel();
		JPanel pUsuarioContrasena = new JPanel();
		pInferiorBox.setLayout(new BoxLayout(pInferiorBox, BoxLayout.Y_AXIS));
		JPanel pBotonera = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JPanel pTexto = new JPanel();
		pTexto.setLayout(new BoxLayout(pTexto, BoxLayout.Y_AXIS));
		JPanel pCampos = new JPanel();
		pCampos.setLayout(new BoxLayout(pCampos, BoxLayout.Y_AXIS));
		
		//Formato de contenedores
//		pInferior.setOpaque(false);
		
		//Crear componentes
		JLabel lUsuario = new JLabel("Usuario:");
		JTextField tfUsuario = new JTextField(15);
		JLabel lContrasena = new JLabel("Contraseña:");
		JPasswordField pfContrasena = new JPasswordField(15);
		JButton btIniciarSesion = new JButton("Iniciar sesión");
		JButton btNuevaCuenta = new JButton("Crear cuenta");
		
		//Formato componentes
		Font fuente = new Font("Arial", Font.BOLD, 15);
		lUsuario.setFont(fuente);
		lContrasena.setFont(fuente);
		
		
		//Añadir componentes a contenedores
		add(pInferior, BorderLayout.SOUTH);
		pInferior.add(pInferiorBox);
		pInferiorBox.add(pUsuarioContrasena);
		pInferiorBox.add(pBotonera);
		
//		pInferiorBox.add(pUsuario);
//		pInferiorBox.add(pContrasena);
//		pUsuario.add(lUsuario);
//		pUsuario.add(tfUsuario);
//		pContrasena.add(lContrasena);
//		pContrasena.add(pfContrasena);
		
		pUsuarioContrasena.add(pTexto);
		pTexto.add(lUsuario);
		pTexto.add(Box.createVerticalStrut(5)); //Añade distancia vertical
		pTexto.add(lContrasena);
		pUsuarioContrasena.add(pCampos);
		pCampos.add(tfUsuario);
		pCampos.add(Box.createVerticalStrut(5));
		pCampos.add(pfContrasena);
		pBotonera.add(btIniciarSesion);
		pBotonera.add(btNuevaCuenta);
		
		
		//Configurar escuchadores
		btNuevaCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new CrearCuenta();
					}
				});
				dispose();
			}
		});
		
		
		
		
		
		
		setVisible(true);
		
		
		
		
	}
	
	

}
