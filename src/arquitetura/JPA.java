package arquitetura;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	
	public static Session getHibernateSession() {

	    final SessionFactory sf = new Configuration()
	        .configure("persistence.xml").buildSessionFactory();

	    // factory = new Configuration().configure().buildSessionFactory();
	    final Session session = sf.openSession();
	    return session;
	    }
}