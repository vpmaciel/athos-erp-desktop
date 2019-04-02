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
import arquitetura.validacao.Mascara;

final class VeiculoImp implements VeiculoDao {

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

		if (naoEstaVazio(veiculo.getId())) {
			predicates.add(criteriaBuilder.equal(rootVeiculo.get("id"), veiculo.getId()));
		}
		if (naoEstaVazio(veiculo.getAnoFabricacao())) {
			predicates.add(
					criteriaBuilder.like(rootVeiculo.get("anoFabricacao"), "%" + veiculo.getAnoFabricacao() + "%"));
		}
		if (naoEstaVazio(veiculo.getAnoModelo())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("anoModelo"), "%" + veiculo.getAnoModelo() + "%"));
		}
		if (naoEstaVazio(veiculo.getAtividade())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("atividade"), "%" + veiculo.getAtividade() + "%"));
		}
		if (naoEstaVazio(veiculo.getBairro())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("bairro"), "%" + veiculo.getBairro() + "%"));
		}
		if (naoEstaVazio(veiculo.getCapCarga())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("capCarga"), "%" + veiculo.getCapCarga() + "%"));
		}
		if (naoEstaVazio(veiculo.getCapacidadePassageiros())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("capacidadePassageiros"),
					"%" + veiculo.getCapacidadePassageiros() + "%"));
		}
		if (naoEstaVazio(veiculo.getCarroceria())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("carroceria"), "%" + veiculo.getCarroceria() + "%"));
		}
		if (naoEstaVazio(veiculo.getCategoria())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("categoria"), "%" + veiculo.getCategoria() + "%"));
		}
		if (veiculo.getCep() != null && !veiculo.getCep().equals(Mascara.getCep().getPlaceholder()) && !veiculo.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cep"), "%" + veiculo.getCep() + "%"));
		}
		if (naoEstaVazio(veiculo.getChassi())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("chassi"), "%" + veiculo.getChassi() + "%"));
		}
		if (naoEstaVazio(veiculo.getChassiRemarcado())) {
			predicates.add(
					criteriaBuilder.like(rootVeiculo.get("chassiRemarcado"), "%" + veiculo.getChassiRemarcado() + "%"));
		}
		if (naoEstaVazio(veiculo.getCidade())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cidade"), "%" + veiculo.getCidade() + "%"));
		}
		if (naoEstaVazio(veiculo.getCilindrada())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cilindrada"), "%" + veiculo.getCilindrada() + "%"));
		}
		if (naoEstaVazio(veiculo.getCilindros())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cilindros"), "%" + veiculo.getCilindros() + "%"));
		}
		if (naoEstaVazio(veiculo.getCmtTon())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cmtTon"), "%" + veiculo.getCmtTon() + "%"));
		}
		if (naoEstaVazio(veiculo.getCombustivel())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("combustivel"), "%" + veiculo.getCombustivel() + "%"));
		}
		if (naoEstaVazio(veiculo.getComplemento())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("complemento"), "%" + veiculo.getComplemento() + "%"));
		}
		if (naoEstaVazio(veiculo.getCor())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("cor"), "%" + veiculo.getCor() + "%"));
		}
		if (veiculo.getDataCompra() != null && !veiculo.getDataCompra().equals(Mascara.getData().getPlaceholder()) && !veiculo.getDataCompra().equals(Mascara.getDataVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("dataCompra"), "%" + veiculo.getDataCompra() + "%"));
		}
		if (veiculo.getDataVenda() != null && !veiculo.getDataVenda().equals(Mascara.getData().getPlaceholder()) && !veiculo.getDataVenda().equals(Mascara.getDataVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("dataVenda"), "%" + veiculo.getDataVenda() + "%"));
		}
		if (naoEstaVazio(veiculo.getEixos())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("eixos"), "%" + veiculo.getEixos() + "%"));
		}
		if (naoEstaVazio(veiculo.getEspecie())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("especie"), "%" + veiculo.getEspecie() + "%"));
		}
		if (naoEstaVazio(veiculo.getEstado())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("estado"), "%" + veiculo.getEstado() + "%"));
		}
		if (naoEstaVazio(veiculo.getFabricacao())) {
			predicates
					.add(criteriaBuilder.like(rootVeiculo.get("fabricacao"), "%" + veiculo.getChassiRemarcado() + "%"));
		}
		if (naoEstaVazio(veiculo.getIpva())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("ipva"), "%" + veiculo.getIpva() + "%"));
		}
		if (naoEstaVazio(veiculo.getLogradouro())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("logradouro"), "%" + veiculo.getLogradouro() + "%"));
		}
		if (naoEstaVazio(veiculo.getMarca())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("marca"), "%" + veiculo.getMarca() + "%"));
		}
		if (naoEstaVazio(veiculo.getModelo())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("modelo"), "%" + veiculo.getModelo() + "%"));
		}
		if (naoEstaVazio(veiculo.getMunicipioEmplacamento())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("municipioEmplacamento"),
					"%" + veiculo.getMunicipioEmplacamento() + "%"));
		}
		if (naoEstaVazio(veiculo.getPais())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("pais"), "%" + veiculo.getPais() + "%"));
		}
		if (naoEstaVazio(veiculo.getPlaca())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("placa"), "%" + veiculo.getPlaca() + "%"));
		}
		if (naoEstaVazio(veiculo.getPotencia())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("potencia"), "%" + veiculo.getPotencia() + "%"));
		}
		if (veiculo.getProprietarioAnteriorCnpj() != null && !veiculo.getProprietarioAnteriorCnpj().equals(Mascara.getCnpj().getPlaceholder()) && !veiculo.getProprietarioAnteriorCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorCnpj"),
					"%" + veiculo.getProprietarioAnteriorCnpj() + "%"));
		}
		if (veiculo.getProprietarioAnteriorCpf() != null && !veiculo.getProprietarioAnteriorCpf().equals(Mascara.getCpf().getPlaceholder()) && !veiculo.getProprietarioAnteriorCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorCpf"),
					"%" + veiculo.getProprietarioAnteriorCpf() + "%"));
		}
		if (naoEstaVazio(veiculo.getProprietarioAnteriorEmail())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorEmail"),
					"%" + veiculo.getProprietarioAnteriorEmail() + "%"));
		}
		if (veiculo.getProprietarioAnteriorFax() != null && !veiculo.getProprietarioAnteriorFax().equals(Mascara.getFax().getPlaceholder()) && !veiculo.getProprietarioAnteriorFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorFax"),
					"%" + veiculo.getProprietarioAnteriorFax() + "%"));
		}
		if (veiculo.getProprietarioAnteriorFone1() != null && !veiculo.getProprietarioAnteriorFone1().equals(Mascara.getFone().getPlaceholder()) && !veiculo.getProprietarioAnteriorFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorFone1"),
					"%" + veiculo.getProprietarioAnteriorFone1() + "%"));
		}
		if (naoEstaVazio(veiculo.getProprietarioAnteriorRGNumero())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorRGNumero"),
					"%" + veiculo.getProprietarioAnteriorRGNumero() + "%"));
		}
		if (naoEstaVazio(veiculo.getProprietarioAnteriorRGOrgaoEmisssor())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorRGOrgaoEmisssor"),
					"%" + veiculo.getProprietarioAnteriorRGOrgaoEmisssor() + "%"));
		}
		if (veiculo.getProprietarioFone1() != null && !veiculo.getProprietarioFone1().equals(Mascara.getFone().getPlaceholder()) && !veiculo.getProprietarioFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioFone1"),
					"%" + veiculo.getProprietarioFone1() + "%"));
		}
		if (veiculo.getProprietarioFone2() != null && !veiculo.getProprietarioFone2().equals(Mascara.getFone().getPlaceholder()) && !veiculo.getProprietarioFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioFone2"),
					"%" + veiculo.getProprietarioFone2() + "%"));
		}
		if (naoEstaVazio(veiculo.getProprietarioEmail())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioEmail"),
					"%" + veiculo.getProprietarioEmail() + "%"));
		}
		if (naoEstaVazio(veiculo.getProprietarioNome())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioNome"),
					"%" + veiculo.getProprietarioNome() + "%"));
		}
		if (veiculo.getProprietarioCpf() != null && !veiculo.getProprietarioCpf().equals(Mascara.getCnpj().getPlaceholder()) && !veiculo.getProprietarioCpf().equals(Mascara.getCnpjVazio())) {
			predicates.add(
					criteriaBuilder.like(rootVeiculo.get("proprietarioCpf"), "%" + veiculo.getProprietarioCpf() + "%"));
		}
		if (naoEstaVazio(veiculo.getProprietarioRGNumero())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioRGNumero"),
					"%" + veiculo.getProprietarioRGNumero() + "%"));
		}
		if (naoEstaVazio(veiculo.getProprietarioRGOrgaoEmisssor())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("proprietarioRGOrgaoEmisssor"),
					"%" + veiculo.getProprietarioRGOrgaoEmisssor() + "%"));
		}
		if (naoEstaVazio(veiculo.getRenavam())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("renavam"), "%" + veiculo.getRenavam() + "%"));
		}
		if (naoEstaVazio(veiculo.getRestricoes())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("restricoes"), "%" + veiculo.getRestricoes() + "%"));
		}
		if (naoEstaVazio(veiculo.getTipo())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("tipo"), "%" + veiculo.getTipo() + "%"));
		}
		if (naoEstaVazio(veiculo.getValorCompra())) {
			predicates.add(criteriaBuilder.like(rootVeiculo.get("valorCompra"), "%" + veiculo.getValorCompra() + "%"));
		}
		if (naoEstaVazio(veiculo.getValorVenda())) {
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
