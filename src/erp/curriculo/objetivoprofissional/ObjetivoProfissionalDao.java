package erp.curriculo.objetivoprofissional;

import java.util.Collection;

public interface ObjetivoProfissionalDao {

	public void deletarRegistro(ObjetivoProfissional objetivoProfissional);

	public Collection<ObjetivoProfissional> getRegistro();

	public ObjetivoProfissional getRegistro(ObjetivoProfissional objetivoProfissional);

	public Collection<ObjetivoProfissional> pesquisarRegistro(ObjetivoProfissional objetivoProfissional);

	public void salvarRegistro(ObjetivoProfissional objetivoProfissional);
}
