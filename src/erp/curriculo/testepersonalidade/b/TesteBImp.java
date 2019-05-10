package erp.curriculo.testepersonalidade.b;

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

final class TesteBImp implements TesteBDao {

	@Override
	public void deletarRegistro(TesteB testeB) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(TesteB.class, testeB.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<TesteB> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from TesteB T order by T.id", TesteB.class);
		@SuppressWarnings("unchecked")
		List<TesteB> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public TesteB getRegistro(TesteB testeB) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(TesteB.class, testeB.getId());
	}

	@Override
	public Collection<TesteB> pesquisarRegistro(TesteB testeB) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TesteB> criteriaQuery = criteriaBuilder.createQuery(TesteB.class);
		Root<TesteB> rootCliente = criteriaQuery.from(TesteB.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (testeB.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("id"), testeB.getId()));
		}
		if (testeB.getFuncionario() != null && testeB.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), testeB.getFuncionario()));
		}
		if (testeB.getAdequado() != null && testeB.getAdequado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("adequado"), "%" + testeB.getAdequado() + "%"));
		}
		if (testeB.getAgil() != null && testeB.getAgil().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agil"), "%" + testeB.getAgil() + "%"));
		}
		if (testeB.getAgitado() != null && testeB.getAgitado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agitado"), "%" + testeB.getAgitado() + "%"));
		}
		if (testeB.getAlegre() != null && testeB.getAlegre().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("alegre"), "%" + testeB.getAlegre() + "%"));
		}
		if (testeB.getAmavel() != null && testeB.getAmavel().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("amavel"), "%" + testeB.getAmavel() + "%"));
		}
		if (testeB.getAnalitico() != null && testeB.getAnalitico().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("analitico"), "%" + testeB.getAnalitico() + "%"));
		}
		if (testeB.getAnimado() != null && testeB.getAnimado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("animado"), "%" + testeB.getAnimado() + "%"));
		}
		if (testeB.getAnsioso() != null && testeB.getAnsioso().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ansioso"), "%" + testeB.getAnsioso() + "%"));
		}
		if (testeB.getApatico() != null && testeB.getApatico().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("apatico"), "%" + testeB.getApatico() + "%"));
		}
		if (testeB.getArticulado() != null && testeB.getArticulado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("articulado"), "%" + testeB.getArticulado() + "%"));
		}
		if (testeB.getAssumeRiscosCalculados() != null
				&& testeB.getAssumeRiscosCalculados().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("assumeRiscosCalculados"),
					"%" + testeB.getAssumeRiscosCalculados() + "%"));
		}
		if (testeB.getAtencioso() != null && testeB.getAtencioso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("atencioso"), "%" + testeB.getAtencioso() + "%"));
		}
		if (testeB.getAtivo() != null && testeB.getAtivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ativo"), "%" + testeB.getAtivo() + "%"));
		}
		if (testeB.getAutoConfiante() != null && testeB.getAutoConfiante().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("autoConfiante"),
					"%" + testeB.getAutoConfiante() + "%"));
		}
		if (testeB.getAventureiro() != null && testeB.getAventureiro().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("aventureiro"), "%" + testeB.getAventureiro() + "%"));
		}
		if (testeB.getBemHumorado() != null && testeB.getBemHumorado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("bemHumorado"), "%" + testeB.getBemHumorado() + "%"));
		}
		if (testeB.getCalmo() != null && testeB.getCalmo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("calmo"), "%" + testeB.getCalmo() + "%"));
		}
		if (testeB.getCarismatico() != null && testeB.getCarismatico().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("carismatico"), "%" + testeB.getCarismatico() + "%"));
		}
		if (testeB.getCauteloso() != null && testeB.getCauteloso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("cauteloso"), "%" + testeB.getCauteloso() + "%"));
		}
		if (testeB.getCompetitivo() != null && testeB.getCompetitivo().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("competitivo"), "%" + testeB.getCompetitivo() + "%"));
		}
		if (testeB.getCompreensivo() != null && testeB.getCompreensivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("compreensivo"),
					"%" + testeB.getCompreensivo() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<TesteB> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(TesteB testeB) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(testeB);
		entityTransaction.commit();
		entityManager.close();
	}
}
