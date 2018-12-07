package erp.fornecedor;

import java.util.Comparator;

public class FornecedorCPT {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Fornecedor) o1).getId().compareTo(((Fornecedor) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Fornecedor) o1).getNomeFantasia().compareToIgnoreCase(((Fornecedor) o2).getNomeFantasia());
		}
	}

}
