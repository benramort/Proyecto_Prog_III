package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

import domain.Usuario;
import exceptions.DataException;
import interfaces.Datos;
import io.DatosFactory;

public class IniciarSesion extends JFrame {

/**
*
*/
private static final long serialVersionUID = 1L;
Datos datos;


	private static final Color c = new Color(42,215,245);

	public static void main(String[] args) {
		// searchLookAndFeel();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new IniciarSesion();

				//IniciarSesion.metodoParaNadaSospechoso();

//				IniciarSesion.metodoParaNadaSospechoso();

			}
		});

	}

// private static void searchLookAndFeel() {
// LookAndFeelInfo[] lfs = UIManager.getInstalledLookAndFeels();
// for (LookAndFeelInfo lf : lfs) {
// System.out.println(lf.getName());
// }
// try {
//    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//        if ("Nimbus".equals(info.getName())) {
//            UIManager.setLookAndFeel(info.getClassName());
//            return;
//        }
//    }
// } catch (Exception e) {} // Si no está disponible nimbus, no se hace nada
// }

	public IniciarSesion() {
		try {
			datos = DatosFactory.getDatos();
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Formato ventana
		setTitle("Iniciar sesión");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Por qué exit on close??
// getContentPane().setBackground(Color.WHITE);

		//Crear contenedores
		JPanel pInferior = new JPanel();
		JPanel pInferiorBox = new JPanel();
		JPanel pUsuarioContrasena = new JPanel();
		pInferiorBox.setLayout(new BoxLayout(pInferiorBox, BoxLayout.Y_AXIS));
		JPanel pBotonera = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		JPanel pCheckBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel pTexto = new JPanel();
		pTexto.setLayout(new BoxLayout(pTexto, BoxLayout.Y_AXIS));
		JPanel pCampos = new JPanel();
		pCampos.setLayout(new BoxLayout(pCampos, BoxLayout.Y_AXIS));
		JPanel pIncorrecto =  new JPanel();

		//Formato de contenedores
		// pInferior.setOpaque(false);
		pInferior.setBackground(c);
		pUsuarioContrasena.setOpaque(false);
		pBotonera.setOpaque(false);
		pTexto.setOpaque(false);
		pCampos.setOpaque(false);
		pInferiorBox.setOpaque(false);
		pCheckBox.setBackground(c);
		pIncorrecto.setOpaque(false);
		pIncorrecto.setVisible(false);
		//Crear componentes
		JLabel lUsuario = new JLabel("Usuario:");
		JTextField tfUsuario = new JTextField(15);
		JLabel lContrasena = new JLabel("Contraseña:");
		JPasswordField pfContrasena = new JPasswordField(15);
		JButton btIniciarSesion = new JButton("Iniciar sesión");
		JButton btNuevaCuenta = new JButton("Crear cuenta");
		Path path = Paths.get("resources/img/logo.png");
		System.out.println(path.isAbsolute());
//		Path absolutePath = path.toAbsolutePath();
		System.out.println(path.toAbsolutePath().toFile());
		JLabel lLogo = new JLabel(new ImageIcon(path.toAbsolutePath().toString()));
		JCheckBox cbMostrarContrasena = new JCheckBox("Mostrar contraseña");
		JLabel lIncorrecto = new JLabel("Usuario o contraseña incorrectos");
		Path path1 = Path.of("resources/img/logo chiquito.png");
		ImageIcon logoPequeño = new ImageIcon(path1.toAbsolutePath().toString());
		//Formato componentes
		Font fuente = new Font("Arial", Font.BOLD, 15);
		lUsuario.setFont(fuente);
		lContrasena.setFont(fuente);
		cbMostrarContrasena.setBackground(c);
		lIncorrecto.setForeground(Color.RED);


		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		add(pInferior, BorderLayout.SOUTH);
		pInferior.add(pInferiorBox);
		pInferiorBox.add(pUsuarioContrasena);
		pInferiorBox.add(pCheckBox);
		pInferiorBox.add(pIncorrecto);
		pInferiorBox.add(pBotonera);
		

// pInferiorBox.add(pUsuario);
// pInferiorBox.add(pContrasena);
// pUsuario.add(lUsuario);
// pUsuario.add(tfUsuario);
// pContrasena.add(lContrasena);
// pContrasena.add(pfContrasena);

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
		pCheckBox.add(cbMostrarContrasena);
		pIncorrecto.add(lIncorrecto);
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
				dispose();
			}
		});

		btIniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
							String contrasena = String.valueOf(pfContrasena.getPassword());
							
							if (contrasena.isEmpty() || tfUsuario.getText().isEmpty()) {
								lIncorrecto.setText("Rellene los campos de inicio de sesión");
								pIncorrecto.setVisible(true);
								return;
							}
//							Comprobar si existe usuario para lanzar la ventana
							Usuario usuario = validarUsuario(tfUsuario.getText(),contrasena, datos);
							if(usuario != null) {
//								System.out.println(usuario);
//								System.out.println(usuario.getMonedas());
//								usuario.setMonedas(usuario.getMonedas()+10);
								new Album(IniciarSesion.this, usuario, datos);
								dispose();
							} else {
								lIncorrecto.setText("Usuario o contraseña incorrectos");
								pIncorrecto.setVisible(true);
								System.out.println(datos.getUsuarios());
							}
						
					
						
//						usuario.getCartas().put(new Carta(2), 1);
//						usuario.getCartas().put(new Carta(4), 1);
						
//						for (Carta c: usuario.getCartas().keySet()) {
//							System.out.println(c.toString() + usuario.getCartas().get(c));
//						}
					}
					
					private Usuario validarUsuario(String nombre, String contrasena, Datos datos) {
						Usuario u = datos.cargarUsuario(nombre);
						if (u == null) return null;
						System.out.println(u.aLinea());
						if (contrasena.equals(u.getContrasena()) == false) return null;
						return u;
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
					pfContrasena.requestFocus();
				} else {
					pfContrasena.setEchoChar(caracter);
				}

			}
		});

		setVisible(true);
	}
	
}