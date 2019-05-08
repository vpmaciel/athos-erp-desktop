package erp.curriculo.testepersonalidade.a;

import java.util.Comparator;

public class TesteAComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TesteA) o1).getFuncionario().getId()
					.compareTo(((TesteA) o2).getFuncionario().getId());
		}
	}

}
