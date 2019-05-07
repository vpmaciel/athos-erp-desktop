package erp.funcionario;

import java.util.Collection;

public final class FuncionarioFac {

	private static final FuncionarioDao funcionarioDao = new FuncionarioImp();

	public static Funcionario consultarRegistro(Funcionario funcionario) {
		return funcionarioDao.consultarRegistro(funcionario);
	}

	public static void deletarRegistro(Funcionario funcionario) {
		funcionarioDao.deletarRegistro(funcionario);
	}

	public static Collection<Funcionario> getRegistro() {
		return funcionarioDao.getRegistro();
	}

	public static Funcionario getRegistro(Funcionario funcionario) {
		return funcionarioDao.getRegistro(funcionario);
	}

	public static Collection<Funcionario> pesquisarRegistro(Funcionario funcionario) {
		return funcionarioDao.pesquisarRegistro(funcionario);
	}

	public static void salvarRegistro(Funcionario funcionario) {
		funcionarioDao.salvarRegistro(funcionario);
	}

	private FuncionarioFac() {

	}
}
