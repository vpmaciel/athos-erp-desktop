package erp.banco;

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

final class BancoImp implements BancoDao {

	@Override
	public Banco consultarRegistro(Banco banco) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Banco> criteriaQuery = criteriaBuilder.createQuery(Banco.class);
		Root<Banco> rootBanco = criteriaQuery.from(Banco.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (banco.getNome() != null && banco.getNome().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootBanco.get("nome"), banco.getNome()));
			naoTemCriterio = false;
		}
		if (banco.getCodigo() != null && banco.getCodigo().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootBanco.get("codigo"), banco.getCodigo()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new Banco();
		}

		criteriaQuery.select(rootBanco).where(predicates.toArray(new Predicate[] {}));

		List<Banco> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new Banco();
	}

	@Override
	public void deletarRegistro(Banco banco) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Banco.class, banco.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Banco> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Banco T order by T.nome", Banco.class);
		@SuppressWarnings("unchecked")
		List<Banco> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Banco getRegistro(Banco banco) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Banco.class, banco.getId());
	}

	@Override
	public Collection<Banco> pesquisarRegistro(Banco banco) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Banco> criteriaQuery = criteriaBuilder.createQuery(Banco.class);
		Root<Banco> rootBanco = criteriaQuery.from(Banco.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (banco.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootBanco.get("id"), banco.getId()));
		}
		if (banco.getNome() != null && banco.getNome().length() > 0) {
			predicates.add(criteriaBuilder.like(rootBanco.get("nome"), "%" + banco.getNome() + "%"));
		}
		if (banco.getCodigo() != null && banco.getCodigo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootBanco.get("codigo"), "%" + banco.getCodigo() + "%"));
		}

		criteriaQuery.select(rootBanco).where(predicates.toArray(new Predicate[] {}));

		List<Banco> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Banco banco) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(banco);
		entityTransaction.commit();
		entityManager.close();
	}
}
