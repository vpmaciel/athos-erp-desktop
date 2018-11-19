package erp.imovel;

import java.util.Collection;

public final class ImovelDaoFacade {

	private static final ImovelDao imovelDao = new ImovelDaoImp();

	public static void deletarRegistro(Imovel imovel) {
		imovelDao.deletarRegistro(imovel);
	}

	public static Imovel getRegistro(Imovel imovel) {
		return imovelDao.getRegistro(imovel);
	}

	public static Collection<Imovel> getRegistro() {
		return imovelDao.getRegistro();
	}

	public static Collection<Imovel> pesquisarRegistro(Imovel imovel) {
		return imovelDao.pesquisarRegistro(imovel);
	}

	public static void salvarRegistro(Imovel imovel) {
		imovelDao.salvarRegistro(imovel);
	}

	private ImovelDaoFacade() {
	}
}
