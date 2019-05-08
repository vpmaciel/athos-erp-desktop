package erp.curriculo.habilidade;

import java.util.Collection;

public interface HabilidadeDao {

	public void deletarRegistro(Habilidade habilidade);

	public Collection<Habilidade> getRegistro();

	public Habilidade getRegistro(Habilidade habilidade);

	public Collection<Habilidade> pesquisarRegistro(Habilidade habilidade);

	public void salvarRegistro(Habilidade habilidade);
}
