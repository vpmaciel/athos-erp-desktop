package erp.agenda.agenda;

import java.util.Collection;

interface AgendaDao {

	public String construirQuery(StringBuilder agenda);

	public void deletarRegistro(Agenda agenda);

	public Agenda getRegistro(Agenda agenda);

	public Collection<Agenda> getRegistro();

	public Collection<Agenda> pesquisarRegistro(Agenda agenda);

	public void salvarRegistro(Agenda agenda);
}
