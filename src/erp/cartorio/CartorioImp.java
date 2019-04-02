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

		if (naoEstaVazio(cartorio.getId())) {
			predicates.add(criteriaBuilder.equal(rootCartorio.get("id"), cartorio.getId()));
		}
		if (naoEstaVazio(cartorio.getNomeFantasia())) {
			predicates.add(
					criteriaBuilder.like(rootCartorio.get("nomeFantasia"), "%" + cartorio.getNomeFantasia() + "%"));
		}
		if (naoEstaVazio(cartorio.getRazaoSocial())) {
			predicates
					.add(criteriaBuilder.like(rootCartorio.get("razaoSocial"), "%" + cartorio.getRazaoSocial() + "%"));
		}
		if (naoEstaVazio(cartorio.getComarca())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("comarca"), "%" + cartorio.getComarca() + "%"));
		}
		if (naoEstaVazio(cartorio.getMunicipio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("municipio"), "%" + cartorio.getMunicipio() + "%"));
		}
		if (naoEstaVazio(cartorio.getDistrito())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("distrito"), "%" + cartorio.getDistrito() + "%"));
		}
		if (naoEstaVazio(cartorio.getTitular())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("titular"), "%" + cartorio.getTitular() + "%"));
		}
		if (naoEstaVazio(cartorio.getSubstituto())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("substituto"), "%" + cartorio.getSubstituto() + "%"));
		}
		if (cartorio.getCnpj() != null && !cartorio.getCnpj().equals(Mascara.getCnpj().getPlaceholder()) && !cartorio.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cnpj"), "%" + cartorio.getCnpj() + "%"));
		}
		if (cartorio.getFone1() != null && !cartorio.getFone1().equals(Mascara.getFone().getPlaceholder()) && !cartorio.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fone1"), "%" + cartorio.getFone1() + "%"));
		}
		if (cartorio.getFone2() != null && !cartorio.getFone2().equals(Mascara.getFone().getPlaceholder()) && !cartorio.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fone2"), "%" + cartorio.getFone2() + "%"));
		}
		if (cartorio.getFax() != null && !cartorio.getFax().equals(Mascara.getFax().getPlaceholder()) && !cartorio.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("fax"), "%" + cartorio.getFax() + "%"));
		}
		if (naoEstaVazio(cartorio.getEmail())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("email"), "%" + cartorio.getEmail() + "%"));
		}
		if (naoEstaVazio(cartorio.getSite())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("site"), "%" + cartorio.getSite() + "%"));
		}
		if (naoEstaVazio(cartorio.getPais())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("pais"), "%" + cartorio.getPais() + "%"));
		}
		if (naoEstaVazio(cartorio.getEstado())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("estado"), "%" + cartorio.getEstado() + "%"));
		}
		if (naoEstaVazio(cartorio.getCidade())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("cidade"), "%" + cartorio.getCidade() + "%"));
		}
		if (naoEstaVazio(cartorio.getBairro())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("bairro"), "%" + cartorio.getBairro() + "%"));
		}
		if (naoEstaVazio(cartorio.getLogradouro())) {
			predicates.add(criteriaBuilder.like(rootCartorio.get("logradouro"), "%" + cartorio.getLogradouro() + "%"));
		}
		if (naoEstaVazio(cartorio.getComplemento())) {
			predicates
					.add(criteriaBuilder.like(rootCartorio.get("complemento"), "%" + cartorio.getComplemento() + "%"));
		}
		if (cartorio.getCep() != null && !cartorio.getCep().equals(Mascara.getCep().getPlaceholder()) && !cartorio.getCep().equals(Mascara.getCepVazio())) {
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
