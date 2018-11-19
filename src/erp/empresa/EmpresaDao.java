package erp.empresa;

import java.util.Collection;

public interface EmpresaDao {

	public String construirQuery(StringBuilder empresa);

	public void deletarRegistro(Empresa empresa);

	public Empresa getRegistro(Empresa empresa);

	public Collection<Empresa> getRegistro();

	public Collection<Empresa> pesquisarRegistro(Empresa empresa);

	public void salvarRegistro(Empresa empresa);
}
