package erp.curriculo.testepersonalidade.c;

import java.util.Collection;

public final class TesteCFac {

	private static final TesteCDao clienteDao = new TesteCImp();

	public static void deletarRegistro(TesteC cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<TesteC> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static TesteC getRegistro(TesteC cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<TesteC> pesquisarRegistro(TesteC cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(TesteC cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private TesteCFac() {
	}
}
