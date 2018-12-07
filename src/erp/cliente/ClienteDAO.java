package erp.cliente;

import java.util.Collection;

public interface ClienteDAO {

	public void deletarRegistro(Cliente cliente);

	public Cliente getRegistro(Cliente cliente);

	public Collection<Cliente> getRegistro();

	public Collection<Cliente> pesquisarRegistro(Cliente cliente);

	public void salvar(Cliente cliente);
}
