package erp.banco;

import java.util.Collection;

interface BancoDAO {

	public void deletarRegistro(Banco banco);

	public Banco getRegistro(Banco banco);

	public Collection<Banco> getRegistro();

	public Collection<Banco> pesquisarRegistro(Banco banco);

	public void salvarRegistro(Banco banco);
}
