package erp.curriculo.testepersonalidade.b;

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

final class TesteBImp implements TesteBDao {

	@Override
	public void deletarRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TesteB.class, testeB.getId()));
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
	public Collection<TesteB> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteB> testeBList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TesteB T order T.funcionario", TesteB.class);
			testeBList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeBList;
	}

	@Override
	public TesteB getRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testeB = entityManager.find(TesteB.class, testeB.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeB;
	}

	@Override
	public Collection<TesteB> pesquisarRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteB> testeBList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TesteB> criteriaQuery = criteriaBuilder.createQuery(TesteB.class);
			Root<TesteB> rootTesteB = criteriaQuery.from(TesteB.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (testeB.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteB.get("id"), testeB.getId()));
			}
			if (testeB.getFuncionario() != null && testeB.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteB.get("funcionario"), testeB.getFuncionario()));
			}
			if (testeB.getTotalOpcaoA() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteB.get("totalOpcaoA"), testeB.getTotalOpcaoA()));
			}
			if (testeB.getTotalOpcaoB() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteB.get("totalOpcaoB"), testeB.getTotalOpcaoB()));
			}
			if (testeB.getTotalOpcaoC() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteB.get("totalOpcaoC"), testeB.getTotalOpcaoC()));
			}
			if (testeB.getTotalOpcaoD() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteB.get("totalOpcaoD"), testeB.getTotalOpcaoD()));
			}
			criteriaQuery.select(rootTesteB).where(predicateList.toArray(new Predicate[] {}));
			testeBList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeBList;
	}

	@Override
	public void salvarRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testeB);
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