package erp.curriculo.testepersonalidade.b;

import java.util.Comparator;

public class TesteBComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TesteB) o1).getFuncionario().getId().compareTo(((TesteB) o2).getFuncionario().getId());
		}
	}

}
