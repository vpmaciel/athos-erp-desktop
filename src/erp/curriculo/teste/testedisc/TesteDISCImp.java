package erp.curriculo.teste.testedisc;

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

final class TesteDISCImp implements TesteDISCDao {

	@Override
	public void deletarRegistro(TesteDISC testeDISC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TesteDISC.class, testeDISC.getId()));
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
	public Collection<TesteDISC> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteDISC> testeDISCList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TesteDISC T order by T.funcionario",
					TesteDISC.class);
			testeDISCList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeDISCList;
	}

	@Override
	public TesteDISC getRegistro(TesteDISC testeDISC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testeDISC = entityManager.find(TesteDISC.class, testeDISC.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeDISC;
	}

	@Override
	public Collection<TesteDISC> pesquisarRegistro(TesteDISC testeDISC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteDISC> testeDISCList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TesteDISC> criteriaQuery = criteriaBuilder.createQuery(TesteDISC.class);
			Root<TesteDISC> rootTesteDISC = criteriaQuery.from(TesteDISC.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (testeDISC.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteDISC.get("id"), testeDISC.getId()));
			}
			if (testeDISC.getFuncionario() != null && testeDISC.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteDISC.get("funcionario"), testeDISC.getFuncionario()));
			}
			if (testeDISC.getTotalOpcaoD() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteDISC.get("totalOpcaoD"),
						testeDISC.getTotalOpcaoD()));
			}
			if (testeDISC.getTotalOpcaoI() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteDISC.get("totalOpcaoI"),
						testeDISC.getTotalOpcaoI()));
			}
			if (testeDISC.getTotalOpcaoS() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteDISC.get("totalOpcaoS"),
						testeDISC.getTotalOpcaoS()));
			}
			if (testeDISC.getTotalOpcaoC() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteDISC.get("totalOpcaoC"),
						testeDISC.getTotalOpcaoC()));
			}

			criteriaQuery.select(rootTesteDISC).where(predicateList.toArray(new Predicate[] {}));
			testeDISCList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeDISCList;
	}

	@Override
	public void salvarRegistro(TesteDISC testeDISC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testeDISC);
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