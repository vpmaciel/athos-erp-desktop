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
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(TesteA.class, testeA.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Collection<TesteA> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.currriculo.testeA.TesteA C");
		@SuppressWarnings("unchecked")
		List<TesteA> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public TesteA getRegistro(TesteA testeA) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(TesteA.class, testeA.getId());
	}

	@Override
	public Collection<TesteA> pesquisarRegistro(TesteA testeA) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

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
		if (testeA.getAdequado() != null && testeA.getAdequado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("adequado"), "%" + testeA.getAdequado() + "%"));
		}
		if (testeA.getAgil() != null && testeA.getAgil().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agil"), "%" + testeA.getAgil() + "%"));
		}
		if (testeA.getAgitado() != null && testeA.getAgitado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agitado"), "%" + testeA.getAgitado() + "%"));
		}
		if (testeA.getAlegre() != null && testeA.getAlegre().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("alegre"), "%" + testeA.getAlegre() + "%"));
		}
		if (testeA.getAmavel() != null && testeA.getAmavel().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("amavel"), "%" + testeA.getAmavel() + "%"));
		}
		if (testeA.getAnalitico() != null && testeA.getAnalitico().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("analitico"), "%" + testeA.getAnalitico() + "%"));
		}
		if (testeA.getAnimado() != null && testeA.getAnimado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("animado"), "%" + testeA.getAnimado() + "%"));
		}
		if (testeA.getAnsioso() != null && testeA.getAnsioso().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ansioso"), "%" + testeA.getAnsioso() + "%"));
		}
		if (testeA.getApatico() != null && testeA.getApatico().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("apatico"), "%" + testeA.getApatico() + "%"));
		}
		if (testeA.getArticulado() != null && testeA.getArticulado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("articulado"), "%" + testeA.getArticulado() + "%"));
		}
		if (testeA.getAssumeRiscosCalculados() != null
				&& testeA.getAssumeRiscosCalculados().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("assumeRiscosCalculados"),
					"%" + testeA.getAssumeRiscosCalculados() + "%"));
		}
		if (testeA.getAtencioso() != null && testeA.getAtencioso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("atencioso"), "%" + testeA.getAtencioso() + "%"));
		}
		if (testeA.getAtivo() != null && testeA.getAtivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ativo"), "%" + testeA.getAtivo() + "%"));
		}
		if (testeA.getAutoConfiante() != null && testeA.getAutoConfiante().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("autoConfiante"),
					"%" + testeA.getAutoConfiante() + "%"));
		}
		if (testeA.getAventureiro() != null && testeA.getAventureiro().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("aventureiro"), "%" + testeA.getAventureiro() + "%"));
		}
		if (testeA.getBemHumorado() != null && testeA.getBemHumorado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("bemHumorado"), "%" + testeA.getBemHumorado() + "%"));
		}
		if (testeA.getCalmo() != null && testeA.getCalmo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("calmo"), "%" + testeA.getCalmo() + "%"));
		}
		if (testeA.getCarismatico() != null && testeA.getCarismatico().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("carismatico"), "%" + testeA.getCarismatico() + "%"));
		}
		if (testeA.getCauteloso() != null && testeA.getCauteloso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("cauteloso"), "%" + testeA.getCauteloso() + "%"));
		}
		if (testeA.getCompetitivo() != null && testeA.getCompetitivo().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("competitivo"), "%" + testeA.getCompetitivo() + "%"));
		}
		if (testeA.getCompreensivo() != null && testeA.getCompreensivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("compreensivo"),
					"%" + testeA.getCompreensivo() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<TesteA> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(TesteA testeA) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(testeA);
		tx.commit();
		em.close();
	}
}
