package erp.usuario;

import java.util.Collection;

public final class UsuarioFac {

	private static final UsuarioDao usuarioDao = new UsuarioImp();

	public static void deletarRegistro(Usuario usuario) {
		usuarioDao.deletarRegistro(usuario);
	}

	public static Collection<Usuario> getRegistro() {
		return usuarioDao.getRegistro();
	}

	public static Usuario getRegistro(Usuario usuario) {
		return usuarioDao.getRegistro(usuario);
	}

	public static boolean isRegistroValido(Usuario usuario) {
		return usuarioDao.isRegistroValido(usuario);
	}

	public static Collection<Usuario> pesquisarRegistro(Usuario usuario) {
		return usuarioDao.pesquisarRegistro(usuario);
	}

	public static void salvarRegistro(Usuario usuario) {
		usuarioDao.salvarRegistro(usuario);
	}

	private UsuarioFac() {
	}
}
