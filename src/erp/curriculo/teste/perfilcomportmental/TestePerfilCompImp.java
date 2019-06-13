package erp.curriculo.teste.perfilcomportmental;

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

final class TestePerfilCompImp implements TestePerfilCompDao {

	@Override
	public void deletarRegistro(TestePerfilComp testePerfilComp) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TestePerfilComp.class, testePerfilComp.getId()));
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
	public Collection<TestePerfilComp> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TestePerfilComp> testePerfilCompList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TestePerfilComp T order by T.funcionario",
					TestePerfilComp.class);
			testePerfilCompList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testePerfilCompList;
	}

	@Override
	public TestePerfilComp getRegistro(TestePerfilComp testePerfilComp) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testePerfilComp = entityManager.find(TestePerfilComp.class, testePerfilComp.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testePerfilComp;
	}

	@Override
	public Collection<TestePerfilComp> pesquisarRegistro(TestePerfilComp testePerfilComp) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TestePerfilComp> testePerfilCompList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TestePerfilComp> criteriaQuery = criteriaBuilder.createQuery(TestePerfilComp.class);
			Root<TestePerfilComp> rootTestePerfilComp = criteriaQuery.from(TestePerfilComp.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (testePerfilComp.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTestePerfilComp.get("id"), testePerfilComp.getId()));
			}
			if (testePerfilComp.getFuncionario() != null && testePerfilComp.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTestePerfilComp.get("funcionario"),
						testePerfilComp.getFuncionario()));
			}
			if (testePerfilComp.getTotalOpcaoA() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTestePerfilComp.get("totalOpcaoA"),
						testePerfilComp.getTotalOpcaoA()));
			}
			if (testePerfilComp.getTotalOpcaoB() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTestePerfilComp.get("totalOpcaoB"),
						testePerfilComp.getTotalOpcaoB()));
			}
			if (testePerfilComp.getTotalOpcaoC() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTestePerfilComp.get("totalOpcaoC"),
						testePerfilComp.getTotalOpcaoC()));
			}
			if (testePerfilComp.getTotalOpcaoD() != null) {
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(rootTestePerfilComp.get("totalOpcaoD"),
						testePerfilComp.getTotalOpcaoD()));
			}
			criteriaQuery.select(rootTestePerfilComp).where(predicateList.toArray(new Predicate[] {}));
			testePerfilCompList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testePerfilCompList;
	}

	@Override
	public void salvarRegistro(TestePerfilComp testePerfilComp) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testePerfilComp);
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