package erp.banco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import arquitetura.JPA;

final class BancoImp implements BancoDao {

	@Override
	public void deletarRegistro(Banco banco) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Banco.class, banco.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Banco getRegistro(Banco banco) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Banco.class, banco.getId());
	}

	@Override
	public Collection<Banco> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
		criteria.from(Banco.class);
		List<Banco> list = em.createQuery(criteria).getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Banco> pesquisarRegistro(Banco banco) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

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
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public boolean consultarRegistro(Banco banco) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

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
		
		if(naoTemCriterio) {
			return false;
		}

		criteriaQuery.select(rootBanco).where(predicates.toArray(new Predicate[] {}));

		List<Banco> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list.size() > 0;
	}

	@Override
	public void salvarRegistro(Banco banco) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(banco);
		tx.commit();
		em.close();
	}
}
