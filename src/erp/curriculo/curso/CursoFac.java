package erp.curriculo.curso;

import java.util.Collection;

public final class CursoFac {

	private static final CursoDao cursoDao = new CursoImp();

	public static void deletarRegistro(Curso curso) {
		cursoDao.deletarRegistro(curso);
	}

	public static Collection<Curso> getRegistro() {
		return cursoDao.getRegistro();
	}

	public static Curso getRegistro(Curso curso) {
		return cursoDao.getRegistro(curso);
	}

	public static Collection<Curso> pesquisarRegistro(Curso curso) {
		return cursoDao.pesquisarRegistro(curso);
	}

	public static void salvarRegistro(Curso curso) {
		cursoDao.salvarRegistro(curso);
	}

	private CursoFac() {
	}
}
