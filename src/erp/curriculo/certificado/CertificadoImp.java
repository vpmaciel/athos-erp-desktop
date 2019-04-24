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
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Certificado.class, certificado.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Certificado getRegistro(Certificado certificado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Certificado.class, certificado.getId());
	}

	@Override
	public Collection<Certificado> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.currriculo.certificado.Certificado C");
		@SuppressWarnings("unchecked")
		List<Certificado> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Certificado> pesquisarRegistro(Certificado certificado) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Certificado> criteriaQuery = criteriaBuilder.createQuery(Certificado.class);
		Root<Certificado> rootCliente = criteriaQuery.from(Certificado.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (certificado.getFuncionario() != null && certificado.getFuncionario().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("funcionario"), certificado.getFuncionario()));
		}
		if (naoEstaVazio(certificado.getAnoConclusao())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("anoConclusao"), "%" + certificado.getAnoConclusao() + "%"));
		}
		if (certificado.getCargaHoraria() != null) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("cargaHoraria"), certificado.getCargaHoraria()));
		}
		if (naoEstaVazio(certificado.getCurso())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("curso"), "%" + certificado.getCurso() + "%"));
		}
		if (naoEstaVazio(certificado.getInstituicao())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("instituicao"), "%" + certificado.getInstituicao() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Certificado> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Certificado certificado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(certificado);
		tx.commit();
		em.close();
	}

	private boolean naoEstaVazio(Object objeto) {
		if (objeto == null) {
			return false;
		}
		if (objeto.toString().equals("")) {
			return false;
		}

		return true;
	}
}
