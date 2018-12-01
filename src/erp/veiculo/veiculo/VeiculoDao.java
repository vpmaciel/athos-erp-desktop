package erp.veiculo.veiculo;

import java.util.Collection;

public interface VeiculoDao {

	public void deletarRegistro(Veiculo veiculo);

	public Veiculo getRegistro(Veiculo veiculo);

	public Collection<Veiculo> getRegistro();

	public Collection<Veiculo> pesquisarRegistro(Veiculo veiculo);

	public void salvarRegistro(Veiculo veiculo);
}
