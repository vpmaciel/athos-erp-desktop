package erp.agenda.contato;

import java.util.Collection;

public final class ContatoFAC {

	private static final ContatoDAO contatoDAO = new ContatoIMP();

	public static void deletarRegistro(Contato contato) {
		contatoDAO.deletarRegistro(contato);
	}

	public static Contato getRegistro(Contato contato) {
		return contatoDAO.getRegistro(contato);
	}

	public static Collection<Contato> getRegistro() {
		return contatoDAO.getRegistro();
	}

	public static Collection<Contato> pesquisarRegistro(Contato contato) {
		return contatoDAO.pesquisarRegistro(contato);
	}

	public static void salvarRegistro(Contato contato) {
		contatoDAO.salvarRegistro(contato);
	}

	private ContatoFAC() {
	}
}
