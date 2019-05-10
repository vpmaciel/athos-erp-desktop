package erp.curriculo.testepersonalidade.c;

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

final class TesteCImp implements TesteCDao {

	@Override
	public void deletarRegistro(TesteC testeC) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(TesteC.class, testeC.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<TesteC> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from TesteC T order by T.id", TesteC.class);
		@SuppressWarnings("unchecked")
		List<TesteC> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public TesteC getRegistro(TesteC testeC) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(TesteC.class, testeC.getId());
	}

	@Override
	public Collection<TesteC> pesquisarRegistro(TesteC testeC) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TesteC> criteriaQuery = criteriaBuilder.createQuery(TesteC.class);
		Root<TesteC> rootCliente = criteriaQuery.from(TesteC.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (testeC.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("id"), testeC.getId()));
		}
		if (testeC.getFuncionario() != null && testeC.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), testeC.getFuncionario()));
		}
		if (testeC.getAdequado() != null && testeC.getAdequado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("adequado"), "%" + testeC.getAdequado() + "%"));
		}
		if (testeC.getAgil() != null && testeC.getAgil().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agil"), "%" + testeC.getAgil() + "%"));
		}
		if (testeC.getAgitado() != null && testeC.getAgitado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agitado"), "%" + testeC.getAgitado() + "%"));
		}
		if (testeC.getAlegre() != null && testeC.getAlegre().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("alegre"), "%" + testeC.getAlegre() + "%"));
		}
		if (testeC.getAmavel() != null && testeC.getAmavel().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("amavel"), "%" + testeC.getAmavel() + "%"));
		}
		if (testeC.getAnalitico() != null && testeC.getAnalitico().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("analitico"), "%" + testeC.getAnalitico() + "%"));
		}
		if (testeC.getAnimado() != null && testeC.getAnimado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("animado"), "%" + testeC.getAnimado() + "%"));
		}
		if (testeC.getAnsioso() != null && testeC.getAnsioso().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ansioso"), "%" + testeC.getAnsioso() + "%"));
		}
		if (testeC.getApatico() != null && testeC.getApatico().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("apatico"), "%" + testeC.getApatico() + "%"));
		}
		if (testeC.getArticulado() != null && testeC.getArticulado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("articulado"), "%" + testeC.getArticulado() + "%"));
		}
		if (testeC.getAssumeRiscosCalculados() != null
				&& testeC.getAssumeRiscosCalculados().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("assumeRiscosCalculados"),
					"%" + testeC.getAssumeRiscosCalculados() + "%"));
		}
		if (testeC.getAtencioso() != null && testeC.getAtencioso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("atencioso"), "%" + testeC.getAtencioso() + "%"));
		}
		if (testeC.getAtivo() != null && testeC.getAtivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ativo"), "%" + testeC.getAtivo() + "%"));
		}
		if (testeC.getAutoConfiante() != null && testeC.getAutoConfiante().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("autoConfiante"),
					"%" + testeC.getAutoConfiante() + "%"));
		}
		if (testeC.getAventureiro() != null && testeC.getAventureiro().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("aventureiro"), "%" + testeC.getAventureiro() + "%"));
		}
		if (testeC.getBemHumorado() != null && testeC.getBemHumorado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("bemHumorado"), "%" + testeC.getBemHumorado() + "%"));
		}
		if (testeC.getCalmo() != null && testeC.getCalmo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("calmo"), "%" + testeC.getCalmo() + "%"));
		}
		if (testeC.getCarismatico() != null && testeC.getCarismatico().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("carismatico"), "%" + testeC.getCarismatico() + "%"));
		}
		if (testeC.getCauteloso() != null && testeC.getCauteloso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("cauteloso"), "%" + testeC.getCauteloso() + "%"));
		}
		if (testeC.getCompetitivo() != null && testeC.getCompetitivo().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("competitivo"), "%" + testeC.getCompetitivo() + "%"));
		}
		if (testeC.getCompreensivo() != null && testeC.getCompreensivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("compreensivo"),
					"%" + testeC.getCompreensivo() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<TesteC> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(TesteC testeC) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(testeC);
		entityTransaction.commit();
		entityManager.close();
	}
}
