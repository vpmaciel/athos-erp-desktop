package erp.curriculo.curso;

import java.util.Collection;

public interface CursoDao {

	public void deletarRegistro(Curso curso);

	public Collection<Curso> getRegistro();

	public Curso getRegistro(Curso curso);

	public Collection<Curso> pesquisarRegistro(Curso curso);

	public void salvarRegistro(Curso curso);
}
