package erp.fornecedor;

import java.util.Collection;

public final class FornecedorDaoFacade {

	private static final FornecedorDao fornecedorDao = new FornecedorDaoImp();

	public static void deletarRegistro(Fornecedor fornecedor) {
		fornecedorDao.deletarRegistro(fornecedor);
	}

	public static Fornecedor getRegistro(Fornecedor fornecedor) {
		return fornecedorDao.getRegistro(fornecedor);
	}

	public static Collection<Fornecedor> getRegistro() {
		return fornecedorDao.getRegistro();
	}

	public static Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor) {
		return fornecedorDao.pesquisarRegistro(fornecedor);
	}

	public static void salvarRegistro(Fornecedor fornecedor) {
		fornecedorDao.salvarRegistro(fornecedor);
	}

	private FornecedorDaoFacade() {
	}
}
