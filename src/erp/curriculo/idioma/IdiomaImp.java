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
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Idioma.class, idioma.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Collection<Idioma> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.currriculo.idioma.Idioma C");
		@SuppressWarnings("unchecked")
		List<Idioma> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Idioma getRegistro(Idioma idioma) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Idioma.class, idioma.getId());
	}

	@Override
	public Collection<Idioma> pesquisarRegistro(Idioma idioma) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Idioma> criteriaQuery = criteriaBuilder.createQuery(Idioma.class);
		Root<Idioma> rootCliente = criteriaQuery.from(Idioma.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (idioma.getFuncionario() != null && idioma.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), idioma.getFuncionario()));
		}
		if (idioma.getConhecimento() != null && idioma.getConhecimento().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("conhecimento"), "%" + idioma.getConhecimento() + "%"));
		}
		if (idioma.getNivelConhecimento() != null && idioma.getNivelConhecimento().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("nivelConhecimento"), "%" + idioma.getNivelConhecimento() + "%"));
		}
		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Idioma> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Idioma Idioma) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(Idioma);
		tx.commit();
		em.close();
	}
}
