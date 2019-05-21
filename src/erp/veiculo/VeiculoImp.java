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
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Veiculo.class, veiculo.getId()));
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
	public Collection<Veiculo> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Veiculo> veiculoList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Veiculo T order by T.modelo, T.marca",
					Veiculo.class);
			veiculoList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoList;
	}

	@Override
	public Veiculo getRegistro(Veiculo veiculo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			veiculo = entityManager.find(Veiculo.class, veiculo.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculo;
	}

	@Override
	public Collection<Veiculo> pesquisarRegistro(Veiculo veiculo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Veiculo> veiculoList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Veiculo> criteriaQuery = criteriaBuilder.createQuery(Veiculo.class);
			Root<Veiculo> rootVeiculo = criteriaQuery.from(Veiculo.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (veiculo.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootVeiculo.get("id"), veiculo.getId()));
			}
			if (veiculo.getAnoFabricacao() != null && veiculo.getAnoFabricacao().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootVeiculo.get("anoFabricacao"), "%" + veiculo.getAnoFabricacao() + "%"));
			}
			if (veiculo.getAnoModelo() != null && veiculo.getAnoModelo().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("anoModelo"), "%" + veiculo.getAnoModelo() + "%"));
			}
			if (veiculo.getAtividade() != null && veiculo.getAtividade().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("atividade"), "%" + veiculo.getAtividade() + "%"));
			}
			if (veiculo.getBairro() != null && veiculo.getBairro().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("bairro"), "%" + veiculo.getBairro() + "%"));
			}
			if (veiculo.getCapCarga() != null && veiculo.getCapCarga().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("capCarga"), "%" + veiculo.getCapCarga() + "%"));
			}
			if (veiculo.getCapacidadePassageiros() != null && veiculo.getCapacidadePassageiros().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("capacidadePassageiros"),
						"%" + veiculo.getCapacidadePassageiros() + "%"));
			}
			if (veiculo.getCarroceria() != null && veiculo.getCarroceria().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("carroceria"), "%" + veiculo.getCarroceria() + "%"));
			}
			if (veiculo.getCategoria() != null && veiculo.getCategoria().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("categoria"), "%" + veiculo.getCategoria() + "%"));
			}
			if (veiculo.getCep() != null && !veiculo.getCep().equals(Mascara.getCep().getPlaceholder())
					&& !veiculo.getCep().equals(Mascara.getCepVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("cep"), "%" + veiculo.getCep() + "%"));
			}
			if (veiculo.getChassi() != null && veiculo.getChassi().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("chassi"), "%" + veiculo.getChassi() + "%"));
			}
			if (veiculo.getChassiRemarcado() != null && veiculo.getChassiRemarcado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("chassiRemarcado"),
						"%" + veiculo.getChassiRemarcado() + "%"));
			}
			if (veiculo.getCidade() != null && veiculo.getCidade().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("cidade"), "%" + veiculo.getCidade() + "%"));
			}
			if (veiculo.getCilindrada() != null && veiculo.getCilindrada().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("cilindrada"), "%" + veiculo.getCilindrada() + "%"));
			}
			if (veiculo.getCilindros() != null && veiculo.getCilindros().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("cilindros"), "%" + veiculo.getCilindros() + "%"));
			}
			if (veiculo.getCmtTon() != null && veiculo.getCmtTon().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("cmtTon"), "%" + veiculo.getCmtTon() + "%"));
			}
			if (veiculo.getCombustivel() != null && veiculo.getCombustivel().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootVeiculo.get("combustivel"), "%" + veiculo.getCombustivel() + "%"));
			}
			if (veiculo.getComplemento() != null && veiculo.getComplemento().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootVeiculo.get("complemento"), "%" + veiculo.getComplemento() + "%"));
			}
			if (veiculo.getCor() != null && veiculo.getCor().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("cor"), "%" + veiculo.getCor() + "%"));
			}
			if (veiculo.getDataCompra() != null && !veiculo.getDataCompra().equals(Mascara.getData().getPlaceholder())
					&& !veiculo.getDataCompra().equals(Mascara.getDataVazio())) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("dataCompra"), "%" + veiculo.getDataCompra() + "%"));
			}
			if (veiculo.getDataVenda() != null && !veiculo.getDataVenda().equals(Mascara.getData().getPlaceholder())
					&& !veiculo.getDataVenda().equals(Mascara.getDataVazio())) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("dataVenda"), "%" + veiculo.getDataVenda() + "%"));
			}
			if (veiculo.getEixos() != null && veiculo.getEixos().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("eixos"), "%" + veiculo.getEixos() + "%"));
			}
			if (veiculo.getEspecie() != null && veiculo.getEspecie().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("especie"), "%" + veiculo.getEspecie() + "%"));
			}
			if (veiculo.getEstado() != null && veiculo.getEstado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("estado"), "%" + veiculo.getEstado() + "%"));
			}
			if (veiculo.getFabricacao() != null && veiculo.getFabricacao().length() > 0) {
				predicateList.add(
						criteriaBuilder.like(rootVeiculo.get("fabricacao"), "%" + veiculo.getChassiRemarcado() + "%"));
			}
			if (veiculo.getIpva() != null && veiculo.getIpva().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("ipva"), "%" + veiculo.getIpva() + "%"));
			}
			if (veiculo.getLogradouro() != null && veiculo.getLogradouro().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("logradouro"), "%" + veiculo.getLogradouro() + "%"));
			}
			if (veiculo.getMarca() != null) {
				predicateList.add(criteriaBuilder.equal(rootVeiculo.get("marca"), veiculo.getMarca()));
			}
			if (veiculo.getModelo() != null) {
				predicateList.add(criteriaBuilder.equal(rootVeiculo.get("modelo"), veiculo.getModelo()));
			}
			if (veiculo.getMunicipioEmplacamento() != null && veiculo.getMunicipioEmplacamento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("municipioEmplacamento"),
						"%" + veiculo.getMunicipioEmplacamento() + "%"));
			}
			if (veiculo.getPais() != null && veiculo.getPais().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("pais"), "%" + veiculo.getPais() + "%"));
			}
			if (veiculo.getPlaca() != null && veiculo.getPlaca().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("placa"), "%" + veiculo.getPlaca() + "%"));
			}
			if (veiculo.getPotencia() != null && veiculo.getPotencia().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("potencia"), "%" + veiculo.getPotencia() + "%"));
			}
			if (veiculo.getProprietarioAnteriorCnpj() != null
					&& !veiculo.getProprietarioAnteriorCnpj().equals(Mascara.getCnpj().getPlaceholder())
					&& !veiculo.getProprietarioAnteriorCnpj().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorCnpj"),
						"%" + veiculo.getProprietarioAnteriorCnpj() + "%"));
			}
			if (veiculo.getProprietarioAnteriorCpf() != null
					&& !veiculo.getProprietarioAnteriorCpf().equals(Mascara.getCpf().getPlaceholder())
					&& !veiculo.getProprietarioAnteriorCpf().equals(Mascara.getCpfVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorCpf"),
						"%" + veiculo.getProprietarioAnteriorCpf() + "%"));
			}
			if (veiculo.getProprietarioAnteriorEmail() != null && veiculo.getProprietarioAnteriorEmail().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorEmail"),
						"%" + veiculo.getProprietarioAnteriorEmail() + "%"));
			}
			if (veiculo.getProprietarioAnteriorFax() != null
					&& !veiculo.getProprietarioAnteriorFax().equals(Mascara.getFax().getPlaceholder())
					&& !veiculo.getProprietarioAnteriorFax().equals(Mascara.getFaxVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorFax"),
						"%" + veiculo.getProprietarioAnteriorFax() + "%"));
			}
			if (veiculo.getProprietarioAnteriorFone1() != null
					&& !veiculo.getProprietarioAnteriorFone1().equals(Mascara.getFone().getPlaceholder())
					&& !veiculo.getProprietarioAnteriorFone1().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorFone1"),
						"%" + veiculo.getProprietarioAnteriorFone1() + "%"));
			}
			if (veiculo.getProprietarioAnteriorRGNumero() != null
					&& veiculo.getProprietarioAnteriorRGNumero().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorRGNumero"),
						"%" + veiculo.getProprietarioAnteriorRGNumero() + "%"));
			}
			if (veiculo.getProprietarioAnteriorRGOrgaoEmisssor() != null
					&& veiculo.getProprietarioAnteriorRGOrgaoEmisssor().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioAnteriorRGOrgaoEmisssor"),
						"%" + veiculo.getProprietarioAnteriorRGOrgaoEmisssor() + "%"));
			}
			if (veiculo.getProprietarioFone1() != null
					&& !veiculo.getProprietarioFone1().equals(Mascara.getFone().getPlaceholder())
					&& !veiculo.getProprietarioFone1().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioFone1"),
						"%" + veiculo.getProprietarioFone1() + "%"));
			}
			if (veiculo.getProprietarioFone2() != null
					&& !veiculo.getProprietarioFone2().equals(Mascara.getFone().getPlaceholder())
					&& !veiculo.getProprietarioFone2().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioFone2"),
						"%" + veiculo.getProprietarioFone2() + "%"));
			}
			if (veiculo.getProprietarioEmail() != null && veiculo.getProprietarioEmail().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioEmail"),
						"%" + veiculo.getProprietarioEmail() + "%"));
			}
			if (veiculo.getProprietarioNome() != null && veiculo.getProprietarioNome().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioNome"),
						"%" + veiculo.getProprietarioNome() + "%"));
			}
			if (veiculo.getProprietarioCpf() != null
					&& !veiculo.getProprietarioCpf().equals(Mascara.getCnpj().getPlaceholder())
					&& !veiculo.getProprietarioCpf().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioCpf"),
						"%" + veiculo.getProprietarioCpf() + "%"));
			}
			if (veiculo.getProprietarioRGNumero() != null && veiculo.getProprietarioRGNumero().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioRGNumero"),
						"%" + veiculo.getProprietarioRGNumero() + "%"));
			}
			if (veiculo.getProprietarioRGOrgaoEmisssor() != null
					&& veiculo.getProprietarioRGOrgaoEmisssor().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("proprietarioRGOrgaoEmisssor"),
						"%" + veiculo.getProprietarioRGOrgaoEmisssor() + "%"));
			}
			if (veiculo.getRenavam() != null && veiculo.getRenavam().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("renavam"), "%" + veiculo.getRenavam() + "%"));
			}
			if (veiculo.getRestricoes() != null && veiculo.getRestricoes().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootVeiculo.get("restricoes"), "%" + veiculo.getRestricoes() + "%"));
			}
			if (veiculo.getTipo() != null && veiculo.getTipo().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootVeiculo.get("tipo"), "%" + veiculo.getTipo() + "%"));
			}
			if (veiculo.getValorCompra() > 0) {
				predicateList.add(
						criteriaBuilder.lessThanOrEqualTo(rootVeiculo.get("valorCompra"), veiculo.getValorCompra()));
			}
			if (veiculo.getValorVenda() > 0) {
				predicateList
						.add(criteriaBuilder.lessThanOrEqualTo(rootVeiculo.get("valorVenda"), veiculo.getValorVenda()));
			}

			criteriaQuery.select(rootVeiculo).where(predicateList.toArray(new Predicate[] {}));
			veiculoList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return veiculoList;
	}

	@Override
	public void salvarRegistro(Veiculo veiculo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(veiculo);
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