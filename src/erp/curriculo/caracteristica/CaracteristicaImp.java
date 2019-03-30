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
		em.remove(em.find(Caracteristica.class, caracteristica.getFuncionario()));
		tx.commit();
		em.close();
	}

	@Override
	public Caracteristica getRegistro(Caracteristica caracteristica) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Caracteristica.class, caracteristica.getFuncionario());
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

		if (caracteristica.getFuncionario() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), caracteristica.getFuncionario()));
		}
		if (caracteristica.getAdequado() != null && !caracteristica.getAdequado().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("adequado"), "%" + caracteristica.getAdequado() + "%"));
		}
		if (caracteristica.getAgil() != null && !caracteristica.getAgil().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agil"), "%" + caracteristica.getAgil() + "%"));
		}
		if (caracteristica.getAgitado() != null && !caracteristica.getAgitado().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("agitado"), "%" + caracteristica.getAgitado() + "%"));
		}
		if (caracteristica.getAlegre() != null && !caracteristica.getAlegre().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("alegre"), "%" + caracteristica.getAlegre() + "%"));
		}
		if (caracteristica.getAmavel() != null && !caracteristica.getAmavel().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("amavel"), "%" + caracteristica.getAmavel() + "%"));
		}
		if (caracteristica.getAnalitico() != null && !caracteristica.getAnalitico().equals("")) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("analitico"), "%" + caracteristica.getAnalitico() + "%"));
		}
		if (caracteristica.getAnimado() != null && !caracteristica.getAnimado().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("animado"), "%" + caracteristica.getAnimado() + "%"));
		}
		if (caracteristica.getAnsioso() != null && !caracteristica.getAnsioso().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("ansioso"), "%" + caracteristica.getAnsioso() + "%"));
		}
		if (caracteristica.getApatico() != null && !caracteristica.getApatico().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("apatico"), "%" + caracteristica.getApatico() + "%"));
		}
		if (caracteristica.getArticulado() != null && !caracteristica.getArticulado().equals("")) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("articulado"), "%" + caracteristica.getArticulado() + "%"));
		}
		if (caracteristica.getAssumeRiscosCalculados() != null
				&& !caracteristica.getAssumeRiscosCalculados().equals("")) {
			predicates.add(criteriaBuilder.like(rootCliente.get("assumeRiscosCalculados"),
					"%" + caracteristica.getAssumeRiscosCalculados() + "%"));
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
}
