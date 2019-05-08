package erp.curriculo.idioma;

import java.util.Collection;

public final class IdiomaFac {

	private static final IdiomaDao idiomaDao = new IdiomaImp();

	public static void deletarRegistro(Idioma idioma) {
		idiomaDao.deletarRegistro(idioma);
	}

	public static Collection<Idioma> getRegistro() {
		return idiomaDao.getRegistro();
	}

	public static Idioma getRegistro(Idioma idioma) {
		return idiomaDao.getRegistro(idioma);
	}

	public static Collection<Idioma> pesquisarRegistro(Idioma idioma) {
		return idiomaDao.pesquisarRegistro(idioma);
	}

	public static void salvarRegistro(Idioma idioma) {
		idiomaDao.salvarRegistro(idioma);
	}

	private IdiomaFac() {
	}
}
