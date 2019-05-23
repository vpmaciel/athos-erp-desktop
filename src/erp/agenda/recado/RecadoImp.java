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
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Recado.class, recado.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Recado> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Recado T order by T.data", Recado.class);
		@SuppressWarnings("unchecked")
		List<Recado> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Recado getRegistro(Recado recado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Recado.class, recado.getId());
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

	@Override
	public Collection<Recado> pesquisarRegistro(Recado recado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Recado> criteriaQuery = criteriaBuilder.createQuery(Recado.class);
		Root<Recado> rootRecado = criteriaQuery.from(Recado.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (naoEstaVazio(recado.getId())) {
			predicateList.add(criteriaBuilder.equal(rootRecado.get("id"), recado.getId()));
		}
		if (recado.getData() != null && !recado.getData().equals(Mascara.getData().getPlaceholder())
				&& !recado.getData().equals(Mascara.getDataVazio())) {
			predicateList.add(criteriaBuilder.like(rootRecado.get("data"), "%" + recado.getData() + "%"));
		}
		if (naoEstaVazio(recado.getDestinatario())) {
			predicateList
					.add(criteriaBuilder.like(rootRecado.get("destinatario"), "%" + recado.getDestinatario() + "%"));
		}
		if (naoEstaVazio(recado.getRecado())) {
			predicateList.add(criteriaBuilder.like(rootRecado.get("recado"), "%" + recado.getRecado() + "%"));
		}
		if (naoEstaVazio(recado.getRemetente())) {
			predicateList.add(criteriaBuilder.like(rootRecado.get("remetente"), "%" + recado.getRemetente() + "%"));
		}
		criteriaQuery.select(rootRecado).where(predicateList.toArray(new Predicate[] {}));

		List<Recado> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Recado recado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(recado);
		entityTransaction.commit();
		entityManager.close();
	}
}
