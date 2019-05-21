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
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Usuario.class, usuario.getId()));
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
	public Collection<Usuario> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Usuario> usuarioList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Usuario T order by T.nome", Usuario.class);
			usuarioList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return usuarioList;
	}

	@Override
	public Usuario getRegistro(Usuario usuario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			usuario = entityManager.find(Usuario.class, usuario.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return usuario;
	}

	@Override
	public Collection<Usuario> pesquisarRegistro(Usuario usuario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Usuario> usuarioList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
			Root<Usuario> rootUsuario = criteriaQuery.from(Usuario.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if (usuario.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootUsuario.get("id"), usuario.getId()));
			}
			if (usuario.getNome() != null && usuario.getNome().length() > 0) {
				predicateList.add(criteriaBuilder.equal(rootUsuario.get("nome"), usuario.getNome()));
			}
			if (usuario.getSenha() != null && usuario.getSenha().length() > 0) {
				predicateList.add(criteriaBuilder.equal(rootUsuario.get("senha"), usuario.getSenha()));
			}
			criteriaQuery.select(rootUsuario).where(predicateList.toArray(new Predicate[] {}));
			usuarioList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return usuarioList;
	}

	@Override
	public boolean isRegistroValido(Usuario usuario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Usuario> usuarioList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
			Root<Usuario> rootUsuario = criteriaQuery.from(Usuario.class);

			List<Predicate> predicateList = new ArrayList<Predicate>();
			
			if (usuario.getNome() != null && !usuario.getNome().equals("")) {
				predicateList.add(criteriaBuilder.equal(rootUsuario.get("nome"), usuario.getNome()));
			}
			if (usuario.getSenha() != null && !usuario.getSenha().equals("")) {
				predicateList.add(criteriaBuilder.equal(rootUsuario.get("senha"), usuario.getSenha()));
			}
			criteriaQuery.select(rootUsuario).where(predicateList.toArray(new Predicate[] {}));

			usuarioList = entityManager.createQuery(criteriaQuery).getResultList();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

		return usuarioList.size() == 1;
	}

	@Override
	public void salvarRegistro(Usuario usuario) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(usuario);
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