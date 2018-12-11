package erp.veiculo.marca;

import java.util.Collection;

public final class VeiculoMarcaFAC {

	private static final VeiculoMarcaDAO veiculoMarcaDAO = new VeiculoMarcaIMP();

	public static void deletarRegistro(VeiculoMarca veiculoMarca) {
		veiculoMarcaDAO.deletarRegistro(veiculoMarca);
	}

	public static VeiculoMarca getRegistro(VeiculoMarca veiculoMarca) {
		return veiculoMarcaDAO.getRegistro(veiculoMarca);
	}

	public static Collection<VeiculoMarca> getRegistro() {
		return veiculoMarcaDAO.getRegistro();
	}

	public static Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca) {
		return veiculoMarcaDAO.pesquisarRegistro(veiculoMarca);
	}

	public static void salvarRegistro(VeiculoMarca veiculoMarca) {
		veiculoMarcaDAO.salvarRegistro(veiculoMarca);
	}

	private VeiculoMarcaFAC() {
	}
}
