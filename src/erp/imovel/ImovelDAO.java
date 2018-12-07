package erp.imovel;

import java.util.Collection;

public interface ImovelDAO {

	public void deletarRegistro(Imovel imovel);

	public Imovel getRegistro(Imovel imovel);

	public Collection<Imovel> getRegistro();

	public Collection<Imovel> pesquisarRegistro(Imovel imovel);

	public void salvarRegistro(Imovel imovel);
}
