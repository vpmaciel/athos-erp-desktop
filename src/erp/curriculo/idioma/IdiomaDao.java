package erp.curriculo.idioma;

import java.util.Collection;

public interface IdiomaDao {

	public void deletarRegistro(Idioma idioma);

	public Collection<Idioma> getRegistro();

	public Idioma getRegistro(Idioma idioma);

	public Collection<Idioma> pesquisarRegistro(Idioma idioma);

	public void salvarRegistro(Idioma idioma);
}
