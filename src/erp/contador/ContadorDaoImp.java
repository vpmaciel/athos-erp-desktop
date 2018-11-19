package erp.contador;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import erp.aop.JPA;

final class ContadorDaoImp implements ContadorDao {

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
		StringBuilder qsb = new StringBuilder();

		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.contador.Contador C where");

		Map<String, Object> parametros = new HashMap<String, Object>();
		if (contador.getId() != null) {
			qsb.append(" C.id = :id and");
			parametros.put("id", contador.getId());
		}

		if ((contador.getCnpj() != null) && (!contador.getCnpj().trim().equals(""))) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + contador.getCnpj() + "%");
		}

		if ((contador.getCpf() != null) && (!contador.getCpf().trim().equals(""))) {
			qsb.append(" C.cpf like :cpf and");
			parametros.put("cpf", "%" + contador.getCpf() + "%");
		}

		if ((contador.getCrc() != null) && (!contador.getCrc().trim().equals(""))) {
			qsb.append(" C.crc like :crc and");
			parametros.put("crc", "%" + contador.getCrc() + "%");
		}

		if ((contador.getEmail() != null) && (!contador.getEmail().trim().equals(""))) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + contador.getEmail() + "%");
		}

		if ((contador.getFax() != null) && (!contador.getFax().trim().equals(""))) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + contador.getFax() + "%");
		}

		if ((contador.getFone1() != null) && (!contador.getFone1().trim().equals(""))) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + contador.getFone1() + "%");
		}

		if ((contador.getFone2() != null) && (!contador.getFone2().trim().equals(""))) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + contador.getFone2() + "%");
		}

		if ((contador.getNome() != null) && (!contador.getNome().trim().equals(""))) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + contador.getNome() + "%");
		}

		if ((contador.getSite() != null) && (!contador.getSite().trim().equals(""))) {
			qsb.append(" C.site like :site and");
			parametros.put("site", "%" + contador.getSite() + "%");
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
		List<Contador> list = query.getResultList();
		tx.commit();

		em.close();
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
