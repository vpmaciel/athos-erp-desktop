package erp.agenda.contato;

import java.util.Collection;

public interface ContatoDao {

	void deletarRegistro(Contato contato);

	Contato getRegistro(Contato contato);

	Collection<Contato> getRegistro();

	Collection<Contato> pesquisarRegistro(Contato contato);

	void salvarRegistro(Contato contato);

	Contato consultarRegistro(Contato contato);
}
