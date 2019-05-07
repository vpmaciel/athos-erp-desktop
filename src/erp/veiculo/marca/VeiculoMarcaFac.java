package erp.veiculo.marca;

import java.util.Collection;

public final class VeiculoMarcaFac {

	private static final VeiculoMarcaDao veiculoMarcaDao = new VeiculoMarcaImp();

	public static VeiculoMarca consultarRegistro(VeiculoMarca veiculoMarca) {
		return veiculoMarcaDao.consultarRegistro(veiculoMarca);
	}

	public static void deletarRegistro(VeiculoMarca veiculoMarca) {
		veiculoMarcaDao.deletarRegistro(veiculoMarca);
	}

	public static Collection<VeiculoMarca> getRegistro() {
		return veiculoMarcaDao.getRegistro();
	}

	public static VeiculoMarca getRegistro(VeiculoMarca veiculoMarca) {
		return veiculoMarcaDao.getRegistro(veiculoMarca);
	}

	public static Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca) {
		return veiculoMarcaDao.pesquisarRegistro(veiculoMarca);
	}

	public static void salvarRegistro(VeiculoMarca veiculoMarca) {
		veiculoMarcaDao.salvarRegistro(veiculoMarca);
	}

	private VeiculoMarcaFac() {
	}
}
