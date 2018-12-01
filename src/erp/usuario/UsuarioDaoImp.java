package erp.usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class UsuarioDaoImp implements UsuarioDao {

	@Override
	public String construirQuery(StringBuilder stringBuilder) {
		String PesquisaRegistro = stringBuilder.toString();
		if (PesquisaRegistro.endsWith("and")) {
			PesquisaRegistro = stringBuilder.substring(0, stringBuilder.length() - 4);
			stringBuilder = new StringBuilder(PesquisaRegistro);
		}
		if (PesquisaRegistro.endsWith("where")) {
			PesquisaRegistro = stringBuilder.substring(0, stringBuilder.length() - 5);
			stringBuilder = new StringBuilder(PesquisaRegistro);
		}
		stringBuilder.append(" order by U.nome");
		PesquisaRegistro = stringBuilder.toString();
		return PesquisaRegistro;
	}

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
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select U from erp.usuario.Usuario U where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		if (usuario.getId() != null && !usuario.getId().equals("")) {
			qsb.append(" U.id = :id and");
			parametros.put("id", usuario.getId());
		}
		if (usuario.getNome() != null && !usuario.getNome().trim().equals("")) {
			qsb.append(" U.nome like :nome and");
			parametros.put("nome", "%" + usuario.getNome() + "%");
		}
		if (usuario.getSenha() != null && !usuario.getSenha().trim().equals("")) {
			qsb.append(" U.senha like :senha and");
			parametros.put("senha", "%" + usuario.getSenha() + "%");
		}

		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery(this.construirQuery(qsb));

		Set<Map.Entry<String, Object>> set = parametros.entrySet();

		for (Map.Entry<String, Object> me : set) {
			query.setParameter(me.getKey(), me.getValue());
		}

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.getResultList();
		tx.commit();
		em.close();

		return list.size() > 0;
	}

	@Override
	public Collection<Usuario> pesquisarRegistro(Usuario usuario) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select U from erp.usuario.Usuario U where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (usuario.getId() != null) {
			qsb.append(" U.id = :id and");
			parametros.put("id", usuario.getId());
		}
		if (usuario.getNome() != null && !usuario.getNome().trim().equals("")) {
			qsb.append(" U.nome like :nome and");
			parametros.put("nome", "%" + usuario.getNome() + "%");
		}
		if (usuario.getSenha() != null && !usuario.getSenha().trim().equals("")) {
			qsb.append(" U.senha like :senha and");
			parametros.put("senha", "%" + usuario.getSenha() + "%");
		}

		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery(this.construirQuery(qsb));

		Set<Map.Entry<String, Object>> set = parametros.entrySet();

		for (Map.Entry<String, Object> me : set) {
			query.setParameter(me.getKey(), me.getValue());
		}

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.getResultList();
		tx.commit();
		em.close();
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
