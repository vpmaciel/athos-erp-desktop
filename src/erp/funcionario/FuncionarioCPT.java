package erp.funcionario;

import java.util.Comparator;

public class FuncionarioCPT {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Funcionario) o1).getId().compareTo(((Funcionario) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Funcionario) o1).getNome().compareToIgnoreCase(((Funcionario) o2).getNome());
		}
	}

}
