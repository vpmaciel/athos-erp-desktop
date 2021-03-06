package erp.imovel;

import java.util.Collection;

public interface ImovelDao {

	public void deletarRegistro(Imovel imovel);

	public Collection<Imovel> getRegistro();

	public Imovel getRegistro(Imovel imovel);

	public Collection<Imovel> pesquisarRegistro(Imovel imovel);

	public void salvarRegistro(Imovel imovel);
}
