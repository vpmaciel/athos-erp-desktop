package erp.curriculo.habilidade;

import java.util.Comparator;

public class HabilidadeComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Habilidade) o1).getId().compareTo(((Habilidade) o2).getId());
		}
	}

}
