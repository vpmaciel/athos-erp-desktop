package erp.curriculo.caracteristica;

import java.util.Comparator;

public class CaracteristicaComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Caracteristica) o1).getFuncionario().getId().compareTo(((Caracteristica) o2).getFuncionario().getId());
		}
	}

}
