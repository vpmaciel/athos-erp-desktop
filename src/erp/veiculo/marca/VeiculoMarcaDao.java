package erp.veiculo.marca;

import java.util.Collection;

public interface VeiculoMarcaDao {

	public void deletarRegistro(VeiculoMarca veiculoMarca);

	public VeiculoMarca getRegistro(VeiculoMarca veiculoMarca);

	public Collection<VeiculoMarca> getRegistro();

	public Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca);

	public void salvarRegistro(VeiculoMarca veiculoMarca);
}
