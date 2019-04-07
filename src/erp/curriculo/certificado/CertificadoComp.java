package erp.curriculo.certificado;

import java.util.Comparator;

public class CertificadoComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Certificado) o1).getId().compareTo(((Certificado) o2).getId());
		}
	}

}
