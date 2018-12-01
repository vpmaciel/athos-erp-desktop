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
		Query query = em.createQuery("from erp.agenda.agenda.Agenda C order by C.nome");
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
		qsb.append("select C from erp.agenda.agenda.Agenda C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (tipoEvento.getId() != null && !tipoEvento.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", tipoEvento.getId());
		}
		if (tipoEvento.getBairro() != null && !tipoEvento.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + tipoEvento.getBairro().toUpperCase() + "%");
		}
		if (tipoEvento.getCep() != null && !tipoEvento.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + tipoEvento.getCep().toUpperCase() + "%");
		}
		if (tipoEvento.getCidade() != null && !tipoEvento.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + tipoEvento.getCidade().toUpperCase() + "%");
		}
		if (tipoEvento.getComplemento() != null && !tipoEvento.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + tipoEvento.getComplemento().toUpperCase() + "%");
		}
		if (tipoEvento.getCpfNumero() != null && !tipoEvento.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + tipoEvento.getCpfNumero().toUpperCase() + "%");
		}
		if (tipoEvento.getEmail() != null && !tipoEvento.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + tipoEvento.getEmail().toUpperCase() + "%");
		}
		if (tipoEvento.getEmpresa() != null) {
			qsb.append(" C.empresa = :empresa and");
			parametros.put("empresa", tipoEvento.getEmpresa() + "%");
		}
		if (tipoEvento.getEstado() != null && !tipoEvento.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + tipoEvento.getEstado().toUpperCase() + "%");
		}
		if (tipoEvento.getFax() != null && !tipoEvento.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + tipoEvento.getFax().toUpperCase() + "%");
		}
		if (tipoEvento.getFone1() != null && !tipoEvento.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + tipoEvento.getFone1().toUpperCase() + "%");
		}
		if (tipoEvento.getFone2() != null && !tipoEvento.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + tipoEvento.getFone2().toUpperCase() + "%");
		}
		if (tipoEvento.getLogradouro() != null && !tipoEvento.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + tipoEvento.getLogradouro().toUpperCase() + "%");
		}
		if (tipoEvento.getNome() != null && !tipoEvento.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + tipoEvento.getNome().toUpperCase() + "%");
		}
		if (tipoEvento.getPais() != null && !tipoEvento.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + tipoEvento.getPais().toUpperCase() + "%");
		}
		if (tipoEvento.getCnpj() != null && !tipoEvento.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + tipoEvento.getCnpj().toUpperCase() + "%");
		}
		if (tipoEvento.getSalario() != null && !tipoEvento.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + tipoEvento.getSalario().toUpperCase() + "%");
		}
		if (tipoEvento.getSexo() != null && !tipoEvento.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + tipoEvento.getSexo().toUpperCase() + "%");
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
