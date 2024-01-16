package interfaces;

import java.util.List;

import domain.Carta;
import domain.Usuario;
import domain.Venta;

public interface Datos {
	
	public void cargarModeloCartas();
	public void cargarUsuarios();
	public void configurarLogger();
	public List<Usuario> getUsuarios();
	public List<Carta> getModeloCartas();
	public void guardarUsuario(Usuario usuario);
	public Usuario cargarUsuario(String nombre);
//	public Usuario comprobarUsuario(String nombre);
	public List<Venta> getVentas();
	public void guardarVenta(Venta v);
	void cargarVentas();

}
