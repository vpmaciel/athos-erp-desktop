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
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(ExperienciaProfissional.class, experienciaProfissional.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<ExperienciaProfissional> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from ExperienciaProfissional T order by T.id", ExperienciaProfissional.class);
		@SuppressWarnings("unchecked")
		List<ExperienciaProfissional> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public ExperienciaProfissional getRegistro(ExperienciaProfissional experienciaProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(ExperienciaProfissional.class, experienciaProfissional.getId());
	}

	@Override
	public Collection<ExperienciaProfissional> pesquisarRegistro(ExperienciaProfissional experienciaProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ExperienciaProfissional> criteriaQuery = criteriaBuilder.createQuery(ExperienciaProfissional.class);
		Root<ExperienciaProfissional> rootCliente = criteriaQuery.from(ExperienciaProfissional.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (experienciaProfissional.getFuncionario() != null && experienciaProfissional.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), experienciaProfissional.getFuncionario()));
		}
		if (experienciaProfissional.getCargo() != null && experienciaProfissional.getCargo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("cargo"), "%" + experienciaProfissional.getCargo() + "%"));
		}
		if (experienciaProfissional.getDataAdmissao() != null && !experienciaProfissional.getDataAdmissao().equals(Mascara.getAno().getPlaceholder())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("dataAdmissao"), "%" + experienciaProfissional.getDataAdmissao() + "%"));
		}
		if (experienciaProfissional.getDataSaida() != null && !experienciaProfissional.getDataSaida().equals(Mascara.getAno().getPlaceholder())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("dataSaida"), "%" + experienciaProfissional.getDataSaida() + "%"));
		}
		if (experienciaProfissional.getEmpresa() != null && experienciaProfissional.getEmpresa().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("empresa"), "%" + experienciaProfissional.getEmpresa() + "%"));
		}
		if (experienciaProfissional.getFuncoes() != null && experienciaProfissional.getFuncoes().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("funcoes"), "%" + experienciaProfissional.getFuncoes() + "%"));
		}
		if (experienciaProfissional.getNivelHierarquico() != null && experienciaProfissional.getNivelHierarquico().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("nivelHierarquico"), "%" + experienciaProfissional.getNivelHierarquico() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<ExperienciaProfissional> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(ExperienciaProfissional experienciaProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(experienciaProfissional);
		entityTransaction.commit();
		entityManager.close();
	}
}
