package erp.fornecedor;

import java.util.Collection;

public interface FornecedorDao {

	void deletarRegistro(Fornecedor fornecedor);

	Fornecedor getRegistro(Fornecedor fornecedor);

	Collection<Fornecedor> getRegistro();

	Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor);

	Fornecedor consultarRegistro(Fornecedor fornecedor);

	void salvarRegistro(Fornecedor fornecedor);
}
