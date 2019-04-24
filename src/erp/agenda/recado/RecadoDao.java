package erp.agenda.recado;

import java.util.Collection;

interface RecadoDao {

	void deletarRegistro(Recado recado);

	Recado getRegistro(Recado recado);

	Collection<Recado> getRegistro();

	Collection<Recado> pesquisarRegistro(Recado recado);

	void salvarRegistro(Recado recado);
}
