package erp.curriculo.teste.perfilcomportmental;

import java.util.Collection;

public final class TestePerfilCompFac {

	private static final TestePerfilCompDao clienteDao = new TestePerfilCompImp();

	public static void deletarRegistro(TestePerfilComp cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<TestePerfilComp> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static TestePerfilComp getRegistro(TestePerfilComp cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<TestePerfilComp> pesquisarRegistro(TestePerfilComp cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(TestePerfilComp cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private TestePerfilCompFac() {
	}
}
