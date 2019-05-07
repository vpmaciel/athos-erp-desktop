package erp.curriculo.curso;

import java.util.Comparator;

public class CursoComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Curso) o1).getId().compareTo(((Curso) o2).getId());
		}
	}

}
