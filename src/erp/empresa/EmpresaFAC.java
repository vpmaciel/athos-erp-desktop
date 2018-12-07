package erp.empresa;

import java.util.Collection;

public final class EmpresaFAC {

	private static final EmpresaDAO empresaDAO = new EmpresaDaoImp();

	public static void deletarRegistro(Empresa empresa) {
		empresaDAO.deletarRegistro(empresa);
	}

	public static Empresa getRegistro(Empresa empresa) {
		return empresaDAO.getRegistro(empresa);
	}

	public static Collection<Empresa> getRegistro() {
		return empresaDAO.getRegistro();
	}

	public static Collection<Empresa> pesquisarRegistro(Empresa empresa) {
		return empresaDAO.pesquisarRegistro(empresa);
	}

	public static void salvarRegistro(Empresa empresa) {
		empresaDAO.salvarRegistro(empresa);
	}

	private EmpresaFAC() {
	}
}
