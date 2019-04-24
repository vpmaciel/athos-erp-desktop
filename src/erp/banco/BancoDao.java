package erp.banco;

import java.util.Collection;

interface BancoDao {

	void deletarRegistro(Banco banco);

	Banco getRegistro(Banco banco);

	Collection<Banco> getRegistro();

	Collection<Banco> pesquisarRegistro(Banco banco);

	Banco consultarRegistro(Banco banco);

	void salvarRegistro(Banco banco);
}
