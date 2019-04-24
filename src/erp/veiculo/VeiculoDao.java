package erp.veiculo;

import java.util.Collection;

interface VeiculoDao {

	void deletarRegistro(Veiculo veiculo);

	Veiculo getRegistro(Veiculo veiculo);

	Collection<Veiculo> getRegistro();

	Collection<Veiculo> pesquisarRegistro(Veiculo veiculo);
	
	Veiculo consultarRegistro(Veiculo veiculo);

	void salvarRegistro(Veiculo veiculo);
}
