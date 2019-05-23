package erp.banco;

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

final class BancoImp implements BancoDao {

	@Override
	public void deletarRegistro(Banco banco) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Banco.class, banco.getId()));
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
			exception.printStackTrace();
			throw exception;
		} finally {
			entityManager.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Banco> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Banco> bancoList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Banco T order by T.nome", Banco.class);
			bancoList = query.getResultList();
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return bancoList;
	}

	@Override
	public Banco getRegistro(Banco banco) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			banco = entityManager.find(Banco.class, banco.getId());

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			entityManager.close();
		}
		return banco;
	}

	@Override
	public Collection<Banco> pesquisarRegistro(Banco banco) {

		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Banco> bancoList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Banco> criteriaQuery = criteriaBuilder.createQuery(Banco.class);
			Root<Banco> rootBanco = criteriaQuery.from(Banco.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (banco.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootBanco.get("id"), banco.getId()));
			}
			if (banco.getNome() != null && banco.getNome().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootBanco.get("nome"), "%" + banco.getNome() + "%"));
			}
			if (banco.getCodigo() != null && banco.getCodigo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootBanco.get("codigo"), "%" + banco.getCodigo() + "%"));
			}

			criteriaQuery.select(rootBanco).where(predicateList.toArray(new Predicate[] {}));
			bancoList = entityManager.createQuery(criteriaQuery).getResultList();
			entityTransaction.commit();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			entityManager.close();
		}

		return bancoList;
	}

	@Override
	public void salvarRegistro(Banco banco) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.merge(banco);
			entityTransaction.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			entityTransaction.rollback();
			throw exception;
		} finally {
			entityManager.close();
		}
	}
}
