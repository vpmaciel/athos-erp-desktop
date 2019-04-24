package erp.funcionario;

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

final class FuncionarioImp implements FuncionarioDao {

	@Override
	public void deletarRegistro(Funcionario funcionario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Funcionario.class, funcionario.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Funcionario getRegistro(Funcionario funcionario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Funcionario.class, funcionario.getId());
	}

	@Override
	public Collection<Funcionario> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.funcionario.Funcionario C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Funcionario> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Funcionario> pesquisarRegistro(Funcionario funcionario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
		Root<Funcionario> rootFuncionario = criteriaQuery.from(Funcionario.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (funcionario.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("id"), funcionario.getId()));
		}
		if (funcionario.getBairro() != null && funcionario.getBairro().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("bairro"), "%" + funcionario.getBairro() + "%"));
		}
		if (funcionario.getCategoria() != null && funcionario.getCategoria().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("categoria"), "%" + funcionario.getCategoria() + "%"));
		}
		if (funcionario.getCentroCusto() != null && funcionario.getCentroCusto().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("centroCusto"), funcionario.getCentroCusto()));
		}
		if (funcionario.getCep() != null && !funcionario.getCep().equals(Mascara.getCep().getPlaceholder())
				&& !funcionario.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cep"), "%" + funcionario.getCep() + "%"));
		}
		if (funcionario.getCidade() != null && funcionario.getCidade().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cidade"), "%" + funcionario.getCidade() + "%"));
		}
		if (funcionario.getCnhCategoria() != null && funcionario.getCnhCategoria().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cnhCategoria"),
					"%" + funcionario.getCnhCategoria() + "%"));
		}
		if (funcionario.getCnpj() != null && !funcionario.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !funcionario.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cnpj"), "%" + funcionario.getCnpj() + "%"));
		}
		if (funcionario.getCpf() != null && !funcionario.getCpf().equals(Mascara.getCpf().getPlaceholder())
				&& !funcionario.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cpf"), "%" + funcionario.getCpf() + "%"));
		}
		if (funcionario.getComplemento() != null && funcionario.getComplemento().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("complemento"), "%" + funcionario.getComplemento() + "%"));
		}
		if (funcionario.getConjuge() != null && funcionario.getConjuge().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("conjuge"), "%" + funcionario.getConjuge() + "%"));
		}
		if (funcionario.getEmail() != null && funcionario.getEmail().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("email"), "%" + funcionario.getEmail() + "%"));
		}
		if (funcionario.getEmpresa() != null && funcionario.getEmpresa().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("empresa"), funcionario.getEmpresa()));
		}
		if (funcionario.getEscolaridade() != null && funcionario.getEscolaridade().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("escolaridade"),
					"%" + funcionario.getEscolaridade() + "%"));
		}
		if (funcionario.getEstado() != null && funcionario.getEstado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("estado"), "%" + funcionario.getEstado() + "%"));
		}
		if (funcionario.getEstadoCivil() != null && funcionario.getEstadoCivil().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("estadoCivil"), "%" + funcionario.getEstadoCivil() + "%"));
		}
		if (funcionario.getFax() != null && !funcionario.getFax().equals(Mascara.getFone().getPlaceholder())
				&& !funcionario.getFax().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("fax"), "%" + funcionario.getFax() + "%"));
		}
		if (funcionario.getFilhos() != null && funcionario.getFilhos().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("filhos"), "%" + funcionario.getFilhos() + "%"));
		}
		if (funcionario.getFone1() != null && !funcionario.getFone1().equals(Mascara.getFone().getPlaceholder())
				&& !funcionario.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("fone1"), "%" + funcionario.getFone1() + "%"));
		}
		if (funcionario.getFone2() != null && !funcionario.getFone2().equals(Mascara.getFone().getPlaceholder())
				&& !funcionario.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("fone2"), "%" + funcionario.getFone2() + "%"));
		}
		if (funcionario.getGerente() != null && funcionario.getGerente().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("gerente"), "%" + funcionario.getGerente() + "%"));
		}
		if (funcionario.getLogradouro() != null && funcionario.getLogradouro().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("logradouro"), "%" + funcionario.getLogradouro() + "%"));
		}
		if (funcionario.getMatricula() != null && funcionario.getMatricula().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("matricula"), "%" + funcionario.getMatricula() + "%"));
		}
		if (funcionario.getNome() != null && funcionario.getNome().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("nome"), "%" + funcionario.getNome() + "%"));
		}
		if (funcionario.getPais() != null && funcionario.getPais().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("pais"), "%" + funcionario.getPais() + "%"));
		}
		if (funcionario.getPis() != null && !funcionario.getPis().equals(Mascara.getPis().getPlaceholder())
				&& !funcionario.getPis().equals(Mascara.getPisVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("pis"), "%" + funcionario.getPis() + "%"));
		}
		if (funcionario.getRgNumero() != null && funcionario.getRgNumero().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootFuncionario.get("rgNumero"), "%" + funcionario.getRgNumero() + "%"));
		}
		if (funcionario.getRgOrgaoEmissor() != null && funcionario.getRgOrgaoEmissor().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("rgOrgaoEmissor"),
					"%" + funcionario.getRgOrgaoEmissor() + "%"));
		}
		if (funcionario.getSalario() != null && funcionario.getSalario().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("salario"), "%" + funcionario.getSalario() + "%"));
		}
		if (funcionario.getSexo() != null) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("sexo"), "%" + funcionario.getSexo() + "%"));
		}
		if (funcionario.getTurno() != null && funcionario.getTurno().length() > 0) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("turno"), "%" + funcionario.getTurno() + "%"));
		}

		criteriaQuery.select(rootFuncionario).where(predicates.toArray(new Predicate[] {}));

		List<Funcionario> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Funcionario consultarRegistro(Funcionario funcionario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
		Root<Funcionario> rootFuncionario = criteriaQuery.from(Funcionario.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (funcionario.getCnpj() != null && !funcionario.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !funcionario.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("cnpj"), funcionario.getCnpj()));
			naoTemCriterio = false;
		}

		if (funcionario.getCpf() != null && !funcionario.getCpf().equals(Mascara.getCpf().getPlaceholder())
				&& !funcionario.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("cpf"), funcionario.getCpf()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new Funcionario();
		}

		criteriaQuery.select(rootFuncionario).where(predicates.toArray(new Predicate[] {}));

		List<Funcionario> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();

		return list.size() > 0 ? list.get(0) : new Funcionario();
	}

	@Override
	public void salvarRegistro(Funcionario funcionario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(funcionario);
		tx.commit();
		em.close();
	}
}
