package erp.curriculo.experienciaprofissional;

import java.util.Collection;

public final class ExperienciaProfissionalFac {

	private static final ExperienciaProfissionalDao experienciaProfissionalDao = new ExperienciaProfissionalImp();

	public static void deletarRegistro(ExperienciaProfissional experienciaProfissional) {
		experienciaProfissionalDao.deletarRegistro(experienciaProfissional);
	}

	public static Collection<ExperienciaProfissional> getRegistro() {
		return experienciaProfissionalDao.getRegistro();
	}

	public static ExperienciaProfissional getRegistro(ExperienciaProfissional experienciaProfissional) {
		return experienciaProfissionalDao.getRegistro(experienciaProfissional);
	}

	public static Collection<ExperienciaProfissional> pesquisarRegistro(
			ExperienciaProfissional experienciaProfissional) {
		return experienciaProfissionalDao.pesquisarRegistro(experienciaProfissional);
	}

	public static void salvarRegistro(ExperienciaProfissional experienciaProfissional) {
		experienciaProfissionalDao.salvarRegistro(experienciaProfissional);
	}

	private ExperienciaProfissionalFac() {
	}
}
