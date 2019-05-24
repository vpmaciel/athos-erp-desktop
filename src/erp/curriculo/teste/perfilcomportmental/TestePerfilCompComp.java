package erp.curriculo.teste.perfilcomportmental;

import java.util.Comparator;

public class TestePerfilCompComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((TestePerfilComp) o1).getFuncionario().getId().compareTo(((TestePerfilComp) o2).getFuncionario().getId());
		}
	}

}
