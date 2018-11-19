package erp.veiculo.veiculo;

import java.util.Comparator;

public class VeiculoSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Veiculo) o1).getId().compareTo(((Veiculo) o2).getId());
		}
	}

	public class Modelo implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Veiculo) o1).getModelo().compareToIgnoreCase(((Veiculo) o2).getModelo());
		}
	}

}
