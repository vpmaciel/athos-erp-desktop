package erp.veiculo;

import java.util.Comparator;

public class VeiculoComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Veiculo) o1).getId().compareTo(((Veiculo) o2).getId());
		}
	}

	public class Modelo implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Veiculo) o1).getModelo().getModelo().compareToIgnoreCase(((Veiculo) o2).getModelo().getModelo());
		}
	}

	public class Placa implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Veiculo) o1).getPlaca().compareTo(((Veiculo) o2).getPlaca());
		}
	}

}
