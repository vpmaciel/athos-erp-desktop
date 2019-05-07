package erp.cliente;

import java.util.Collection;

public final class ClienteFac {

	private static final ClienteDao clienteDao = new ClienteImp();

	public static Cliente consultarRegistro(Cliente cliente) {
		return clienteDao.consultarRegistro(cliente);
	}

	public static void deletarRegistro(Cliente cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<Cliente> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static Cliente getRegistro(Cliente cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<Cliente> pesquisarRegistro(Cliente cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(Cliente cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private ClienteFac() {
	}
}
