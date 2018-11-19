package erp.agenda.recado;

import java.util.Comparator;

public class RecadoSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Recado) o1).getId().compareTo(((Recado) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Recado) o1).getNome().compareToIgnoreCase(((Recado) o2).getNome());
		}
	}

}
