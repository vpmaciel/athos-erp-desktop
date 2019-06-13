package erp.usuario;

import java.security.MessageDigest;

public final class UsuarioUtil {

	public static void criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("ADMIN");
		usuario.setSenha("123");

		String original = usuario.getSenha();
		MessageDigest algorithm = null;
		byte messageDigest[] = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
			messageDigest = algorithm.digest(original.getBytes("UTF-8"));
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha = hexString.toString();
		usuario.setSenha(senha);

		int usuarioRegTotal = UsuarioFac.getRegistro().size();

		if (usuarioRegTotal < 1) {
			try {
				UsuarioFac.salvarRegistro(usuario);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
