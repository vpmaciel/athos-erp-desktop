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

import arquitetura.Jpa;
import arquitetura.validacao.Mascara;

final class SindicatoImp implements SindicatoDao {

	@Override
	public void deletarRegistro(Sindicato sindicato) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Sindicato.class, sindicato.getId()));
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
	public Collection<Sindicato> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Sindicato> sindicatoList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Sindicato T order by T.nomeFantasia",
					Sindicato.class);
			sindicatoList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return sindicatoList;
	}

	@Override
	public Sindicato getRegistro(Sindicato sindicato) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			sindicato = entityManager.find(Sindicato.class, sindicato.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return sindicato;
	}

	@Override
	public Collection<Sindicato> pesquisarRegistro(Sindicato sindicato) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Sindicato> sindicatoList = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Sindicato> criteriaQuery = criteriaBuilder.createQuery(Sindicato.class);
			Root<Sindicato> rootSindicato = criteriaQuery.from(Sindicato.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (sindicato.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootSindicato.get("id"), sindicato.getId()));
			}
			if (sindicato.getEnderecoBairro() != null && sindicato.getEnderecoBairro().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("enderecoBairro"), "%" + sindicato.getEnderecoBairro() + "%"));
			}
			if (sindicato.getCapitalSocial() != null && sindicato.getCapitalSocial().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("capitalSocial"),
						"%" + sindicato.getCapitalSocial() + "%"));
			}
			if (sindicato.getEnderecoCep() != null && !sindicato.getEnderecoCep().equals(Mascara.getEnderecoCep().getPlaceholder())
					&& !sindicato.getEnderecoCep().equals(Mascara.getEnderecoCepVazio())) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("enderecoCep"), "%" + sindicato.getEnderecoCep() + "%"));
			}
			if (sindicato.getEnderecoCidade() != null && sindicato.getEnderecoCidade().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("enderecoCidade"), "%" + sindicato.getEnderecoCidade() + "%"));
			}
			if (sindicato.getCnpj() != null && !sindicato.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
					&& !sindicato.getCnpj().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("cnpj"), "%" + sindicato.getCnpj() + "%"));
			}
			if (sindicato.getEnderecoComplemento() != null && sindicato.getEnderecoComplemento().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootSindicato.get("enderecoComplemento"), "%" + sindicato.getEnderecoComplemento() + "%"));
			}
			if (sindicato.getDataFundacao() != null
					&& !sindicato.getDataFundacao().equals(Mascara.getData().getPlaceholder())
					&& !sindicato.getDataFundacao().equals(Mascara.getDataVazio())) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("dataFundacao"),
						"%" + sindicato.getDataFundacao() + "%"));
			}
			if (sindicato.getEmail() != null && sindicato.getEmail().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("email"), "%" + sindicato.getEmail() + "%"));
			}
			if (sindicato.getEnderecoEstado() != null && sindicato.getEnderecoEstado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("enderecoEstado"), "%" + sindicato.getEnderecoEstado() + "%"));
			}
			if (sindicato.getFaturamentoMensal() != null && sindicato.getFaturamentoMensal().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("faturamentoMensal"),
						"%" + sindicato.getFaturamentoMensal() + "%"));
			}
			if (sindicato.getFax() != null && !sindicato.getFax().equals(Mascara.getFax().getPlaceholder())
					&& !sindicato.getFax().equals(Mascara.getFaxVazio())) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("fax"), "%" + sindicato.getFax() + "%"));
			}
			if (sindicato.getFone1() != null && !sindicato.getFone1().equals(Mascara.getFone().getPlaceholder())
					&& !sindicato.getFone1().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("fone1"), "%" + sindicato.getFone1() + "%"));
			}
			if (sindicato.getFone2() != null && !sindicato.getFone2().equals(Mascara.getFone().getPlaceholder())
					&& !sindicato.getFone2().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("fone2"), "%" + sindicato.getFone2() + "%"));
			}
			if (sindicato.getInscricaoEstadual() != null && sindicato.getEnderecoBairro().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("inscricaoEstadual"),
						"%" + sindicato.getInscricaoEstadual() + "%"));
			}
			if (sindicato.getInscricaoMunicipal() != null && sindicato.getInscricaoMunicipal().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("inscricaoMunicipal"),
						"%" + sindicato.getInscricaoMunicipal() + "%"));
			}
			if (sindicato.getEnderecoLogradouro() != null && sindicato.getEnderecoLogradouro().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootSindicato.get("enderecoLogradouro"), "%" + sindicato.getEnderecoLogradouro() + "%"));
			}
			if (sindicato.getNomeFantasia() != null && sindicato.getNomeFantasia().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("nomeFantasia"),
						"%" + sindicato.getNomeFantasia() + "%"));
			}
			if (sindicato.getNumeroFuncionarios() != null && sindicato.getNumeroFuncionarios().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("numeroFuncionarios"),
						"%" + sindicato.getNumeroFuncionarios() + "%"));
			}
			if (sindicato.getPais() != null && sindicato.getPais().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("pais"), "%" + sindicato.getPais() + "%"));
			}
			if (sindicato.getRamoAtividade() != null && sindicato.getRamoAtividade().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("ramoAtividade"),
						"%" + sindicato.getRamoAtividade() + "%"));
			}
			if (sindicato.getRazaoSocial() != null && sindicato.getRazaoSocial().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootSindicato.get("razaoSocial"), "%" + sindicato.getRazaoSocial() + "%"));
			}
			if (sindicato.getTipoSindicato() != null && sindicato.getTipoSindicato().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootSindicato.get("tipoSindicato"),
						"%" + sindicato.getTipoSindicato() + "%"));
			}
			criteriaQuery.select(rootSindicato).where(predicateList.toArray(new Predicate[] {}));
			sindicatoList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return sindicatoList;
	}

	@Override
	public void salvarRegistro(Sindicato sindicato) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(sindicato);
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