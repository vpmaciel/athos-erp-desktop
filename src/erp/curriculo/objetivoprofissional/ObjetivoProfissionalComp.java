package erp.curriculo.objetivoprofissional;

import java.util.Comparator;

public class ObjetivoProfissionalComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((ObjetivoProfissional) o1).getId().compareTo(((ObjetivoProfissional) o2).getId());
		}
	}

}
