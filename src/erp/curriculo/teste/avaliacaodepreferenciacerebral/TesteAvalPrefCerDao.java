package erp.curriculo.teste.avaliacaodepreferenciacerebral;

import java.util.Collection;

public interface TesteAvalPrefCerDao {

	public void deletarRegistro(TesteAvalPrefCer cliente);

	public Collection<TesteAvalPrefCer> getRegistro();

	public TesteAvalPrefCer getRegistro(TesteAvalPrefCer cliente);

	public Collection<TesteAvalPrefCer> pesquisarRegistro(TesteAvalPrefCer cliente);

	public void salvarRegistro(TesteAvalPrefCer cliente);
}
