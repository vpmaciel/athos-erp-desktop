package erp.agenda.compromisso;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import erp.aop.JPA;

final class CompromissoDaoImp implements CompromissoDao {

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
	public void deletarRegistro(Compromisso compromisso) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Compromisso.class, compromisso.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Compromisso getRegistro(Compromisso compromisso) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Compromisso.class, compromisso.getId());
	}

	@Override
	public Collection<Compromisso> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.Compromisso C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Compromisso> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Compromisso> pesquisarRegistro(Compromisso compromisso) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.agenda.Compromisso C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (compromisso.getId() != null && !compromisso.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", compromisso.getId());
		}
		if (compromisso.getBairro() != null && !compromisso.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + compromisso.getBairro().toUpperCase() + "%");
		}
		if (compromisso.getCep() != null && !compromisso.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + compromisso.getCep().toUpperCase() + "%");
		}
		if (compromisso.getCidade() != null && !compromisso.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + compromisso.getCidade().toUpperCase() + "%");
		}
		if (compromisso.getComplemento() != null && !compromisso.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + compromisso.getComplemento().toUpperCase() + "%");
		}
		if (compromisso.getCpfNumero() != null && !compromisso.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + compromisso.getCpfNumero().toUpperCase() + "%");
		}
		if (compromisso.getEmail() != null && !compromisso.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + compromisso.getEmail().toUpperCase() + "%");
		}
		if (compromisso.getEmpresa() != null) {
			qsb.append(" C.empresa = :empresa and");
			parametros.put("empresa", compromisso.getEmpresa() + "%");
		}
		if (compromisso.getEstado() != null && !compromisso.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + compromisso.getEstado().toUpperCase() + "%");
		}
		if (compromisso.getFax() != null && !compromisso.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + compromisso.getFax().toUpperCase() + "%");
		}
		if (compromisso.getFone1() != null && !compromisso.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + compromisso.getFone1().toUpperCase() + "%");
		}
		if (compromisso.getFone2() != null && !compromisso.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + compromisso.getFone2().toUpperCase() + "%");
		}
		if (compromisso.getLogradouro() != null && !compromisso.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + compromisso.getLogradouro().toUpperCase() + "%");
		}
		if (compromisso.getNome() != null && !compromisso.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + compromisso.getNome().toUpperCase() + "%");
		}
		if (compromisso.getPais() != null && !compromisso.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + compromisso.getPais().toUpperCase() + "%");
		}
		if (compromisso.getCnpj() != null && !compromisso.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + compromisso.getCnpj().toUpperCase() + "%");
		}
		if (compromisso.getSalario() != null && !compromisso.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + compromisso.getSalario().toUpperCase() + "%");
		}
		if (compromisso.getSexo() != null && !compromisso.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + compromisso.getSexo().toUpperCase() + "%");
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
		List<Compromisso> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Compromisso compromisso) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(compromisso);
		tx.commit();
		em.close();
	}
}
