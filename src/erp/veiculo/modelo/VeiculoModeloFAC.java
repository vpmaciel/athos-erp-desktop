package erp.veiculo.modelo;

import java.util.Collection;

public final class VeiculoModeloFAC {

	private static final VeiculoModeloDAO veiculoModeloDAO = new VeiculoModeloIMP();

	public static void deletarRegistro(VeiculoModelo veiculoModelo) {
		veiculoModeloDAO.deletarRegistro(veiculoModelo);
	}

	public static VeiculoModelo getRegistro(VeiculoModelo veiculoModelo) {
		return veiculoModeloDAO.getRegistro(veiculoModelo);
	}

	public static Collection<VeiculoModelo> getRegistro() {
		return veiculoModeloDAO.getRegistro();
	}

	public static Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo) {
		return veiculoModeloDAO.pesquisarRegistro(veiculoModelo);
	}

	public static void salvarRegistro(VeiculoModelo veiculoModelo) {
		veiculoModeloDAO.salvarRegistro(veiculoModelo);
	}

	private VeiculoModeloFAC() {
	}
}
