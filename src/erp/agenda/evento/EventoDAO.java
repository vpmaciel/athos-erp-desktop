package erp.agenda.evento;

import java.util.Collection;

public interface EventoDAO {

	public void deletarRegistro(Evento evento);

	public Evento getRegistro(Evento evento);

	public Collection<Evento> getRegistro();

	public Collection<Evento> pesquisarRegistro(Evento evento);

	public void salvarRegistro(Evento evento);
}
