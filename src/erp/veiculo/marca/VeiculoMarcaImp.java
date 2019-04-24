package erp.veiculo.marca;

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

final class VeiculoMarcaImp implements VeiculoMarcaDao {

	@Override
	public void deletarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(VeiculoMarca.class, veiculoMarca.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public VeiculoMarca getRegistro(VeiculoMarca veiculoMarca) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(VeiculoMarca.class, veiculoMarca.getId());
	}

	@Override
	public Collection<VeiculoMarca> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.veiculo.marca.VeiculoMarca C order by C.marca");
		@SuppressWarnings("unchecked")
		List<VeiculoMarca> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VeiculoMarca> criteriaQuery = criteriaBuilder.createQuery(VeiculoMarca.class);
		Root<VeiculoMarca> rootVeiculoMarca = criteriaQuery.from(VeiculoMarca.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (veiculoMarca.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootVeiculoMarca.get("id"), veiculoMarca.getId()));
		}
		if (veiculoMarca.getMarca() != null && veiculoMarca.getMarca().length() > 0) {
			predicates.add(criteriaBuilder.like(rootVeiculoMarca.get("marca"), "%" + veiculoMarca.getMarca() + "%"));
		}

		criteriaQuery.select(rootVeiculoMarca).where(predicates.toArray(new Predicate[] {}));

		List<VeiculoMarca> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public VeiculoMarca consultarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VeiculoMarca> criteriaQuery = criteriaBuilder.createQuery(VeiculoMarca.class);
		Root<VeiculoMarca> rootVeiculoMarca = criteriaQuery.from(VeiculoMarca.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		naoTemCriterio = false;

	if (naoTemCriterio) {
		return new VeiculoMarca();
	}

		if (veiculoMarca.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootVeiculoMarca.get("id"), veiculoMarca.getId()));
		}

		if (veiculoMarca.getMarca() != null && veiculoMarca.getMarca().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootVeiculoMarca.get("marca"), veiculoMarca.getMarca()));
		}
		
		criteriaQuery.select(rootVeiculoMarca).where(predicates.toArray(new Predicate[] {}));

		List<VeiculoMarca> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new VeiculoMarca();
	}

	@Override
	public void salvarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(veiculoMarca);
		tx.commit();
		em.close();
	}
}
