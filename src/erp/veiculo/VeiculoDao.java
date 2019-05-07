package erp.veiculo;

import java.util.Collection;

interface VeiculoDao {

	Veiculo consultarRegistro(Veiculo veiculo);

	void deletarRegistro(Veiculo veiculo);

	Collection<Veiculo> getRegistro();

	Veiculo getRegistro(Veiculo veiculo);

	Collection<Veiculo> pesquisarRegistro(Veiculo veiculo);

	void salvarRegistro(Veiculo veiculo);
}
