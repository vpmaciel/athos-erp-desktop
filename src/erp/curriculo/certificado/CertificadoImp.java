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
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Certificado.class, certificado.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Certificado> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Certificado T", Certificado.class);
		@SuppressWarnings("unchecked")
		List<Certificado> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Certificado getRegistro(Certificado certificado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Certificado.class, certificado.getId());
	}

	@Override
	public Collection<Certificado> pesquisarRegistro(Certificado certificado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Certificado> criteriaQuery = criteriaBuilder.createQuery(Certificado.class);
		Root<Certificado> rootCliente = criteriaQuery.from(Certificado.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (certificado.getFuncionario() != null && certificado.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), certificado.getFuncionario()));
		}
		if (certificado.getAnoConclusao() != null && certificado.getAnoConclusao().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("anoConclusao"), "%" + certificado.getAnoConclusao() + "%"));
		}
		if (certificado.getCargaHoraria() > 0) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("cargaHoraria"), certificado.getCargaHoraria()));
		}
		if (certificado.getCurso() != null && certificado.getCurso().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCliente.get("curso"), "%" + certificado.getCurso() + "%"));
		}
		if (certificado.getInstituicao() != null && certificado.getInstituicao().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("instituicao"), "%" + certificado.getInstituicao() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Certificado> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Certificado certificado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(certificado);
		entityTransaction.commit();
		entityManager.close();
	}
}
