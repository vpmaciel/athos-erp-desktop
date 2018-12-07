package erp.agenda.contato;

import java.util.Collection;

public interface ContatoDAO {

	public void deletarRegistro(Contato contato);

	public Contato getRegistro(Contato contato);

	public Collection<Contato> getRegistro();

	public Collection<Contato> pesquisarRegistro(Contato contato);

	public void salvarRegistro(Contato contato);
}