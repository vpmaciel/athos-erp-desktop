package erp.agenda.evento;

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

final class EventoImp implements EventoDao {

	@Override
	public void deletarRegistro(Evento evento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Evento.class, evento.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Evento> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Evento T order by T.data, T.horaInicio", Evento.class);
		@SuppressWarnings("unchecked")
		List<Evento> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Evento getRegistro(Evento evento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Evento.class, evento.getId());
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
	public Collection<Evento> pesquisarRegistro(Evento evento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Evento> criteriaQuery = criteriaBuilder.createQuery(Evento.class);
		Root<Evento> rootEvento = criteriaQuery.from(Evento.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (naoEstaVazio(evento.getId())) {
			predicates.add(criteriaBuilder.equal(rootEvento.get("id"), evento.getId()));
		}
		if (evento.getData() != null && !evento.getData().equals(Mascara.getData().getPlaceholder())
				&& !evento.getData().equals(Mascara.getDataVazio())) {
			predicates.add(criteriaBuilder.like(rootEvento.get("data"), "%" + evento.getData() + "%"));
		}
		if (naoEstaVazio(evento.getDescricao())) {
			predicates.add(criteriaBuilder.like(rootEvento.get("descricao"), "%" + evento.getDescricao() + "%"));
		}
		if (evento.getHoraInicio() != null && !evento.getHoraInicio().equals(Mascara.getHora().getPlaceholder())
				&& !evento.getHoraInicio().equals(Mascara.getHoraVazio())) {
			predicates.add(criteriaBuilder.like(rootEvento.get("horaInicio"), "%" + evento.getHoraInicio() + "%"));
		}
		if (evento.getHoraTermino() != null && !evento.getHoraTermino().equals(Mascara.getHora().getPlaceholder())
				&& !evento.getHoraTermino().equals(Mascara.getHoraVazio())) {
			predicates.add(criteriaBuilder.like(rootEvento.get("horaTermino"), "%" + evento.getHoraTermino() + "%"));
		}
		if (evento.getTipoEvento() != null && evento.getTipoEvento().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootEvento.get("tipoEvento"), evento.getTipoEvento()));
		}

		criteriaQuery.select(rootEvento).where(predicates.toArray(new Predicate[] {}));

		List<Evento> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Evento evento) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(evento);
		entityTransaction.commit();
		entityManager.close();
	}
}