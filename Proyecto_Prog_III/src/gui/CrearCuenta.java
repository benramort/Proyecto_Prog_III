package gui;

import javax.swing.*;

import domain.Carta;
import domain.Usuario;
import exceptions.DataException;
import interfaces.Datos;
import io.DatosFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		JPanel pIncorrecto = new JPanel();
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
		JLabel lIncorrecto = new JLabel();
		Path path = Paths.get("");
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		//Formato componentes
		lPrincipal.setFont(new Font("Arial" ,Font.BOLD, 25));
		lPrincipal.setForeground(Color.WHITE);
		lNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lCorreo.setFont(new Font("Arial", Font.BOLD, 15));
		lContrasena.setFont(new Font("Arial", Font.BOLD, 15));
		lContrasena2.setFont(new Font("Arial", Font.BOLD, 15));
		lIncorrecto.setForeground(Color.RED);
		lIncorrecto.setOpaque(true);
		lIncorrecto.setVisible(false);

		
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
		pCentral.add(pIncorrecto);
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
		pIncorrecto.add(lIncorrecto);

		
		setVisible(true);
		
		bCrearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@SuppressWarnings("unused")
					@Override
					public void run() {
						String contrasena = String.valueOf(pfContrasena.getPassword());
						String confirmarContrasena = String.valueOf(pfContrasena2.getPassword());
						Pattern patronNum = Pattern.compile("[0-9]");
						Pattern patronMayus = Pattern.compile("[A-Z]");
						Matcher matcherNum = patronNum.matcher(contrasena);
						Matcher matcherMayus = patronMayus.matcher(contrasena);
						if(!contrasena.isEmpty() && !confirmarContrasena.isEmpty() && contrasena.equals(confirmarContrasena)) {
							try {
								Datos datos;
								datos = DatosFactory.getDatos();
								if(datos.cargarUsuario(tfNombre.getText()) == null) {
									if(contrasena.length() >= 6 && contrasena.length() <= 16) {
											if(matcherNum.find() && matcherMayus.find()) {
												Usuario usuario = new Usuario(tfNombre.getText(), String.valueOf( pfContrasena.getPassword()), datos, 100000);
												for(int i = 1; i <= 13; i++) {
													usuario.getCartas().put(new Carta(1), 0);											
												}
												new Album(null, usuario, datos);
//										for (Carta c: usuario.getCartas().keySet()) {
//											System.out.println(c.toString() + usuario.getCartas().get(c));
//										}	
												
												dispose();	
											} else {
												lIncorrecto.setText("La contraseña debe tener al menos 1 dígito y 1 letra mayúscula");
												lIncorrecto.setVisible(true);
											}
											
									} else {
										lIncorrecto.setText("La contraseña debe tener entre 6 y 16 caracteres");
										lIncorrecto.setVisible(true);
									}
								} else {
									lIncorrecto.setText("Ese nombre de usario ya existe");
									lIncorrecto.setVisible(true);
								}
								
							} catch (DataException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							lIncorrecto.setText("Las dos contraseñas deben de ser iguales");
							lIncorrecto.setVisible(true);
						}
					}
				});
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
	

