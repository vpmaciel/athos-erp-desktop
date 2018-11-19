package erp.agenda.tarefa;

import java.util.Collection;

public interface TarefaDao {

	public String construirQuery(StringBuilder recado);

	public void deletarRegistro(Tarefa recado);

	public Tarefa getRegistro(Tarefa recado);

	public Collection<Tarefa> getRegistro();

	public Collection<Tarefa> pesquisarRegistro(Tarefa recado);

	public void salvarRegistro(Tarefa recado);
}
