package erp.agenda.agenda;

import java.util.Comparator;

public class AgendaSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Agenda) o1).getId().compareTo(((Agenda) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Agenda) o1).getNome().compareToIgnoreCase(((Agenda) o2).getNome());
		}
	}

}
