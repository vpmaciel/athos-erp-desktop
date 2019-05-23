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
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Curso.class, curso.getId()));
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
	public Collection<Curso> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Curso> cursoList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Curso T order by T.funcionario", Curso.class);
			cursoList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return cursoList;
	}

	@Override
	public Curso getRegistro(Curso curso) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			curso = entityManager.find(Curso.class, curso.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return curso;
	}

	@Override
	public Collection<Curso> pesquisarRegistro(Curso curso) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Curso> cursoList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Curso> criteriaQuery = criteriaBuilder.createQuery(Curso.class);
			Root<Curso> rootCurso = criteriaQuery.from(Curso.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (curso.getFuncionario() != null && curso.getFuncionario().getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootCurso.get("funcionario"), curso.getFuncionario()));
			}
			if (curso.getCurso() != null && curso.getCurso().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCurso.get("curso"), "%" + curso.getCurso() + "%"));
			}
			if (curso.getInstituicao() != null && curso.getInstituicao().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootCurso.get("instituicao"), "%" + curso.getInstituicao() + "%"));
			}
			if (curso.getAnoInicio() != null && !curso.getAnoInicio().equals(Mascara.getAno().getPlaceholder())) {
				predicateList.add(criteriaBuilder.like(rootCurso.get("anoInicio"), "%" + curso.getAnoInicio() + "%"));
			}
			if (curso.getAnoConclusao() != null && !curso.getAnoConclusao().equals(Mascara.getAno().getPlaceholder())) {
				predicateList
						.add(criteriaBuilder.like(rootCurso.get("anoConclusao"), "%" + curso.getAnoConclusao() + "%"));
			}
			if (curso.getSituacao() != null && curso.getSituacao().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCurso.get("situacao"), "%" + curso.getInstituicao() + "%"));
			}
			if (curso.getModalidade() != null && curso.getModalidade().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCurso.get("modalidade"), "%" + curso.getModalidade() + "%"));
			}
			if (curso.getNivel() != null && curso.getNivel().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCurso.get("nivel"), "%" + curso.getNivel() + "%"));
			}
			criteriaQuery.select(rootCurso).where(predicateList.toArray(new Predicate[] {}));
			cursoList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return cursoList;
	}

	@Override
	public void salvarRegistro(Curso curso) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(curso);
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