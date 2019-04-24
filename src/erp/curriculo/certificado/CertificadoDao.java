package erp.curriculo.certificado;

import java.util.Collection;

public interface CertificadoDao {

	public void deletarRegistro(Certificado cliente);

	public Certificado getRegistro(Certificado cliente);

	public Collection<Certificado> getRegistro();

	public Collection<Certificado> pesquisarRegistro(Certificado cliente);

	public void salvarRegistro(Certificado cliente);
}
