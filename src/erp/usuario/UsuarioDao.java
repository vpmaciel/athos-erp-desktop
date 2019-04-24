package erp.usuario;

import java.util.Collection;

public interface UsuarioDao {

	void deletarRegistro(Usuario usuario);

	Usuario getRegistro(Usuario usuario);

	Collection<Usuario> getRegistro();

	boolean isRegistroValido(Usuario usuario);

	Collection<Usuario> pesquisarRegistro(Usuario usuario);

	Usuario consultarRegistro(Usuario usuario);

	void salvarRegistro(Usuario usuario);
}
