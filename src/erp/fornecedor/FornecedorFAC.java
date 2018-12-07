package erp.fornecedor;

import java.util.Collection;

public final class FornecedorFAC {

	private static final FornecedorDAO fornecedorDAO = new FornecedorIMP();

	public static void deletarRegistro(Fornecedor fornecedor) {
		fornecedorDAO.deletarRegistro(fornecedor);
	}

	public static Fornecedor getRegistro(Fornecedor fornecedor) {
		return fornecedorDAO.getRegistro(fornecedor);
	}

	public static Collection<Fornecedor> getRegistro() {
		return fornecedorDAO.getRegistro();
	}

	public static Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor) {
		return fornecedorDAO.pesquisarRegistro(fornecedor);
	}

	public static void salvarRegistro(Fornecedor fornecedor) {
		fornecedorDAO.salvarRegistro(fornecedor);
	}

	private FornecedorFAC() {
	}
}
