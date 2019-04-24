package erp.funcionario;

import java.util.Collection;

public interface FuncionarioDao {

	void deletarRegistro(Funcionario funcionario);

	Funcionario getRegistro(Funcionario funcionario);

	Collection<Funcionario> getRegistro();

	Collection<Funcionario> pesquisarRegistro(Funcionario funcionario);

	Funcionario consultarRegistro(Funcionario funcionario);

	void salvarRegistro(Funcionario funcionario);
}
