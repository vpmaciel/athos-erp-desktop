package erp.veiculo;

import java.util.Collection;

public final class VeiculoFAC {

	private static final VeiculoDAO veiculoDAO = new VeiculoIMP();

	public static void deletarRegistro(Veiculo veiculo) {
		veiculoDAO.deletarRegistro(veiculo);
	}

	public static Veiculo getRegistro(Veiculo veiculo) {
		return veiculoDAO.getRegistro(veiculo);
	}

	public static Collection<Veiculo> getRegistro() {
		return veiculoDAO.getRegistro();
	}

	public static Collection<Veiculo> pesquisarRegistro(Veiculo veiculo) {
		return veiculoDAO.pesquisarRegistro(veiculo);
	}

	public static void salvarRegistro(Veiculo veiculo) {
		veiculoDAO.salvarRegistro(veiculo);
	}

	private VeiculoFAC() {
	}
}
