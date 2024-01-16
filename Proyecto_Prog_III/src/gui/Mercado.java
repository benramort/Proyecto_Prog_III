package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

import domain.Carta;
import domain.CompraCarta;
import domain.Saga;
import domain.Usuario;
import domain.Venta;
import interfaces.Datos;


public class Mercado extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField tfBuscar;
	private JLabel lMonedas;
	private JTable jTable;
	private JComboBox<Saga> cbSelSaga;
	private JSpinner spSelPrecioMin;
	private JSpinner spSelPrecioMax;

	private List<Venta> ventasTotales;
	private List<Venta> ventasCondicionales;
	
	public Mercado(JFrame ventanaAnterior, Datos datos, Usuario usuario) {
//		Venta venta = new Venta();
//		GestorMercado gestorMercado = new GestorMercado(datos);
//		List<Venta> ventas = new ArrayList<>();
		datos.cargarVentas();
		System.out.println(datos.getVentas());
		//Formato ventana
		setTitle("Mercado");
		setSize(1500,1000);
		setLocationRelativeTo(ventanaAnterior);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		ventasTotales = datos.getVentas();
		ventasCondicionales = new ArrayList<>(ventasTotales);
//		List<Venta> ventas = datos.getVentas();
		
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
		lMonedas = new JLabel(usuario.getMonedas() + "");
		JLabel lImagenMonedas = new JLabel();
		tfBuscar = new JTextField();
		JLabel lPrecioMin = new JLabel("Precio mínimo: ");
		spSelPrecioMin = new JSpinner();
		JLabel lPrecioMax = new JLabel("Precio máximo:");
		spSelPrecioMax = new JSpinner();
		JLabel lSaga = new JLabel("Saga");
		JButton bBuscar = new JButton("BUSCAR");
//		ArrayList<Saga> lSagas = new ArrayList<Saga>();
//		lSagas.add(new Saga("Super Mario"));
//		lSagas.add(new Saga("God of War"));

		Saga[] listaSagas = {
				new Saga("", ""),
				new Saga("GodOfWar", "God Of War"),
				new Saga("Portal", "Portal"),
				new Saga("SuperMario", "Super Mario"),
				new Saga("TheLastOfUs", "The Last Of Us"),	
				new Saga("TheLegendOfZelda", "The Legend Of Zelda")
		};
		
		ComboBoxModel<Saga> comboBoxModel = new DefaultComboBoxModel<>(listaSagas);
		cbSelSaga = new JComboBox<Saga>(comboBoxModel);
		

		
		
		JButton botonVender = new JButton("VENDER");
		
		Path path = Path.of("resources/img/moneda.png");

		ImageIcon imagen1 = new ImageIcon(path.toAbsolutePath().toString());
		ImageIcon imagenMoneda = new ImageIcon(imagen1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		ImageIcon logoChiquito = new ImageIcon(getClass().getResource("/logo chiquito.png"));
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
		bBuscar.setPreferredSize(new Dimension(120, 50));
		pSaga.setPreferredSize(new Dimension(220, 100));
//		pBotonBuscar.setBackground(Color.BLUE);
//		pBotonBuscar.setOpaque(true);
//		pCentral.setBackground(Color.RED);
//		pCentral.setOpaque(true);
//		pSaga.setOpaque(true);
//		pSaga.setBackground(Color.GREEN);
		//Añadir componentes a contenedores
		setIconImage(logoChiquito.getImage());
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
		pSaga.add(Box.createVerticalStrut(30));
		pSaga.add(bBuscar);
		
		pInferior.add(botonVender);
		
		bBuscar.addActionListener(new ActionListener() {
			
			@Override

			public void actionPerformed(ActionEvent e) {
				actualizarLista();
				
			}
		});

		
		AbstractTableModel modeloTabla = new ModeloJTableCartas(ventasCondicionales);
			
		
		
		//Para insertar imagenes en una tabla nos hemos basado en este video:
		//https://www.youtube.com/watch?v=oLksi_fsRHo&t=567s
		jTable = new JTable(modeloTabla);
		JScrollPane spTabla = new JScrollPane(jTable);
		spTabla.getVerticalScrollBar().setUnitIncrement(20);
		spTabla.setPreferredSize(new Dimension(500, 500));
		jTable.setRowHeight(350);
//		jTable.setPreferredSize(new Dimension(1000, 3500));
		jTable.setDefaultRenderer(Object.class, new RendererJTableCartas());
		pDerecho.add(spTabla);
		
		
		jTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) { 
//				int fila = ;
				Venta venta = ventasCondicionales.get(jTable.rowAtPoint(e.getPoint()));
//				System.out.println(venta.getCarta());
				CompraCarta compra = new CompraCarta(ventasCondicionales, venta, datos, usuario, Mercado.this);
				System.out.println(compra);
				compra.gestionarCompra();
//				datos.getVentas().remove(venta);
//				usuario.getCartas().put(venta.getCarta(), usuario.getCartas().get(venta.getCarta()) + 1);
				lMonedas.setText(String.valueOf(usuario.getMonedas()));
				actualizar();
			}
		});
		
		setVisible(true);
		
		bBotonHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Album) ventanaAnterior).lMonedasAlbum.setText(String.valueOf(usuario.getMonedas()));
				((Album) ventanaAnterior).cargarCartas();
				((Album) ventanaAnterior).repaint();
				dispose();	
			}
		});
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				((Album) ventanaAnterior).lMonedasAlbum.setText(String.valueOf(usuario.getMonedas()));
				((Album) ventanaAnterior).cargarCartas();
				((Album) ventanaAnterior).repaint();
			}
		});
		
		botonVender.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaSeleccionVender(Mercado.this, usuario, datos, null);


					}
				});
				
			}
		});
		
		for(int i = 0; i<jTable.getRowCount(); i++ ) {
			if(!tfBuscar.getText().isEmpty() && tfBuscar.getText().startsWith(((Carta) jTable.getValueAt(i, 0)).getNombreVisible())) {			
			
			} else {
			
			}
			
		}
		
	}
	
	public void actualizar() {
		revalidate();
		jTable.revalidate();
		repaint();
//		System.out.println("actualizado");
	}

	public JLabel getlMonedas() {
		return lMonedas;
	}

	public List<Venta> getVentasTotales() {
		return ventasTotales;
	}

	public List<Venta> getVentasCondicionales() {
		return ventasCondicionales;
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
	
	public void actualizarLista() {

		System.out.println((spSelPrecioMax.getValue()).equals(0));
		
		if((((Saga)cbSelSaga.getSelectedItem()).getNombreInterno().equals("")) && (tfBuscar.getText().isEmpty()) && (spSelPrecioMax.getValue().equals(0))) {
			ventasCondicionales.removeIf(v -> true);
			ventasCondicionales.addAll(ventasTotales);
			System.out.println("hola que ase");
		} else {
			ventasCondicionales.removeIf(v -> true);
			ventasCondicionales.addAll(ventasTotales);
			ventasCondicionales.removeIf(v -> (!v.getCarta().getNombreVisible().toUpperCase().startsWith(tfBuscar.getText().toUpperCase())));
			ventasCondicionales.removeIf(v -> (!v.getCarta().getSaga().equals(cbSelSaga.getSelectedItem())));
//			ventasCondicionales.removeIf(v -> !(v.getPrecio() >= ((int) spSelPrecioMin.getValue()) && v.getPrecio() <= ((int) spSelPrecioMax.getValue())));
			System.out.println("NO null");
		}
		actualizar();
//			for(Venta v : ventasTotales) {
//				if(!ventasCondicionales.contains(v)) {
//					if((v.getCarta().getSaga().equals(cbSelSaga.getSelectedItem())) && (!tfBuscar.getText().isEmpty() && v.getCarta().getNombreVisible().startsWith(tfBuscar.getText()))) {
//						ventasCondicionales.add(v);
//					}
//				}
//			}
		
	}
	
}
