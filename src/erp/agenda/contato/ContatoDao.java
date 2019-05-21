package erp.agenda.contato;

import java.util.Collection;

public interface ContatoDao {

	void deletarRegistro(Contato contato);

	Collection<Contato> getRegistro();

	Contato getRegistro(Contato contato);

	Collection<Contato> pesquisarRegistro(Contato contato);

	void salvarRegistro(Contato contato);
}
