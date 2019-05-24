package erp.curriculo.teste.avaliacaodepreferenciacerebral;

import java.util.Comparator;

public class TesteAvalPrefCerComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TesteAvalPrefCer) o1).getFuncionario().getId().compareTo(((TesteAvalPrefCer) o2).getFuncionario().getId());
		}
	}

}
