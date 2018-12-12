package erp.contador;

import java.util.Comparator;

public final class ContadorComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Contador) o1).getId().compareTo(((Contador) o2).getId());
		}
	}

}
