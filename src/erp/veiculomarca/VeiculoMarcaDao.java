package erp.veiculomarca;

import java.util.Collection;

public interface VeiculoMarcaDao {

	public String construirQuery(StringBuilder stringBuilder);

	public void deletarRegistro(VeiculoMarca veiculoMarca);

	public VeiculoMarca getRegistro(VeiculoMarca veiculoMarca);

	public Collection<VeiculoMarca> getRegistro();

	public Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca);

	public void salvarRegistro(VeiculoMarca veiculoMarca);
}
