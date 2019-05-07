package erp.curriculo.experienciaprofissional;

import java.util.Collection;

public interface ExperienciaProfissionalDao {

	public void deletarRegistro(ExperienciaProfissional experienciaProfissional);

	public Collection<ExperienciaProfissional> getRegistro();

	public ExperienciaProfissional getRegistro(ExperienciaProfissional experienciaProfissional);

	public Collection<ExperienciaProfissional> pesquisarRegistro(ExperienciaProfissional experienciaProfissional);

	public void salvarRegistro(ExperienciaProfissional experienciaProfissional);
}
