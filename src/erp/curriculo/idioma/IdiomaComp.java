package erp.curriculo.idioma;

import java.util.Comparator;

public class IdiomaComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Idioma) o1).getId().compareTo(((Idioma) o2).getId());
		}
	}

}
