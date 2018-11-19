package erp.empresa;

import java.util.Comparator;

public class EmpresaSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Empresa) o1).getId().compareTo(((Empresa) o2).getId());
		}
	}

	public class NomeFantasia implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Empresa) o1).getNomeFantasia().compareToIgnoreCase(((Empresa) o2).getNomeFantasia());
		}
	}

}
