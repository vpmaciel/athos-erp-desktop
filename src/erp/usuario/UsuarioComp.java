package erp.usuario;

import java.util.Comparator;

public final class UsuarioComp {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Usuario) o1).getId().compareTo(((Usuario) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Usuario) o1).getNome().compareToIgnoreCase(((Usuario) o2).getNome());
		}
	}

}
