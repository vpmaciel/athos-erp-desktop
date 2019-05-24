package erp.curriculo.teste.testedisc;

import java.util.Collection;

public interface TesteDISCDao {

	public void deletarRegistro(TesteDISC cliente);

	public Collection<TesteDISC> getRegistro();

	public TesteDISC getRegistro(TesteDISC cliente);

	public Collection<TesteDISC> pesquisarRegistro(TesteDISC cliente);

	public void salvarRegistro(TesteDISC cliente);
}
