package erp.veiculo.modelo;

import java.util.Collection;

public interface VeiculoModeloDao {

	public String construirQuery(StringBuilder stringBuilder);

	public void deletarRegistro(VeiculoModelo veiculoModelo);

	public VeiculoModelo getRegistro(VeiculoModelo veiculoModelo);

	public Collection<VeiculoModelo> getRegistro();

	public Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo);

	public void salvarRegistro(VeiculoModelo veiculoModelo);
}
