package erp.curriculo.experienciaprofissional;

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

final class ExperienciaProfissionalImp implements ExperienciaProfissionalDao {

	@Override
	public void deletarRegistro(ExperienciaProfissional experienciaProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(ExperienciaProfissional.class, experienciaProfissional.getId()));
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
	public Collection<ExperienciaProfissional> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<ExperienciaProfissional> experienciaProfissionalList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from ExperienciaProfissional T order by T.funcionario", ExperienciaProfissional.class);
			experienciaProfissionalList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return experienciaProfissionalList;
	}

	@Override
	public ExperienciaProfissional getRegistro(ExperienciaProfissional experienciaProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			experienciaProfissional = entityManager.find(ExperienciaProfissional.class, experienciaProfissional.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return experienciaProfissional;
	}

	@Override
	public Collection<ExperienciaProfissional> pesquisarRegistro(ExperienciaProfissional experienciaProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<ExperienciaProfissional> experienciaProfissionalList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<ExperienciaProfissional> criteriaQuery = criteriaBuilder.createQuery(ExperienciaProfissional.class);
			Root<ExperienciaProfissional> rootExperienciaProfissional = criteriaQuery.from(ExperienciaProfissional.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (experienciaProfissional.getFuncionario() != null && experienciaProfissional.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootExperienciaProfissional.get("funcionario"), experienciaProfissional.getFuncionario()));
			}
			if (experienciaProfissional.getCargo() != null && experienciaProfissional.getCargo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootExperienciaProfissional.get("cargo"), "%" + experienciaProfissional.getCargo() + "%"));
			}
			if (experienciaProfissional.getDataAdmissao() != null && !experienciaProfissional.getDataAdmissao().equals(Mascara.getAno().getPlaceholder())) {
				predicateList.add(criteriaBuilder.like(rootExperienciaProfissional.get("dataAdmissao"), "%" + experienciaProfissional.getDataAdmissao() + "%"));
			}
			if (experienciaProfissional.getDataSaida() != null && !experienciaProfissional.getDataSaida().equals(Mascara.getAno().getPlaceholder())) {
				predicateList.add(criteriaBuilder.like(rootExperienciaProfissional.get("dataSaida"), "%" + experienciaProfissional.getDataSaida() + "%"));
			}
			if (experienciaProfissional.getEmpresa() != null && experienciaProfissional.getEmpresa().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootExperienciaProfissional.get("empresa"), "%" + experienciaProfissional.getEmpresa() + "%"));
			}
			if (experienciaProfissional.getFuncoes() != null && experienciaProfissional.getFuncoes().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootExperienciaProfissional.get("funcoes"), "%" + experienciaProfissional.getFuncoes() + "%"));
			}
			if (experienciaProfissional.getNivelHierarquico() != null && experienciaProfissional.getNivelHierarquico().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootExperienciaProfissional.get("nivelHierarquico"), "%" + experienciaProfissional.getNivelHierarquico() + "%"));
			}


			criteriaQuery.select(rootExperienciaProfissional).where(predicateList.toArray(new Predicate[] {}));
			experienciaProfissionalList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return experienciaProfissionalList;
	}

	@Override
	public void salvarRegistro(ExperienciaProfissional experienciaProfissional) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(experienciaProfissional);
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