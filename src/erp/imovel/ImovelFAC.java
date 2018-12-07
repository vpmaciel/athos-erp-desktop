package erp.imovel;

import java.util.Collection;

public final class ImovelFAC {

	private static final ImovelDAO imovelDAO = new ImovelIMP();

	public static void deletarRegistro(Imovel imovel) {
		imovelDAO.deletarRegistro(imovel);
	}

	public static Imovel getRegistro(Imovel imovel) {
		return imovelDAO.getRegistro(imovel);
	}

	public static Collection<Imovel> getRegistro() {
		return imovelDAO.getRegistro();
	}

	public static Collection<Imovel> pesquisarRegistro(Imovel imovel) {
		return imovelDAO.pesquisarRegistro(imovel);
	}

	public static void salvarRegistro(Imovel imovel) {
		imovelDAO.salvarRegistro(imovel);
	}

	private ImovelFAC() {
	}
}
