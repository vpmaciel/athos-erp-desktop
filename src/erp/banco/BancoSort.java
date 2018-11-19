package erp.banco;

import java.util.Comparator;

public final class BancoSort {

	public class Codigo implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Banco) o1).getCodigo().compareToIgnoreCase(((Banco) o2).getCodigo());
		}
	}

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Banco) o1).getId().compareTo(((Banco) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Banco) o1).getNome().compareToIgnoreCase(((Banco) o2).getNome());
		}
	}

}
