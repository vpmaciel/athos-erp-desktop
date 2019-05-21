package erp.contador;

import java.util.Collection;

public interface ContadorDao {

	void deletarRegistro(Contador contador);

	Collection<Contador> getRegistro();

	Contador getRegistro(Contador contador);

	Collection<Contador> pesquisarRegistro(Contador contador);

	void salvarRegistro(Contador contador);
}
