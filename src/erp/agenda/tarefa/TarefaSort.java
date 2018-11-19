package erp.agenda.tarefa;

import java.util.Comparator;

public class TarefaSort {

	public class Id implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Tarefa) o1).getId().compareTo(((Tarefa) o2).getId());
		}
	}

	public class Nome implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			return ((Tarefa) o1).getNome().compareToIgnoreCase(((Tarefa) o2).getNome());
		}
	}

}
