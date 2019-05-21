package erp.usuario;

public final class UsuarioUtil {

	public static void criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("ADMIN");
		usuario.setSenha("123");

		int usuarioRegTotal = UsuarioFac.getRegistro().size();

		if (usuarioRegTotal < 1) {
			try {
				UsuarioFac.salvarRegistro(usuario);	
			}catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
