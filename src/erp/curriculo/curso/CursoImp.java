package erp.curriculo.curso;

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

final class CursoImp implements CursoDao {

	@Override
	public void deletarRegistro(Curso curso) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Curso.class, curso.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Curso> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Curso T order by T.id", Curso.class);
		@SuppressWarnings("unchecked")
		List<Curso> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Curso getRegistro(Curso curso) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Curso.class, curso.getId());
	}

	@Override
	public Collection<Curso> pesquisarRegistro(Curso curso) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Curso> criteriaQuery = criteriaBuilder.createQuery(Curso.class);
		Root<Curso> rootCliente = criteriaQuery.from(Curso.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (curso.getFuncionario() != null && curso.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), curso.getFuncionario()));
		}
		if (curso.getCurso() != null && curso.getCurso().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("curso"), "%" + curso.getCurso() + "%"));
		}
		if (curso.getInstituicao() != null && curso.getInstituicao().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("instituicao"), "%" + curso.getInstituicao() + "%"));
		}
		if (curso.getAnoInicio() != null && !curso.getAnoInicio().equals(Mascara.getAno().getPlaceholder())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("anoInicio"), "%" + curso.getAnoInicio() + "%"));
		}
		if (curso.getAnoConclusao() != null && !curso.getAnoConclusao().equals(Mascara.getAno().getPlaceholder())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("anoConclusao"), "%" + curso.getAnoConclusao() + "%"));
		}
		if (curso.getSituacao() != null && curso.getSituacao().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("situacao"), "%" + curso.getInstituicao() + "%"));
		}
		if (curso.getModalidade() != null && curso.getModalidade().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("modalidade"), "%" + curso.getModalidade() + "%"));
		}
		if (curso.getNivel() != null && curso.getNivel().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("nivel"), "%" + curso.getNivel() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Curso> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Curso Curso) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(Curso);
		entityTransaction.commit();
		entityManager.close();
	}
}
