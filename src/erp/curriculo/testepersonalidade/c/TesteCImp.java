package erp.curriculo.testepersonalidade.c;

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

final class TesteCImp implements TesteCDao {

	@Override
	public void deletarRegistro(TesteC testeC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TesteC.class, testeC.getId()));
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
	public Collection<TesteC> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteC> testeCList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TesteC T order by T.funcionario", TesteC.class);
			testeCList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeCList;
	}

	@Override
	public TesteC getRegistro(TesteC testeC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testeC = entityManager.find(TesteC.class, testeC.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeC;
	}

	@Override
	public Collection<TesteC> pesquisarRegistro(TesteC testeC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteC> testeCList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TesteC> criteriaQuery = criteriaBuilder.createQuery(TesteC.class);
			Root<TesteC> rootTesteC = criteriaQuery.from(TesteC.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();


			if (testeC.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteC.get("id"), testeC.getId()));
			}
			if (testeC.getFuncionario() != null && testeC.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteC.get("funcionario"), testeC.getFuncionario()));
			}
			if (testeC.getTotalOpcaoD() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteC.get("totalOpcaoD"), testeC.getTotalOpcaoD()));
			}
			if (testeC.getTotalOpcaoI() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteC.get("totalOpcaoI"), testeC.getTotalOpcaoI()));
			}
			if (testeC.getTotalOpcaoS() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteC.get("totalOpcaoS"), testeC.getTotalOpcaoS()));
			}
			if (testeC.getTotalOpcaoC() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTesteC.get("totalOpcaoC"), testeC.getTotalOpcaoC()));
			}

			criteriaQuery.select(rootTesteC).where(predicateList.toArray(new Predicate[] {}));
			testeCList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeCList;
	}

	@Override
	public void salvarRegistro(TesteC testeC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testeC);
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