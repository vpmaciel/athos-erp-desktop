package erp.agenda.evento.tipoevento;

import java.util.Collection;

public interface TipoEventoDao {

	void deletarRegistro(TipoEvento tipoEvento);

	Collection<TipoEvento> getRegistro();

	TipoEvento getRegistro(TipoEvento tipoEvento);

	Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento);

	void salvarRegistro(TipoEvento tipoEvento);

}
