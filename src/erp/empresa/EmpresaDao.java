package erp.empresa;

import java.util.Collection;

public interface EmpresaDao {

	void deletarRegistro(Empresa empresa);

	Empresa getRegistro(Empresa empresa);

	Collection<Empresa> getRegistro();

	Collection<Empresa> pesquisarRegistro(Empresa empresa);

	Empresa consultarRegistro(Empresa empresa);

	void salvarRegistro(Empresa empresa);
}
