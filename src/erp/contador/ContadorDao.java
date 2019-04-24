package erp.contador;

import java.util.Collection;

public interface ContadorDao {

	void deletarRegistro(Contador contador);

	Contador getRegistro(Contador contador);

	Collection<Contador> getRegistro();

	Collection<Contador> pesquisarRegistro(Contador contador);

    void salvarRegistro(Contador contador);
	
	Contador consultarRegistro(Contador contador);
}
