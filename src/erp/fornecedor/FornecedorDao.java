package erp.fornecedor;

import java.util.Collection;

public interface FornecedorDao {

	Fornecedor consultarRegistro(Fornecedor fornecedor);

	void deletarRegistro(Fornecedor fornecedor);

	Collection<Fornecedor> getRegistro();

	Fornecedor getRegistro(Fornecedor fornecedor);

	Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor);

	void salvarRegistro(Fornecedor fornecedor);
}
