package erp.veiculo;

import java.util.Collection;

public final class VeiculoFac {

	private static final VeiculoDao veiculoDao = new VeiculoImp();

	public static void deletarRegistro(Veiculo veiculo) {
		veiculoDao.deletarRegistro(veiculo);
	}

	public static Collection<Veiculo> getRegistro() {
		return veiculoDao.getRegistro();
	}

	public static Veiculo getRegistro(Veiculo veiculo) {
		return veiculoDao.getRegistro(veiculo);
	}

	public static Collection<Veiculo> pesquisarRegistro(Veiculo veiculo) {
		return veiculoDao.pesquisarRegistro(veiculo);
	}

	public static void salvarRegistro(Veiculo veiculo) {
		veiculoDao.salvarRegistro(veiculo);
	}

	private VeiculoFac() {
	}
}
