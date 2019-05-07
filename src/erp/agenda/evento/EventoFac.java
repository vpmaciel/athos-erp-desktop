package erp.agenda.evento;

import java.util.Collection;

public final class EventoFac {

	private static final EventoDao eventoDao = new EventoImp();

	public static void deletarRegistro(Evento evento) {
		eventoDao.deletarRegistro(evento);
	}

	public static Collection<Evento> getRegistro() {
		return eventoDao.getRegistro();
	}

	public static Evento getRegistro(Evento evento) {
		return eventoDao.getRegistro(evento);
	}

	public static Collection<Evento> pesquisarRegistro(Evento evento) {
		return eventoDao.pesquisarRegistro(evento);
	}

	public static void salvarRegistro(Evento evento) {
		eventoDao.salvarRegistro(evento);
	}

	private EventoFac() {
	}
}
