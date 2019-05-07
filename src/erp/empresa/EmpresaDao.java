package erp.empresa;

import java.util.Collection;

public interface EmpresaDao {

	Empresa consultarRegistro(Empresa empresa);

	void deletarRegistro(Empresa empresa);

	Collection<Empresa> getRegistro();

	Empresa getRegistro(Empresa empresa);

	Collection<Empresa> pesquisarRegistro(Empresa empresa);

	void salvarRegistro(Empresa empresa);
}
