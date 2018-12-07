package erp.contador;

import java.util.Collection;

public final class ContadorFAC {

	private static final ContadorDAO contadorDAO = new ContadorIMP();

	public static void deletarRegistro(Contador contador) {
		contadorDAO.deletarRegistro(contador);
	}

	public static Contador getRegistro(Contador contador) {
		return contadorDAO.getRegistro(contador);
	}

	public static Collection<Contador> getRegistro() {
		return contadorDAO.getRegistro();
	}

	public static Collection<Contador> pesquisarRegistro(Contador contador) {
		return contadorDAO.pesquisarRegistro(contador);
	}

	public static void salvarRegistro(Contador contador) {
		contadorDAO.salvarRegistro(contador);
	}

	private ContadorFAC() {
	}
}
