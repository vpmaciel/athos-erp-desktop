package erp.banco;

import java.util.Collection;

interface BancoDao {
	
	void deletarRegistro(Banco banco);

	Collection<Banco> getRegistro();

	Banco getRegistro(Banco banco);

	Collection<Banco> pesquisarRegistro(Banco banco);

	void salvarRegistro(Banco banco);
}
