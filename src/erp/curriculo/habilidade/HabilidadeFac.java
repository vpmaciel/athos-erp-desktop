package erp.curriculo.habilidade;

import java.util.Collection;

public final class HabilidadeFac {

	private static final HabilidadeDao habilidadeDao = new HabilidadeImp();

	public static void deletarRegistro(Habilidade habilidade) {
		habilidadeDao.deletarRegistro(habilidade);
	}

	public static Collection<Habilidade> getRegistro() {
		return habilidadeDao.getRegistro();
	}

	public static Habilidade getRegistro(Habilidade habilidade) {
		return habilidadeDao.getRegistro(habilidade);
	}

	public static Collection<Habilidade> pesquisarRegistro(Habilidade habilidade) {
		return habilidadeDao.pesquisarRegistro(habilidade);
	}

	public static void salvarRegistro(Habilidade habilidade) {
		habilidadeDao.salvarRegistro(habilidade);
	}

	private HabilidadeFac() {
	}
}
