package erp.funcionario;

import java.util.Collection;

public interface FuncionarioDao {

	void deletarRegistro(Funcionario funcionario);

	Collection<Funcionario> getRegistro();

	Funcionario getRegistro(Funcionario funcionario);

	Collection<Funcionario> pesquisarRegistro(Funcionario funcionario);

	void salvarRegistro(Funcionario funcionario);
}
