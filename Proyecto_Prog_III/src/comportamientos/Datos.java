package comportamientos;

import java.util.List;
import java.util.Set;

public interface Datos {
	
	public void cargarModeloCartas();
	public void cargarUsuarios();
	public void configurarLogger();
	public List<Usuario> getUsuarios();
	public List<Carta> getModeloCartas();
	public void guardarUsuario(Usuario usuario);
	public Usuario cargarUsuario(String nombre);

}
