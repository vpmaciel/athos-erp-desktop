package erp.agenda.evento;

import java.util.Collection;

interface EventoDao {

	void deletarRegistro(Evento evento);

	Collection<Evento> getRegistro();

	Evento getRegistro(Evento evento);

	Collection<Evento> pesquisarRegistro(Evento evento);

	void salvarRegistro(Evento evento);
}
