package erp.curriculo.certificado;

import java.util.Collection;

public interface CertificadoDao {

	public void deletarRegistro(Certificado certificado);

	public Collection<Certificado> getRegistro();

	public Certificado getRegistro(Certificado certificado);

	public Collection<Certificado> pesquisarRegistro(Certificado certificado);

	public void salvarRegistro(Certificado certificado);
}
