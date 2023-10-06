package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class CrearCuenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrearCuenta(){
		//Formato ventana
		setTitle("Crear cuenta de usuario");
		setSize(400, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pSuperior = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pNombre = new JPanel();
		JPanel pCorreo = new JPanel();
		JPanel pContrasena = new JPanel();
		JPanel pContrasena2 = new JPanel();
		JPanel pBoton = new JPanel();

		//Formato contenedores
		pSuperior.setBackground(Color.DARK_GRAY);
		pCentral.setLayout(new BoxLayout(pCentral, BoxLayout.Y_AXIS));
		pNombre.setLayout(new FlowLayout());
		pCorreo.setLayout(new FlowLayout());
		pContrasena.setLayout(new FlowLayout());
		pContrasena2.setLayout(new FlowLayout());
		pNombre.setMaximumSize(new Dimension(400, 800));
		pCorreo.setMaximumSize(new Dimension(400, 800));
		pContrasena.setMaximumSize(new Dimension(400, 800));
		pBoton.setLayout(new FlowLayout());
		
		//Crear componentes
		JLabel lPrincipal = new JLabel("Crear nueva cuenta de usuario");
		JLabel lNombre = new JLabel("Nombre de usuario:");
		JLabel lCorreo = new JLabel("Correo electrónico:");
		JLabel lContrasena = new JLabel("Contraseña:");
		JLabel lContrasena2 = new JLabel("Repetir contraseña:");
		JTextField tfNombre = new JTextField(15);
		JTextField tfCorreo = new JTextField(15);
		JPasswordField pfContrasena = new JPasswordField(15);
		JPasswordField pfContrasena2 = new JPasswordField(15);
		JButton bCrearCuenta = new JButton("Crear cuenta");
		JCheckBox cbMostrarContrasena = new JCheckBox("Mostrar contraseña");
		
		//Formato componentes
		lPrincipal.setFont(new Font("Arial" ,Font.BOLD, 25));
		lPrincipal.setForeground(Color.WHITE);
		lNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lCorreo.setFont(new Font("Arial", Font.BOLD, 15));
		lContrasena.setFont(new Font("Arial", Font.BOLD, 15));
		lContrasena2.setFont(new Font("Arial", Font.BOLD, 15));

		
		//Añadir componentes a contenedores
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		getContentPane().add(pCentral, BorderLayout.CENTER);
		getContentPane().add(pBoton, BorderLayout.SOUTH);
		pSuperior.add(lPrincipal);
		pCentral.add(pNombre);
		pCentral.add(pCorreo);
		pCentral.add(pContrasena);
		pCentral.add(pContrasena2);
		pNombre.add(lNombre);
		pNombre.add(tfNombre);
		pCorreo.add(lCorreo);
		pCorreo.add(tfCorreo);
		pContrasena.add(lContrasena);
		pContrasena.add(pfContrasena);
		pContrasena2.add(lContrasena2);
		pContrasena2.add(pfContrasena2);
		pBoton.add(bCrearCuenta);
		pContrasena2.add(cbMostrarContrasena);

		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CrearCuenta();				
			}
		});

	}
	
}
