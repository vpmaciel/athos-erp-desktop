package erp.fornecedor;

import java.util.Collection;

public interface FornecedorDao {

	public String construirQuery(StringBuilder fornecedor);

	public void deletarRegistro(Fornecedor fornecedor);

	public Fornecedor getRegistro(Fornecedor fornecedor);

	public Collection<Fornecedor> getRegistro();

	public Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor);

	public void salvarRegistro(Fornecedor fornecedor);
}
