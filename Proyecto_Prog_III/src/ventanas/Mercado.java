package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import comportamientos.Carta;
import comportamientos.Datos;
import comportamientos.Saga;
import comportamientos.Usuario;
import comportamientos.Venta;


public class Mercado extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Venta venta = new Venta();
	private List<Venta> ventas = new ArrayList<>();
	private Random r = new Random();
	
	public Mercado(JFrame ventanaAnterior, Usuario usuario, Datos datos) {		
		//Formato ventana
		setTitle("Mercado");
		setSize(1500,1000);
		setLocationRelativeTo(ventanaAnterior);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		//Crear contenedores
		JPanel pIzquierdo = new JPanel();
		JPanel pDerecho = new JPanel();
		JPanel pIzqSuperior = new JPanel();
		JPanel pDerSuperior = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pInferior = new JPanel();
		JPanel pBotonAlbum = new JPanel();
		JPanel pMonedas = new JPanel();
		JPanel pPrecio1 = new JPanel();
		JPanel pPrecio2 = new JPanel();
		JPanel pSaga = new JPanel();
		//Formato contenedores
		Border bordePanelIzquierdo = BorderFactory.createLineBorder(Color.BLACK);
		pIzquierdo.setBorder(bordePanelIzquierdo);
		pIzquierdo.setPreferredSize(new Dimension(300, 1000));
		
		
		pIzquierdo.setLayout(new BorderLayout());
		pBotonAlbum.setLayout(new BorderLayout());
		
		pDerecho.setLayout(new BorderLayout());
		pDerSuperior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		pIzqSuperior.setLayout(new BoxLayout(pIzqSuperior, BoxLayout.Y_AXIS));

		pPrecio1.setMaximumSize(new Dimension(400, 800));
		pPrecio1.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPrecio2.setMaximumSize(new Dimension(400, 800));
		pPrecio2.setLayout(new FlowLayout(FlowLayout.CENTER));
		pSaga.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		pCentral.setLayout(new BoxLayout(pCentral, BoxLayout.Y_AXIS));
		pCentral.add(Box.createVerticalGlue());
		
		pBotonAlbum.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInferior.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Crear componentes
		JButton bBotonHome = new JButton("ÁLBUM");
		JLabel lMonedas = new JLabel(usuario.getMonedas() + "");
		JLabel lImagenMonedas = new JLabel();
		JTextField tfBuscar = new JTextField("Buscar:");
		JLabel lPrecioMin = new JLabel("Precio mínimo: ");
		JSpinner spSelPrecioMin = new JSpinner();
		JLabel lPrecioMax = new JLabel("Precio máximo:");
		JSpinner spSelPrecioMax = new JSpinner();
		JLabel lSaga = new JLabel("Saga");
//		ArrayList<Saga> lSagas = new ArrayList<Saga>();
//		lSagas.add(new Saga("Super Mario"));
//		lSagas.add(new Saga("God of War"));
		JComboBox<Saga> cbSelSaga = new JComboBox<Saga>();
		JButton botonVender = new JButton("Vender");
		
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/moneda.png"));
		ImageIcon imagenMoneda = new ImageIcon(imagen1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		ImageIcon logoPequeño = new ImageIcon(getClass().getResource("/logo chiquito.png"));
		//Formato componentes
		lImagenMonedas.setIcon(imagenMoneda);
		tfBuscar.setMaximumSize(new Dimension(200,100));
		spSelPrecioMin.setPreferredSize(new Dimension(100, 25));
		spSelPrecioMax.setPreferredSize(new Dimension(100, 25));
		spSelPrecioMin.setModel(new SpinnerNumberModel(0, 0, 999999999, 100));
		spSelPrecioMax.setModel(new SpinnerNumberModel(0, 0, 999999999, 100));
		botonVender.setPreferredSize(new Dimension(150,70));
		bBotonHome.setPreferredSize(new Dimension(100,30));
		cbSelSaga.setMinimumSize(new Dimension(200, 200));
		bBotonHome.setPreferredSize(new Dimension(90, 40));
		
		
		//Añadir componentes a contenedores
		setIconImage(logoPequeño.getImage());
		getContentPane().add(pIzquierdo,BorderLayout.WEST);
		getContentPane().add(pDerecho, BorderLayout.CENTER);
		
		pDerecho.add(pDerSuperior, BorderLayout.NORTH);
		pDerSuperior.add(pMonedas);
		pMonedas.add(lMonedas);
		pMonedas.add(lImagenMonedas);
		
		pIzquierdo.add(pIzqSuperior,BorderLayout.NORTH);
		pIzquierdo.add(pCentral,BorderLayout.CENTER);
		pIzquierdo.add(pInferior, BorderLayout.SOUTH);
		
		pIzqSuperior.add(pBotonAlbum, BorderLayout.WEST);
		
		pBotonAlbum.add(bBotonHome);
		
		pCentral.add(tfBuscar);
		pCentral.add(Box.createVerticalStrut(10));
		pCentral.add(pPrecio1);
		pCentral.add(pPrecio2);
		pCentral.add(pSaga);
		
		pPrecio1.add(lPrecioMin);
		pPrecio1.add(spSelPrecioMin);
		pPrecio2.add(lPrecioMax);
		pPrecio2.add(spSelPrecioMax);
		pSaga.add(lSaga);
		pSaga.add(cbSelSaga);
		
		pInferior.add(botonVender);
		
		int cartaAletaoria = r.nextInt(datos.getModeloCartas().size());
		int precioAleatorio = r.nextInt(200000, 1250000);
		int usuarioAleatorio = r.nextInt(datos.getUsuarios().size());
		for (int i = 0; i < 10 ; i++) {
			venta.setCarta(datos.getModeloCartas().get(cartaAletaoria));
			venta.setPrecio(precioAleatorio);
			venta.setUsuario(datos.getUsuarios().get(usuarioAleatorio));
			ventas.add(venta);
		}
		
		JLabel lImagenCarta;
		JLabel lPrecio;
		JLabel lUsuario;
		
		String[] cabeceras = {"Carta", "Precio", "Usuario"};
		DefaultTableModel modeloTabla = new DefaultTableModel(null, cabeceras);
		for(Venta v : ventas) {
			ImageIcon imagen = datos.getModeloCartas().get(r.nextInt(datos.getModeloCartas().size())).getRecursoGrafico();
			lImagenCarta = new JLabel(new ImageIcon(imagen.getImage().getScaledInstance(235, 335, Image.SCALE_DEFAULT)));
			lPrecio = new JLabel(r.nextInt(200000, 1250000) + "");
			lPrecio.setHorizontalAlignment(JLabel.CENTER);
			lPrecio.setFont(new Font("Arial", Font.BOLD, 20));
			lUsuario = new JLabel(datos.getUsuarios().get(r.nextInt(datos.getUsuarios().size())) + "");
			lUsuario.setHorizontalAlignment(JLabel.CENTER);
			lUsuario.setFont(new Font("Arial", Font.BOLD, 20));
			modeloTabla.addRow(new Object[] {lImagenCarta, lPrecio, lUsuario});
			
			lImagenCarta.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							int resp = JOptionPane.showConfirmDialog(Mercado.this, "¿Quieres comprar esta carta?", "Comprar", JOptionPane.YES_NO_OPTION);
							if (resp==JOptionPane.OK_OPTION) {
								Carta cartaComprada = v.getCarta();
								System.out.println(cartaComprada.toString());
							}
							
						}
					});
				}
				
			});
		}
		
		
		
		//Para insertar imagenes en una tabla nos hemos basado en este video:
		//https://www.youtube.com/watch?v=oLksi_fsRHo&t=567s
		JTable jTable = new JTable();
		JScrollPane spTabla = new JScrollPane(jTable);
		spTabla.setPreferredSize(new Dimension(500, 500));
		jTable.setModel(modeloTabla);
		jTable.setRowHeight(350);
		jTable.setPreferredSize(new Dimension(1000, 3500));
		jTable.setDefaultRenderer(Object.class, new RendererJTableCartas());
		pDerecho.add(spTabla);
		
		setVisible(true);
		
		bBotonHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				new Mercado(null);
//				
//			}
//		});
//		
//	}
	
}
