package erp.veiculo.modelo;

import java.util.Collection;

public interface VeiculoModeloDAO {

	public void deletarRegistro(VeiculoModelo veiculoModelo);

	public VeiculoModelo getRegistro(VeiculoModelo veiculoModelo);

	public Collection<VeiculoModelo> getRegistro();

	public Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo);

	public void salvarRegistro(VeiculoModelo veiculoModelo);
}
