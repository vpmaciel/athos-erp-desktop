package erp.usuario;

public final class UsuarioUtil {

	public static void criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("ADMIN");
		usuario.setSenha("123");

		int usuarioRegTotal = UsuarioDaoFacade.getRegistro().size();

		if (usuarioRegTotal < 1) {
			UsuarioDaoFacade.salvarRegistro(usuario);
		}
	}
}
