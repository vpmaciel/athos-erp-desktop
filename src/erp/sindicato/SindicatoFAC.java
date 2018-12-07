package erp.sindicato;

import java.util.Collection;

public final class SindicatoFAC {

	private static final SindicatoDAO sindicatoDAO = new SindicatoIMP();

	public static void deletarRegistro(Sindicato sindicato) {
		sindicatoDAO.deletarRegistro(sindicato);
	}

	public static Sindicato getRegistro(Sindicato sindicato) {
		return sindicatoDAO.getRegistro(sindicato);
	}

	public static Collection<Sindicato> getRegistro() {
		return sindicatoDAO.getRegistro();
	}

	public static Collection<Sindicato> pesquisarRegistro(Sindicato sindicato) {
		return sindicatoDAO.pesquisarRegistro(sindicato);
	}

	public static void salvarRegistro(Sindicato sindicato) {
		sindicatoDAO.salvarRegistro(sindicato);
	}

	private SindicatoFAC() {
	}
}
