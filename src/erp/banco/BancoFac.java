package erp.banco;

import java.util.Collection;

public final class BancoFac {

	private static final BancoDao bancoDao = new BancoImp();

	public static void deletarRegistro(Banco banco) {
		bancoDao.deletarRegistro(banco);
	}

	public static Banco getRegistro(Banco banco) {
		return bancoDao.getRegistro(banco);
	}

	public static Collection<Banco> getRegistro() {
		return bancoDao.getRegistro();
	}

	public static Collection<Banco> pesquisarRegistro(Banco banco) {
		return bancoDao.pesquisarRegistro(banco);
	}
	
	public static boolean consultarRegistro(Banco banco) {
		return bancoDao.consultarRegistro(banco);
	}

	public static void salvarBanco(Banco banco) {
		bancoDao.salvarRegistro(banco);
	}

	private BancoFac() {

	}
}
