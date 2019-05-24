package erp.curriculo.teste.avaliacaodepreferenciacerebral;

import java.util.Collection;

public final class TesteAvalPrefCerFac {

	private static final TesteAvalPrefCerDao clienteDao = new TesteAvalPrefCerImp();

	public static void deletarRegistro(TesteAvalPrefCer cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<TesteAvalPrefCer> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static TesteAvalPrefCer getRegistro(TesteAvalPrefCer cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<TesteAvalPrefCer> pesquisarRegistro(TesteAvalPrefCer cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(TesteAvalPrefCer cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private TesteAvalPrefCerFac() {
	}
}
