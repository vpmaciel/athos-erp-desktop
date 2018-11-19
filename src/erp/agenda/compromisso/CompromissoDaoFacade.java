package erp.agenda.compromisso;

import java.util.Collection;

public final class CompromissoDaoFacade {

	private static final CompromissoDao compromissoDao = new CompromissoDaoImp();

	public static void deletarRegistro(Compromisso compromisso) {
		compromissoDao.deletarRegistro(compromisso);
	}

	public static Compromisso getRegistro(Compromisso compromisso) {
		return compromissoDao.getRegistro(compromisso);
	}

	public static Collection<Compromisso> getRegistro() {
		return compromissoDao.getRegistro();
	}

	public static Collection<Compromisso> pesquisarRegistro(Compromisso compromisso) {
		return compromissoDao.pesquisarRegistro(compromisso);
	}

	public static void salvarRegistro(Compromisso compromisso) {
		compromissoDao.salvarRegistro(compromisso);
	}

	private CompromissoDaoFacade() {
	}
}
