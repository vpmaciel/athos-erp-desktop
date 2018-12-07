package erp.sindicato;

import java.util.Collection;

public interface SindicatoDAO {

	public void deletarRegistro(Sindicato sindicato);

	public Sindicato getRegistro(Sindicato sindicato);

	public Collection<Sindicato> getRegistro();

	public Collection<Sindicato> pesquisarRegistro(Sindicato sindicato);

	public void salvarRegistro(Sindicato sindicato);
}
