package erp.curriculo.teste.testedisc;

import java.util.Collection;

public final class TesteDISCFac {

	private static final TesteDISCDao clienteDao = new TesteDISCImp();

	public static void deletarRegistro(TesteDISC cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<TesteDISC> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static TesteDISC getRegistro(TesteDISC cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<TesteDISC> pesquisarRegistro(TesteDISC cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(TesteDISC cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private TesteDISCFac() {
	}
}
