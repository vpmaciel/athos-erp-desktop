package erp.curriculo.objetivoprofissional;

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

final class ObjetivoProfissionalImp implements ObjetivoProfissionalDao {

	@Override
	public void deletarRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(ObjetivoProfissional.class, objetivoProfissional.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<ObjetivoProfissional> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from ObjetivoProfissional T order by T.id", ObjetivoProfissional.class);
		@SuppressWarnings("unchecked")
		List<ObjetivoProfissional> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public ObjetivoProfissional getRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(ObjetivoProfissional.class, objetivoProfissional.getId());
	}

	@Override
	public Collection<ObjetivoProfissional> pesquisarRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ObjetivoProfissional> criteriaQuery = criteriaBuilder.createQuery(ObjetivoProfissional.class);
		Root<ObjetivoProfissional> rootCliente = criteriaQuery.from(ObjetivoProfissional.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (objetivoProfissional.getFuncionario() != null && objetivoProfissional.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), objetivoProfissional.getFuncionario()));
		}
		if (objetivoProfissional.getAreaInteresse() != null && objetivoProfissional.getAreaInteresse().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("areaInteresse"), "%" + objetivoProfissional.getAreaInteresse() + "%"));
		}
		if (objetivoProfissional.getCargo() != null && objetivoProfissional.getCargo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("cargo"), "%" + objetivoProfissional.getCargo() + "%"));
		}
		if (objetivoProfissional.getContrato() != null && objetivoProfissional.getContrato().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("contrato"), "%" + objetivoProfissional.getContrato() + "%"));
		}
		if (objetivoProfissional.getNivelHierarquico() != null && objetivoProfissional.getNivelHierarquico().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("nivelHierarquico"), "%" + objetivoProfissional.getNivelHierarquico() + "%"));
		}
		if (objetivoProfissional.getPretensaoSalarial() != null && objetivoProfissional.getPretensaoSalarial().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("pretensaoSalarial"), "%" + objetivoProfissional.getPretensaoSalarial() + "%"));
		}
		
		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<ObjetivoProfissional> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(ObjetivoProfissional ObjetivoProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(ObjetivoProfissional);
		entityTransaction.commit();
		entityManager.close();
	}
}
