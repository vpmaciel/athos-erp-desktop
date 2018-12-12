package erp.agenda.recado;

import java.util.Collection;

public final class RecadoFac {

	private static final RecadoDao recadoDao = new RecadoImp();

	public static void deletarRegistro(Recado recado) {
		recadoDao.deletarRegistro(recado);
	}

	public static Recado getRegistro(Recado recado) {
		return recadoDao.getRegistro(recado);
	}

	public static Collection<Recado> getRegistro() {
		return recadoDao.getRegistro();
	}

	public static Collection<Recado> pesquisarRegistro(Recado recado) {
		return recadoDao.pesquisarRegistro(recado);
	}

	public static void salvarRegistro(Recado recado) {
		recadoDao.salvarRegistro(recado);
	}

	private RecadoFac() {
	}
}
