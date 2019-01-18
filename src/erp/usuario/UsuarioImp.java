package erp.usuario;

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

final class UsuarioImp implements UsuarioDao {

	@Override
	public void deletarRegistro(Usuario usuario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Usuario.class, usuario.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Usuario getRegistro(Usuario usuario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Usuario.class, usuario.getId());
	}

	@Override
	public Collection<Usuario> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.usuario.Usuario U order by U.nome");
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public boolean isRegistroValido(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> rootUsuario = criteriaQuery.from(Usuario.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (usuario.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("id"), usuario.getId()));
		}
		if (usuario.getNome() != null && !usuario.getNome().equals("")) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("nome"), usuario.getNome()));
		}
		if (usuario.getSenha() != null && !usuario.getSenha().equals("")) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("senha"), usuario.getSenha()));
		}
		criteriaQuery.select(rootUsuario).where(predicates.toArray(new Predicate[] {}));

		List<Usuario> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();

		return list.size() > 0;
	}

	@Override
	public Collection<Usuario> pesquisarRegistro(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> rootUsuario = criteriaQuery.from(Usuario.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (usuario.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("id"), usuario.getId()));
		}
		if (usuario.getNome() != null && !usuario.getNome().equals("")) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("nome"), usuario.getNome()));
		}
		if (usuario.getSenha() != null && !usuario.getSenha().equals("")) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("senha"), usuario.getSenha()));
		}
		criteriaQuery.select(rootUsuario).where(predicates.toArray(new Predicate[] {}));

		List<Usuario> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();

		return list;
	}

	@Override
	public void salvarRegistro(Usuario usuario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(usuario);
		tx.commit();
		em.close();
	}
}
