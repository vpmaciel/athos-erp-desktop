package erp.agenda.evento.tipoevento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import arquitetura.JPA;

final class TipoEventoImp implements TipoEventoDao {

	@Override
	public void deletarRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.remove(entityManager.find(TipoEvento.class, tipoEvento.getId()));
			entityTransaction.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			entityTransaction.rollback();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<TipoEvento> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TipoEvento> tipoEventoList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TipoEvento T order by T.nome", TipoEvento.class);
			tipoEventoList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

		return tipoEventoList;
	}

	@Override
	public TipoEvento getRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			tipoEvento = entityManager.find(TipoEvento.class, tipoEvento.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return tipoEvento;
	}

	@Override
	public Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TipoEvento> tipoEventoList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TipoEvento> criteriaQuery = criteriaBuilder.createQuery(TipoEvento.class);
			Root<TipoEvento> rootTipoEvento = criteriaQuery.from(TipoEvento.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (tipoEvento.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTipoEvento.get("id"), tipoEvento.getId()));
			}

			if (tipoEvento.getNome() != null && tipoEvento.getNome().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTipoEvento.get("nome"), "%" + tipoEvento.getNome() + "%"));
			}

			criteriaQuery.select(rootTipoEvento).where(predicateList.toArray(new Predicate[] {}));

			tipoEventoList = entityManager.createQuery(criteriaQuery).getResultList();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return tipoEventoList;
	}

	@Override
	public void salvarRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(tipoEvento);
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
}