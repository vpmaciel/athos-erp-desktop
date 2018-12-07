package erp.funcionario;

import java.util.Collection;

public final class FuncionarioFAC {

	private static final FuncionarioDAO funcionarioDAO = new FuncionarioIMP();

	public static void deletarRegistro(Funcionario funcionario) {
		funcionarioDAO.deletarRegistro(funcionario);
	}

	public static Funcionario getRegistro(Funcionario funcionario) {
		return funcionarioDAO.getRegistro(funcionario);
	}

	public static Collection<Funcionario> getRegistro() {
		return funcionarioDAO.getRegistro();
	}

	public static Collection<Funcionario> pesquisarRegistro(Funcionario funcionario) {
		return funcionarioDAO.pesquisarRegistro(funcionario);
	}

	public static void salvarRegistro(Funcionario funcionario) {
		funcionarioDAO.salvarRegistro(funcionario);
	}

	private FuncionarioFAC() {
	}
}
