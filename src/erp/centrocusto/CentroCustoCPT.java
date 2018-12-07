package erp.centrocusto;

import java.util.Comparator;

public final class CentroCustoCPT {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((CentroCusto) o1).getId().compareTo(((CentroCusto) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((CentroCusto) o1).getNome().compareToIgnoreCase(((CentroCusto) o2).getNome());
		}
	}

}
