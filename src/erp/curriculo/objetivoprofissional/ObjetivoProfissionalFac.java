package erp.curriculo.objetivoprofissional;

import java.util.Collection;

public final class ObjetivoProfissionalFac {

	private static final ObjetivoProfissionalDao objetivoProfissionalDao = new ObjetivoProfissionalImp();

	public static void deletarRegistro(ObjetivoProfissional objetivoProfissional) {
		objetivoProfissionalDao.deletarRegistro(objetivoProfissional);
	}

	public static Collection<ObjetivoProfissional> getRegistro() {
		return objetivoProfissionalDao.getRegistro();
	}

	public static ObjetivoProfissional getRegistro(ObjetivoProfissional objetivoProfissional) {
		return objetivoProfissionalDao.getRegistro(objetivoProfissional);
	}

	public static Collection<ObjetivoProfissional> pesquisarRegistro(ObjetivoProfissional objetivoProfissional) {
		return objetivoProfissionalDao.pesquisarRegistro(objetivoProfissional);
	}

	public static void salvarRegistro(ObjetivoProfissional objetivoProfissional) {
		objetivoProfissionalDao.salvarRegistro(objetivoProfissional);
	}

	private ObjetivoProfissionalFac() {
	}
}
