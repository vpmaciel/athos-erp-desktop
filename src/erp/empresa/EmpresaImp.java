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
import arquitetura.validacao.Mascara;

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

		if (naoEstaVazio(empresa.getId())) {
			predicates.add(criteriaBuilder.equal(rootEmpresa.get("id"), empresa.getId()));
		}
		if (naoEstaVazio(empresa.getBairro())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("bairro"), "%" + empresa.getBairro() + "%"));
		}
		if (naoEstaVazio(empresa.getCapitalSocial())) {
			predicates.add(
					criteriaBuilder.like(rootEmpresa.get("capitalSocial"), "%" + empresa.getCapitalSocial() + "%"));
		}
		if (empresa.getCep() != null && !empresa.getCep().equals(Mascara.getCep().getPlaceholder()) && !empresa.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("cep"), "%" + empresa.getCep() + "%"));
		}
		if (naoEstaVazio(empresa.getCidade())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("cidade"), "%" + empresa.getCidade() + "%"));
		}
		if (empresa.getCnpj() != null && !empresa.getCnpj().equals(Mascara.getCnpj().getPlaceholder()) && !empresa.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("cnpj"), "%" + empresa.getCnpj() + "%"));
		}
		if (naoEstaVazio(empresa.getComplemento())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("complemento"), "%" + empresa.getComplemento() + "%"));
		}
		if (empresa.getDataFundacao() != null && !empresa.getDataFundacao().equals(Mascara.getData().getPlaceholder()) && !empresa.getDataFundacao().equals(Mascara.getDataVazio())) {
			predicates
					.add(criteriaBuilder.like(rootEmpresa.get("dataFundacao"), "%" + empresa.getDataFundacao() + "%"));
		}
		if (naoEstaVazio(empresa.getEmail())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("email"), "%" + empresa.getEmail() + "%"));
		}
		if (naoEstaVazio(empresa.getEstado())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("estado"), "%" + empresa.getEstado() + "%"));
		}
		if (naoEstaVazio(empresa.getFaturamentoMensal())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("faturamentoMensal"),
					"%" + empresa.getFaturamentoMensal() + "%"));
		}
		if (empresa.getFax() != null && !empresa.getFax().equals(Mascara.getFax().getPlaceholder()) && !empresa.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("fax"), "%" + empresa.getFax() + "%"));
		}
		if (empresa.getFone1() != null && !empresa.getFone1().equals(Mascara.getFone().getPlaceholder()) && !empresa.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("fone1"), "%" + empresa.getFone1() + "%"));
		}
		if (empresa.getFone2() != null && !empresa.getFone2().equals(Mascara.getFone().getPlaceholder()) && !empresa.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("fone2"), "%" + empresa.getFone2() + "%"));
		}
		if (naoEstaVazio(empresa.getInscricaoEstadual())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("inscricaoEstadual"),
					"%" + empresa.getInscricaoEstadual() + "%"));
		}
		if (naoEstaVazio(empresa.getInscricaoMunicipal())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("inscricaoMunicipal"),
					"%" + empresa.getInscricaoMunicipal() + "%"));
		}
		if (naoEstaVazio(empresa.getLogradouro())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("logradouro"), "%" + empresa.getLogradouro() + "%"));
		}
		if (naoEstaVazio(empresa.getNomeFantasia())) {
			predicates
					.add(criteriaBuilder.like(rootEmpresa.get("nomeFantasia"), "%" + empresa.getNomeFantasia() + "%"));
		}
		if (naoEstaVazio(empresa.getNumeroFuncionarios())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("numeroFuncionarios"),
					"%" + empresa.getNumeroFuncionarios() + "%"));
		}
		if (naoEstaVazio(empresa.getPais())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("pais"), "%" + empresa.getPais() + "%"));
		}
		if (naoEstaVazio(empresa.getRamoAtividade())) {
			predicates.add(
					criteriaBuilder.like(rootEmpresa.get("ramoAtividade"), "%" + empresa.getRamoAtividade() + "%"));
		}
		if (naoEstaVazio(empresa.getRazaoSocial())) {
			predicates.add(criteriaBuilder.like(rootEmpresa.get("razaoSocial"), "%" + empresa.getRazaoSocial() + "%"));
		}
		if (naoEstaVazio(empresa.getTipoEmpresa())) {
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
