package erp.agenda.contato;

import java.util.Comparator;

public class ContatoSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Contato) o1).getId().compareTo(((Contato) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Contato) o1).getNome().compareToIgnoreCase(((Contato) o2).getNome());
		}
	}

}
