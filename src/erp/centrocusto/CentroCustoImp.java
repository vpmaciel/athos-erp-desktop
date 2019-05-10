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
	public CentroCusto consultarRegistro(CentroCusto centroCusto) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroCusto> criteriaQuery = criteriaBuilder.createQuery(CentroCusto.class);
		Root<CentroCusto> rootCentroCusto = criteriaQuery.from(CentroCusto.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (centroCusto.getNome() != null && centroCusto.getNome().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootCentroCusto.get("nome"), centroCusto.getNome()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new CentroCusto();
		}

		criteriaQuery.select(rootCentroCusto).where(predicates.toArray(new Predicate[] {}));

		List<CentroCusto> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new CentroCusto();
	}

	@Override
	public void deletarRegistro(CentroCusto centroCusto) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(CentroCusto.class, centroCusto.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<CentroCusto> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from CentroCusto T order by T.nome",CentroCusto.class);
		@SuppressWarnings("unchecked")
		List<CentroCusto> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public CentroCusto getRegistro(CentroCusto centroCusto) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(CentroCusto.class, centroCusto.getId());
	}

	@Override
	public Collection<CentroCusto> pesquisarRegistro(CentroCusto centroCusto) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

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
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(CentroCusto centroCusto) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(centroCusto);
		entityTransaction.commit();
		entityManager.close();
	}
}
