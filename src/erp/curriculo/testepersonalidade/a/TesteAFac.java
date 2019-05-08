package erp.curriculo.testepersonalidade.a;

import java.util.Collection;

public final class TesteAFac {

	private static final TesteADao clienteDao = new TesteAImp();

	public static void deletarRegistro(TesteA cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<TesteA> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static TesteA getRegistro(TesteA cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<TesteA> pesquisarRegistro(TesteA cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(TesteA cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private TesteAFac() {
	}
}
