package erp.usuario;

import java.util.Collection;

public interface UsuarioDao {

	Usuario consultarRegistro(Usuario usuario);

	void deletarRegistro(Usuario usuario);

	Collection<Usuario> getRegistro();

	Usuario getRegistro(Usuario usuario);

	boolean isRegistroValido(Usuario usuario);

	Collection<Usuario> pesquisarRegistro(Usuario usuario);

	void salvarRegistro(Usuario usuario);
}
