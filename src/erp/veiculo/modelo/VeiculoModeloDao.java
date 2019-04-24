package erp.veiculo.modelo;

import java.util.Collection;

public interface VeiculoModeloDao {

	void deletarRegistro(VeiculoModelo veiculoModelo);

	VeiculoModelo getRegistro(VeiculoModelo veiculoModelo);

	Collection<VeiculoModelo> getRegistro();

	Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo);

	VeiculoModelo consultarRegistro(VeiculoModelo veiculoModelo);

	void salvarRegistro(VeiculoModelo veiculoModelo);
}
