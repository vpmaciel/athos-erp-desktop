package erp.contador;

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

final class ContadorImp implements ContadorDao {

	@Override
	public void deletarRegistro(Contador contador) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Contador.class, contador.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Contador getRegistro(Contador contador) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Contador.class, contador.getId());
	}

	@Override
	public Collection<Contador> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.contador.Contador C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Contador> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Contador> pesquisarRegistro(Contador contador) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contador> criteriaQuery = criteriaBuilder.createQuery(Contador.class);
		Root<Contador> rootContador = criteriaQuery.from(Contador.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (contador.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootContador.get("id"), contador.getId()));
		}
		if (contador.getCnpj() != null && !contador.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !contador.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootContador.get("cnpj"), "%" + contador.getCnpj() + "%"));
		}
		if (contador.getCpf() != null && !contador.getCpf().equals(Mascara.getCpf().getPlaceholder())
				&& !contador.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.like(rootContador.get("cpf"), "%" + contador.getCpf() + "%"));
		}
		if (contador.getCrc() != null && contador.getCrc().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContador.get("crc"), "%" + contador.getCrc() + "%"));
		}
		if (contador.getEmail() != null && contador.getEmail().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContador.get("email"), "%" + contador.getEmail() + "%"));
		}
		if (contador.getFax() != null && !contador.getFax().equals(Mascara.getFax().getPlaceholder())
				&& !contador.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootContador.get("fax"), "%" + contador.getFax() + "%"));
		}
		if (contador.getFone1() != null && !contador.getFone1().equals(Mascara.getFone().getPlaceholder())
				&& !contador.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootContador.get("fone1"), "%" + contador.getFone1() + "%"));
		}
		if (contador.getFone2() != null && !contador.getFone2().equals(Mascara.getFone().getPlaceholder())
				&& !contador.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootContador.get("fone2"), "%" + contador.getFone2() + "%"));
		}
		if (contador.getNome() != null && contador.getNome().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContador.get("nome"), "%" + contador.getNome() + "%"));
		}
		if (contador.getSite() != null && contador.getSite().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContador.get("site"), "%" + contador.getSite() + "%"));
		}

		criteriaQuery.select(rootContador).where(predicates.toArray(new Predicate[] {}));

		List<Contador> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Contador contador) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(contador);
		tx.commit();
		em.close();
	}
}