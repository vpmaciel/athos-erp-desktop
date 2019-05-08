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
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(ObjetivoProfissional.class, objetivoProfissional.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Collection<ObjetivoProfissional> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.currriculo.objetivoProfissional.ObjetivoProfissional C");
		@SuppressWarnings("unchecked")
		List<ObjetivoProfissional> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public ObjetivoProfissional getRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(ObjetivoProfissional.class, objetivoProfissional.getId());
	}

	@Override
	public Collection<ObjetivoProfissional> pesquisarRegistro(ObjetivoProfissional objetivoProfissional) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

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
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(ObjetivoProfissional ObjetivoProfissional) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(ObjetivoProfissional);
		tx.commit();
		em.close();
	}
}
