package erp.agenda.contato;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class ContatoDaoImp implements ContatoDao {

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
	public void deletarRegistro(Contato contato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Contato.class, contato.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Contato getRegistro(Contato contato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Contato.class, contato.getId());
	}

	@Override
	public Collection<Contato> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.Contato C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Contato> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Contato> pesquisarRegistro(Contato contato) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.agenda.Contato C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (contato.getId() != null && !contato.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", contato.getId());
		}
		if (contato.getBairro() != null && !contato.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + contato.getBairro().toUpperCase() + "%");
		}
		if (contato.getCep() != null && !contato.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + contato.getCep().toUpperCase() + "%");
		}
		if (contato.getCidade() != null && !contato.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + contato.getCidade().toUpperCase() + "%");
		}
		if (contato.getComplemento() != null && !contato.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + contato.getComplemento().toUpperCase() + "%");
		}
		if (contato.getCpfNumero() != null && !contato.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + contato.getCpfNumero().toUpperCase() + "%");
		}
		if (contato.getEmail() != null && !contato.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + contato.getEmail().toUpperCase() + "%");
		}
		if (contato.getEmpresa() != null) {
			qsb.append(" C.empresa = :empresa and");
			parametros.put("empresa", contato.getEmpresa() + "%");
		}
		if (contato.getEstado() != null && !contato.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + contato.getEstado().toUpperCase() + "%");
		}
		if (contato.getFax() != null && !contato.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + contato.getFax().toUpperCase() + "%");
		}
		if (contato.getFone1() != null && !contato.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + contato.getFone1().toUpperCase() + "%");
		}
		if (contato.getFone2() != null && !contato.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + contato.getFone2().toUpperCase() + "%");
		}
		if (contato.getLogradouro() != null && !contato.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + contato.getLogradouro().toUpperCase() + "%");
		}
		if (contato.getNome() != null && !contato.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + contato.getNome().toUpperCase() + "%");
		}
		if (contato.getPais() != null && !contato.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + contato.getPais().toUpperCase() + "%");
		}
		if (contato.getCnpj() != null && !contato.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + contato.getCnpj().toUpperCase() + "%");
		}
		if (contato.getSalario() != null && !contato.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + contato.getSalario().toUpperCase() + "%");
		}
		if (contato.getSexo() != null && !contato.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + contato.getSexo().toUpperCase() + "%");
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
		List<Contato> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Contato contato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(contato);
		tx.commit();
		em.close();
	}
}
