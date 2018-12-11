package erp.veiculo.modelo;

import java.util.Comparator;

public class VeiculoModeloCPT {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((VeiculoModelo) o1).getId().compareTo(((VeiculoModelo) o2).getId());
		}
	}

	public class Modelo implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((VeiculoModelo) o1).getModelo().compareToIgnoreCase(((VeiculoModelo) o2).getModelo());
		}
	}

}
