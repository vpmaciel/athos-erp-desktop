package erp.curriculo.testepersonalidade.c;

import java.util.Comparator;

public class TesteCComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TesteC) o1).getFuncionario().getId()
					.compareTo(((TesteC) o2).getFuncionario().getId());
		}
	}

}
