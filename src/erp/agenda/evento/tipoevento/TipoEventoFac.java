package erp.agenda.evento.tipoevento;

import java.util.Collection;

public final class TipoEventoFac {

	private static final TipoEventoDao tipoEventoDao = new TipoEventoImp();

	public static void deletarRegistro(TipoEvento tipoEvento) {
		tipoEventoDao.deletarRegistro(tipoEvento);
	}

	public static TipoEvento getRegistro(TipoEvento tipoEvento) {
		return tipoEventoDao.getRegistro(tipoEvento);
	}

	public static Collection<TipoEvento> getRegistro() {
		return tipoEventoDao.getRegistro();
	}

	public static Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento) {
		return tipoEventoDao.pesquisarRegistro(tipoEvento);
	}

	public static void salvarRegistro(TipoEvento tipoEvento) {
		tipoEventoDao.salvarRegistro(tipoEvento);
	}

	private TipoEventoFac() {
	}
}
