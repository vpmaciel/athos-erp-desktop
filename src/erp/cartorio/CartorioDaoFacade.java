package erp.cartorio;

import java.util.Collection;

public final class CartorioDaoFacade {

	private static final CartorioDao cartorioDao = new CartorioDaoImp();

	public static void deletarCartorio(Cartorio cartorio) {
		cartorioDao.deletarCartorio(cartorio);
	}

	public static Cartorio getCartorio(Cartorio cartorio) {
		return cartorioDao.getCartorio(cartorio);
	}

	public static Collection<Cartorio> getCartorioTodos() {
		return cartorioDao.getCartorioTodos();
	}

	public static Collection<Cartorio> pesquisarRegistroCartorio(Cartorio cartorio) {
		return cartorioDao.pesquisarRegistroCartorio(cartorio);
	}

	public static void salvarCartorio(Cartorio cartorio) {
		cartorioDao.salvarCartorio(cartorio);
	}

	private CartorioDaoFacade() {
	}
}
