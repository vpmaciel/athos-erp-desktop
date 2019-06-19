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

import arquitetura.Jpa;
import arquitetura.validacao.Mascara;

final class FornecedorImp implements FornecedorDao {

	@Override
	public void deletarRegistro(Fornecedor fornecedor) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Fornecedor.class, fornecedor.getId()));
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
	public Collection<Fornecedor> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Fornecedor> fornecedorList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Fornecedor T order by C.nomeFantasia",
					Fornecedor.class);
			fornecedorList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return fornecedorList;
	}

	@Override
	public Fornecedor getRegistro(Fornecedor fornecedor) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			fornecedor = entityManager.find(Fornecedor.class, fornecedor.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return fornecedor;
	}

	@Override
	public Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Fornecedor> fornecedorList = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Fornecedor> criteriaQuery = criteriaBuilder.createQuery(Fornecedor.class);
			Root<Fornecedor> rootFornecedor = criteriaQuery.from(Fornecedor.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (fornecedor.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootFornecedor.get("id"), fornecedor.getId()));
			}
			if (fornecedor.getEnderecoBairro() != null && fornecedor.getEnderecoBairro().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFornecedor.get("enderecoBairro"), "%" + fornecedor.getEnderecoBairro() + "%"));
			}
			if (fornecedor.getCapitalSocial() != null && fornecedor.getCapitalSocial().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("capitalSocial"),
						"%" + fornecedor.getCapitalSocial() + "%"));
			}
			if (fornecedor.getEnderecoCep() != null && !fornecedor.getEnderecoCep().equals(Mascara.getEnderecoCep().getPlaceholder())
					&& !fornecedor.getEnderecoCep().equals(Mascara.getEnderecoCepVazio())) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("enderecoCep"), "%" + fornecedor.getEnderecoCep() + "%"));
			}
			if (fornecedor.getEnderecoCidade() != null && fornecedor.getEnderecoCidade().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFornecedor.get("enderecoCidade"), "%" + fornecedor.getEnderecoCidade() + "%"));
			}
			if (fornecedor.getCpf() != null && !fornecedor.getCpf().equals(Mascara.getCpf().getPlaceholder())
					&& !fornecedor.getCpf().equals(Mascara.getCpfVazio())) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("cpf"), "%" + fornecedor.getCpf() + "%"));
			}
			if (fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
					&& !fornecedor.getCnpj().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("cnpj"), "%" + fornecedor.getCnpj() + "%"));
			}
			if (fornecedor.getEnderecoComplemento() != null && fornecedor.getEnderecoComplemento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("enderecoComplemento"),
						"%" + fornecedor.getEnderecoComplemento() + "%"));
			}
			if (fornecedor.getDataFundacao() != null
					&& !fornecedor.getDataFundacao().equals(Mascara.getData().getPlaceholder())
					&& !fornecedor.getDataFundacao().equals(Mascara.getDataVazio())) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("dataFundacao"),
						"%" + fornecedor.getDataFundacao() + "%"));
			}
			if (fornecedor.getEmail() != null && fornecedor.getEmail().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("email"), "%" + fornecedor.getEmail() + "%"));
			}
			if (fornecedor.getEnderecoEstado() != null && fornecedor.getEnderecoEstado().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFornecedor.get("enderecoEstado"), "%" + fornecedor.getEnderecoEstado() + "%"));
			}
			if (fornecedor.getFaturamentoMensal() != null && fornecedor.getFaturamentoMensal().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("faturamentoMensal"),
						"%" + fornecedor.getFaturamentoMensal() + "%"));
			}
			if (fornecedor.getFax() != null && !fornecedor.getFax().equals(Mascara.getFax().getPlaceholder())
					&& !fornecedor.getFax().equals(Mascara.getFaxVazio())) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("fax"), "%" + fornecedor.getFax() + "%"));
			}
			if (fornecedor.getFone1() != null && !fornecedor.getFone1().equals(Mascara.getFone().getPlaceholder())
					&& !fornecedor.getFone1().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("fone1"), "%" + fornecedor.getFone1() + "%"));
			}
			if (fornecedor.getFone2() != null && !fornecedor.getFone2().equals(Mascara.getFone().getPlaceholder())
					&& !fornecedor.getFone2().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("fone2"), "%" + fornecedor.getFone2() + "%"));
			}
			if (fornecedor.getInscricaoEstadual() != null && fornecedor.getInscricaoEstadual().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("inscricaoEstadual"),
						"%" + fornecedor.getInscricaoEstadual() + "%"));
			}
			if (fornecedor.getInscricaoMunicipal() != null && fornecedor.getInscricaoMunicipal().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("inscricaoMunicipal"),
						"%" + fornecedor.getInscricaoMunicipal() + "%"));
			}
			if (fornecedor.getEnderecoLogradouro() != null && fornecedor.getEnderecoLogradouro().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootFornecedor.get("enderecoLogradouro"), "%" + fornecedor.getEnderecoLogradouro() + "%"));
			}
			if (fornecedor.getNomeFantasia() != null && fornecedor.getNomeFantasia().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("nomeFantasia"),
						"%" + fornecedor.getNomeFantasia() + "%"));
			}
			if (fornecedor.getNumeroFuncionarios() != null && fornecedor.getNumeroFuncionarios().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("numeroFuncionarios"),
						"%" + fornecedor.getNumeroFuncionarios() + "%"));
			}
			if (fornecedor.getPais() != null && fornecedor.getPais().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("pais"), "%" + fornecedor.getPais() + "%"));
			}
			if (fornecedor.getRamoAtividade() != null && fornecedor.getRamoAtividade().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("ramoAtividade"),
						"%" + fornecedor.getRamoAtividade() + "%"));
			}
			if (fornecedor.getRazaoSocial() != null && fornecedor.getRazaoSocial().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("razaoSocial"),
						"%" + fornecedor.getRazaoSocial() + "%"));
			}
			if (fornecedor.getTipoEmpresa() != null && fornecedor.getTipoEmpresa().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFornecedor.get("tipoEmpresa"),
						"%" + fornecedor.getTipoEmpresa() + "%"));
			}
			criteriaQuery.select(rootFornecedor).where(predicateList.toArray(new Predicate[] {}));
			fornecedorList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return fornecedorList;
	}

	@Override
	public void salvarRegistro(Fornecedor fornecedor) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(fornecedor);
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