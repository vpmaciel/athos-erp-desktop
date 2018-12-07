package erp.agenda.recado;

import java.util.Collection;

public final class RecadoFAC {

	private static final RecadoDAO recadoDAO = new RecadoIMP();

	public static void deletarRegistro(Recado recado) {
		recadoDAO.deletarRegistro(recado);
	}

	public static Recado getRegistro(Recado recado) {
		return recadoDAO.getRegistro(recado);
	}

	public static Collection<Recado> getRegistro() {
		return recadoDAO.getRegistro();
	}

	public static Collection<Recado> pesquisarRegistro(Recado recado) {
		return recadoDAO.pesquisarRegistro(recado);
	}

	public static void salvarRegistro(Recado recado) {
		recadoDAO.salvarRegistro(recado);
	}

	private RecadoFAC() {
	}
}
