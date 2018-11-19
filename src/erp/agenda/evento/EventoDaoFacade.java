package erp.agenda.evento;

import java.util.Collection;

public final class EventoDaoFacade {

	private static final EventoDao eventoDao = new EventoDaoImp();

	public static void deletarRegistro(Evento evento) {
		eventoDao.deletarRegistro(evento);
	}

	public static Evento getRegistro(Evento evento) {
		return eventoDao.getRegistro(evento);
	}

	public static Collection<Evento> getRegistro() {
		return eventoDao.getRegistro();
	}

	public static Collection<Evento> pesquisarRegistro(Evento evento) {
		return eventoDao.pesquisarRegistro(evento);
	}

	public static void salvarRegistro(Evento evento) {
		eventoDao.salvarRegistro(evento);
	}

	private EventoDaoFacade() {
	}
}
