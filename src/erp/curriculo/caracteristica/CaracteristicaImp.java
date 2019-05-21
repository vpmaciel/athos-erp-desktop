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
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Caracteristica.class, caracteristica.getId()));
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
	public Collection<Caracteristica> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Caracteristica> caracteristicaList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Caracteristica T order by T.funcionario", Caracteristica.class);
			caracteristicaList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return caracteristicaList;
	}

	@Override
	public Caracteristica getRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			caracteristica = entityManager.find(Caracteristica.class, caracteristica.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return caracteristica;
	}

	@Override
	public Collection<Caracteristica> pesquisarRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Caracteristica> caracteristicaList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Caracteristica> criteriaQuery = criteriaBuilder.createQuery(Caracteristica.class);
			Root<Caracteristica> rootCaracteristica = criteriaQuery.from(Caracteristica.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();


			if (caracteristica.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootCaracteristica.get("id"), caracteristica.getId()));
			}
			if (caracteristica.getFuncionario() != null && caracteristica.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootCaracteristica.get("funcionario"), caracteristica.getFuncionario()));
			}
			if (caracteristica.getAdequado() != null && caracteristica.getAdequado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("adequado"), "%" + caracteristica.getAdequado() + "%"));
			}
			if (caracteristica.getAgil() != null && caracteristica.getAgil().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("agil"), "%" + caracteristica.getAgil() + "%"));
			}
			if (caracteristica.getAgitado() != null && caracteristica.getAgitado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("agitado"), "%" + caracteristica.getAgitado() + "%"));
			}
			if (caracteristica.getAlegre() != null && caracteristica.getAlegre().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("alegre"), "%" + caracteristica.getAlegre() + "%"));
			}
			if (caracteristica.getAmavel() != null && caracteristica.getAmavel().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("amavel"), "%" + caracteristica.getAmavel() + "%"));
			}
			if (caracteristica.getAnalitico() != null && caracteristica.getAnalitico().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootCaracteristica.get("analitico"), "%" + caracteristica.getAnalitico() + "%"));
			}
			if (caracteristica.getAnimado() != null && caracteristica.getAnimado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("animado"), "%" + caracteristica.getAnimado() + "%"));
			}
			if (caracteristica.getAnsioso() != null && caracteristica.getAnsioso().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("ansioso"), "%" + caracteristica.getAnsioso() + "%"));
			}
			if (caracteristica.getApatico() != null && caracteristica.getApatico().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("apatico"), "%" + caracteristica.getApatico() + "%"));
			}
			if (caracteristica.getArticulado() != null && caracteristica.getArticulado().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootCaracteristica.get("articulado"), "%" + caracteristica.getArticulado() + "%"));
			}
			if (caracteristica.getAssumeRiscosCalculados() != null
					&& caracteristica.getAssumeRiscosCalculados().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("assumeRiscosCalculados"),
						"%" + caracteristica.getAssumeRiscosCalculados() + "%"));
			}
			if (caracteristica.getAtencioso() != null && caracteristica.getAtencioso().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootCaracteristica.get("atencioso"), "%" + caracteristica.getAtencioso() + "%"));
			}
			if (caracteristica.getAtivo() != null && caracteristica.getAtivo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("ativo"), "%" + caracteristica.getAtivo() + "%"));
			}
			if (caracteristica.getAutoConfiante() != null && caracteristica.getAutoConfiante().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("autoConfiante"),
						"%" + caracteristica.getAutoConfiante() + "%"));
			}
			if (caracteristica.getAventureiro() != null && caracteristica.getAventureiro().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootCaracteristica.get("aventureiro"), "%" + caracteristica.getAventureiro() + "%"));
			}
			if (caracteristica.getBemHumorado() != null && caracteristica.getBemHumorado().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootCaracteristica.get("bemHumorado"), "%" + caracteristica.getBemHumorado() + "%"));
			}
			if (caracteristica.getCalmo() != null && caracteristica.getCalmo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("calmo"), "%" + caracteristica.getCalmo() + "%"));
			}
			if (caracteristica.getCarismatico() != null && caracteristica.getCarismatico().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootCaracteristica.get("carismatico"), "%" + caracteristica.getCarismatico() + "%"));
			}
			if (caracteristica.getCauteloso() != null && caracteristica.getCauteloso().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootCaracteristica.get("cauteloso"), "%" + caracteristica.getCauteloso() + "%"));
			}
			if (caracteristica.getCompetitivo() != null && caracteristica.getCompetitivo().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootCaracteristica.get("competitivo"), "%" + caracteristica.getCompetitivo() + "%"));
			}
			if (caracteristica.getCompreensivo() != null && caracteristica.getCompreensivo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCaracteristica.get("compreensivo"),
						"%" + caracteristica.getCompreensivo() + "%"));
			}

			criteriaQuery.select(rootCaracteristica).where(predicateList.toArray(new Predicate[] {}));
			caracteristicaList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return caracteristicaList;
	}

	@Override
	public void salvarRegistro(Caracteristica caracteristica) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(caracteristica);
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