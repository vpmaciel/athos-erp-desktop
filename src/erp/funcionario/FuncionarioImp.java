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

import arquitetura.Jpa;
import arquitetura.validacao.Mascara;

final class FuncionarioImp implements FuncionarioDao {

	@Override
	public void deletarRegistro(Funcionario funcionario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Funcionario.class, funcionario.getId()));
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
	public Collection<Funcionario> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Funcionario> funcionarioList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Funcionario T order by T.nome", Funcionario.class);
			funcionarioList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return funcionarioList;
	}

	@Override
	public Funcionario getRegistro(Funcionario funcionario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			funcionario = entityManager.find(Funcionario.class, funcionario.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return funcionario;
	}

	@Override
	public Collection<Funcionario> pesquisarRegistro(Funcionario funcionario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Funcionario> funcionarioList = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
			Root<Funcionario> rootFuncionario = criteriaQuery.from(Funcionario.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (funcionario.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootFuncionario.get("id"), funcionario.getId()));
			}
			if (funcionario.getEnderecoBairro() != null && funcionario.getEnderecoBairro().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("enderecoBairro"), "%" + funcionario.getEnderecoBairro() + "%"));
			}
			if (funcionario.getCategoria() != null && funcionario.getCategoria().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootFuncionario.get("categoria"), "%" + funcionario.getCategoria() + "%"));
			}
			if (funcionario.getCentroCusto() != null && funcionario.getCentroCusto().getId() != null) {
				predicateList
						.add(criteriaBuilder.equal(rootFuncionario.get("centroCusto"), funcionario.getCentroCusto()));
			}
			if (funcionario.getEnderecoCep() != null && !funcionario.getEnderecoCep().equals(Mascara.getEnderecoCep().getPlaceholder())
					&& !funcionario.getEnderecoCep().equals(Mascara.getEnderecoCepVazio())) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("enderecoCep"), "%" + funcionario.getEnderecoCep() + "%"));
			}
			if (funcionario.getEnderecoCidade() != null && funcionario.getEnderecoCidade().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("enderecoCidade"), "%" + funcionario.getEnderecoCidade() + "%"));
			}
			if (funcionario.getCnhCategoria() != null && funcionario.getCnhCategoria().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("cnhCategoria"),
						"%" + funcionario.getCnhCategoria() + "%"));
			}
			if (funcionario.getCnpj() != null && !funcionario.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
					&& !funcionario.getCnpj().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("cnpj"), "%" + funcionario.getCnpj() + "%"));
			}
			if (funcionario.getCpf() != null && !funcionario.getCpf().equals(Mascara.getCpf().getPlaceholder())
					&& !funcionario.getCpf().equals(Mascara.getCpfVazio())) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("cpf"), "%" + funcionario.getCpf() + "%"));
			}
			if (funcionario.getEnderecoComplemento() != null && funcionario.getEnderecoComplemento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("enderecoComplemento"),
						"%" + funcionario.getEnderecoComplemento() + "%"));
			}
			if (funcionario.getConjuge() != null && funcionario.getConjuge().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootFuncionario.get("conjuge"), "%" + funcionario.getConjuge() + "%"));
			}
			if (funcionario.getEmail() != null && funcionario.getEmail().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("email"), "%" + funcionario.getEmail() + "%"));
			}
			if (funcionario.getEmpresa() != null && funcionario.getEmpresa().length() > 0) {
				predicateList.add(criteriaBuilder.equal(rootFuncionario.get("empresa"), funcionario.getEmpresa()));
			}
			if (funcionario.getEscolaridade() != null && funcionario.getEscolaridade().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("escolaridade"),
						"%" + funcionario.getEscolaridade() + "%"));
			}
			if (funcionario.getEnderecoEstado() != null && funcionario.getEnderecoEstado().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("enderecoEstado"), "%" + funcionario.getEnderecoEstado() + "%"));
			}
			if (funcionario.getEnderecoEstadoCivil() != null && funcionario.getEnderecoEstadoCivil().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("enderecoEstadoCivil"),
						"%" + funcionario.getEnderecoEstadoCivil() + "%"));
			}
			if (funcionario.getFax() != null && !funcionario.getFax().equals(Mascara.getFone().getPlaceholder())
					&& !funcionario.getFax().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("fax"), "%" + funcionario.getFax() + "%"));
			}
			if (funcionario.getFilhos() != null && funcionario.getFilhos().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("filhos"), "%" + funcionario.getFilhos() + "%"));
			}
			if (funcionario.getFone1() != null && !funcionario.getFone1().equals(Mascara.getFone().getPlaceholder())
					&& !funcionario.getFone1().equals(Mascara.getFoneVazio())) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("fone1"), "%" + funcionario.getFone1() + "%"));
			}
			if (funcionario.getFone2() != null && !funcionario.getFone2().equals(Mascara.getFone().getPlaceholder())
					&& !funcionario.getFone2().equals(Mascara.getFoneVazio())) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("fone2"), "%" + funcionario.getFone2() + "%"));
			}
			if (funcionario.getGerente() != null && funcionario.getGerente().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootFuncionario.get("gerente"), "%" + funcionario.getGerente() + "%"));
			}
			if (funcionario.getEnderecoLogradouro() != null && funcionario.getEnderecoLogradouro().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("enderecoLogradouro"),
						"%" + funcionario.getEnderecoLogradouro() + "%"));
			}
			if (funcionario.getMatricula() != null && funcionario.getMatricula().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootFuncionario.get("matricula"), "%" + funcionario.getMatricula() + "%"));
			}
			if (funcionario.getNome() != null && funcionario.getNome().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("nome"), "%" + funcionario.getNome() + "%"));
			}
			if (funcionario.getEnderecoPais() != null && funcionario.getEnderecoPais().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("pais"), "%" + funcionario.getEnderecoPais() + "%"));
			}
			if (funcionario.getPis() != null && !funcionario.getPis().equals(Mascara.getPis().getPlaceholder())
					&& !funcionario.getPis().equals(Mascara.getPisVazio())) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("pis"), "%" + funcionario.getPis() + "%"));
			}
			if (funcionario.getRgNumero() != null && funcionario.getRgNumero().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootFuncionario.get("rgNumero"), "%" + funcionario.getRgNumero() + "%"));
			}
			if (funcionario.getRgOrgaoEmissor() != null && funcionario.getRgOrgaoEmissor().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("rgOrgaoEmissor"),
						"%" + funcionario.getRgOrgaoEmissor() + "%"));
			}
			if (funcionario.getSalario() != null && funcionario.getSalario().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootFuncionario.get("salario"), "%" + funcionario.getSalario() + "%"));
			}
			if (funcionario.getSexo() != null) {
				predicateList.add(criteriaBuilder.like(rootFuncionario.get("sexo"), "%" + funcionario.getSexo() + "%"));
			}
			if (funcionario.getTurno() != null && funcionario.getTurno().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootFuncionario.get("turno"), "%" + funcionario.getTurno() + "%"));
			}
			criteriaQuery.select(rootFuncionario).where(predicateList.toArray(new Predicate[] {}));
			funcionarioList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return funcionarioList;
	}

	@Override
	public void salvarRegistro(Funcionario funcionario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(funcionario);
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