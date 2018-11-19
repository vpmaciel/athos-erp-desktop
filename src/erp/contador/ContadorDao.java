package erp.contador;

import java.util.Collection;

public interface ContadorDao {

	public String construirQuery(StringBuilder contador);

	public void deletarRegistro(Contador contador);

	public Contador getRegistro(Contador contador);

	public Collection<Contador> getRegistro();

	public Collection<Contador> pesquisarRegistro(Contador contador);

	public void salvarRegistro(Contador contador);
}
