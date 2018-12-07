package erp.cartorio;

import java.util.Collection;

public interface CartorioDAO {

	public void deletarCartorio(Cartorio cartorio);

	public Cartorio getCartorio(Cartorio cartorio);

	public Collection<Cartorio> getCartorioTodos();

	public Collection<Cartorio> pesquisarRegistroCartorio(Cartorio cartorio);

	public void salvarCartorio(Cartorio cartorio);
}
