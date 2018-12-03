package erp.veiculomarca;

import java.util.Collection;

public final class VeiculoMarcaDaoFacade {

	private static final VeiculoMarcaDao veiculoMarcaDao = new VeiculoMarcaDaoImp();

	public static void deletarRegistro(VeiculoMarca veiculoMarca) {
		veiculoMarcaDao.deletarRegistro(veiculoMarca);
	}

	public static VeiculoMarca getRegistro(VeiculoMarca veiculoMarca) {
		return veiculoMarcaDao.getRegistro(veiculoMarca);
	}

	public static Collection<VeiculoMarca> getRegistro() {
		return veiculoMarcaDao.getRegistro();
	}

	public static Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca) {
		return veiculoMarcaDao.pesquisarRegistro(veiculoMarca);
	}

	public static void salvarRegistro(VeiculoMarca veiculoMarca) {
		veiculoMarcaDao.salvarRegistro(veiculoMarca);
	}

	private VeiculoMarcaDaoFacade() {
	}
}
