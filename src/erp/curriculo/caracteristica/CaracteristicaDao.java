package erp.curriculo.caracteristica;

import java.util.Collection;

public interface CaracteristicaDao {

	public void deletarRegistro(Caracteristica cliente);

	public Collection<Caracteristica> getRegistro();

	public Caracteristica getRegistro(Caracteristica cliente);

	public Collection<Caracteristica> pesquisarRegistro(Caracteristica cliente);

	public void salvarRegistro(Caracteristica cliente);
}
