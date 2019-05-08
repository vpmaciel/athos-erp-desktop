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
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Habilidade.class, habilidade.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Collection<Habilidade> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.currriculo.habilidade.Habilidade C");
		@SuppressWarnings("unchecked")
		List<Habilidade> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Habilidade getRegistro(Habilidade habilidade) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Habilidade.class, habilidade.getId());
	}

	@Override
	public Collection<Habilidade> pesquisarRegistro(Habilidade habilidade) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Habilidade> criteriaQuery = criteriaBuilder.createQuery(Habilidade.class);
		Root<Habilidade> rootCliente = criteriaQuery.from(Habilidade.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (habilidade.getFuncionario() != null && habilidade.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), habilidade.getFuncionario()));
		}
		if (habilidade.getConhecimento() != null && habilidade.getConhecimento().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("conhecimento"), "%" + habilidade.getConhecimento() + "%"));
		}
		if (habilidade.getNivelConhecimento() != null && habilidade.getNivelConhecimento().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("nivelConhecimento"), "%" + habilidade.getNivelConhecimento() + "%"));
		}
		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Habilidade> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Habilidade Habilidade) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(Habilidade);
		tx.commit();
		em.close();
	}
}
