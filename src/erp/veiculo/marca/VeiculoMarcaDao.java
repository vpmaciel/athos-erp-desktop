package erp.veiculo.marca;

import java.util.Collection;

public interface VeiculoMarcaDao {

	VeiculoMarca consultarRegistro(VeiculoMarca veiculoMarca);

	void deletarRegistro(VeiculoMarca veiculoMarca);

	Collection<VeiculoMarca> getRegistro();

	VeiculoMarca getRegistro(VeiculoMarca veiculoMarca);

	Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca);

	void salvarRegistro(VeiculoMarca veiculoMarca);
}
