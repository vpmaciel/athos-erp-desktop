package erp.agenda.evento.tipoevento;

import java.util.Collection;

public final class TipoEventoFAC {

	private static final TipoEventoDAO tipoEventoDAO = new TipoEventoIMP();

	public static void deletarRegistro(TipoEvento tipoEvento) {
		tipoEventoDAO.deletarRegistro(tipoEvento);
	}

	public static TipoEvento getRegistro(TipoEvento tipoEvento) {
		return tipoEventoDAO.getRegistro(tipoEvento);
	}

	public static Collection<TipoEvento> getRegistro() {
		return tipoEventoDAO.getRegistro();
	}

	public static Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento) {
		return tipoEventoDAO.pesquisarRegistro(tipoEvento);
	}

	public static void salvarRegistro(TipoEvento tipoEvento) {
		tipoEventoDAO.salvarRegistro(tipoEvento);
	}

	private TipoEventoFAC() {
	}
}
