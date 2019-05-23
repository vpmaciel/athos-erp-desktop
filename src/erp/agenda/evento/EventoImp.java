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
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Evento.class, evento.getId()));
			entityTransaction.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			entityTransaction.rollback();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Evento> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Evento> list = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Evento T order by T.data, T.horaInicio",
					Evento.class);
			list = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

		return list;
	}

	@Override
	public Evento getRegistro(Evento evento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			evento = entityManager.find(Evento.class, evento.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return evento;
	}

	@Override
	public Collection<Evento> pesquisarRegistro(Evento evento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Evento> eventoList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Evento> criteriaQuery = criteriaBuilder.createQuery(Evento.class);
			Root<Evento> rootEvento = criteriaQuery.from(Evento.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (evento.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootEvento.get("id"), evento.getId()));
			}
			if (evento.getData() != null && !evento.getData().equals(Mascara.getData().getPlaceholder())
					&& !evento.getData().equals(Mascara.getDataVazio())) {
				predicateList.add(criteriaBuilder.like(rootEvento.get("data"), "%" + evento.getData() + "%"));
			}
			if (evento.getDescricao() != null && evento.getDescricao().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootEvento.get("descricao"), "%" + evento.getDescricao() + "%"));
			}
			if (evento.getHoraInicio() != null && !evento.getHoraInicio().equals(Mascara.getHora().getPlaceholder())
					&& !evento.getHoraInicio().equals(Mascara.getHoraVazio())) {
				predicateList
						.add(criteriaBuilder.like(rootEvento.get("horaInicio"), "%" + evento.getHoraInicio() + "%"));
			}
			if (evento.getHoraTermino() != null && !evento.getHoraTermino().equals(Mascara.getHora().getPlaceholder())
					&& !evento.getHoraTermino().equals(Mascara.getHoraVazio())) {
				predicateList
						.add(criteriaBuilder.like(rootEvento.get("horaTermino"), "%" + evento.getHoraTermino() + "%"));
			}
			if (evento.getTipoEvento() != null && evento.getTipoEvento().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootEvento.get("tipoEvento"), evento.getTipoEvento()));
			}
			criteriaQuery.select(rootEvento).where(predicateList.toArray(new Predicate[] {}));
			eventoList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return eventoList;
	}

	@Override
	public void salvarRegistro(Evento evento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(evento);
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

}