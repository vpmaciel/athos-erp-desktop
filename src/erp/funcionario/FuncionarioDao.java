package erp.funcionario;

import java.util.Collection;

public interface FuncionarioDao {

	Funcionario consultarRegistro(Funcionario funcionario);

	void deletarRegistro(Funcionario funcionario);

	Collection<Funcionario> getRegistro();

	Funcionario getRegistro(Funcionario funcionario);

	Collection<Funcionario> pesquisarRegistro(Funcionario funcionario);

	void salvarRegistro(Funcionario funcionario);
}
