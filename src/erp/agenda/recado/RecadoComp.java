package erp.agenda.recado;

import java.util.Comparator;

public class RecadoComp {

	public class Data implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Recado) o1).getData().compareToIgnoreCase(((Recado) o2).getData());
		}
	}

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Recado) o1).getId().compareTo(((Recado) o2).getId());
		}
	}

}
