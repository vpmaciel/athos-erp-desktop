package erp.veiculo.documento;

import java.util.Collection;

interface DocumentoDao {

	void deletarRegistro(Documento documento);

	Collection<Documento> getRegistro();

	Documento getRegistro(Documento documento);

	Collection<Documento> pesquisarRegistro(Documento documento);

	void salvarRegistro(Documento documento);
}
