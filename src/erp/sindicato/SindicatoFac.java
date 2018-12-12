package erp.sindicato;

import java.util.Collection;

public final class SindicatoFac {

	private static final SindicatoDao sindicatoDao = new SindicatoImp();

	public static void deletarRegistro(Sindicato sindicato) {
		sindicatoDao.deletarRegistro(sindicato);
	}

	public static Sindicato getRegistro(Sindicato sindicato) {
		return sindicatoDao.getRegistro(sindicato);
	}

	public static Collection<Sindicato> getRegistro() {
		return sindicatoDao.getRegistro();
	}

	public static Collection<Sindicato> pesquisarRegistro(Sindicato sindicato) {
		return sindicatoDao.pesquisarRegistro(sindicato);
	}

	public static void salvarRegistro(Sindicato sindicato) {
		sindicatoDao.salvarRegistro(sindicato);
	}

	private SindicatoFac() {
	}
}
