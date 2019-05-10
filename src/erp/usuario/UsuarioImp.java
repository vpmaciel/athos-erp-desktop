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
	public Usuario consultarRegistro(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> rootUsuario = criteriaQuery.from(Usuario.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTemCriterio = true;

		if (usuario.getNome() != null && usuario.getNome().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("nome"), usuario.getNome()));
			naoTemCriterio = false;
		}

		if (naoTemCriterio) {
			return new Usuario();
		}

		criteriaQuery.select(rootUsuario).where(predicates.toArray(new Predicate[] {}));

		List<Usuario> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();

		return list.size() > 0 ? list.get(0) : new Usuario();
	}

	@Override
	public void deletarRegistro(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Usuario.class, usuario.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Usuario> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Usuario T order by T.nome", Usuario.class);
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Usuario getRegistro(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Usuario.class, usuario.getId());
	}

	@Override
	public boolean isRegistroValido(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

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
		entityTransaction.commit();
		entityManager.close();

		return list.size() > 0;
	}

	@Override
	public Collection<Usuario> pesquisarRegistro(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> rootUsuario = criteriaQuery.from(Usuario.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (usuario.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("id"), usuario.getId()));
		}
		if (usuario.getNome() != null && usuario.getNome().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("nome"), usuario.getNome()));
		}
		if (usuario.getSenha() != null && usuario.getSenha().length() > 0) {
			predicates.add(criteriaBuilder.equal(rootUsuario.get("senha"), usuario.getSenha()));
		}
		criteriaQuery.select(rootUsuario).where(predicates.toArray(new Predicate[] {}));

		List<Usuario> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();

		return list;
	}

	@Override
	public void salvarRegistro(Usuario usuario) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(usuario);
		entityTransaction.commit();
		entityManager.close();
	}
}
