package erp.curriculo.certificado;

import java.util.Collection;

public final class CertificadoFac {

	private static final CertificadoDao clienteDao = new CertificadoImp();

	public static void deletarRegistro(Certificado cliente) {
		clienteDao.deletarRegistro(cliente);
	}

	public static Certificado getRegistro(Certificado cliente) {
		return clienteDao.getRegistro(cliente);
	}

	public static Collection<Certificado> getRegistro() {
		return clienteDao.getRegistro();
	}

	public static Collection<Certificado> pesquisarRegistro(Certificado cliente) {
		return clienteDao.pesquisarRegistro(cliente);
	}

	public static void salvar(Certificado cliente) {
		clienteDao.salvar(cliente);
	}

	private CertificadoFac() {
	}
}
