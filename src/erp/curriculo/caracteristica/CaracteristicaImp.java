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
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Caracteristica.class, caracteristica.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Caracteristica getRegistro(Caracteristica caracteristica) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Caracteristica.class, caracteristica.getId());
	}

	@Override
	public Collection<Caracteristica> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.currriculo.caracteristica.Caracteristica C");
		@SuppressWarnings("unchecked")
		List<Caracteristica> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Caracteristica> pesquisarRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Caracteristica> criteriaQuery = criteriaBuilder.createQuery(Caracteristica.class);
		Root<Caracteristica> rootCliente = criteriaQuery.from(Caracteristica.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (naoEstaVazio(caracteristica.getFuncionario())) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), caracteristica.getFuncionario()));
		}
		if (naoEstaVazio(caracteristica.getAdequado())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("adequado"), "%" + caracteristica.getAdequado() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAgil())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agil"), "%" + caracteristica.getAgil() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAgitado())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agitado"), "%" + caracteristica.getAgitado() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAlegre())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("alegre"), "%" + caracteristica.getAlegre() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAmavel())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("amavel"), "%" + caracteristica.getAmavel() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAnalitico())) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("analitico"), "%" + caracteristica.getAnalitico() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAnimado())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("animado"), "%" + caracteristica.getAnimado() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAnsioso())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ansioso"), "%" + caracteristica.getAnsioso() + "%"));
		}
		if (naoEstaVazio(caracteristica.getApatico())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("apatico"), "%" + caracteristica.getApatico() + "%"));
		}
		if (naoEstaVazio(caracteristica.getArticulado())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("articulado"), "%" + caracteristica.getArticulado() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAssumeRiscosCalculados())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("assumeRiscosCalculados"),
					"%" + caracteristica.getAssumeRiscosCalculados() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAtencioso())) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("atencioso"), "%" + caracteristica.getAtencioso() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAtivo())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ativo"), "%" + caracteristica.getAtivo() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAutoConfiante())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("autoConfiante"),
					"%" + caracteristica.getAutoConfiante() + "%"));
		}
		if (naoEstaVazio(caracteristica.getAventureiro())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("aventureiro"), "%" + caracteristica.getAventureiro() + "%"));
		}
		if (naoEstaVazio(caracteristica.getBemHumorado())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("bemHumorado"), "%" + caracteristica.getBemHumorado() + "%"));
		}
		if (naoEstaVazio(caracteristica.getCalmo())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("calmo"), "%" + caracteristica.getCalmo() + "%"));
		}
		if (naoEstaVazio(caracteristica.getCarismatico())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("carismatico"), "%" + caracteristica.getCarismatico() + "%"));
		}
		if (naoEstaVazio(caracteristica.getCauteloso())) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("cauteloso"), "%" + caracteristica.getCauteloso() + "%"));
		}
		if (naoEstaVazio(caracteristica.getCompetitivo())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("competitivo"), "%" + caracteristica.getCompetitivo() + "%"));
		}
		if (naoEstaVazio(caracteristica.getCompreensivo())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("compreensivo"),
					"%" + caracteristica.getCompreensivo() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Caracteristica> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvar(Caracteristica caracteristica) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(caracteristica);
		tx.commit();
		em.close();
	}

	private boolean naoEstaVazio(Object objeto) {
		if (objeto == null) {
			return false;
		}
		if (objeto.toString().equals("")) {
			return false;
		}
		return true;
	}
}
