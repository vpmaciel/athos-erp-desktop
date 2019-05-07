package erp.banco;

import java.util.Collection;

interface BancoDao {

	Banco consultarRegistro(Banco banco);

	void deletarRegistro(Banco banco);

	Collection<Banco> getRegistro();

	Banco getRegistro(Banco banco);

	Collection<Banco> pesquisarRegistro(Banco banco);

	void salvarRegistro(Banco banco);
}
