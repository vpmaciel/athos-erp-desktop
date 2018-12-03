package erp.veiculomodelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class VeiculoModeloDaoImp implements VeiculoModeloDao {

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
		stringBuilder.append(" order by C.modelo");
		PesquisaRegistro = stringBuilder.toString();
		return PesquisaRegistro;
	}

	@Override
	public void deletarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(VeiculoModelo.class, veiculoModelo.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public VeiculoModelo getRegistro(VeiculoModelo veiculoModelo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(VeiculoModelo.class, veiculoModelo.getId());
	}

	@Override
	public Collection<VeiculoModelo> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.veiculo.modelo.VeiculoModelo C order by C.modelo");
		@SuppressWarnings("unchecked")
		List<VeiculoModelo> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<VeiculoModelo> pesquisarRegistro(VeiculoModelo veiculoModelo) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.veiculo.modelo.VeiculoModelo C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (veiculoModelo.getId() != null) {
			qsb.append(" C.id = :id and");
			parametros.put("id", veiculoModelo.getId());
		}
		if (veiculoModelo.getModelo() != null && !veiculoModelo.getModelo().trim().equals("")) {
			qsb.append(" C.modelo like :modelo and");
			parametros.put("modelo", "%" + veiculoModelo.getModelo() + "%");
		}

		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery(construirQuery(qsb));
		Set<Map.Entry<String, Object>> set = parametros.entrySet();

		for (Map.Entry<String, Object> me : set) {
			query.setParameter(me.getKey(), me.getValue());
		}
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<VeiculoModelo> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(VeiculoModelo veiculoModelo) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(veiculoModelo);
		tx.commit();
		em.close();
	}
}
