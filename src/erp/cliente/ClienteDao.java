package erp.cliente;

import java.util.Collection;

interface ClienteDao {

	Cliente consultarRegistro(Cliente cliente);

	void deletarRegistro(Cliente cliente);

	Collection<Cliente> getRegistro();

	Cliente getRegistro(Cliente cliente);

	Collection<Cliente> pesquisarRegistro(Cliente cliente);

	void salvarRegistro(Cliente cliente);
}
