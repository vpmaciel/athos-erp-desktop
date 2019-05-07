package erp.curriculo.curso;

import java.util.Collection;

public final class CursoFac {

	private static final CursoDao clienteDao = new CursoImp();

	public static void deletarRegistro(Curso cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Collection<Curso> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static Curso getRegistro(Curso cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<Curso> pesquisarRegistro(Curso cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(Curso cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private CursoFac() {
	}
}
