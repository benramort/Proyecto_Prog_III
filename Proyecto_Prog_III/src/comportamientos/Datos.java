package comportamientos;

import java.util.List;
import java.util.Set;

public interface Datos {
	
	public void cargarModeloCartas();
	public void cargarUsuarios();
	public void configurarLogger();
	public Set<Usuario> getUsuarios();
	public List<Carta> getModeloCartas();

}
