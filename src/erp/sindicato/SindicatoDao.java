package erp.sindicato;

import java.util.Collection;

public interface SindicatoDao {

	public String construirQuery(StringBuilder sindicato);

	public void deletarRegistro(Sindicato sindicato);

	public Sindicato getRegistro(Sindicato sindicato);

	public Collection<Sindicato> getRegistro();

	public Collection<Sindicato> pesquisarRegistro(Sindicato sindicato);

	public void salvarRegistro(Sindicato sindicato);
}
