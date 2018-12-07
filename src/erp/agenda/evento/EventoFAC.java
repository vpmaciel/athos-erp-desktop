package erp.agenda.evento;

import java.util.Collection;

public final class EventoFAC {

	private static final EventoDAO eventoDAO = new EventoIMP();

	public static void deletarRegistro(Evento evento) {
		eventoDAO.deletarRegistro(evento);
	}

	public static Evento getRegistro(Evento evento) {
		return eventoDAO.getRegistro(evento);
	}

	public static Collection<Evento> getRegistro() {
		return eventoDAO.getRegistro();
	}

	public static Collection<Evento> pesquisarRegistro(Evento evento) {
		return eventoDAO.pesquisarRegistro(evento);
	}

	public static void salvarRegistro(Evento evento) {
		eventoDAO.salvarRegistro(evento);
	}

	private EventoFAC() {
	}
}
