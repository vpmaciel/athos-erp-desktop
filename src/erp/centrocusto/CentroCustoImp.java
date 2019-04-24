package erp.centrocusto;

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

final class CentroCustoImp implements CentroCustoDao {

	@Override
	public void deletarRegistro(CentroCusto centroCusto) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(CentroCusto.class, centroCusto.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public CentroCusto getRegistro(CentroCusto centroCusto) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(CentroCusto.class, centroCusto.getId());
	}

	@Override
	public Collection<CentroCusto> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.centrocusto.CentroCusto B order by B.nome");
		@SuppressWarnings("unchecked")
		List<CentroCusto> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<CentroCusto> pesquisarRegistro(CentroCusto centroCusto) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroCusto> criteriaQuery = criteriaBuilder.createQuery(CentroCusto.class);
		Root<CentroCusto> rootCentroCusto = criteriaQuery.from(CentroCusto.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (centroCusto.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCentroCusto.get("id"), centroCusto.getId()));
		}

		if (centroCusto.getNome() != null && centroCusto.getNome().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCentroCusto.get("nome"), "%" + centroCusto.getNome() + "%"));
		}

		criteriaQuery.select(rootCentroCusto).where(predicates.toArray(new Predicate[] {}));

		List<CentroCusto> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}
	
	@Override
	public CentroCusto consultarRegistro(CentroCusto centroCusto) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroCusto> criteriaQuery = criteriaBuilder.createQuery(CentroCusto.class);
		Root<CentroCusto> rootCentroCusto = criteriaQuery.from(CentroCusto.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (centroCusto.getNome() != null && centroCusto.getNome().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootCentroCusto.get("nome"),centroCusto.getNome()));
			naoTemCriterio = false;
		}
		
		if (naoTemCriterio) {
			return new CentroCusto();
		}

		criteriaQuery.select(rootCentroCusto).where(predicates.toArray(new Predicate[] {}));

		List<CentroCusto> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new CentroCusto();
	}


	@Override
	public void salvarRegistro(CentroCusto centroCusto) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(centroCusto);
		tx.commit();
		em.close();
	}
}
