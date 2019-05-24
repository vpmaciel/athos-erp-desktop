package erp.curriculo;

import java.util.Collection;

import erp.funcionario.Funcionario;

public interface CurriculoDao {

	Collection<Funcionario> getRegistro();

	Funcionario getRegistro(Funcionario funcionario);

	Collection<Funcionario> pesquisarRegistro(Funcionario funcionario);
}
