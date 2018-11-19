package erp.agenda.agenda;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import erp.aop.JPA;

final class AgendaDaoImp implements AgendaDao {

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
	public void deletarRegistro(Agenda agenda) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Agenda.class, agenda.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Agenda getRegistro(Agenda agenda) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Agenda.class, agenda.getId());
	}

	@Override
	public Collection<Agenda> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.agenda.Agenda C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Agenda> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Agenda> pesquisarRegistro(Agenda agenda) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.agenda.agenda.Agenda C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (agenda.getId() != null && !agenda.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", agenda.getId());
		}
		if (agenda.getBairro() != null && !agenda.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + agenda.getBairro().toUpperCase() + "%");
		}
		if (agenda.getCep() != null && !agenda.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + agenda.getCep().toUpperCase() + "%");
		}
		if (agenda.getCidade() != null && !agenda.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + agenda.getCidade().toUpperCase() + "%");
		}
		if (agenda.getComplemento() != null && !agenda.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + agenda.getComplemento().toUpperCase() + "%");
		}
		if (agenda.getCpfNumero() != null && !agenda.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + agenda.getCpfNumero().toUpperCase() + "%");
		}
		if (agenda.getEmail() != null && !agenda.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + agenda.getEmail().toUpperCase() + "%");
		}
		if (agenda.getEmpresa() != null) {
			qsb.append(" C.empresa = :empresa and");
			parametros.put("empresa", agenda.getEmpresa() + "%");
		}
		if (agenda.getEstado() != null && !agenda.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + agenda.getEstado().toUpperCase() + "%");
		}
		if (agenda.getFax() != null && !agenda.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + agenda.getFax().toUpperCase() + "%");
		}
		if (agenda.getFone1() != null && !agenda.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + agenda.getFone1().toUpperCase() + "%");
		}
		if (agenda.getFone2() != null && !agenda.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + agenda.getFone2().toUpperCase() + "%");
		}
		if (agenda.getLogradouro() != null && !agenda.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + agenda.getLogradouro().toUpperCase() + "%");
		}
		if (agenda.getNome() != null && !agenda.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + agenda.getNome().toUpperCase() + "%");
		}
		if (agenda.getPais() != null && !agenda.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + agenda.getPais().toUpperCase() + "%");
		}
		if (agenda.getCnpj() != null && !agenda.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + agenda.getCnpj().toUpperCase() + "%");
		}
		if (agenda.getSalario() != null && !agenda.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + agenda.getSalario().toUpperCase() + "%");
		}
		if (agenda.getSexo() != null && !agenda.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + agenda.getSexo().toUpperCase() + "%");
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
		List<Agenda> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Agenda agenda) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(agenda);
		tx.commit();
		em.close();
	}
}
