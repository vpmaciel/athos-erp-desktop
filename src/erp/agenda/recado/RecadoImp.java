package erp.agenda.recado;

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
import arquitetura.validacao.Mascara;

final class RecadoImp implements RecadoDao {

	@Override
	public void deletarRegistro(Recado recado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Recado.class, recado.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Recado getRegistro(Recado recado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Recado.class, recado.getId());
	}

	@Override
	public Collection<Recado> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.Recado C order by C.data");
		@SuppressWarnings("unchecked")
		List<Recado> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Recado> pesquisarRegistro(Recado recado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Recado> criteriaQuery = criteriaBuilder.createQuery(Recado.class);
		Root<Recado> rootRecado = criteriaQuery.from(Recado.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (recado.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootRecado.get("id"), recado.getId()));
		}
		if (recado.getData() != null && !recado.getData().equals(Mascara.getData().getPlaceholder()) && !recado.getData().equals(Mascara.getDataVazio())) {
			predicates.add(criteriaBuilder.like(rootRecado.get("data"), "%" + recado.getData() + "%"));
		}
		if (recado.getDestinatario() != null && recado.getDestinatario() != "") {
			predicates.add(criteriaBuilder.like(rootRecado.get("destinatario"), "%" + recado.getDestinatario() + "%"));
		}
		if (recado.getRecado() != null && recado.getRecado() != "") {
			predicates.add(criteriaBuilder.like(rootRecado.get("recado"), "%" + recado.getRecado() + "%"));
		}
		if (recado.getRemetente() != null && recado.getRemetente() != "") {
			predicates.add(criteriaBuilder.like(rootRecado.get("remetente"), "%" + recado.getRemetente() + "%"));
		}
		criteriaQuery.select(rootRecado).where(predicates.toArray(new Predicate[] {}));

		List<Recado> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Recado recado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(recado);
		tx.commit();
		em.close();
	}
}
