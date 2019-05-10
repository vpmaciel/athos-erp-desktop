package erp.agenda.evento.tipoevento;

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

final class TipoEventoImp implements TipoEventoDao {

	@Override
	public TipoEvento consultarRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TipoEvento> criteriaQuery = criteriaBuilder.createQuery(TipoEvento.class);
		Root<TipoEvento> rootTipoEvento = criteriaQuery.from(TipoEvento.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (tipoEvento.getNome() != null && tipoEvento.getNome().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootTipoEvento.get("nome"), tipoEvento.getNome()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new TipoEvento();
		}

		criteriaQuery.select(rootTipoEvento).where(predicates.toArray(new Predicate[] {}));

		List<TipoEvento> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new TipoEvento();
	}

	@Override
	public void deletarRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(TipoEvento.class, tipoEvento.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<TipoEvento> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from TipoEvento T order by T.nome", TipoEvento.class);
		@SuppressWarnings("unchecked")
		List<TipoEvento> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public TipoEvento getRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(TipoEvento.class, tipoEvento.getId());
	}

	@Override
	public Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TipoEvento> criteriaQuery = criteriaBuilder.createQuery(TipoEvento.class);
		Root<TipoEvento> rootTipoEvento = criteriaQuery.from(TipoEvento.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (tipoEvento.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootTipoEvento.get("id"), tipoEvento.getId()));
		}

		if (tipoEvento.getNome() != null && tipoEvento.getNome().length() > 0) {
			predicates.add(criteriaBuilder.like(rootTipoEvento.get("nome"), "%" + tipoEvento.getNome() + "%"));
		}

		criteriaQuery.select(rootTipoEvento).where(predicates.toArray(new Predicate[] {}));

		List<TipoEvento> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(TipoEvento tipoEvento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(tipoEvento);
		entityTransaction.commit();
		entityManager.close();
	}
}
