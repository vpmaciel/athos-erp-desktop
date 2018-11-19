package erp.agenda.evento;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import erp.aop.JPA;

final class EventoDaoImp implements EventoDao {

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
	public void deletarRegistro(Evento evento) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Evento.class, evento.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Evento getRegistro(Evento evento) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Evento.class, evento.getId());
	}

	@Override
	public Collection<Evento> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.agenda.Agenda C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Evento> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Evento> pesquisarRegistro(Evento evento) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.agenda.agenda.Agenda C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (evento.getId() != null && !evento.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", evento.getId());
		}
		if (evento.getBairro() != null && !evento.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + evento.getBairro().toUpperCase() + "%");
		}
		if (evento.getCep() != null && !evento.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + evento.getCep().toUpperCase() + "%");
		}
		if (evento.getCidade() != null && !evento.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + evento.getCidade().toUpperCase() + "%");
		}
		if (evento.getComplemento() != null && !evento.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + evento.getComplemento().toUpperCase() + "%");
		}
		if (evento.getCpfNumero() != null && !evento.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + evento.getCpfNumero().toUpperCase() + "%");
		}
		if (evento.getEmail() != null && !evento.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + evento.getEmail().toUpperCase() + "%");
		}
		if (evento.getEmpresa() != null) {
			qsb.append(" C.empresa = :empresa and");
			parametros.put("empresa", evento.getEmpresa() + "%");
		}
		if (evento.getEstado() != null && !evento.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + evento.getEstado().toUpperCase() + "%");
		}
		if (evento.getFax() != null && !evento.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + evento.getFax().toUpperCase() + "%");
		}
		if (evento.getFone1() != null && !evento.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + evento.getFone1().toUpperCase() + "%");
		}
		if (evento.getFone2() != null && !evento.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + evento.getFone2().toUpperCase() + "%");
		}
		if (evento.getLogradouro() != null && !evento.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + evento.getLogradouro().toUpperCase() + "%");
		}
		if (evento.getNome() != null && !evento.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + evento.getNome().toUpperCase() + "%");
		}
		if (evento.getPais() != null && !evento.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + evento.getPais().toUpperCase() + "%");
		}
		if (evento.getCnpj() != null && !evento.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + evento.getCnpj().toUpperCase() + "%");
		}
		if (evento.getSalario() != null && !evento.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + evento.getSalario().toUpperCase() + "%");
		}
		if (evento.getSexo() != null && !evento.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + evento.getSexo().toUpperCase() + "%");
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
		List<Evento> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Evento evento) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(evento);
		tx.commit();
		em.close();
	}
}
