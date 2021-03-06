package erp.imovel;

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

final class ImovelImp implements ImovelDao {

	@Override
	public void deletarRegistro(Imovel imovel) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Imovel.class, imovel.getId()));
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
	public Collection<Imovel> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Imovel> imovelList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Imovel T order by T.nomeProprietario", Imovel.class);
			imovelList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return imovelList;
	}

	@Override
	public Imovel getRegistro(Imovel imovel) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			imovel = entityManager.find(Imovel.class, imovel.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return imovel;
	}

	@Override
	public Collection<Imovel> pesquisarRegistro(Imovel imovel) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Imovel> imovelList = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Imovel> criteriaQuery = criteriaBuilder.createQuery(Imovel.class);
			Root<Imovel> rootImovel = criteriaQuery.from(Imovel.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (imovel.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootImovel.get("id"), imovel.getId()));
			}
			if (imovel.getEnderecoBairro() != null && imovel.getEnderecoBairro().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("enderecoBairro"), "%" + imovel.getEnderecoBairro() + "%"));
			}
			if (imovel.getBanheiro() != null && imovel.getBanheiro().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("banheiro"), "%" + imovel.getBanheiro() + "%"));
			}
			if (imovel.getEnderecoCep() != null && !imovel.getEnderecoCep().equals(Mascara.getEnderecoCep().getPlaceholder())
					&& !imovel.getEnderecoCep().equals(Mascara.getEnderecoCepVazio())) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("enderecoCep"), "%" + imovel.getEnderecoCep() + "%"));
			}
			if (imovel.getEnderecoCidade() != null && imovel.getEnderecoCidade().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("enderecoCidade"), "%" + imovel.getEnderecoCidade() + "%"));
			}
			if (imovel.getCnpj() != null && !imovel.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
					&& !imovel.getCnpj().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("cnpj"), "%" + imovel.getCnpj() + "%"));
			}
			if (imovel.getEnderecoComplemento() != null && imovel.getEnderecoComplemento().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootImovel.get("enderecoComplemento"), "%" + imovel.getEnderecoComplemento() + "%"));
			}
			if (imovel.getCozinha() != null && imovel.getCozinha().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("cozinha"), "%" + imovel.getCozinha() + "%"));
			}
			if (imovel.getCpf() != null && !imovel.getCpf().equals(Mascara.getCpf().getPlaceholder())
					&& !imovel.getCpf().equals(Mascara.getCpfVazio())) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("cpf"), "%" + imovel.getCpf() + "%"));
			}
			if (imovel.getEmail() != null && imovel.getEmail().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("email"), "%" + imovel.getEmail() + "%"));
			}
			if (imovel.getEnderecoEstado() != null && imovel.getEnderecoEstado().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("enderecoEstado"), "%" + imovel.getEnderecoEstado() + "%"));
			}
			if (imovel.getFax() != null && !imovel.getFax().equals(Mascara.getFax().getPlaceholder())
					&& !imovel.getFax().equals(Mascara.getFaxVazio())) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("fax"), "%" + imovel.getFax() + "%"));
			}
			if (imovel.getFone1() != null && !imovel.getFone1().equals(Mascara.getFone().getPlaceholder())
					&& !imovel.getFone1().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("fone1"), "%" + imovel.getFone1() + "%"));
			}
			if (imovel.getFone2() != null && !imovel.getFone2().equals(Mascara.getFone().getPlaceholder())
					&& !imovel.getFone2().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("fone2"), "%" + imovel.getFone2() + "%"));
			}
			if (imovel.getGaragem() != null && imovel.getGaragem().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("garagem"), "%" + imovel.getGaragem() + "%"));
			}
			if (imovel.getEnderecoLogradouro() != null && imovel.getEnderecoLogradouro().length() > 0) {
				predicateList
						.add(criteriaBuilder.like(rootImovel.get("enderecoLogradouro"), "%" + imovel.getEnderecoLogradouro() + "%"));
			}
			if (imovel.getNomeProprietario() != null && imovel.getNomeProprietario().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("nomeProprietario"),
						"%" + imovel.getNomeProprietario() + "%"));
			}
			if (imovel.getEnderecoPais() != null && imovel.getPiscina().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("pais"), "%" + imovel.getEnderecoPais() + "%"));
			}
			if (imovel.getPiscina() != null && imovel.getPiscina().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("piscina"), "%" + imovel.getPiscina() + "%"));
			}
			if (imovel.getQuarto() != null && imovel.getQuarto().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("quarto"), "%" + imovel.getQuarto() + "%"));
			}
			if (imovel.getSala() != null && imovel.getSala().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("sala"), "%" + imovel.getSala() + "%"));
			}
			if (imovel.getSuite() != null && imovel.getSuite().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("suite"), "%" + imovel.getSuite() + "%"));
			}
			if (imovel.getTerraco() != null && imovel.getTerraco().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("terraco"), "%" + imovel.getTerraco() + "%"));
			}
			if (imovel.getVaranda() != null && imovel.getVaranda().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootImovel.get("varanda"), "%" + imovel.getVaranda() + "%"));
			}

			criteriaQuery.select(rootImovel).where(predicateList.toArray(new Predicate[] {}));
			imovelList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return imovelList;
	}

	@Override
	public void salvarRegistro(Imovel imovel) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(imovel);
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