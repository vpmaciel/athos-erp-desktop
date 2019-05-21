package erp.curriculo.objetivoprofissional;

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

final class ObjetivoProfissionalImp implements ObjetivoProfissionalDao {

	@Override
	public void deletarRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(ObjetivoProfissional.class, objetivoProfissional.getId()));
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
	public Collection<ObjetivoProfissional> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<ObjetivoProfissional> objetivoProfissionalList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from ObjetivoProfissional T order by T.cargo", ObjetivoProfissional.class);
			objetivoProfissionalList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return objetivoProfissionalList;
	}

	@Override
	public ObjetivoProfissional getRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			objetivoProfissional = entityManager.find(ObjetivoProfissional.class, objetivoProfissional.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return objetivoProfissional;
	}

	@Override
	public Collection<ObjetivoProfissional> pesquisarRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<ObjetivoProfissional> objetivoProfissionalList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<ObjetivoProfissional> criteriaQuery = criteriaBuilder.createQuery(ObjetivoProfissional.class);
			Root<ObjetivoProfissional> rootObjetivoProfissional = criteriaQuery.from(ObjetivoProfissional.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (objetivoProfissional.getFuncionario() != null && objetivoProfissional.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootObjetivoProfissional.get("funcionario"), objetivoProfissional.getFuncionario()));
			}
			if (objetivoProfissional.getAreaInteresse() != null && objetivoProfissional.getAreaInteresse().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootObjetivoProfissional.get("areaInteresse"), "%" + objetivoProfissional.getAreaInteresse() + "%"));
			}
			if (objetivoProfissional.getCargo() != null && objetivoProfissional.getCargo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootObjetivoProfissional.get("cargo"), "%" + objetivoProfissional.getCargo() + "%"));
			}
			if (objetivoProfissional.getContrato() != null && objetivoProfissional.getContrato().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootObjetivoProfissional.get("contrato"), "%" + objetivoProfissional.getContrato() + "%"));
			}
			if (objetivoProfissional.getNivelHierarquico() != null && objetivoProfissional.getNivelHierarquico().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootObjetivoProfissional.get("nivelHierarquico"), "%" + objetivoProfissional.getNivelHierarquico() + "%"));
			}
			if (objetivoProfissional.getPretensaoSalarial() != null && objetivoProfissional.getPretensaoSalarial().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootObjetivoProfissional.get("pretensaoSalarial"), "%" + objetivoProfissional.getPretensaoSalarial() + "%"));
			}
			criteriaQuery.select(rootObjetivoProfissional).where(predicateList.toArray(new Predicate[] {}));
			objetivoProfissionalList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return objetivoProfissionalList;
	}

	@Override
	public void salvarRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(objetivoProfissional);
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