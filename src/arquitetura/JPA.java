package arquitetura;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import arquitetura.gui.Msg;

public class JPA {

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("erp");

		} catch (Exception ex) {
			Msg.erroConectarDataBase();
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}