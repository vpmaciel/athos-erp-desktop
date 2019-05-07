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
	public Fornecedor consultarRegistro(Fornecedor fornecedor) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Fornecedor> criteriaQuery = criteriaBuilder.createQuery(Fornecedor.class);
		Root<Fornecedor> rootFornecedor = criteriaQuery.from(Fornecedor.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (fornecedor.getCpf() != null && !fornecedor.getCpf().equals(Mascara.getCpf().getPlaceholder())
				&& !fornecedor.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.equal(rootFornecedor.get("cpf"), fornecedor.getCpf()));
			naoTemCriterio = false;
		}

		if (fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !fornecedor.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.equal(rootFornecedor.get("cnpj"), fornecedor.getCnpj()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new Fornecedor();
		}

		criteriaQuery.select(rootFornecedor).where(predicates.toArray(new Predicate[] {}));

		List<Fornecedor> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();

		return list.size() > 0 ? list.get(0) : new Fornecedor();
	}

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
	public Fornecedor getRegistro(Fornecedor fornecedor) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Fornecedor.class, fornecedor.getId());
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

		if (fornecedor.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootFornecedor.get("id"), fornecedor.getId()));
		}
		if (fornecedor.getBairro() != null && fornecedor.getBairro().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("bairro"), "%" + fornecedor.getBairro() + "%"));
		}
		if (fornecedor.getCapitalSocial() != null && fornecedor.getCapitalSocial().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("capitalSocial"),
					"%" + fornecedor.getCapitalSocial() + "%"));
		}
		if (fornecedor.getCep() != null && !fornecedor.getCep().equals(Mascara.getCep().getPlaceholder())
				&& !fornecedor.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("cep"), "%" + fornecedor.getCep() + "%"));
		}
		if (fornecedor.getCidade() != null && fornecedor.getCidade().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("cidade"), "%" + fornecedor.getCidade() + "%"));
		}
		if (fornecedor.getCpf() != null && !fornecedor.getCpf().equals(Mascara.getCpf().getPlaceholder())
				&& !fornecedor.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("cpf"), "%" + fornecedor.getCpf() + "%"));
		}
		if (fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !fornecedor.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("cnpj"), "%" + fornecedor.getCnpj() + "%"));
		}
		if (fornecedor.getComplemento() != null && fornecedor.getComplemento().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("complemento"), "%" + fornecedor.getComplemento() + "%"));
		}
		if (fornecedor.getDataFundacao() != null
				&& !fornecedor.getDataFundacao().equals(Mascara.getData().getPlaceholder())
				&& !fornecedor.getDataFundacao().equals(Mascara.getDataVazio())) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("dataFundacao"), "%" + fornecedor.getDataFundacao() + "%"));
		}
		if (fornecedor.getEmail() != null && fornecedor.getEmail().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("email"), "%" + fornecedor.getEmail() + "%"));
		}
		if (fornecedor.getEstado() != null && fornecedor.getEstado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("estado"), "%" + fornecedor.getEstado() + "%"));
		}
		if (fornecedor.getFaturamentoMensal() != null && fornecedor.getFaturamentoMensal().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("faturamentoMensal"),
					"%" + fornecedor.getFaturamentoMensal() + "%"));
		}
		if (fornecedor.getFax() != null && !fornecedor.getFax().equals(Mascara.getFax().getPlaceholder())
				&& !fornecedor.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("fax"), "%" + fornecedor.getFax() + "%"));
		}
		if (fornecedor.getFone1() != null && !fornecedor.getFone1().equals(Mascara.getFone().getPlaceholder())
				&& !fornecedor.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("fone1"), "%" + fornecedor.getFone1() + "%"));
		}
		if (fornecedor.getFone2() != null && !fornecedor.getFone2().equals(Mascara.getFone().getPlaceholder())
				&& !fornecedor.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("fone2"), "%" + fornecedor.getFone2() + "%"));
		}
		if (fornecedor.getInscricaoEstadual() != null && fornecedor.getInscricaoEstadual().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("inscricaoEstadual"),
					"%" + fornecedor.getInscricaoEstadual() + "%"));
		}
		if (fornecedor.getInscricaoMunicipal() != null && fornecedor.getInscricaoMunicipal().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("inscricaoMunicipal"),
					"%" + fornecedor.getInscricaoMunicipal() + "%"));
		}
		if (fornecedor.getLogradouro() != null && fornecedor.getLogradouro().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("logradouro"), "%" + fornecedor.getLogradouro() + "%"));
		}
		if (fornecedor.getNomeFantasia() != null && fornecedor.getNomeFantasia().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("nomeFantasia"), "%" + fornecedor.getNomeFantasia() + "%"));
		}
		if (fornecedor.getNumeroFuncionarios() != null && fornecedor.getNumeroFuncionarios().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("numeroFuncionarios"),
					"%" + fornecedor.getNumeroFuncionarios() + "%"));
		}
		if (fornecedor.getPais() != null && fornecedor.getPais().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("pais"), "%" + fornecedor.getPais() + "%"));
		}
		if (fornecedor.getRamoAtividade() != null && fornecedor.getRamoAtividade().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFornecedor.get("ramoAtividade"),
					"%" + fornecedor.getRamoAtividade() + "%"));
		}
		if (fornecedor.getRazaoSocial() != null && fornecedor.getRazaoSocial().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFornecedor.get("razaoSocial"), "%" + fornecedor.getRazaoSocial() + "%"));
		}
		if (fornecedor.getTipoEmpresa() != null && fornecedor.getTipoEmpresa().length() > 0) {
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
}
