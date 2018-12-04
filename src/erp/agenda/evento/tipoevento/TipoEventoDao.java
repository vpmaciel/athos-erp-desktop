package erp.agenda.evento.tipoevento;

import java.util.Collection;

public interface TipoEventoDao {

	public void deletarRegistro(TipoEvento tipoEvento);

	public TipoEvento getRegistro(TipoEvento tipoEvento);

	public Collection<TipoEvento> getRegistro();

	public Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento);

	public void salvarRegistro(TipoEvento tipoEvento);
}
