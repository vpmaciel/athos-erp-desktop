package erp.curriculo.habilidade;

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

final class HabilidadeImp implements HabilidadeDao {

	@Override
	public void deletarRegistro(Habilidade habilidade) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Habilidade.class, habilidade.getId()));
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
	public Collection<Habilidade> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Habilidade> habilidadeList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Habilidade T order by T.funcionario", Habilidade.class);
			habilidadeList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return habilidadeList;
	}

	@Override
	public Habilidade getRegistro(Habilidade habilidade) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			habilidade = entityManager.find(Habilidade.class, habilidade.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return habilidade;
	}

	@Override
	public Collection<Habilidade> pesquisarRegistro(Habilidade habilidade) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Habilidade> habilidadeList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Habilidade> criteriaQuery = criteriaBuilder.createQuery(Habilidade.class);
			Root<Habilidade> rootHabilidade = criteriaQuery.from(Habilidade.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (habilidade.getFuncionario() != null && habilidade.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootHabilidade.get("funcionario"), habilidade.getFuncionario()));
			}
			if (habilidade.getConhecimento() != null && habilidade.getConhecimento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootHabilidade.get("conhecimento"), "%" + habilidade.getConhecimento() + "%"));
			}
			if (habilidade.getNivelConhecimento() != null && habilidade.getNivelConhecimento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootHabilidade.get("nivelConhecimento"), "%" + habilidade.getNivelConhecimento() + "%"));
			}

			criteriaQuery.select(rootHabilidade).where(predicateList.toArray(new Predicate[] {}));
			habilidadeList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return habilidadeList;
	}

	@Override
	public void salvarRegistro(Habilidade habilidade) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(habilidade);
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