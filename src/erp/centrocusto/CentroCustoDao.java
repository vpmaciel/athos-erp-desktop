package erp.centrocusto;

import java.util.Collection;

public interface CentroCustoDao {

	public void deletarRegistro(CentroCusto centroCusto);

	public CentroCusto getRegistro(CentroCusto centroCusto);

	public Collection<CentroCusto> getRegistro();

	public Collection<CentroCusto> pesquisarRegistro(CentroCusto centroCusto);

	public void salvarRegistro(CentroCusto centroCusto);
}
