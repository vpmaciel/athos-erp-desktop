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
	public VeiculoMarca consultarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

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
		entityTransaction.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new VeiculoMarca();
	}

	@Override
	public void deletarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(VeiculoMarca.class, veiculoMarca.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<VeiculoMarca> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from VeiculoMarca T order by T.marca", VeiculoMarca.class);
		@SuppressWarnings("unchecked")
		List<VeiculoMarca> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public VeiculoMarca getRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(VeiculoMarca.class, veiculoMarca.getId());
	}

	@Override
	public Collection<VeiculoMarca> pesquisarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

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
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(VeiculoMarca veiculoMarca) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(veiculoMarca);
		entityTransaction.commit();
		entityManager.close();
	}
}
