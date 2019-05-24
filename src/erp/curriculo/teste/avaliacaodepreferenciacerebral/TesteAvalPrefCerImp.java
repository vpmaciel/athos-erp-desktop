package erp.curriculo.teste.avaliacaodepreferenciacerebral;

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

final class TesteAvalPrefCerImp implements TesteAvalPrefCerDao {

	@Override
	public void deletarRegistro(TesteAvalPrefCer testeAvalPrefCer) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TesteAvalPrefCer.class, testeAvalPrefCer.getId()));
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
	public Collection<TesteAvalPrefCer> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteAvalPrefCer> testeAvalPrefCerList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TesteAvalPrefCer T order by T.funcionario", TesteAvalPrefCer.class);
			testeAvalPrefCerList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeAvalPrefCerList;
	}

	@Override
	public TesteAvalPrefCer getRegistro(TesteAvalPrefCer testeAvalPrefCer) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testeAvalPrefCer = entityManager.find(TesteAvalPrefCer.class, testeAvalPrefCer.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeAvalPrefCer;
	}

	@Override
	public Collection<TesteAvalPrefCer> pesquisarRegistro(TesteAvalPrefCer testeAvalPrefCer) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteAvalPrefCer> testeAvalPrefCerList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TesteAvalPrefCer> criteriaQuery = criteriaBuilder.createQuery(TesteAvalPrefCer.class);
			Root<TesteAvalPrefCer> rootTesteAvalPrefCer = criteriaQuery.from(TesteAvalPrefCer.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (testeAvalPrefCer.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteAvalPrefCer.get("id"), testeAvalPrefCer.getId()));
			}
			if (testeAvalPrefCer.getFuncionario() != null && testeAvalPrefCer.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteAvalPrefCer.get("funcionario"), testeAvalPrefCer.getFuncionario()));
			}
			if (testeAvalPrefCer.getTotalOpcaoA() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteAvalPrefCer.get("totalOpcaoA"), testeAvalPrefCer.getTotalOpcaoA()));
			}
			if (testeAvalPrefCer.getTotalOpcaoC() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteAvalPrefCer.get("totalOpcaoC"), testeAvalPrefCer.getTotalOpcaoC()));
			}
			if (testeAvalPrefCer.getTotalOpcaoI() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteAvalPrefCer.get("totalOpcaoI"), testeAvalPrefCer.getTotalOpcaoI()));
			}
			if (testeAvalPrefCer.getTotalOpcaoO() != null) {
				predicateList.add(
						criteriaBuilder.greaterThanOrEqualTo(rootTesteAvalPrefCer.get("totalOpcaoO"), testeAvalPrefCer.getTotalOpcaoO()));
			}
			criteriaQuery.select(rootTesteAvalPrefCer).where(predicateList.toArray(new Predicate[] {}));
			testeAvalPrefCerList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeAvalPrefCerList;
	}

	@Override
	public void salvarRegistro(TesteAvalPrefCer testeAvalPrefCer) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testeAvalPrefCer);
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