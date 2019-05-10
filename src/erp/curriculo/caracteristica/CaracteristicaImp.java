package erp.curriculo.caracteristica;

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

final class CaracteristicaImp implements CaracteristicaDao {

	@Override
	public void deletarRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Caracteristica.class, caracteristica.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Caracteristica> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Caracteristica T", Caracteristica.class);
		@SuppressWarnings("unchecked")
		List<Caracteristica> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Caracteristica getRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Caracteristica.class, caracteristica.getId());
	}

	@Override
	public Collection<Caracteristica> pesquisarRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Caracteristica> criteriaQuery = criteriaBuilder.createQuery(Caracteristica.class);
		Root<Caracteristica> rootCliente = criteriaQuery.from(Caracteristica.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (caracteristica.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("id"), caracteristica.getId()));
		}
		if (caracteristica.getFuncionario() != null && caracteristica.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), caracteristica.getFuncionario()));
		}
		if (caracteristica.getAdequado() != null && caracteristica.getAdequado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("adequado"), "%" + caracteristica.getAdequado() + "%"));
		}
		if (caracteristica.getAgil() != null && caracteristica.getAgil().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agil"), "%" + caracteristica.getAgil() + "%"));
		}
		if (caracteristica.getAgitado() != null && caracteristica.getAgitado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agitado"), "%" + caracteristica.getAgitado() + "%"));
		}
		if (caracteristica.getAlegre() != null && caracteristica.getAlegre().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("alegre"), "%" + caracteristica.getAlegre() + "%"));
		}
		if (caracteristica.getAmavel() != null && caracteristica.getAmavel().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("amavel"), "%" + caracteristica.getAmavel() + "%"));
		}
		if (caracteristica.getAnalitico() != null && caracteristica.getAnalitico().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("analitico"), "%" + caracteristica.getAnalitico() + "%"));
		}
		if (caracteristica.getAnimado() != null && caracteristica.getAnimado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("animado"), "%" + caracteristica.getAnimado() + "%"));
		}
		if (caracteristica.getAnsioso() != null && caracteristica.getAnsioso().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ansioso"), "%" + caracteristica.getAnsioso() + "%"));
		}
		if (caracteristica.getApatico() != null && caracteristica.getApatico().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("apatico"), "%" + caracteristica.getApatico() + "%"));
		}
		if (caracteristica.getArticulado() != null && caracteristica.getArticulado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("articulado"), "%" + caracteristica.getArticulado() + "%"));
		}
		if (caracteristica.getAssumeRiscosCalculados() != null
				&& caracteristica.getAssumeRiscosCalculados().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("assumeRiscosCalculados"),
					"%" + caracteristica.getAssumeRiscosCalculados() + "%"));
		}
		if (caracteristica.getAtencioso() != null && caracteristica.getAtencioso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("atencioso"), "%" + caracteristica.getAtencioso() + "%"));
		}
		if (caracteristica.getAtivo() != null && caracteristica.getAtivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ativo"), "%" + caracteristica.getAtivo() + "%"));
		}
		if (caracteristica.getAutoConfiante() != null && caracteristica.getAutoConfiante().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("autoConfiante"),
					"%" + caracteristica.getAutoConfiante() + "%"));
		}
		if (caracteristica.getAventureiro() != null && caracteristica.getAventureiro().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("aventureiro"), "%" + caracteristica.getAventureiro() + "%"));
		}
		if (caracteristica.getBemHumorado() != null && caracteristica.getBemHumorado().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("bemHumorado"), "%" + caracteristica.getBemHumorado() + "%"));
		}
		if (caracteristica.getCalmo() != null && caracteristica.getCalmo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("calmo"), "%" + caracteristica.getCalmo() + "%"));
		}
		if (caracteristica.getCarismatico() != null && caracteristica.getCarismatico().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("carismatico"), "%" + caracteristica.getCarismatico() + "%"));
		}
		if (caracteristica.getCauteloso() != null && caracteristica.getCauteloso().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("cauteloso"), "%" + caracteristica.getCauteloso() + "%"));
		}
		if (caracteristica.getCompetitivo() != null && caracteristica.getCompetitivo().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("competitivo"), "%" + caracteristica.getCompetitivo() + "%"));
		}
		if (caracteristica.getCompreensivo() != null && caracteristica.getCompreensivo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("compreensivo"),
					"%" + caracteristica.getCompreensivo() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Caracteristica> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(caracteristica);
		entityTransaction.commit();
		entityManager.close();
	}
}
