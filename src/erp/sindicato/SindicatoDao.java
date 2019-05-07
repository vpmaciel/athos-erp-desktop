package erp.sindicato;

import java.util.Collection;

public interface SindicatoDao {

	Sindicato consultarRegistro(Sindicato sindicato);

	void deletarRegistro(Sindicato sindicato);

	Collection<Sindicato> getRegistro();

	Sindicato getRegistro(Sindicato sindicato);

	Collection<Sindicato> pesquisarRegistro(Sindicato sindicato);

	void salvarRegistro(Sindicato sindicato);
}
