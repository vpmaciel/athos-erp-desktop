package erp.curriculo.experienciaprofissional;

import java.util.Comparator;

public class ExperienciaProfissionalComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((ExperienciaProfissional) o1).getId().compareTo(((ExperienciaProfissional) o2).getId());
		}
	}

}
