package erp.curriculo;

import java.util.Collection;

import erp.funcionario.Funcionario;

public final class CurriculoFac {

	private static final CurriculoDao curriculoDao = new CurriculoImp();


	public static Collection<Funcionario> getRegistro() {
		return curriculoDao.getRegistro();
	}

	public static Funcionario getRegistro(Funcionario curriculo) {
		return curriculoDao.getRegistro(curriculo);
	}

	public static Collection<Funcionario> pesquisarRegistro(Funcionario curriculo) {
		return curriculoDao.pesquisarRegistro(curriculo);
	}

	private CurriculoFac() {
	}
}
