package erp.curriculo;

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
import erp.funcionario.Funcionario;

final class CurriculoImp implements CurriculoDao {

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Funcionario> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Funcionario> funcionarioList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Funcionario T order by T.funcionario",
					Funcionario.class);
			funcionarioList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return funcionarioList;
	}

	@Override
	public Funcionario getRegistro(Funcionario funcionario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			funcionario = entityManager.find(Funcionario.class, funcionario.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return funcionario;
	}

	@Override
	public Collection<Funcionario> pesquisarRegistro(Funcionario funcionario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Funcionario> funcionarioList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
			Root<Funcionario> rootFuncionario = criteriaQuery.from(Funcionario.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (funcionario != null && funcionario.getId() != null) {
				predicateList.add(
						criteriaBuilder.equal(rootFuncionario.get("funcionario"), funcionario));
			}

			criteriaQuery.select(rootFuncionario).where(predicateList.toArray(new Predicate[] {}));
			funcionarioList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return funcionarioList;
	}
}