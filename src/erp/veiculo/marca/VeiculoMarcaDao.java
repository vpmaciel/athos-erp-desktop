package erp.veiculo.marca;

import java.util.Collection;

public interface VeiculoMarcaDao {

	void deletarRegistro(VeiculoMarca veiculoMarca);

	VeiculoMarca getRegistro(VeiculoMarca veiculoMarca);

	Collection<VeiculoMarca> getRegistro();

	Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca);

	VeiculoMarca consultarRegistro(VeiculoMarca veiculoMarca);
	
	void salvarRegistro(VeiculoMarca veiculoMarca);
}
