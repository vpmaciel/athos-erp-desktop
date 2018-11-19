package erp.cartorio;

import java.util.Comparator;

public final class CartorioSort {

	public class Comarca implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Cartorio) o1).getComarca().compareToIgnoreCase(((Cartorio) o2).getComarca());
		}
	}

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Cartorio) o1).getId().compareTo(((Cartorio) o2).getId());
		}
	}

}
