package erp.curriculo.testepersonalidade.c;

import java.util.Collection;

public interface TesteCDao {

	public void deletarRegistro(TesteC cliente);

	public Collection<TesteC> getRegistro();

	public TesteC getRegistro(TesteC cliente);

	public Collection<TesteC> pesquisarRegistro(TesteC cliente);

	public void salvarRegistro(TesteC cliente);
}
