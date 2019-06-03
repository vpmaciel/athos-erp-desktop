package erp.veiculo.documento;

import java.util.Collection;

public final class DocumentoFac {

	private static final DocumentoDao documentoDao = new DocumentoImp();

	public static void deletarRegistro(Documento documento) {
		documentoDao.deletarRegistro(documento);
	}

	public static Collection<Documento> getRegistro() {
		return documentoDao.getRegistro();
	}

	public static Documento getRegistro(Documento documento) {
		return documentoDao.getRegistro(documento);
	}

	public static Collection<Documento> pesquisarRegistro(Documento documento) {
		return documentoDao.pesquisarRegistro(documento);
	}

	public static void salvarRegistro(Documento documento) {
		documentoDao.salvarRegistro(documento);
	}

	private DocumentoFac() {
	}
}
