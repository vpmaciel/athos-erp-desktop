package erp.banco;

import java.util.Collection;

public final class BancoFAC {

	private final BancoDAO bancoDAO = new BancoIMP();

	public void deletarRegistro(Banco banco) {
		bancoDAO.deletarRegistro(banco);
	}

	public Banco getRegistro(Banco banco) {
		return bancoDAO.getRegistro(banco);
	}

	public Collection<Banco> getRegistro() {
		return bancoDAO.getRegistro();
	}

	public Collection<Banco> pesquisarRegistro(Banco banco) {
		return bancoDAO.pesquisarRegistro(banco);
	}

	public void salvarBanco(Banco banco) {
		bancoDAO.salvarRegistro(banco);
	}
}
