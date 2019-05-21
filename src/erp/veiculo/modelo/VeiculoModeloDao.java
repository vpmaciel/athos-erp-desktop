package erp.veiculo.modelo;

import java.util.Collection;

public interface VeiculoModeloDao {

	void deletarRegistro(VeiculoModelo veiculoModelo);

	Collection<VeiculoModelo> getRegistro();

	VeiculoModelo getRegistro(VeiculoModelo veiculoModelo);

	Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo);

	void salvarRegistro(VeiculoModelo veiculoModelo);
}
