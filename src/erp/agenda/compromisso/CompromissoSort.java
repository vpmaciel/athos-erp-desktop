package erp.agenda.compromisso;

import java.util.Comparator;

public class CompromissoSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Compromisso) o1).getId().compareTo(((Compromisso) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Compromisso) o1).getNome().compareToIgnoreCase(((Compromisso) o2).getNome());
		}
	}

}
