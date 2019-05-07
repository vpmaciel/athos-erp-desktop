package erp.agenda.recado;

import java.util.Collection;

interface RecadoDao {

	void deletarRegistro(Recado recado);

	Collection<Recado> getRegistro();

	Recado getRegistro(Recado recado);

	Collection<Recado> pesquisarRegistro(Recado recado);

	void salvarRegistro(Recado recado);
}
