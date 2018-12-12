package erp.sindicato;

import java.util.Comparator;

public class SindicatoComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Sindicato) o1).getId().compareTo(((Sindicato) o2).getId());
		}
	}

	public class NomeFantasia implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Sindicato) o1).getNomeFantasia().compareToIgnoreCase(((Sindicato) o2).getNomeFantasia());
		}
	}

}
