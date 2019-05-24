package erp.curriculo.teste.perfilcomportmental;

import java.util.Collection;

public interface TestePerfilCompDao {

	public void deletarRegistro(TestePerfilComp cliente);

	public Collection<TestePerfilComp> getRegistro();

	public TestePerfilComp getRegistro(TestePerfilComp cliente);

	public Collection<TestePerfilComp> pesquisarRegistro(TestePerfilComp cliente);

	public void salvarRegistro(TestePerfilComp cliente);
}
