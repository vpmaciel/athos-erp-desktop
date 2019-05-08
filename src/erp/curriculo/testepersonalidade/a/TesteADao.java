package erp.curriculo.testepersonalidade.a;

import java.util.Collection;

public interface TesteADao {

	public void deletarRegistro(TesteA cliente);

	public Collection<TesteA> getRegistro();

	public TesteA getRegistro(TesteA cliente);

	public Collection<TesteA> pesquisarRegistro(TesteA cliente);

	public void salvarRegistro(TesteA cliente);
}
