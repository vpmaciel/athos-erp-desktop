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

import arquitetura.JPA;
import arquitetura.validacao.Mascara;

final class CartorioImp implements CartorioDao {

	@Override
	public Cartorio consultarRegistro(Cartorio cartorio) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cartorio> criteriaQuery = criteriaBuilder.createQuery(Cartorio.class);
		Root<Cartorio> rootCartorio = criteriaQuery.from(Cartorio.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (cartorio.getNomeFantasia() != null && cartorio.getNomeFantasia().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootCartorio.get("nomeFantasia"), cartorio.getNomeFantasia()));
			naoTemCriterio = false;

		}
		if (cartorio.getRazaoSocial() != null && cartorio.getRazaoSocial().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootCartorio.get("razaoSocial"), cartorio.getRazaoSocial()));
			naoTemCriterio = false;

		}
		if (cartorio.getCnpj() != null && !cartorio.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !cartorio.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.equal(rootCartorio.get("cnpj"), cartorio.getCnpj()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new Cartorio();
		}

		criteriaQuery.select(rootCartorio).where(predicates.toArray(new Predicate[] {}));

		List<Cartorio> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new Cartorio();
	}

	@Override
	public void deletarRegistro(Cartorio cartorio) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Cartorio.class, cartorio.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Collection<Cartorio> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.cartorio.Cartorio C order by C.nomeFantasia, C.razaoSocial");
		@SuppressWarnings("unchecked")
		List<Cartorio> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Cartorio getRegistro(Cartorio cartorio) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Cartorio.class, cartorio.getId());
	}

	@Override
	public Collection<Cartorio> pesquisarRegistro(Cartorio cartorio) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cartorio> criteriaQuery = criteriaBuilder.createQuery(Cartorio.class);
		Root<Cartorio> rootCartorio = criteriaQuery.from(Cartorio.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (cartorio.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootCartorio.get("id"), cartorio.getId()));
		}
		if (cartorio.getNomeFantasia() != null && cartorio.getNomeFantasia().length() > 0) {
			predicates.add(
					criteriaBuilder.like(rootCartorio.get("nomeFantasia"), "%" + cartorio.getNomeFantasia() + "%"));
		}
		if (cartorio.getRazaoSocial() != null && cartorio.getRazaoSocial().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCartorio.get("razaoSocial"), "%" + cartorio.getRazaoSocial() + "%"));
		}
		if (cartorio.getComarca() != null && cartorio.getComarca().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("comarca"), "%" + cartorio.getComarca() + "%"));
		}
		if (cartorio.getMunicipio() != null && cartorio.getMunicipio().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("municipio"), "%" + cartorio.getMunicipio() + "%"));
		}
		if (cartorio.getDistrito() != null && cartorio.getDistrito().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("distrito"), "%" + cartorio.getDistrito() + "%"));
		}
		if (cartorio.getTitular() != null && cartorio.getTitular().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("titular"), "%" + cartorio.getTitular() + "%"));
		}
		if (cartorio.getSubstituto() != null && cartorio.getSubstituto().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("substituto"), "%" + cartorio.getSubstituto() + "%"));
		}
		if (cartorio.getCnpj() != null && !cartorio.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !cartorio.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cnpj"), "%" + cartorio.getCnpj() + "%"));
		}
		if (cartorio.getFone1() != null && !cartorio.getFone1().equals(Mascara.getFone().getPlaceholder())
				&& !cartorio.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fone1"), "%" + cartorio.getFone1() + "%"));
		}
		if (cartorio.getFone2() != null && !cartorio.getFone2().equals(Mascara.getFone().getPlaceholder())
				&& !cartorio.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fone2"), "%" + cartorio.getFone2() + "%"));
		}
		if (cartorio.getFax() != null && !cartorio.getFax().equals(Mascara.getFax().getPlaceholder())
				&& !cartorio.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fax"), "%" + cartorio.getFax() + "%"));
		}
		if (cartorio.getEmail() != null && cartorio.getEmail().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("email"), "%" + cartorio.getEmail() + "%"));
		}
		if (cartorio.getSite() != null && cartorio.getSite().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("site"), "%" + cartorio.getSite() + "%"));
		}
		if (cartorio.getPais() != null && cartorio.getPais().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("pais"), "%" + cartorio.getPais() + "%"));
		}
		if (cartorio.getEstado() != null && cartorio.getEstado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("estado"), "%" + cartorio.getEstado() + "%"));
		}
		if (cartorio.getCidade() != null && cartorio.getCidade().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cidade"), "%" + cartorio.getCidade() + "%"));
		}
		if (cartorio.getBairro() != null && cartorio.getBairro().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("bairro"), "%" + cartorio.getBairro() + "%"));
		}
		if (cartorio.getLogradouro() != null && cartorio.getLogradouro().length() > 0) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("logradouro"), "%" + cartorio.getLogradouro() + "%"));
		}
		if (cartorio.getComplemento() != null && cartorio.getComplemento().length() > 0) {
			predicates
					.add(criteriaBuilder.like(rootCartorio.get("complemento"), "%" + cartorio.getComplemento() + "%"));
		}
		if (cartorio.getCep() != null && !cartorio.getCep().equals(Mascara.getCep().getPlaceholder())
				&& !cartorio.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cep"), "%" + cartorio.getCep() + "%"));
		}

		criteriaQuery.select(rootCartorio).where(predicates.toArray(new Predicate[] {}));

		List<Cartorio> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Cartorio cartorio) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(cartorio);
		tx.commit();
		em.close();
	}
}
