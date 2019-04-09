package erp.agenda.evento.tipoevento;

import java.util.Collection;

public interface TipoEventoDao {

	void deletarRegistro(TipoEvento tipoEvento);

	TipoEvento getRegistro(TipoEvento tipoEvento);

	Collection<TipoEvento> getRegistro();

	Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento);

	void salvarRegistro(TipoEvento tipoEvento);

	TipoEvento consultarRegistro(TipoEvento tipoEvento);

}
