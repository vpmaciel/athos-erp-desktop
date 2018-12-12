package erp.empresa;

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

final class EmpresaImp implements EmpresaDao {

	@Override
	public void deletarRegistro(Empresa empresa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Empresa.class, empresa.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Empresa getRegistro(Empresa empresa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Empresa.class, empresa.getId());
	}

	@Override
	public Collection<Empresa> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.empresa.Empresa C order by C.nomeFantasia");
		@SuppressWarnings("unchecked")
		List<Empresa> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Empresa> pesquisarRegistro(Empresa empresa) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Empresa> criteriaQuery = criteriaBuilder.createQuery(Empresa.class);
		Root<Empresa> rootEmpresa = criteriaQuery.from(Empresa.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (empresa.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootEmpresa.get("id"), empresa.getId()));
		}
		if (empresa.getBairro() != null && !empresa.getBairro().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("bairro"), "%" + empresa.getBairro() + "%"));
		}
		if (empresa.getCapitalSocial() != null && !empresa.getCapitalSocial().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("capitalSocial"), "%" + empresa.getCapitalSocial() + "%"));
		}
		if (empresa.getCep() != null && !empresa.getCep().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("cep"), "%" + empresa.getCep() + "%"));
		}
		if (empresa.getCidade() != null && !empresa.getCidade().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("cidade"), "%" + empresa.getCidade() + "%"));
		}
		if (empresa.getCnpj() != null && !empresa.getCnpj().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("cnpj"), "%" + empresa.getCnpj() + "%"));
		}
		if (empresa.getComplemento() != null && !empresa.getComplemento().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("complemento"), "%" + empresa.getComplemento() + "%"));
		}
		if (empresa.getDataFundacao() != null && !empresa.getDataFundacao().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("dataFundacao"), "%" + empresa.getDataFundacao() + "%"));
		}
		if (empresa.getEmail() != null && !empresa.getEmail().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("email"), "%" + empresa.getEmail() + "%"));
		}
		if (empresa.getEstado() != null && !empresa.getEstado().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("estado"), "%" + empresa.getEstado() + "%"));
		}
		if (empresa.getFaturamentoMensal() != null && !empresa.getFaturamentoMensal().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("faturamentoMensal"), "%" + empresa.getFaturamentoMensal() + "%"));
		}
		if (empresa.getFax() != null && !empresa.getFax().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("fax"), "%" + empresa.getFax() + "%"));
		}
		if (empresa.getFone1() != null && !empresa.getFone1().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("fone1"), "%" + empresa.getFone1() + "%"));
		}
		if (empresa.getFone2() != null && !empresa.getFone2().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("fone2"), "%" + empresa.getFone2() + "%"));
		}
		if (empresa.getInscricaoEstadual() != null && !empresa.getInscricaoEstadual().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("inscricaoEstadual"), "%" + empresa.getInscricaoEstadual() + "%"));
		}
		if (empresa.getInscricaoMunicipal() != null && !empresa.getInscricaoMunicipal().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("inscricaoMunicipal"), "%" + empresa.getInscricaoMunicipal() + "%"));
		}
		if (empresa.getLogradouro() != null && !empresa.getLogradouro().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("logradouro"), "%" + empresa.getLogradouro() + "%"));
		}
		if (empresa.getNomeFantasia() != null && !empresa.getNomeFantasia().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("nomeFantasia"), "%" + empresa.getNomeFantasia() + "%"));
		}
		if (empresa.getNumeroFuncionarios() != null && !empresa.getNumeroFuncionarios().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("numeroFuncionarios"), "%" + empresa.getNumeroFuncionarios() + "%"));
		}
		if (empresa.getPais() != null && !empresa.getPais().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("pais"), "%" + empresa.getPais() + "%"));
		}
		if (empresa.getRamoAtividade() != null && !empresa.getRamoAtividade().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("ramoAtividade"), "%" + empresa.getRamoAtividade() + "%"));
		}
		if (empresa.getRazaoSocial() != null && !empresa.getRazaoSocial().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("razaoSocial"), "%" + empresa.getRazaoSocial() + "%"));
		}
		if (empresa.getTipoEmpresa() != null && !empresa.getTipoEmpresa().equals("")) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("tipoEmpresa"), "%" + empresa.getTipoEmpresa() + "%"));
		}
		
		criteriaQuery.select(rootEmpresa).where(predicates.toArray(new Predicate[] {}));

		List<Empresa> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Empresa empresa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(empresa);
		tx.commit();
		em.close();
	}
}
