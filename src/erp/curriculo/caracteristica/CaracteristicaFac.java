package erp.curriculo.caracteristica;

import java.util.Collection;

public final class CaracteristicaFac {

	private static final CaracteristicaDao clienteDao = new CaracteristicaImp();

	public static void deletarRegistro(Caracteristica cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Caracteristica getRegistro(Caracteristica cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<Caracteristica> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static Collection<Caracteristica> pesquisarRegistro(Caracteristica cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvarRegistro(Caracteristica cliente) {
		clienteDao.salvarRegistro(cliente);
	}

	private CaracteristicaFac() {
	}
}
