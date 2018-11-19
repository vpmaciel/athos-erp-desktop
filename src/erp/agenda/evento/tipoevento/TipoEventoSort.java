package erp.agenda.evento.tipoevento;

import java.util.Comparator;

public class TipoEventoSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TipoEvento) o1).getId().compareTo(((TipoEvento) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TipoEvento) o1).getNome().compareToIgnoreCase(((TipoEvento) o2).getNome());
		}
	}

}
