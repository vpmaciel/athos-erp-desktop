package erp.curriculo.testepersonalidade.b;

import java.util.Collection;

public final class TesteBFac {

	private static final TesteBDao clienteDao = new TesteBImp();

	public static void deletarRegistro(TesteB cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<TesteB> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static TesteB getRegistro(TesteB cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<TesteB> pesquisarRegistro(TesteB cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(TesteB cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private TesteBFac() {
	}
}
