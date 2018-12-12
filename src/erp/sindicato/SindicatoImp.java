package erp.sindicato;

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

final class SindicatoImp implements SindicatoDao {

	@Override
	public void deletarRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Sindicato.class, sindicato.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Sindicato getRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Sindicato.class, sindicato.getId());
	}

	@Override
	public Collection<Sindicato> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.sindicato.Sindicato C order by C.nomeFantasia");
		@SuppressWarnings("unchecked")
		List<Sindicato> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Sindicato> pesquisarRegistro(Sindicato sindicato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Sindicato> criteriaQuery = criteriaBuilder.createQuery(Sindicato.class);
		Root<Sindicato> rootSindicato = criteriaQuery.from(Sindicato.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (sindicato.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootSindicato.get("id"), sindicato.getId()));
		}
		if (sindicato.getBairro() != null && !sindicato.getBairro().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("bairro"), "%" + sindicato.getBairro() + "%"));
		}
		if (sindicato.getCapitalSocial() != null && !sindicato.getCapitalSocial().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("capitalSocial"), "%" + sindicato.getCapitalSocial() + "%"));
		}
		if (sindicato.getCep() != null && !sindicato.getCep().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("cep"), "%" + sindicato.getCep() + "%"));
		}
		if (sindicato.getCidade() != null && !sindicato.getCidade().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("cidade"), "%" + sindicato.getCidade() + "%"));
		}
		if (sindicato.getCnpj() != null && !sindicato.getCnpj().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("cnpj"), "%" + sindicato.getCnpj() + "%"));
		}
		if (sindicato.getComplemento() != null && !sindicato.getComplemento().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("complemento"), "%" + sindicato.getComplemento() + "%"));
		}
		if (sindicato.getDataFundacao() != null && !sindicato.getDataFundacao().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("dataFundacao"), "%" + sindicato.getDataFundacao() + "%"));
		}
		if (sindicato.getEmail() != null && !sindicato.getEmail().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("email"), "%" + sindicato.getEmail() + "%"));
		}
		if (sindicato.getEstado() != null && !sindicato.getEstado().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("estado"), "%" + sindicato.getEstado() + "%"));
		}
		if (sindicato.getFaturamentoMensal() != null && !sindicato.getFaturamentoMensal().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("faturamentoMensal"), "%" + sindicato.getFaturamentoMensal() + "%"));
		}
		if (sindicato.getFax() != null && !sindicato.getFax().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("fax"), "%" + sindicato.getFax() + "%"));
		}
		if (sindicato.getFone1() != null && !sindicato.getFone1().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("fone1"), "%" + sindicato.getFone1() + "%"));
		}
		if (sindicato.getFone2() != null && !sindicato.getFone2().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("fone2"), "%" + sindicato.getFone2() + "%"));
		}
		if (sindicato.getInscricaoEstadual() != null && !sindicato.getInscricaoEstadual().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("inscricaoEstadual"), "%" + sindicato.getInscricaoEstadual() + "%"));
		}
		if (sindicato.getInscricaoMunicipal() != null && !sindicato.getInscricaoMunicipal().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("inscricaoMunicipal"), "%" + sindicato.getInscricaoMunicipal() + "%"));
		}
		if (sindicato.getLogradouro() != null && !sindicato.getLogradouro().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("logradouro"), "%" + sindicato.getLogradouro() + "%"));
		}
		if (sindicato.getNomeFantasia() != null && !sindicato.getNomeFantasia().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("nomeFantasia"), "%" + sindicato.getNomeFantasia() + "%"));
		}
		if (sindicato.getNumeroFuncionarios() != null && !sindicato.getNumeroFuncionarios().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("numeroFuncionarios"), "%" + sindicato.getNumeroFuncionarios() + "%"));
		}
		if (sindicato.getPais() != null && !sindicato.getPais().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("pais"), "%" + sindicato.getPais() + "%"));
		}
		if (sindicato.getRamoAtividade() != null && !sindicato.getRamoAtividade().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("ramoAtividade"), "%" + sindicato.getRamoAtividade() + "%"));
		}
		if (sindicato.getRazaoSocial() != null && !sindicato.getRazaoSocial().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("razaoSocial"), "%" + sindicato.getRazaoSocial() + "%"));
		}
		if (sindicato.getTipoSindicato() != null && !sindicato.getTipoSindicato().equals("")) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("tipoSindicato"), "%" + sindicato.getTipoSindicato() + "%"));
		}
		
		criteriaQuery.select(rootSindicato).where(predicates.toArray(new Predicate[] {}));

		List<Sindicato> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(sindicato);
		tx.commit();
		em.close();
	}
}
