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

final class CartorioDaoImp implements CartorioDao {

	@Override
	public void deletarCartorio(Cartorio cartorio) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Cartorio.class, cartorio.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Cartorio getCartorio(Cartorio cartorio) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Cartorio.class, cartorio.getId());
	}

	@Override
	public Collection<Cartorio> getCartorioTodos() {
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
	public Collection<Cartorio> pesquisarRegistroCartorio(Cartorio cartorio) {
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
		if (cartorio.getNomeFantasia() != null && !cartorio.getNomeFantasia().equals("")) {
			predicates.add(
					criteriaBuilder.like(rootCartorio.get("nomeFantasia"), "%" + cartorio.getNomeFantasia() + "%"));
		}
		if (cartorio.getRazaoSocial() != null && !cartorio.getRazaoSocial().equals("")) {
			predicates
					.add(criteriaBuilder.like(rootCartorio.get("razaoSocial"), "%" + cartorio.getRazaoSocial() + "%"));
		}
		if (cartorio.getComarca() != null && !cartorio.getComarca().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("comarca"), "%" + cartorio.getComarca() + "%"));
		}
		if (cartorio.getMunicipio() != null && !cartorio.getMunicipio().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("municipio"), "%" + cartorio.getMunicipio() + "%"));
		}
		if (cartorio.getDistrito() != null && !cartorio.getDistrito().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("distrito"), "%" + cartorio.getDistrito() + "%"));
		}
		if (cartorio.getTitular() != null && !cartorio.getTitular().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("titular"), "%" + cartorio.getTitular() + "%"));
		}
		if (cartorio.getSubstituto() != null && !cartorio.getSubstituto().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("substituto"), "%" + cartorio.getSubstituto() + "%"));
		}
		if (cartorio.getCnpj() != null && !cartorio.getCnpj().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cnpj"), "%" + cartorio.getCnpj() + "%"));
		}
		if (cartorio.getFone1() != null && !cartorio.getFone1().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fone1"), "%" + cartorio.getFone1() + "%"));
		}
		if (cartorio.getFone2() != null && !cartorio.getFone2().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fone2"), "%" + cartorio.getFone2() + "%"));
		}
		if (cartorio.getFax() != null && !cartorio.getFax().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fax"), "%" + cartorio.getFax() + "%"));
		}
		if (cartorio.getEmail() != null && !cartorio.getEmail().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("email"), "%" + cartorio.getEmail() + "%"));
		}
		if (cartorio.getSite() != null && !cartorio.getSite().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("site"), "%" + cartorio.getSite() + "%"));
		}
		if (cartorio.getPais() != null && !cartorio.getPais().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("pais"), "%" + cartorio.getPais() + "%"));
		}
		if (cartorio.getEstado() != null && !cartorio.getEstado().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("estado"), "%" + cartorio.getEstado() + "%"));
		}
		if (cartorio.getCidade() != null && !cartorio.getCidade().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cidade"), "%" + cartorio.getCidade() + "%"));
		}
		if (cartorio.getBairro() != null && !cartorio.getBairro().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("bairro"), "%" + cartorio.getBairro() + "%"));
		}
		if (cartorio.getLogradouro() != null && !cartorio.getLogradouro().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("logradouro"), "%" + cartorio.getLogradouro() + "%"));
		}
		if (cartorio.getComplemento() != null && !cartorio.getComplemento().equals("")) {
			predicates
					.add(criteriaBuilder.like(rootCartorio.get("complemento"), "%" + cartorio.getComplemento() + "%"));
		}
		if (cartorio.getCep() != null && !cartorio.getCep().equals("")) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cep"), "%" + cartorio.getCep() + "%"));
		}

		criteriaQuery.select(rootCartorio).where(predicates.toArray(new Predicate[] {}));

		List<Cartorio> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;

	}

	@Override
	public void salvarCartorio(Cartorio cartorio) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(cartorio);
		tx.commit();
		em.close();
	}
}
