package erp.cliente;

import java.util.Collection;

public final class ClienteDaoFacade {

	private static final ClienteDao clienteDao = new ClienteDaoImp();

	public static void deletarRegistro(Cliente cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Cliente getRegistro(Cliente cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<Cliente> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static Collection<Cliente> pesquisarRegistro(Cliente cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvar(Cliente cliente) {
		clienteDao.salvar(cliente);
	}

	private ClienteDaoFacade() {
	}
}
