package erp.agenda.tarefa;

import java.util.Collection;

public final class TarefaDaoFacade {

	private static final TarefaDao recadoDao = new TarefaDaoImp();

	public static void deletarRegistro(Tarefa recado) {
		recadoDao.deletarRegistro(recado);
	}

	public static Tarefa getRegistro(Tarefa recado) {
		return recadoDao.getRegistro(recado);
	}

	public static Collection<Tarefa> getRegistro() {
		return recadoDao.getRegistro();
	}

	public static Collection<Tarefa> pesquisarRegistro(Tarefa recado) {
		return recadoDao.pesquisarRegistro(recado);
	}

	public static void salvarRegistro(Tarefa recado) {
		recadoDao.salvarRegistro(recado);
	}

	private TarefaDaoFacade() {
	}
}
