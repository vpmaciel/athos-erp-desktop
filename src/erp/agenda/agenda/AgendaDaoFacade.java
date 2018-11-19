package erp.agenda.agenda;

import java.util.Collection;

public final class AgendaDaoFacade {

	private static final AgendaDao agendaDao = new AgendaDaoImp();

	public static void deletarRegistro(Agenda agenda) {
		agendaDao.deletarRegistro(agenda);
	}

	public static Agenda getRegistro(Agenda agenda) {
		return agendaDao.getRegistro(agenda);
	}

	public static Collection<Agenda> getRegistro() {
		return agendaDao.getRegistro();
	}

	public static Collection<Agenda> pesquisarRegistro(Agenda agenda) {
		return agendaDao.pesquisarRegistro(agenda);
	}

	public static void salvarRegistro(Agenda agenda) {
		agendaDao.salvarRegistro(agenda);
	}
	
	private AgendaDaoFacade() {
	}

}
