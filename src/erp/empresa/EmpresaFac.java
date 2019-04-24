package erp.empresa;

import java.util.Collection;

public final class EmpresaFac {

	private static final EmpresaDao empresaDao = new EmpresaImp();

	public static void deletarRegistro(Empresa empresa) {
		empresaDao.deletarRegistro(empresa);
	}

	public static Empresa getRegistro(Empresa empresa) {
		return empresaDao.getRegistro(empresa);
	}

	public static Collection<Empresa> getRegistro() {
		return empresaDao.getRegistro();
	}

	public static Collection<Empresa> pesquisarRegistro(Empresa empresa) {
		return empresaDao.pesquisarRegistro(empresa);
	}

	public static void salvarRegistro(Empresa empresa) {
		empresaDao.salvarRegistro(empresa);
	}

	public static Empresa consultarRegistro(Empresa empresa) {
		return empresaDao.consultarRegistro(empresa);
	}
	
	private EmpresaFac() {
	}
}
