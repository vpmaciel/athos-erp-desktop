package erp.centrocusto;

import java.util.Collection;

interface CentroCustoDao {

	CentroCusto consultarRegistro(CentroCusto centroCusto);

	void deletarRegistro(CentroCusto centroCusto);

	Collection<CentroCusto> getRegistro();

	CentroCusto getRegistro(CentroCusto centroCusto);

	Collection<CentroCusto> pesquisarRegistro(CentroCusto centroCusto);

	void salvarRegistro(CentroCusto centroCusto);
}
