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

import arquitetura.JPA;
import arquitetura.validacao.Mascara;

final class SindicatoImp implements SindicatoDao {

	@Override
	public void deletarRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Sindicato.class, sindicato.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Sindicato getRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Sindicato.class, sindicato.getId());
	}

	@Override
	public Collection<Sindicato> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.sindicato.Sindicato C order by C.nomeFantasia");
		@SuppressWarnings("unchecked")
		List<Sindicato> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Sindicato> pesquisarRegistro(Sindicato sindicato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Sindicato> criteriaQuery = criteriaBuilder.createQuery(Sindicato.class);
		Root<Sindicato> rootSindicato = criteriaQuery.from(Sindicato.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (naoEstaVazio(sindicato.getId())) {
			predicates.add(criteriaBuilder.equal(rootSindicato.get("id"), sindicato.getId()));
		}
		if (naoEstaVazio(sindicato.getBairro())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("bairro"), "%" + sindicato.getBairro() + "%"));
		}
		if (naoEstaVazio(sindicato.getCapitalSocial())) {
			predicates.add(
					criteriaBuilder.like(rootSindicato.get("capitalSocial"), "%" + sindicato.getCapitalSocial() + "%"));
		}
		if (sindicato.getCep() != null && !sindicato.getCep().equals(Mascara.getCep().getPlaceholder())
				&& !sindicato.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("cep"), "%" + sindicato.getCep() + "%"));
		}
		if (naoEstaVazio(sindicato.getCidade())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("cidade"), "%" + sindicato.getCidade() + "%"));
		}
		if (sindicato.getCnpj() != null && !sindicato.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !sindicato.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("cnpj"), "%" + sindicato.getCnpj() + "%"));
		}
		if (naoEstaVazio(sindicato.getComplemento())) {
			predicates.add(
					criteriaBuilder.like(rootSindicato.get("complemento"), "%" + sindicato.getComplemento() + "%"));
		}
		if (sindicato.getDataFundacao() != null
				&& !sindicato.getDataFundacao().equals(Mascara.getData().getPlaceholder())
				&& !sindicato.getDataFundacao().equals(Mascara.getDataVazio())) {
			predicates.add(
					criteriaBuilder.like(rootSindicato.get("dataFundacao"), "%" + sindicato.getDataFundacao() + "%"));
		}
		if (naoEstaVazio(sindicato.getEmail())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("email"), "%" + sindicato.getEmail() + "%"));
		}
		if (naoEstaVazio(sindicato.getEstado())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("estado"), "%" + sindicato.getEstado() + "%"));
		}
		if (naoEstaVazio(sindicato.getFaturamentoMensal())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("faturamentoMensal"),
					"%" + sindicato.getFaturamentoMensal() + "%"));
		}
		if (sindicato.getFax() != null && !sindicato.getFax().equals(Mascara.getFax().getPlaceholder())
				&& !sindicato.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("fax"), "%" + sindicato.getFax() + "%"));
		}
		if (sindicato.getFone1() != null && !sindicato.getFone1().equals(Mascara.getFone().getPlaceholder())
				&& !sindicato.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("fone1"), "%" + sindicato.getFone1() + "%"));
		}
		if (sindicato.getFone2() != null && !sindicato.getFone2().equals(Mascara.getFone().getPlaceholder())
				&& !sindicato.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("fone2"), "%" + sindicato.getFone2() + "%"));
		}
		if (naoEstaVazio(sindicato.getInscricaoEstadual())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("inscricaoEstadual"),
					"%" + sindicato.getInscricaoEstadual() + "%"));
		}
		if (naoEstaVazio(sindicato.getInscricaoMunicipal())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("inscricaoMunicipal"),
					"%" + sindicato.getInscricaoMunicipal() + "%"));
		}
		if (naoEstaVazio(sindicato.getLogradouro())) {
			predicates
					.add(criteriaBuilder.like(rootSindicato.get("logradouro"), "%" + sindicato.getLogradouro() + "%"));
		}
		if (naoEstaVazio(sindicato.getNomeFantasia())) {
			predicates.add(
					criteriaBuilder.like(rootSindicato.get("nomeFantasia"), "%" + sindicato.getNomeFantasia() + "%"));
		}
		if (naoEstaVazio(sindicato.getNumeroFuncionarios())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("numeroFuncionarios"),
					"%" + sindicato.getNumeroFuncionarios() + "%"));
		}
		if (naoEstaVazio(sindicato.getPais())) {
			predicates.add(criteriaBuilder.like(rootSindicato.get("pais"), "%" + sindicato.getPais() + "%"));
		}
		if (naoEstaVazio(sindicato.getRamoAtividade())) {
			predicates.add(
					criteriaBuilder.like(rootSindicato.get("ramoAtividade"), "%" + sindicato.getRamoAtividade() + "%"));
		}
		if (naoEstaVazio(sindicato.getRazaoSocial())) {
			predicates.add(
					criteriaBuilder.like(rootSindicato.get("razaoSocial"), "%" + sindicato.getRazaoSocial() + "%"));
		}
		if (naoEstaVazio(sindicato.getTipoSindicato())) {
			predicates.add(
					criteriaBuilder.like(rootSindicato.get("tipoSindicato"), "%" + sindicato.getTipoSindicato() + "%"));
		}

		criteriaQuery.select(rootSindicato).where(predicates.toArray(new Predicate[] {}));

		List<Sindicato> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(sindicato);
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
