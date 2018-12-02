package erp.veiculo;

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

final class VeiculoDaoImp implements VeiculoDao {

	@Override
	public void deletarRegistro(Veiculo veiculo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Veiculo.class, veiculo.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Veiculo getRegistro(Veiculo veiculo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Veiculo.class, veiculo.getId());
	}

	@Override
	public Collection<Veiculo> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.veiculo.Veiculo C order by C.modelo");
		@SuppressWarnings("unchecked")
		List<Veiculo> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Veiculo> pesquisarRegistro(Veiculo veiculo) {

		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = criteriaBuilder.createQuery(Veiculo.class);
		Root<Veiculo> rootVeiculo = criteriaQuery.from(Veiculo.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (veiculo.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootVeiculo.get("id"), veiculo.getId()));
		}
		if (veiculo.getAnoFabricacao() != null && !veiculo.getAnoFabricacao().equals("")) {
			predicates.add(
					criteriaBuilder.like(rootVeiculo.get("anoFabricacao"), "%" + veiculo.getAnoFabricacao() + "%"));
		}
		if (veiculo.getAnoModelo() != null && !veiculo.getAnoModelo().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("anoModelo"), "%" + veiculo.getAnoModelo() + "%"));
		}
		if (veiculo.getAtividade() != null && !veiculo.getAtividade().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("atividade"), "%" + veiculo.getAtividade() + "%"));
		}
		if (veiculo.getBairro() != null && !veiculo.getBairro().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("bairro"), "%" + veiculo.getBairro() + "%"));
		}
		if (veiculo.getCapCarga() != null && !veiculo.getCapCarga().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("capCarga"), "%" + veiculo.getCapCarga() + "%"));
		}
		if (veiculo.getCapacidadePassageiros() != null && !veiculo.getCapacidadePassageiros().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("capacidadePassageiros"),
					"%" + veiculo.getCapacidadePassageiros() + "%"));
		}
		if (veiculo.getCarroceria() != null && !veiculo.getCarroceria().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("carroceria"), "%" + veiculo.getCarroceria() + "%"));
		}
		if (veiculo.getCategoria() != null && !veiculo.getCategoria().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("categoria"), "%" + veiculo.getCategoria() + "%"));
		}
		if (veiculo.getCep() != null && !veiculo.getCep().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cep"), "%" + veiculo.getCep() + "%"));
		}
		if (veiculo.getChassi() != null && !veiculo.getChassi().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("chassi"), "%" + veiculo.getChassi() + "%"));
		}
		if (veiculo.getChassiRemarcado() != null && !veiculo.getChassiRemarcado().equals("")) {
			predicates.add(
					criteriaBuilder.like(rootVeiculo.get("chassiRemarcado"), "%" + veiculo.getChassiRemarcado() + "%"));
		}
		if (veiculo.getCidade() != null && !veiculo.getCidade().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cidade"), "%" + veiculo.getCidade() + "%"));
		}
		if (veiculo.getCilindrada() != null && !veiculo.getCilindrada().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cilindrada"), "%" + veiculo.getCilindrada() + "%"));
		}
		if (veiculo.getCilindros() != null && !veiculo.getCilindros().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cilindros"), "%" + veiculo.getCilindros() + "%"));
		}
		if (veiculo.getCmtTon() != null && !veiculo.getCmtTon().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cmtTon"), "%" + veiculo.getCmtTon() + "%"));
		}
		if (veiculo.getCombustivel() != null && !veiculo.getCombustivel().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("combustivel"), "%" + veiculo.getCombustivel() + "%"));
		}
		if (veiculo.getComplemento() != null && !veiculo.getComplemento().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("complemento"), "%" + veiculo.getComplemento() + "%"));
		}
		if (veiculo.getCor() != null && !veiculo.getCor().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cor"), "%" + veiculo.getCor() + "%"));
		}
		if (veiculo.getDataCompra() != null && !veiculo.getDataCompra().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("dataCompra"), "%" + veiculo.getDataCompra() + "%"));
		}
		if (veiculo.getDataVenda() != null && !veiculo.getDataVenda().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("dataVenda"), "%" + veiculo.getDataVenda() + "%"));
		}
		if (veiculo.getEixos() != null && !veiculo.getEixos().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("eixos"), "%" + veiculo.getEixos() + "%"));
		}
		if (veiculo.getEspecie() != null && !veiculo.getEspecie().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("especie"), "%" + veiculo.getEspecie() + "%"));
		}
		if (veiculo.getEstado() != null && !veiculo.getEstado().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("estado"), "%" + veiculo.getEstado() + "%"));
		}
		if (veiculo.getFabricacao() != null && !veiculo.getFabricacao().equals("")) {
			predicates
					.add(criteriaBuilder.like(rootVeiculo.get("fabricacao"), "%" + veiculo.getChassiRemarcado() + "%"));
		}
		if (veiculo.getIpva() != null && !veiculo.getIpva().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("ipva"), "%" + veiculo.getIpva() + "%"));
		}
		if (veiculo.getLogradouro() != null && !veiculo.getLogradouro().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("logradouro"), "%" + veiculo.getLogradouro() + "%"));
		}
		if (veiculo.getMarca() != null && !veiculo.getMarca().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("marca"), "%" + veiculo.getMarca() + "%"));
		}
		if (veiculo.getModelo() != null && !veiculo.getModelo().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("modelo"), "%" + veiculo.getModelo() + "%"));
		}
		if (veiculo.getMunicipioEmplacamento() != null && !veiculo.getMunicipioEmplacamento().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("municipioEmplacamento"),
					"%" + veiculo.getMunicipioEmplacamento() + "%"));
		}
		if (veiculo.getPais() != null && !veiculo.getPais().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("pais"), "%" + veiculo.getPais() + "%"));
		}
		if (veiculo.getPlaca() != null && !veiculo.getPlaca().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("placa"), "%" + veiculo.getPlaca() + "%"));
		}
		if (veiculo.getPotencia() != null && !veiculo.getPotencia().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("potencia"), "%" + veiculo.getPotencia() + "%"));
		}
		if (veiculo.getProprietarioAnteriorCNPJ() != null && !veiculo.getProprietarioAnteriorCNPJ().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorCNPJ"),
					"%" + veiculo.getProprietarioAnteriorCNPJ() + "%"));
		}
		if (veiculo.getProprietarioAnteriorCPF() != null && !veiculo.getProprietarioAnteriorCPF().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorCPF"),
					"%" + veiculo.getProprietarioAnteriorCPF() + "%"));
		}
		if (veiculo.getProprietarioAnteriorEmail() != null && !veiculo.getProprietarioAnteriorEmail().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorEmail"),
					"%" + veiculo.getProprietarioAnteriorEmail() + "%"));
		}
		if (veiculo.getProprietarioAnteriorFax() != null && !veiculo.getProprietarioAnteriorFax().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorFax"),
					"%" + veiculo.getProprietarioAnteriorFax() + "%"));
		}
		if (veiculo.getProprietarioAnteriorFone1() != null && !veiculo.getProprietarioAnteriorFone1().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorFone1"),
					"%" + veiculo.getProprietarioAnteriorFone1() + "%"));
		}
		if (veiculo.getProprietarioAnteriorRGNumero() != null
				&& !veiculo.getProprietarioAnteriorRGNumero().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorRGNumero"),
					"%" + veiculo.getProprietarioAnteriorRGNumero() + "%"));
		}
		if (veiculo.getProprietarioAnteriorRGOrgaoEmisssor() != null
				&& !veiculo.getProprietarioAnteriorRGOrgaoEmisssor().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorRGOrgaoEmisssor"),
					"%" + veiculo.getProprietarioAnteriorRGOrgaoEmisssor() + "%"));
		}
		if (veiculo.getProprietarioFone1() != null && !veiculo.getProprietarioFone1().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioFone1"),
					"%" + veiculo.getProprietarioFone1() + "%"));
		}
		if (veiculo.getProprietarioFone2() != null && !veiculo.getProprietarioFone2().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioFone2"),
					"%" + veiculo.getProprietarioFone2() + "%"));
		}
		if (veiculo.getProprietarioEmail() != null && !veiculo.getProprietarioEmail().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioEmail"),
					"%" + veiculo.getProprietarioEmail() + "%"));
		}
		if (veiculo.getProprietarioNome() != null && !veiculo.getProprietarioNome().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioNome"),
					"%" + veiculo.getProprietarioNome() + "%"));
		}
		if (veiculo.getProprietarioCPF() != null && !veiculo.getProprietarioCPF().equals("")) {
			predicates.add(
					criteriaBuilder.like(rootVeiculo.get("proprietarioCPF"), "%" + veiculo.getProprietarioCPF() + "%"));
		}
		if (veiculo.getProprietarioRGNumero() != null && !veiculo.getProprietarioRGNumero().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioRGNumero"),
					"%" + veiculo.getProprietarioRGNumero() + "%"));
		}
		if (veiculo.getProprietarioRGOrgaoEmisssor() != null && !veiculo.getProprietarioRGOrgaoEmisssor().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioRGOrgaoEmisssor"),
					"%" + veiculo.getProprietarioRGOrgaoEmisssor() + "%"));
		}
		if (veiculo.getRenavam() != null && !veiculo.getRenavam().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("renavam"), "%" + veiculo.getRenavam() + "%"));
		}
		if (veiculo.getRestricoes() != null && !veiculo.getRestricoes().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("restricoes"), "%" + veiculo.getRestricoes() + "%"));
		}
		if (veiculo.getTipo() != null && !veiculo.getTipo().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("tipo"), "%" + veiculo.getTipo() + "%"));
		}
		if (veiculo.getValorCompra() != null && !veiculo.getValorCompra().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("valorCompra"), "%" + veiculo.getValorCompra() + "%"));
		}
		if (veiculo.getValorVenda() != null && !veiculo.getValorVenda().equals("")) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("valorVenda"), "%" + veiculo.getValorVenda() + "%"));
		}

		criteriaQuery.select(rootVeiculo).where(predicates.toArray(new Predicate[] {}));

		List<Veiculo> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;

	}

	@Override
	public void salvarRegistro(Veiculo veiculo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(veiculo);
		tx.commit();
		em.close();
	}
}
