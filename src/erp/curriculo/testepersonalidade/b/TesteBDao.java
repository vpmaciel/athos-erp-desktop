package erp.curriculo.testepersonalidade.b;

import java.util.Collection;

public interface TesteBDao {

	public void deletarRegistro(TesteB cliente);

	public Collection<TesteB> getRegistro();

	public TesteB getRegistro(TesteB cliente);

	public Collection<TesteB> pesquisarRegistro(TesteB cliente);

	public void salvarRegistro(TesteB cliente);
}
