package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class IniciarSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color c = new Color(42,215,245);
	
	public static void main(String[] args) {
		searchLookAndFeel();
		new IniciarSesion();//En la versión final hacerlo con invokelater
	}
	
	private static void searchLookAndFeel() {
//		LookAndFeelInfo[] lfs = UIManager.getInstalledLookAndFeels();
//		for (LookAndFeelInfo lf : lfs) {
//			System.out.println(lf.getName());
//		}
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Windows".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            return;
		        }
		    }
		} catch (Exception e) {} // Si no está disponible nimbus, no se hace nada
	}

	public IniciarSesion() {
		//Formato ventana
		setTitle("Iniciar sesión");
		setSize(1000, 700);
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
		pInferior.setBackground(c);
		pUsuarioContrasena.setOpaque(false);
		pBotonera.setOpaque(false);
		pTexto.setOpaque(false);
		pCampos.setOpaque(false);
		pInferiorBox.setOpaque(false);
		
		//Crear componentes
		JLabel lUsuario = new JLabel("Usuario:");
		JTextField tfUsuario = new JTextField(15);
		JLabel lContrasena = new JLabel("Contraseña:");
		JPasswordField pfContrasena = new JPasswordField(15);
		JButton btIniciarSesion = new JButton("Iniciar sesión");
		JButton btNuevaCuenta = new JButton("Crear cuenta");
		JLabel lLogo = new JLabel(new ImageIcon("img/logo.png"));
		
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
		add(lLogo, BorderLayout.CENTER);
		
		
		
		//Configurar escuchadores
		btNuevaCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new CrearCuenta(IniciarSesion.this);
					}
				});
//				dispose();
			}
		});
		
		
		
		
		
		
		setVisible(true);
		
		
		
		
	}
	
	

}
