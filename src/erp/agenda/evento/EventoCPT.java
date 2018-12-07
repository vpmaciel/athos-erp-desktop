package erp.agenda.evento;

import java.util.Comparator;

public class EventoCPT {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Evento) o1).getId().compareTo(((Evento) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Evento) o1).getDescricao().compareToIgnoreCase(((Evento) o2).getDescricao());
		}
	}

}
