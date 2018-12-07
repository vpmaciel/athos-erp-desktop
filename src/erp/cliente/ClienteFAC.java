package erp.cliente;

import java.util.Collection;

public final class ClienteFAC {

	private static final ClienteDAO clienteDAO = new ClienteIMP();

	public static void deletarRegistro(Cliente cliente) {
		clienteDAO.deletarRegistro(cliente);
	}

	public static Cliente getRegistro(Cliente cliente) {
		return clienteDAO.getRegistro(cliente);
	}

	public static Collection<Cliente> getRegistro() {
		return clienteDAO.getRegistro();
	}

	public static Collection<Cliente> pesquisarRegistro(Cliente cliente) {
		return clienteDAO.pesquisarRegistro(cliente);
	}

	public static void salvar(Cliente cliente) {
		clienteDAO.salvar(cliente);
	}

	private ClienteFAC() {
	}
}
