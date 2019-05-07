package erp.cartorio;

import java.util.Collection;

interface CartorioDao {

	Cartorio consultarRegistro(Cartorio cartorio);

	void deletarRegistro(Cartorio cartorio);

	Collection<Cartorio> getRegistro();

	Cartorio getRegistro(Cartorio cartorio);

	Collection<Cartorio> pesquisarRegistro(Cartorio cartorio);

	void salvarRegistro(Cartorio cartorio);
}
