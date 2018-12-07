package erp.cartorio;

import java.util.Collection;

public final class CartorioFAC {

	private static final CartorioDAO cartorioDAO = new CartorioDaoImp();

	public static void deletarCartorio(Cartorio cartorio) {
		cartorioDAO.deletarCartorio(cartorio);
	}

	public static Cartorio getCartorio(Cartorio cartorio) {
		return cartorioDAO.getCartorio(cartorio);
	}

	public static Collection<Cartorio> getCartorioTodos() {
		return cartorioDAO.getCartorioTodos();
	}

	public static Collection<Cartorio> pesquisarRegistroCartorio(Cartorio cartorio) {
		return cartorioDAO.pesquisarRegistroCartorio(cartorio);
	}

	public static void salvarCartorio(Cartorio cartorio) {
		cartorioDAO.salvarCartorio(cartorio);
	}

	private CartorioFAC() {
	}
}
