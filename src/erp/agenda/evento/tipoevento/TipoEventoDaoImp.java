package erp.agenda.evento.tipoevento;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class TipoEventoDaoImp implements TipoEventoDao {

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
		stringBuilder.append(" order by C.nome");
		PesquisaRegistro = stringBuilder.toString();
		return PesquisaRegistro;
	}

	@Override
	public void deletarRegistro(TipoEvento tipoEvento) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(TipoEvento.class, tipoEvento.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public TipoEvento getRegistro(TipoEvento tipoEvento) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(TipoEvento.class, tipoEvento.getId());
	}

	@Override
	public Collection<TipoEvento> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.evento.tipoevento.TipoEvento C order by C.nome");
		@SuppressWarnings("unchecked")
		List<TipoEvento> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<TipoEvento> pesquisarRegistro(TipoEvento tipoEvento) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.agenda.evento.tipoevento.TipoEvento C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (tipoEvento.getId() != null && !tipoEvento.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", tipoEvento.getId());
		}
		if (tipoEvento.getNome() != null && !tipoEvento.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + tipoEvento.getNome().toUpperCase() + "%");
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
		List<TipoEvento> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(TipoEvento tipoEvento) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(tipoEvento);
		tx.commit();
		em.close();
	}
}
