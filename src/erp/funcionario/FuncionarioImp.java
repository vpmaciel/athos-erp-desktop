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

		if (naoEstaVazio(funcionario.getId())) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("id"), funcionario.getId()));
		}
		if (naoEstaVazio(funcionario.getBairro())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("bairro"), "%" + funcionario.getBairro() + "%"));
		}
		if (naoEstaVazio(funcionario.getCategoria())) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("categoria"), "%" + funcionario.getCategoria() + "%"));
		}
		if (naoEstaVazio(funcionario.getCentroCusto())) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("centroCusto"), funcionario.getCentroCusto()));
		}
		if (funcionario.getCep() != null && !funcionario.getCep().equals(Mascara.getCep().getPlaceholder()) && !funcionario.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cep"), "%" + funcionario.getCep() + "%"));
		}
		if (naoEstaVazio(funcionario.getCidade())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cidade"), "%" + funcionario.getCidade() + "%"));
		}
		if (naoEstaVazio(funcionario.getCnhCategoria())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cnhCategoria"),
					"%" + funcionario.getCnhCategoria() + "%"));
		}
		if (funcionario.getCnpj() != null && !funcionario.getCnpj().equals(Mascara.getCnpj().getPlaceholder()) && !funcionario.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("cnpj"), "%" + funcionario.getCnpj() + "%"));
		}
		if (naoEstaVazio(funcionario.getComplemento())) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("complemento"), "%" + funcionario.getComplemento() + "%"));
		}
		if (naoEstaVazio(funcionario.getConjuge())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("conjuge"), "%" + funcionario.getConjuge() + "%"));
		}
		if (naoEstaVazio(funcionario.getEmail())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("email"), "%" + funcionario.getEmail() + "%"));
		}
		if (naoEstaVazio(funcionario.getEmpresa())) {
			predicates.add(criteriaBuilder.equal(rootFuncionario.get("empresa"), funcionario.getEmpresa()));
		}
		if (naoEstaVazio(funcionario.getEscolaridade())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("escolaridade"),
					"%" + funcionario.getEscolaridade() + "%"));
		}
		if (naoEstaVazio(funcionario.getEstado())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("estado"), "%" + funcionario.getEstado() + "%"));
		}
		if (naoEstaVazio(funcionario.getEstadoCivil())) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("estadoCivil"), "%" + funcionario.getEstadoCivil() + "%"));
		}
		if (funcionario.getFax() != null && !funcionario.getFax().equals(Mascara.getFone().getPlaceholder()) && !funcionario.getFax().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("fax"), "%" + funcionario.getFax() + "%"));
		}
		if (naoEstaVazio(funcionario.getFilhos())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("filhos"), "%" + funcionario.getFilhos() + "%"));
		}
		if (funcionario.getFone1() != null && !funcionario.getFone1().equals(Mascara.getFone().getPlaceholder()) && !funcionario.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("fone1"), "%" + funcionario.getFone1() + "%"));
		}
		if (funcionario.getFone2() != null && !funcionario.getFone2().equals(Mascara.getFone().getPlaceholder()) && !funcionario.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("fone2"), "%" + funcionario.getFone2() + "%"));
		}
		if (naoEstaVazio(funcionario.getGerente())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("gerente"), "%" + funcionario.getGerente() + "%"));
		}
		if (naoEstaVazio(funcionario.getLogradouro())) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("logradouro"), "%" + funcionario.getLogradouro() + "%"));
		}
		if (naoEstaVazio(funcionario.getMatricula())) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("matricula"), "%" + funcionario.getMatricula() + "%"));
		}
		if (naoEstaVazio(funcionario.getNome())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("nome"), "%" + funcionario.getNome() + "%"));
		}
		if (naoEstaVazio(funcionario.getPais())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("pais"), "%" + funcionario.getPais() + "%"));
		}
		if (naoEstaVazio(funcionario.getPisNumero())) {
			predicates.add(
					criteriaBuilder.like(rootFuncionario.get("pisNumero"), "%" + funcionario.getPisNumero() + "%"));
		}
		if (naoEstaVazio(funcionario.getRgNumero())) {
			predicates
					.add(criteriaBuilder.like(rootFuncionario.get("rgNumero"), "%" + funcionario.getRgNumero() + "%"));
		}
		if (naoEstaVazio(funcionario.getRgOrgaoEmissor())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("rgOrgaoEmissor"),
					"%" + funcionario.getRgOrgaoEmissor() + "%"));
		}
		if (naoEstaVazio(funcionario.getSalario())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("salario"), "%" + funcionario.getSalario() + "%"));
		}
		if (naoEstaVazio(funcionario.getSexo())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("sexo"), "%" + funcionario.getSexo() + "%"));
		}
		if (naoEstaVazio(funcionario.getTurno())) {
			predicates.add(criteriaBuilder.like(rootFuncionario.get("turno"), "%" + funcionario.getTurno() + "%"));
		}

		criteriaQuery.select(rootFuncionario).where(predicates.toArray(new Predicate[] {}));

		List<Funcionario> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
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
