package erp.cliente;

import java.util.Collection;

interface ClienteDao {

	void deletarRegistro(Cliente cliente);

	Cliente getRegistro(Cliente cliente);

	Collection<Cliente> getRegistro();

	Collection<Cliente> pesquisarRegistro(Cliente cliente);

	void salvarRegistro(Cliente cliente);

	Cliente consultarRegistro(Cliente cliente);
}
