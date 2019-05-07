package erp.curriculo.certificado;

import java.util.Collection;

public interface CertificadoDao {

	public void deletarRegistro(Certificado cliente);

	public Collection<Certificado> getRegistro();

	public Certificado getRegistro(Certificado cliente);

	public Collection<Certificado> pesquisarRegistro(Certificado cliente);

	public void salvarRegistro(Certificado cliente);
}
