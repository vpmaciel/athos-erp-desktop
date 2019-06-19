package erp.centrocusto;

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

import arquitetura.Jpa;

final class CentroCustoImp implements CentroCustoDao {

	@Override
	public void deletarRegistro(CentroCusto centroCusto) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.remove(entityManager.find(CentroCusto.class, centroCusto.getId()));
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
	public Collection<CentroCusto> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<CentroCusto> centroCustoList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from CentroCusto T order by T.nome", CentroCusto.class);
			centroCustoList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

		return centroCustoList;
	}

	@Override
	public CentroCusto getRegistro(CentroCusto centroCusto) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			centroCusto = entityManager.find(CentroCusto.class, centroCusto.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return centroCusto;
	}

	@Override
	public Collection<CentroCusto> pesquisarRegistro(CentroCusto centroCusto) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<CentroCusto> centroCustoList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CentroCusto> criteriaQuery = criteriaBuilder.createQuery(CentroCusto.class);
			Root<CentroCusto> rootCentroCusto = criteriaQuery.from(CentroCusto.class);

			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (centroCusto.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootCentroCusto.get("id"), centroCusto.getId()));
			}
			if (centroCusto.getNome() != null && centroCusto.getNome().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCentroCusto.get("nome"), "%" + centroCusto.getNome() + "%"));
			}

			criteriaQuery.select(rootCentroCusto).where(predicateList.toArray(new Predicate[] {}));
			centroCustoList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return centroCustoList;
	}

	@Override
	public void salvarRegistro(CentroCusto centroCusto) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(centroCusto);
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
