package erp.imovel;

import java.util.Comparator;

public class ImovelComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Imovel) o1).getId().compareTo(((Imovel) o2).getId());
		}
	}

	public class NomeProprietario implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Imovel) o1).getNomeProprietario().compareToIgnoreCase(((Imovel) o2).getNomeProprietario());
		}
	}

}
