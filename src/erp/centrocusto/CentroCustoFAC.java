package erp.centrocusto;

import java.util.Collection;

public final class CentroCustoFAC {

	private static final CentroCustoDAO centroCustoDAO = new CentroCustoIMP();

	public static void deletarRegistro(CentroCusto centroCusto) {
		centroCustoDAO.deletarRegistro(centroCusto);
	}

	public static CentroCusto getRegistro(CentroCusto centroCusto) {
		return centroCustoDAO.getRegistro(centroCusto);
	}

	public static Collection<CentroCusto> getRegistro() {
		return centroCustoDAO.getRegistro();
	}

	public static Collection<CentroCusto> pesquisarRegistro(CentroCusto centroCusto) {
		return centroCustoDAO.pesquisarRegistro(centroCusto);
	}

	public static void salvarRegistro(CentroCusto centroCusto) {
		centroCustoDAO.salvarRegistro(centroCusto);
	}

	private CentroCustoFAC() {
	}
}
