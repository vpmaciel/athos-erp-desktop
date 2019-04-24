package erp.cartorio;

import java.util.Collection;

interface CartorioDao {

	void deletarRegistro(Cartorio cartorio);

	Cartorio getRegistro(Cartorio cartorio);

	Collection<Cartorio> getRegistro();

	Collection<Cartorio> pesquisarRegistro(Cartorio cartorio);

	Cartorio consultarRegistro(Cartorio cartorio);
	
	void salvarRegistro(Cartorio cartorio);
}
