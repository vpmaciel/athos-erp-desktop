package erp.curriculo.idioma;

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

final class IdiomaImp implements IdiomaDao {

	@Override
	public void deletarRegistro(Idioma idioma) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Idioma.class, idioma.getId()));
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
	public Collection<Idioma> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Idioma> idiomaList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Idioma T order by T.funcionario", Idioma.class);
			idiomaList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return idiomaList;
	}

	@Override
	public Idioma getRegistro(Idioma idioma) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			idioma = entityManager.find(Idioma.class, idioma.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return idioma;
	}

	@Override
	public Collection<Idioma> pesquisarRegistro(Idioma idioma) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Idioma> idiomaList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Idioma> criteriaQuery = criteriaBuilder.createQuery(Idioma.class);
			Root<Idioma> rootIdioma = criteriaQuery.from(Idioma.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (idioma.getFuncionario() != null && idioma.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootIdioma.get("funcionario"), idioma.getFuncionario()));
			}
			if (idioma.getConhecimento() != null && idioma.getConhecimento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootIdioma.get("conhecimento"), "%" + idioma.getConhecimento() + "%"));
			}
			if (idioma.getNivelConhecimento() != null && idioma.getNivelConhecimento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootIdioma.get("nivelConhecimento"), "%" + idioma.getNivelConhecimento() + "%"));
			}
			criteriaQuery.select(rootIdioma).where(predicateList.toArray(new Predicate[] {}));
			idiomaList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return idiomaList;
	}

	@Override
	public void salvarRegistro(Idioma idioma) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(idioma);
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