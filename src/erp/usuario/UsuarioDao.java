package erp.usuario;

import java.util.Collection;

public interface UsuarioDao {

	public String construirQuery(StringBuilder stringBuilder);

	public void deletarRegistro(Usuario usuario);

	public Usuario getRegistro(Usuario usuario);

	public Collection<Usuario> getRegistro();

	public boolean isRegistroValido(Usuario usuario);

	public Collection<Usuario> pesquisarRegistro(Usuario usuario);

	public void salvarRegistro(Usuario usuario);
}
