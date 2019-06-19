package erp.veiculo.marca;

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

final class VeiculoMarcaImp implements VeiculoMarcaDao {

	@Override
	public void deletarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(VeiculoMarca.class, veiculoMarca.getId()));
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
	public Collection<VeiculoMarca> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<VeiculoMarca> veiculoMarcaList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from VeiculoMarca T order by T.marca",
					VeiculoMarca.class);
			veiculoMarcaList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoMarcaList;
	}

	@Override
	public VeiculoMarca getRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			veiculoMarca = entityManager.find(VeiculoMarca.class, veiculoMarca.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoMarca;
	}

	@Override
	public Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<VeiculoMarca> veiculoMarcaList = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<VeiculoMarca> criteriaQuery = criteriaBuilder.createQuery(VeiculoMarca.class);
			Root<VeiculoMarca> rootVeiculoMarca = criteriaQuery.from(VeiculoMarca.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (veiculoMarca.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootVeiculoMarca.get("id"), veiculoMarca.getId()));
			}
			if (veiculoMarca.getMarca() != null && veiculoMarca.getMarca().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculoMarca.get("marca"), "%" + veiculoMarca.getMarca() + "%"));
			}
			criteriaQuery.select(rootVeiculoMarca).where(predicateList.toArray(new Predicate[] {}));
			veiculoMarcaList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoMarcaList;
	}

	@Override
	public void salvarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(veiculoMarca);
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