package erp.cartorio;

import java.util.Collection;

public final class CartorioFac {

	private static final CartorioDao cartorioDao = new CartorioImp();

	public static Cartorio consultarRegistro(Cartorio cartorio) {
		return cartorioDao.consultarRegistro(cartorio);
	}

	public static void deletarRegistro(Cartorio cartorio) {
		cartorioDao.deletarRegistro(cartorio);
	}

	public static Collection<Cartorio> getRegistro() {
		return cartorioDao.getRegistro();
	}

	public static Cartorio getRegistro(Cartorio cartorio) {
		return cartorioDao.getRegistro(cartorio);
	}

	public static Collection<Cartorio> pesquisarRegistro(Cartorio cartorio) {
		return cartorioDao.pesquisarRegistro(cartorio);
	}

	public static void salvarRegistro(Cartorio cartorio) {
		cartorioDao.salvarRegistro(cartorio);
	}

	private CartorioFac() {
	}
}
