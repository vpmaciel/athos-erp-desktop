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
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Habilidade.class, habilidade.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Habilidade> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Habilidade T order by T.id", Habilidade.class);
		@SuppressWarnings("unchecked")
		List<Habilidade> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Habilidade getRegistro(Habilidade habilidade) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Habilidade.class, habilidade.getId());
	}

	@Override
	public Collection<Habilidade> pesquisarRegistro(Habilidade habilidade) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

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
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Habilidade Habilidade) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(Habilidade);
		entityTransaction.commit();
		entityManager.close();
	}
}
