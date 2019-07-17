package erp.cartorio;

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

final class CartorioImp implements CartorioDao {

	@Override
	public void deletarRegistro(Cartorio cartorio) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Cartorio.class, cartorio.getId()));
			entityTransaction.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	@Override
	public Collection<Cartorio> getRegistro() {
		EntityManager entityManager = Jpa.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Cartorio T order by T.nomeFantasia, T.razaoSocial",
				Cartorio.class);
		@SuppressWarnings("unchecked")
		List<Cartorio> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Cartorio getRegistro(Cartorio cartorio) {
		EntityManager entityManager = Jpa.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Cartorio.class, cartorio.getId());
	}

	@Override
	public Collection<Cartorio> pesquisarRegistro(Cartorio cartorio) {
		EntityManager entityManager = Jpa.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cartorio> criteriaQuery = criteriaBuilder.createQuery(Cartorio.class);
		Root<Cartorio> rootCartorio = criteriaQuery.from(Cartorio.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (cartorio.getId() != null) {
			predicateList.add(criteriaBuilder.equal(rootCartorio.get("id"), cartorio.getId()));
		}
		if (cartorio.getNomeFantasia() != null && cartorio.getNomeFantasia().length() > 0) {
			predicateList.add(
					criteriaBuilder.like(rootCartorio.get("nomeFantasia"), "%" + cartorio.getNomeFantasia() + "%"));
		}
		if (cartorio.getRazaoSocial() != null && cartorio.getRazaoSocial().length() > 0) {
			predicateList
					.add(criteriaBuilder.like(rootCartorio.get("razaoSocial"), "%" + cartorio.getRazaoSocial() + "%"));
		}
		if (cartorio.getComarca() != null && cartorio.getComarca().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("comarca"), "%" + cartorio.getComarca() + "%"));
		}
		if (cartorio.getMunicipio() != null && cartorio.getMunicipio().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("municipio"), "%" + cartorio.getMunicipio() + "%"));
		}
		if (cartorio.getDistrito() != null && cartorio.getDistrito().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("distrito"), "%" + cartorio.getDistrito() + "%"));
		}
		if (cartorio.getTitular() != null && cartorio.getTitular().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("titular"), "%" + cartorio.getTitular() + "%"));
		}
		if (cartorio.getSubstituto() != null && cartorio.getSubstituto().length() > 0) {
			predicateList
					.add(criteriaBuilder.like(rootCartorio.get("substituto"), "%" + cartorio.getSubstituto() + "%"));
		}
		if (cartorio.getCnpj() != null && !cartorio.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !cartorio.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("cnpj"), "%" + cartorio.getCnpj() + "%"));
		}
		if (cartorio.getFone1() != null && !cartorio.getFone1().equals(Mascara.getFone().getPlaceholder())
				&& !cartorio.getFone1().equals(Mascara.getFoneVazio())) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("fone1"), "%" + cartorio.getFone1() + "%"));
		}
		if (cartorio.getFone2() != null && !cartorio.getFone2().equals(Mascara.getFone().getPlaceholder())
				&& !cartorio.getFone2().equals(Mascara.getFoneVazio())) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("fone2"), "%" + cartorio.getFone2() + "%"));
		}
		if (cartorio.getFax() != null && !cartorio.getFax().equals(Mascara.getFax().getPlaceholder())
				&& !cartorio.getFax().equals(Mascara.getFaxVazio())) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("fax"), "%" + cartorio.getFax() + "%"));
		}
		if (cartorio.getEmail() != null && cartorio.getEmail().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("email"), "%" + cartorio.getEmail() + "%"));
		}
		if (cartorio.getSite() != null && cartorio.getSite().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("site"), "%" + cartorio.getSite() + "%"));
		}
		if (cartorio.getEnderecoPais() != null && cartorio.getEnderecoPais().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("enderecoPais"), "%" + cartorio.getEnderecoPais() + "%"));
		}
		if (cartorio.getEnderecoEstado() != null && cartorio.getEnderecoEstado().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("enderecoEstado"), "%" + cartorio.getEnderecoEstado() + "%"));
		}
		if (cartorio.getEnderecoCidade() != null && cartorio.getEnderecoCidade().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("enderecoCidade"), "%" + cartorio.getEnderecoCidade() + "%"));
		}
		if (cartorio.getEnderecoBairro() != null && cartorio.getEnderecoBairro().length() > 0) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("enderecoBairro"), "%" + cartorio.getEnderecoBairro() + "%"));
		}
		if (cartorio.getEnderecoLogradouro() != null && cartorio.getEnderecoLogradouro().length() > 0) {
			predicateList
					.add(criteriaBuilder.like(rootCartorio.get("enderecoLogradouro"), "%" + cartorio.getEnderecoLogradouro() + "%"));
		}
		if (cartorio.getEnderecoComplemento() != null && cartorio.getEnderecoComplemento().length() > 0) {
			predicateList
					.add(criteriaBuilder.like(rootCartorio.get("enderecoComplemento"), "%" + cartorio.getEnderecoComplemento() + "%"));
		}
		if (cartorio.getEnderecoCep() != null && !cartorio.getEnderecoCep().equals(Mascara.getEnderecoCep().getPlaceholder())
				&& !cartorio.getEnderecoCep().equals(Mascara.getEnderecoCepVazio())) {
			predicateList.add(criteriaBuilder.like(rootCartorio.get("enderecoCep"), "%" + cartorio.getEnderecoCep() + "%"));
		}

		criteriaQuery.select(rootCartorio).where(predicateList.toArray(new Predicate[] {}));

		List<Cartorio> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Cartorio cartorio) {
		EntityManager entityManager = Jpa.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(cartorio);
		entityTransaction.commit();
		entityManager.close();
	}
}
