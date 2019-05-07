package erp.veiculo.modelo;

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

final class VeiculoModeloImp implements VeiculoModeloDao {

	@Override
	public VeiculoModelo consultarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VeiculoModelo> criteriaQuery = criteriaBuilder.createQuery(VeiculoModelo.class);
		Root<VeiculoModelo> rootVeiculoModelo = criteriaQuery.from(VeiculoModelo.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (veiculoModelo.getModelo() != null && veiculoModelo.getModelo().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootVeiculoModelo.get("modelo"), veiculoModelo.getModelo()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new VeiculoModelo();
		}

		criteriaQuery.select(rootVeiculoModelo).where(predicates.toArray(new Predicate[] {}));

		List<VeiculoModelo> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new VeiculoModelo();
	}

	@Override
	public void deletarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(VeiculoModelo.class, veiculoModelo.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Collection<VeiculoModelo> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.veiculo.modelo.VeiculoModelo C order by C.modelo");
		@SuppressWarnings("unchecked")
		List<VeiculoModelo> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public VeiculoModelo getRegistro(VeiculoModelo veiculoModelo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(VeiculoModelo.class, veiculoModelo.getId());
	}

	@Override
	public Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VeiculoModelo> criteriaQuery = criteriaBuilder.createQuery(VeiculoModelo.class);
		Root<VeiculoModelo> rootVeiculoModelo = criteriaQuery.from(VeiculoModelo.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (veiculoModelo.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootVeiculoModelo.get("id"), veiculoModelo.getId()));
		}
		if (veiculoModelo.getModelo() != null && veiculoModelo.getModelo().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootVeiculoModelo.get("modelo"), "%" + veiculoModelo.getModelo() + "%"));
		}

		criteriaQuery.select(rootVeiculoModelo).where(predicates.toArray(new Predicate[] {}));

		List<VeiculoModelo> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(veiculoModelo);
		tx.commit();
		em.close();
	}
}
