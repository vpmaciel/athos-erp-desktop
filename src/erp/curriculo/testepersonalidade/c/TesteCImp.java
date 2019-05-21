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
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TesteC.class, testeC.getId()));
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
	public Collection<TesteC> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteC> testeCList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TesteC T order by T.funcionario", TesteC.class);
			testeCList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeCList;
	}

	@Override
	public TesteC getRegistro(TesteC testeC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testeC = entityManager.find(TesteC.class, testeC.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeC;
	}

	@Override
	public Collection<TesteC> pesquisarRegistro(TesteC testeC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteC> testeCList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TesteC> criteriaQuery = criteriaBuilder.createQuery(TesteC.class);
			Root<TesteC> rootTesteC = criteriaQuery.from(TesteC.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (testeC.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteC.get("id"), testeC.getId()));
			}
			if (testeC.getFuncionario() != null && testeC.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteC.get("funcionario"), testeC.getFuncionario()));
			}
			if (testeC.getAdequado() != null && testeC.getAdequado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("adequado"), "%" + testeC.getAdequado() + "%"));
			}
			if (testeC.getAgil() != null && testeC.getAgil().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("agil"), "%" + testeC.getAgil() + "%"));
			}
			if (testeC.getAgitado() != null && testeC.getAgitado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("agitado"), "%" + testeC.getAgitado() + "%"));
			}
			if (testeC.getAlegre() != null && testeC.getAlegre().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("alegre"), "%" + testeC.getAlegre() + "%"));
			}
			if (testeC.getAmavel() != null && testeC.getAmavel().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("amavel"), "%" + testeC.getAmavel() + "%"));
			}
			if (testeC.getAnalitico() != null && testeC.getAnalitico().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteC.get("analitico"), "%" + testeC.getAnalitico() + "%"));
			}
			if (testeC.getAnimado() != null && testeC.getAnimado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("animado"), "%" + testeC.getAnimado() + "%"));
			}
			if (testeC.getAnsioso() != null && testeC.getAnsioso().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("ansioso"), "%" + testeC.getAnsioso() + "%"));
			}
			if (testeC.getApatico() != null && testeC.getApatico().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("apatico"), "%" + testeC.getApatico() + "%"));
			}
			if (testeC.getArticulado() != null && testeC.getArticulado().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootTesteC.get("articulado"), "%" + testeC.getArticulado() + "%"));
			}
			if (testeC.getAssumeRiscosCalculados() != null
					&& testeC.getAssumeRiscosCalculados().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("assumeRiscosCalculados"),
						"%" + testeC.getAssumeRiscosCalculados() + "%"));
			}
			if (testeC.getAtencioso() != null && testeC.getAtencioso().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteC.get("atencioso"), "%" + testeC.getAtencioso() + "%"));
			}
			if (testeC.getAtivo() != null && testeC.getAtivo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("ativo"), "%" + testeC.getAtivo() + "%"));
			}
			if (testeC.getAutoConfiante() != null && testeC.getAutoConfiante().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("autoConfiante"),
						"%" + testeC.getAutoConfiante() + "%"));
			}
			if (testeC.getAventureiro() != null && testeC.getAventureiro().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootTesteC.get("aventureiro"), "%" + testeC.getAventureiro() + "%"));
			}
			if (testeC.getBemHumorado() != null && testeC.getBemHumorado().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootTesteC.get("bemHumorado"), "%" + testeC.getBemHumorado() + "%"));
			}
			if (testeC.getCalmo() != null && testeC.getCalmo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("calmo"), "%" + testeC.getCalmo() + "%"));
			}
			if (testeC.getCarismatico() != null && testeC.getCarismatico().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootTesteC.get("carismatico"), "%" + testeC.getCarismatico() + "%"));
			}
			if (testeC.getCauteloso() != null && testeC.getCauteloso().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteC.get("cauteloso"), "%" + testeC.getCauteloso() + "%"));
			}
			if (testeC.getCompetitivo() != null && testeC.getCompetitivo().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootTesteC.get("competitivo"), "%" + testeC.getCompetitivo() + "%"));
			}
			if (testeC.getCompreensivo() != null && testeC.getCompreensivo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteC.get("compreensivo"),
						"%" + testeC.getCompreensivo() + "%"));
			}


			criteriaQuery.select(rootTesteC).where(predicateList.toArray(new Predicate[] {}));
			testeCList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeCList;
	}

	@Override
	public void salvarRegistro(TesteC testeC) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testeC);
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