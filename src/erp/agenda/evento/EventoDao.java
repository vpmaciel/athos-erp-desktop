package erp.agenda.evento;

import java.util.Collection;

interface EventoDao {

	void deletarRegistro(Evento evento);

	Evento getRegistro(Evento evento);

	Collection<Evento> getRegistro();

	Collection<Evento> pesquisarRegistro(Evento evento);

	void salvarRegistro(Evento evento);
}
