package erp.veiculo.modelo;

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

final class VeiculoModeloImp implements VeiculoModeloDao {

	@Override
	public void deletarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.remove(entityManager.find(VeiculoModelo.class, veiculoModelo.getId()));
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
	public Collection<VeiculoModelo> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<VeiculoModelo> veiculoModeloList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from VeiculoModelo T order by T.modelo",
					VeiculoModelo.class);
			veiculoModeloList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoModeloList;
	}

	@Override
	public VeiculoModelo getRegistro(VeiculoModelo veiculoModelo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			veiculoModelo = entityManager.find(VeiculoModelo.class, veiculoModelo.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoModelo;
	}

	@Override
	public Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<VeiculoModelo> veiculoModeloList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<VeiculoModelo> criteriaQuery = criteriaBuilder.createQuery(VeiculoModelo.class);
			Root<VeiculoModelo> rootVeiculoModelo = criteriaQuery.from(VeiculoModelo.class);

			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (veiculoModelo.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootVeiculoModelo.get("id"), veiculoModelo.getId()));
			}
			if (veiculoModelo.getModelo() != null && veiculoModelo.getModelo().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootVeiculoModelo.get("modelo"), "%" + veiculoModelo.getModelo() + "%"));
			}
			criteriaQuery.select(rootVeiculoModelo).where(predicateList.toArray(new Predicate[] {}));
			veiculoModeloList = entityManager.createQuery(criteriaQuery).getResultList();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoModeloList;
	}

	@Override
	public void salvarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(veiculoModelo);
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
