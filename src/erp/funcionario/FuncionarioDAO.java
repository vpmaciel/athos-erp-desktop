package erp.funcionario;

import java.util.Collection;

public interface FuncionarioDAO {

	public void deletarRegistro(Funcionario funcionario);

	public Funcionario getRegistro(Funcionario funcionario);

	public Collection<Funcionario> getRegistro();

	public Collection<Funcionario> pesquisarRegistro(Funcionario funcionario);

	public void salvarRegistro(Funcionario funcionario);
}
