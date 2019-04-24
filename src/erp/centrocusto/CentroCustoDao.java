package erp.centrocusto;

import java.util.Collection;

interface CentroCustoDao {

	void deletarRegistro(CentroCusto centroCusto);

	CentroCusto getRegistro(CentroCusto centroCusto);

	Collection<CentroCusto> getRegistro();

	Collection<CentroCusto> pesquisarRegistro(CentroCusto centroCusto);

	CentroCusto consultarRegistro(CentroCusto centroCusto);

	void salvarRegistro(CentroCusto centroCusto);
}
