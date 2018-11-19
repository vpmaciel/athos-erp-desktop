package erp.agenda.recado;

import java.util.Collection;

public interface RecadoDao {

	public String construirQuery(StringBuilder recado);

	public void deletarRegistro(Recado recado);

	public Recado getRegistro(Recado recado);

	public Collection<Recado> getRegistro();

	public Collection<Recado> pesquisarRegistro(Recado recado);

	public void salvarRegistro(Recado recado);
}
