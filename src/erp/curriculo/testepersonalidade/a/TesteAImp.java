package erp.curriculo.testepersonalidade.a;

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

final class TesteAImp implements TesteADao {

	@Override
	public void deletarRegistro(TesteA testeA) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TesteA.class, testeA.getId()));
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
	public Collection<TesteA> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteA> testeAList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TesteA T order T.funcionario", TesteA.class);
			testeAList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeAList;
	}

	@Override
	public TesteA getRegistro(TesteA testeA) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testeA = entityManager.find(TesteA.class, testeA.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeA;
	}

	@Override
	public Collection<TesteA> pesquisarRegistro(TesteA testeA) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteA> testeAList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TesteA> criteriaQuery = criteriaBuilder.createQuery(TesteA.class);
			Root<TesteA> rootTesteA = criteriaQuery.from(TesteA.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (testeA.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteA.get("id"), testeA.getId()));
			}
			if (testeA.getFuncionario() != null && testeA.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteA.get("funcionario"), testeA.getFuncionario()));
			}
			if (testeA.getTotalOpcaoA() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteA.get("totalOpcaoA"), testeA.getTotalOpcaoA()));
			}
			if (testeA.getTotalOpcaoC() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteA.get("totalOpcaoC"), testeA.getTotalOpcaoC()));
			}
			if (testeA.getTotalOpcaoI() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteA.get("totalOpcaoI"), testeA.getTotalOpcaoI()));
			}
			if (testeA.getTotalOpcaoO() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteA.get("totalOpcaoO"), testeA.getTotalOpcaoO()));
			}
			criteriaQuery.select(rootTesteA).where(predicateList.toArray(new Predicate[] {}));
			testeAList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeAList;
	}

	@Override
	public void salvarRegistro(TesteA testeA) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testeA);
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