package erp.usuario;

import java.util.Collection;

public final class UsuarioFAC {

	private static final UsuarioDAO usuarioDAO = new UsuarioIMP();

	public static void deletarRegistro(Usuario usuario) {
		usuarioDAO.deletarRegistro(usuario);
	}

	public static Usuario getRegistro(Usuario usuario) {
		return usuarioDAO.getRegistro(usuario);
	}

	public static Collection<Usuario> getRegistro() {
		return usuarioDAO.getRegistro();
	}

	public static boolean isRegistroValido(Usuario usuario) {
		return usuarioDAO.isRegistroValido(usuario);
	}

	public static Collection<Usuario> pesquisarRegistro(Usuario usuario) {
		return usuarioDAO.pesquisarRegistro(usuario);
	}

	public static void salvarRegistro(Usuario usuario) {
		usuarioDAO.salvarRegistro(usuario);
	}

	private UsuarioFAC() {
	}
}
