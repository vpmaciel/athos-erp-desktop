package arquitetura.util;

import java.util.Collection;

public class Colecao {

	public static Long size(Collection<?> collection) {
		return collection == null ? 0 : (long) collection.size();
	}
}
