package erp.curriculo.certificado;

import java.util.Collection;

public final class CertificadoFac {

	private static final CertificadoDao certificadoDao = new CertificadoImp();

	public static void deletarRegistro(Certificado certificado) {
		certificadoDao.deletarRegistro(certificado);
	}

	public static Collection<Certificado> getRegistro() {
		return certificadoDao.getRegistro();
	}

	public static Certificado getRegistro(Certificado certificado) {
		return certificadoDao.getRegistro(certificado);
	}

	public static Collection<Certificado> pesquisarRegistro(Certificado certificado) {
		return certificadoDao.pesquisarRegistro(certificado);
	}

	public static void salvarRegistro(Certificado certificado) {
		certificadoDao.salvarRegistro(certificado);
	}

	private CertificadoFac() {
	}
}
