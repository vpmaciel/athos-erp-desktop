package erp.curriculo.testepersonalidade.a;

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

final class TesteAImp implements TesteADao {

	@Override
	public void deletarRegistro(TesteA testeA) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(TesteA.class, testeA.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<TesteA> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from TesteA T order T.id", TesteA.class);
		@SuppressWarnings("unchecked")
		List<TesteA> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public TesteA getRegistro(TesteA testeA) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(TesteA.class, testeA.getId());
	}

	@Override
	public Collection<TesteA> pesquisarRegistro(TesteA testeA) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TesteA> criteriaQuery = criteriaBuilder.createQuery(TesteA.class);
		Root<TesteA> rootCliente = criteriaQuery.from(TesteA.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (testeA.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("id"), testeA.getId()));
		}
		if (testeA.getFuncionario() != null && testeA.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), testeA.getFuncionario()));
		}
		if (testeA.getTotalOpcaoA() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("totalOpcaoA"), testeA.getTotalOpcaoA()));
		}
		if (testeA.getTotalOpcaoC() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("totalOpcaoC"), testeA.getTotalOpcaoC()));
		}
		if (testeA.getTotalOpcaoI() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("totalOpcaoI"), testeA.getTotalOpcaoI()));
		}
		if (testeA.getTotalOpcaoO() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("totalOpcaoO"), testeA.getTotalOpcaoO()));
		}
		
		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<TesteA> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(TesteA testeA) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(testeA);
		entityTransaction.commit();
		entityManager.close();
	}
}
