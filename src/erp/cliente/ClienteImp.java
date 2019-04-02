package erp.cliente;

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

final class ClienteImp implements ClienteDao {

	@Override
	public void deletarRegistro(Cliente cliente) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Cliente.class, cliente.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Cliente getRegistro(Cliente cliente) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Cliente.class, cliente.getId());
	}

	@Override
	public Collection<Cliente> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.cliente.Cliente C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Cliente> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Cliente> pesquisarRegistro(Cliente cliente) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
		Root<Cliente> rootCliente = criteriaQuery.from(Cliente.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (naoEstaVazio(cliente.getId())) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("id"), cliente.getId()));
		}
		if (naoEstaVazio(cliente.getBairro())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("bairro"), "%" + cliente.getBairro() + "%"));
		}
		if (naoEstaVazio(cliente.getCargo())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("cargo"), "%" + cliente.getCargo() + "%"));
		}
		if (naoEstaVazio(cliente.getClasseEconomica())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("classeEconomica"), "%" + cliente.getClasseEconomica() + "%"));
		}
		if (cliente.getDataCadastro() != null && !cliente.getDataCadastro().equals(Mascara.getData().getPlaceholder()) && !cliente.getDataCadastro().equals(Mascara.getDataVazio())) {
			predicates
					.add(criteriaBuilder.like(rootCliente.get("dataCadastro"), "%" + cliente.getDataCadastro() + "%"));
		}
		if (cliente.getCep() != null && !cliente.getCep().equals(Mascara.getCep().getPlaceholder()) && !cliente.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("cep"), "%" + cliente.getCep() + "%"));
		}
		if (naoEstaVazio(cliente.getCidade())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("cidade"), "%" + cliente.getCidade() + "%"));
		}
		if (naoEstaVazio(cliente.getComplemento())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("complemento"), "%" + cliente.getComplemento() + "%"));
		}
		if (cliente.getCpf() != null && !cliente.getCpf().equals(Mascara.getCpf().getPlaceholder()) && !cliente.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("cpfNumero"), "%" + cliente.getCpf() + "%"));
		}
		if (naoEstaVazio(cliente.getEmail())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("email"), "%" + cliente.getEmail() + "%"));
		}
		if (naoEstaVazio(cliente.getEstado())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("estado"), "%" + cliente.getEstado() + "%"));
		}
		if (naoEstaVazio(cliente.getEstadoCivil())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("estadoCivil"), "%" + cliente.getEstadoCivil() + "%"));
		}
		if (cliente.getFax() != null && !cliente.getFax().equals(Mascara.getFax().getPlaceholder()) && !cliente.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("fax"), "%" + cliente.getFax() + "%"));
		}
		if (cliente.getFone1() != null && !cliente.getFone1().equals(Mascara.getFone().getPlaceholder()) && !cliente.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("fone1"), "%" + cliente.getFone1() + "%"));
		}
		if (cliente.getFone2() != null && !cliente.getFone2().equals(Mascara.getFone().getPlaceholder()) && !cliente.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("fone2"), "%" + cliente.getFone2() + "%"));
		}
		if (naoEstaVazio(cliente.getLogradouro())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("logradouro"), "%" + cliente.getLogradouro() + "%"));
		}
		if (naoEstaVazio(cliente.getNome())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("nome"), "%" + cliente.getNome() + "%"));
		}
		if (naoEstaVazio(cliente.getPais())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("pais"), "%" + cliente.getPais() + "%"));
		}
		if (cliente.getCnpj() != null && !cliente.getCnpj().equals(Mascara.getCnpj().getPlaceholder()) && !cliente.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("cnpj"), "%" + cliente.getCnpj() + "%"));
		}
		if (naoEstaVazio(cliente.getRgNumero())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("rgNumero"), "%" + cliente.getRgNumero() + "%"));
		}
		if (naoEstaVazio(cliente.getRgOrgaoEmissor())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("rgOrgaoEmissor"), "%" + cliente.getRgOrgaoEmissor() + "%"));
		}
		if (naoEstaVazio(cliente.getSalario())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("salario"), "%" + cliente.getSalario() + "%"));
		}
		if (naoEstaVazio(cliente.getSexo())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("sexo"), "%" + cliente.getSexo() + "%"));
		}
		if (naoEstaVazio(cliente.getIdade())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("idade"), "%" + cliente.getIdade() + "%"));
		}
		if (naoEstaVazio(cliente.getEmpresa())) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("empresa"), cliente.getEmpresa()));
		}
		if (naoEstaVazio(cliente.getBanco())) {
			predicates.add(criteriaBuilder.equal(rootCliente.get("banco"), cliente.getBanco()));
		}
		if (naoEstaVazio(cliente.getNumeroAgenciaBancaria())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("numeroAgenciaBancaria"),
					"%" + cliente.getNumeroAgenciaBancaria() + "%"));
		}
		if (naoEstaVazio(cliente.getNumeroContaBancaria())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("numeroContaBancaria"),
					"%" + cliente.getNumeroContaBancaria() + "%"));
		}
		if (naoEstaVazio(cliente.getNomeReferencia1())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("nomeReferencia1"), "%" + cliente.getNomeReferencia1() + "%"));
		}
		if (naoEstaVazio(cliente.getNomeReferencia2())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("nomeReferencia2"), "%" + cliente.getNomeReferencia2() + "%"));
		}
		if (naoEstaVazio(cliente.getNomeReferencia3())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("nomeReferencia3"), "%" + cliente.getNomeReferencia3() + "%"));
		}
		if (cliente.getFoneReferencia1() != null && !cliente.getFoneReferencia1().equals(Mascara.getFone().getPlaceholder()) && !cliente.getFoneReferencia1().equals(Mascara.getFoneVazio())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("foneReferencia1"), "%" + cliente.getFoneReferencia1() + "%"));
		}
		if (cliente.getFoneReferencia2() != null && !cliente.getFoneReferencia2().equals(Mascara.getFone().getPlaceholder()) && !cliente.getFoneReferencia2().equals(Mascara.getFoneVazio())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("foneReferencia2"), "%" + cliente.getFoneReferencia2() + "%"));
		}
		if (cliente.getFoneReferencia3() != null && !cliente.getFoneReferencia3().equals(Mascara.getFone().getPlaceholder()) && !cliente.getFoneReferencia3().equals(Mascara.getFoneVazio())) {
			predicates.add(
					criteriaBuilder.like(rootCliente.get("foneReferencia3"), "%" + cliente.getFoneReferencia3() + "%"));
		}
		if (naoEstaVazio(cliente.getRelacionamentoReferencia1())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("relacionamentoReferencia1"),
					"%" + cliente.getRelacionamentoReferencia1() + "%"));
		}
		if (naoEstaVazio(cliente.getRelacionamentoReferencia2())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("relacionamentoReferencia2"),
					"%" + cliente.getRelacionamentoReferencia2() + "%"));
		}
		if (naoEstaVazio(cliente.getRelacionamentoReferencia3())) {
			predicates.add(criteriaBuilder.like(rootCliente.get("relacionamentoReferencia3"),
					"%" + cliente.getRelacionamentoReferencia3() + "%"));
		}

		criteriaQuery.select(rootCliente).where(predicates.toArray(new Predicate[] {}));

		List<Cliente> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvar(Cliente cliente) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(cliente);
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
