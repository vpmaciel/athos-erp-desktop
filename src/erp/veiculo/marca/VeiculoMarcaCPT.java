package erp.veiculo.marca;

import java.util.Comparator;

public class VeiculoMarcaCPT {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((VeiculoMarca) o1).getId().compareTo(((VeiculoMarca) o2).getId());
		}
	}

	public class Marca implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((VeiculoMarca) o1).getMarca().compareToIgnoreCase(((VeiculoMarca) o2).getMarca());
		}
	}

}
