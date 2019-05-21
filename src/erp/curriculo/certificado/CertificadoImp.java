package erp.curriculo.certificado;

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

final class CertificadoImp implements CertificadoDao {

	@Override
	public void deletarRegistro(Certificado certificado) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Certificado.class, certificado.getId()));
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
	public Collection<Certificado> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Certificado> certificadoList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Certificado T order by T.funcionario",
					Certificado.class);
			certificadoList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return certificadoList;
	}

	@Override
	public Certificado getRegistro(Certificado certificado) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			certificado = entityManager.find(Certificado.class, certificado.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return certificado;
	}

	@Override
	public Collection<Certificado> pesquisarRegistro(Certificado certificado) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Certificado> certificadoList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Certificado> criteriaQuery = criteriaBuilder.createQuery(Certificado.class);
			Root<Certificado> rootCertificado = criteriaQuery.from(Certificado.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (certificado.getFuncionario() != null && certificado.getFuncionario().getId() != null) {
				predicateList
						.add(criteriaBuilder.equal(rootCertificado.get("funcionario"), certificado.getFuncionario()));
			}
			if (certificado.getAnoConclusao() != null && certificado.getAnoConclusao().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCertificado.get("anoConclusao"),
						"%" + certificado.getAnoConclusao() + "%"));
			}
			if (certificado.getCargaHoraria() > 0) {
				predicateList
						.add(criteriaBuilder.equal(rootCertificado.get("cargaHoraria"), certificado.getCargaHoraria()));
			}
			if (certificado.getCurso() != null && certificado.getCurso().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootCertificado.get("curso"), "%" + certificado.getCurso() + "%"));
			}
			if (certificado.getInstituicao() != null && certificado.getInstituicao().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootCertificado.get("instituicao"),
						"%" + certificado.getInstituicao() + "%"));
			}

			criteriaQuery.select(rootCertificado).where(predicateList.toArray(new Predicate[] {}));
			certificadoList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return certificadoList;
	}

	@Override
	public void salvarRegistro(Certificado certificado) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(certificado);
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