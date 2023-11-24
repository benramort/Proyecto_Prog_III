package ventanas;

import javax.swing.*;

import comportamientos.Carta;
import comportamientos.Datos;
import comportamientos.DatosFactory;
import comportamientos.Usuario;
import excepciones.DataException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCuenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color c = new Color(42,215,245);


	
	public CrearCuenta(JFrame ventanaAnterior){
		//Formato ventana
		setTitle("Crear cuenta de usuario");
		setSize(400, 350);
		setLocationRelativeTo(ventanaAnterior);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 450);
		setLocationRelativeTo(ventanaAnterior);
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
		pSuperior.setBackground(c);
		pCentral.setLayout(new BoxLayout(pCentral, BoxLayout.Y_AXIS));
		pCentral.add(Box.createVerticalGlue());
		pNombre.setMaximumSize(new Dimension(400, 800));
		pCorreo.setMaximumSize(new Dimension(400, 800));
		pContrasena.setMaximumSize(new Dimension(400, 800));
		pBoton.setLayout(new FlowLayout());
		
		//Crear componentes
		JLabel lPrincipal = new JLabel("Crear nueva cuenta de usuario");
		JLabel lNombre = new JLabel("Nombre de usuario:");
		JLabel lCorreo = new JLabel("Correo electrónico:");
		JLabel lContrasena = new JLabel("Contraseña:             ");
		JLabel lContrasena2 = new JLabel("Repetir contraseña:");
		JTextField tfNombre = new JTextField(15);
		JTextField tfCorreo = new JTextField(15);
		JPasswordField pfContrasena = new JPasswordField(15);
		JPasswordField pfContrasena2 = new JPasswordField(15);
		JButton bCrearCuenta = new JButton("Crear cuenta");
		JCheckBox cbMostrarContrasena = new JCheckBox("Mostrar contraseña");
		
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		//Formato componentes
		lPrincipal.setFont(new Font("Arial" ,Font.BOLD, 25));
		lPrincipal.setForeground(Color.WHITE);
		lNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lCorreo.setFont(new Font("Arial", Font.BOLD, 15));
		lContrasena.setFont(new Font("Arial", Font.BOLD, 15));
		lContrasena2.setFont(new Font("Arial", Font.BOLD, 15));

		
		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
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
		
		bCrearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						
						try {
							Datos datos;
							datos = DatosFactory.getDatos();
							Usuario usuario = new Usuario(tfNombre.getText(), String.valueOf( pfContrasena.getPassword()), datos, 0);
							usuario.getCartas().put(new Carta(1), 1);
							usuario.getCartas().put(new Carta(5), 2);
							usuario.getCartas().put(new Carta(6), 1);
							new Album(null, usuario, datos);
//							for (Carta c: usuario.getCartas().keySet()) {
//								System.out.println(c.toString() + usuario.getCartas().get(c));
//							}	
						} catch (DataException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
									

					}
				});
				dispose();
			}
		});
		char caracter = pfContrasena.getEchoChar();

		
		
		
		//https://www.youtube.com/shorts/pv5ubFk9JfY
		cbMostrarContrasena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbMostrarContrasena.isSelected()) {
					pfContrasena.setEchoChar((char)0);
					pfContrasena2.setEchoChar((char)0);
					pfContrasena.requestFocus();
					pfContrasena2.requestFocus();
				} else {
					pfContrasena.setEchoChar(caracter);
					pfContrasena2.setEchoChar(caracter);
				}
				
			}
		});
	}
	

	


	}
	

