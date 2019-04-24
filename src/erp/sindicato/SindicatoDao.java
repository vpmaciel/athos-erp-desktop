package erp.sindicato;

import java.util.Collection;

public interface SindicatoDao {

	void deletarRegistro(Sindicato sindicato);

	Sindicato getRegistro(Sindicato sindicato);

	Collection<Sindicato> getRegistro();

	Collection<Sindicato> pesquisarRegistro(Sindicato sindicato);
	
	Sindicato consultarRegistro(Sindicato sindicato);

	void salvarRegistro(Sindicato sindicato);
}
