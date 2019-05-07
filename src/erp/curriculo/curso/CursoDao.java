package erp.curriculo.curso;

import java.util.Collection;

public interface CursoDao {

	public void deletarRegistro(Curso cliente);

	public Collection<Curso> getRegistro();

	public Curso getRegistro(Curso cliente);

	public Collection<Curso> pesquisarRegistro(Curso cliente);

	public void salvarRegistro(Curso cliente);
}
