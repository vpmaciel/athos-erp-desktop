package erp.fornecedor;

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

final class FornecedorImp implements FornecedorDao {

	@Override
	public void deletarRegistro(Fornecedor fornecedor) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Fornecedor.class, fornecedor.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Fornecedor getRegistro(Fornecedor fornecedor) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Fornecedor.class, fornecedor.getId());
	}

	@Override
	public Collection<Fornecedor> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.fornecedor.Fornecedor C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Fornecedor> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Fornecedor> criteriaQuery = criteriaBuilder.createQuery(Fornecedor.class);
		Root<Fornecedor> rootFornecedor = criteriaQuery.from(Fornecedor.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (naoEstaVazio(fornecedor.getId())) {
			predicates.add(criteriaBuilder.equal(rootFornecedor.get("id"), fornecedor.getId()));
		}
		if (naoEstaVazio(fornecedor.getBairro())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("bairro"), "%" + fornecedor.getBairro() + "%"));
		}
		if (naoEstaVazio(fornecedor.getCapitalSocial())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("capitalSocial"),
					"%" + fornecedor.getCapitalSocial() + "%"));
		}
		if (fornecedor.getCep() != null && !fornecedor.getCep().equals(Mascara.getCep().getPlaceholder()) && !fornecedor.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("cep"), "%" + fornecedor.getCep() + "%"));
		}
		if (naoEstaVazio(fornecedor.getCidade())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("cidade"), "%" + fornecedor.getCidade() + "%"));
		}
		if (fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals(Mascara.getCnpj().getPlaceholder()) && !fornecedor.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("cnpj"), "%" + fornecedor.getCnpj() + "%"));
		}
		if (naoEstaVazio(fornecedor.getComplemento())) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("complemento"), "%" + fornecedor.getComplemento() + "%"));
		}
		if (fornecedor.getDataFundacao() != null && !fornecedor.getDataFundacao().equals(Mascara.getData().getPlaceholder()) && !fornecedor.getDataFundacao().equals(Mascara.getDataVazio())) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("dataFundacao"), "%" + fornecedor.getDataFundacao() + "%"));
		}
		if (naoEstaVazio(fornecedor.getEmail())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("email"), "%" + fornecedor.getEmail() + "%"));
		}
		if (naoEstaVazio(fornecedor.getEstado())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("estado"), "%" + fornecedor.getEstado() + "%"));
		}
		if (naoEstaVazio(fornecedor.getFaturamentoMensal())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("faturamentoMensal"),
					"%" + fornecedor.getFaturamentoMensal() + "%"));
		}
		if (fornecedor.getFax() != null && !fornecedor.getFax().equals(Mascara.getFax().getPlaceholder()) && !fornecedor.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("fax"), "%" + fornecedor.getFax() + "%"));
		}
		if (fornecedor.getFone1() != null && !fornecedor.getFone1().equals(Mascara.getFone().getPlaceholder()) && !fornecedor.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("fone1"), "%" + fornecedor.getFone1() + "%"));
		}
		if (fornecedor.getFone2() != null && !fornecedor.getFone2().equals(Mascara.getFone().getPlaceholder()) && !fornecedor.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("fone2"), "%" + fornecedor.getFone2() + "%"));
		}
		if (naoEstaVazio(fornecedor.getInscricaoEstadual())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("inscricaoEstadual"),
					"%" + fornecedor.getInscricaoEstadual() + "%"));
		}
		if (naoEstaVazio(fornecedor.getInscricaoMunicipal())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("inscricaoMunicipal"),
					"%" + fornecedor.getInscricaoMunicipal() + "%"));
		}
		if (naoEstaVazio(fornecedor.getLogradouro())) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("logradouro"), "%" + fornecedor.getLogradouro() + "%"));
		}
		if (naoEstaVazio(fornecedor.getNomeFantasia())) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("nomeFantasia"), "%" + fornecedor.getNomeFantasia() + "%"));
		}
		if (naoEstaVazio(fornecedor.getNumeroFuncionarios())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("numeroFuncionarios"),
					"%" + fornecedor.getNumeroFuncionarios() + "%"));
		}
		if (naoEstaVazio(fornecedor.getPais())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("pais"), "%" + fornecedor.getPais() + "%"));
		}
		if (naoEstaVazio(fornecedor.getRamoAtividade())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("ramoAtividade"),
					"%" + fornecedor.getRamoAtividade() + "%"));
		}
		if (naoEstaVazio(fornecedor.getRazaoSocial())) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("razaoSocial"), "%" + fornecedor.getRazaoSocial() + "%"));
		}
		if (naoEstaVazio(fornecedor.getTipoEmpresa())) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("tipoEmpresa"), "%" + fornecedor.getTipoEmpresa() + "%"));
		}

		criteriaQuery.select(rootFornecedor).where(predicates.toArray(new Predicate[] {}));

		List<Fornecedor> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Fornecedor fornecedor) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(fornecedor);
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
