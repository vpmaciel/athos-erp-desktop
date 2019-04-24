package erp.agenda.contato;

import java.util.Collection;

public final class ContatoFac {

	private static final ContatoDao contatoDao = new ContatoImp();

	public static void deletarRegistro(Contato contato) {
		contatoDao.deletarRegistro(contato);
	}

	public static Contato getRegistro(Contato contato) {
		return contatoDao.getRegistro(contato);
	}

	public static Collection<Contato> getRegistro() {
		return contatoDao.getRegistro();
	}

	public static Collection<Contato> pesquisarRegistro(Contato contato) {
		return contatoDao.pesquisarRegistro(contato);
	}
	
	public static Contato consultarRegistro(Contato contato) {
		return contatoDao.consultarRegistro(contato);
	}

	public static void salvarRegistro(Contato contato) {
		contatoDao.salvarRegistro(contato);
	}

	private ContatoFac() {
	}
}
