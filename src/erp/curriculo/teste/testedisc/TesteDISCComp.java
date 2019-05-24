package erp.curriculo.teste.testedisc;

import java.util.Comparator;

public class TesteDISCComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TesteDISC) o1).getFuncionario().getId().compareTo(((TesteDISC) o2).getFuncionario().getId());
		}
	}

}
