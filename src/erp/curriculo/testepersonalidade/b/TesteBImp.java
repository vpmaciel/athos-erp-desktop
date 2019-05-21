package erp.curriculo.testepersonalidade.b;

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

final class TesteBImp implements TesteBDao {

	@Override
	public void deletarRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(TesteB.class, testeB.getId()));
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
	public Collection<TesteB> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteB> testeBList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from TesteB T order by T.funcionario", TesteB.class);
			testeBList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeBList;
	}

	@Override
	public TesteB getRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			testeB = entityManager.find(TesteB.class, testeB.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeB;
	}

	@Override
	public Collection<TesteB> pesquisarRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<TesteB> testeBList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TesteB> criteriaQuery = criteriaBuilder.createQuery(TesteB.class);
			Root<TesteB> rootTesteB = criteriaQuery.from(TesteB.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (testeB.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteB.get("id"), testeB.getId()));
			}
			if (testeB.getFuncionario() != null && testeB.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootTesteB.get("funcionario"), testeB.getFuncionario()));
			}
			if (testeB.getAdequado() != null && testeB.getAdequado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("adequado"), "%" + testeB.getAdequado() + "%"));
			}
			if (testeB.getAgil() != null && testeB.getAgil().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("agil"), "%" + testeB.getAgil() + "%"));
			}
			if (testeB.getAgitado() != null && testeB.getAgitado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("agitado"), "%" + testeB.getAgitado() + "%"));
			}
			if (testeB.getAlegre() != null && testeB.getAlegre().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("alegre"), "%" + testeB.getAlegre() + "%"));
			}
			if (testeB.getAmavel() != null && testeB.getAmavel().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("amavel"), "%" + testeB.getAmavel() + "%"));
			}
			if (testeB.getAnalitico() != null && testeB.getAnalitico().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("analitico"), "%" + testeB.getAnalitico() + "%"));
			}
			if (testeB.getAnimado() != null && testeB.getAnimado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("animado"), "%" + testeB.getAnimado() + "%"));
			}
			if (testeB.getAnsioso() != null && testeB.getAnsioso().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("ansioso"), "%" + testeB.getAnsioso() + "%"));
			}
			if (testeB.getApatico() != null && testeB.getApatico().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("apatico"), "%" + testeB.getApatico() + "%"));
			}
			if (testeB.getArticulado() != null && testeB.getArticulado().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteB.get("articulado"), "%" + testeB.getArticulado() + "%"));
			}
			if (testeB.getAssumeRiscosCalculados() != null && testeB.getAssumeRiscosCalculados().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("assumeRiscosCalculados"),
						"%" + testeB.getAssumeRiscosCalculados() + "%"));
			}
			if (testeB.getAtencioso() != null && testeB.getAtencioso().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("atencioso"), "%" + testeB.getAtencioso() + "%"));
			}
			if (testeB.getAtivo() != null && testeB.getAtivo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("ativo"), "%" + testeB.getAtivo() + "%"));
			}
			if (testeB.getAutoConfiante() != null && testeB.getAutoConfiante().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootTesteB.get("autoConfiante"), "%" + testeB.getAutoConfiante() + "%"));
			}
			if (testeB.getAventureiro() != null && testeB.getAventureiro().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteB.get("aventureiro"), "%" + testeB.getAventureiro() + "%"));
			}
			if (testeB.getBemHumorado() != null && testeB.getBemHumorado().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteB.get("bemHumorado"), "%" + testeB.getBemHumorado() + "%"));
			}
			if (testeB.getCalmo() != null && testeB.getCalmo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("calmo"), "%" + testeB.getCalmo() + "%"));
			}
			if (testeB.getCarismatico() != null && testeB.getCarismatico().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteB.get("carismatico"), "%" + testeB.getCarismatico() + "%"));
			}
			if (testeB.getCauteloso() != null && testeB.getCauteloso().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootTesteB.get("cauteloso"), "%" + testeB.getCauteloso() + "%"));
			}
			if (testeB.getCompetitivo() != null && testeB.getCompetitivo().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootTesteB.get("competitivo"), "%" + testeB.getCompetitivo() + "%"));
			}
			if (testeB.getCompreensivo() != null && testeB.getCompreensivo().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootTesteB.get("compreensivo"), "%" + testeB.getCompreensivo() + "%"));
			}
			criteriaQuery.select(rootTesteB).where(predicateList.toArray(new Predicate[] {}));
			testeBList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return testeBList;
	}

	@Override
	public void salvarRegistro(TesteB testeB) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(testeB);
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