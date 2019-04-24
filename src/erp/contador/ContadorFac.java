package erp.contador;

import java.util.Collection;

public final class ContadorFac {

	private static final ContadorDao contadorDao = new ContadorImp();

	public static void deletarRegistro(Contador contador) {
		contadorDao.deletarRegistro(contador);
	}

	public static Contador getRegistro(Contador contador) {
		return contadorDao.getRegistro(contador);
	}

	public static Collection<Contador> getRegistro() {
		return contadorDao.getRegistro();
	}

	public static Collection<Contador> pesquisarRegistro(Contador contador) {
		return contadorDao.pesquisarRegistro(contador);
	}

	public static Contador consultarRegistro(Contador contador) {
		return contadorDao.consultarRegistro(contador);
	}

	public static void salvarRegistro(Contador contador) {
		contadorDao.salvarRegistro(contador);
	}

	private ContadorFac() {
	}
}
