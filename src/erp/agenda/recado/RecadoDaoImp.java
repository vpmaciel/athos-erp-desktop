package erp.agenda.recado;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class RecadoDaoImp implements RecadoDao {

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
	public void deletarRegistro(Recado recado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Recado.class, recado.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Recado getRegistro(Recado recado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Recado.class, recado.getId());
	}

	@Override
	public Collection<Recado> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.Recado C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Recado> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Recado> pesquisarRegistro(Recado recado) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.agenda.Recado C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (recado.getId() != null && !recado.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", recado.getId());
		}
		if (recado.getBairro() != null && !recado.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + recado.getBairro().toUpperCase() + "%");
		}
		if (recado.getCep() != null && !recado.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + recado.getCep().toUpperCase() + "%");
		}
		if (recado.getCidade() != null && !recado.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + recado.getCidade().toUpperCase() + "%");
		}
		if (recado.getComplemento() != null && !recado.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + recado.getComplemento().toUpperCase() + "%");
		}
		if (recado.getCpfNumero() != null && !recado.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + recado.getCpfNumero().toUpperCase() + "%");
		}
		if (recado.getEmail() != null && !recado.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + recado.getEmail().toUpperCase() + "%");
		}
		if (recado.getEmpresa() != null) {
			qsb.append(" C.empresa = :empresa and");
			parametros.put("empresa", recado.getEmpresa() + "%");
		}
		if (recado.getEstado() != null && !recado.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + recado.getEstado().toUpperCase() + "%");
		}
		if (recado.getFax() != null && !recado.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + recado.getFax().toUpperCase() + "%");
		}
		if (recado.getFone1() != null && !recado.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + recado.getFone1().toUpperCase() + "%");
		}
		if (recado.getFone2() != null && !recado.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + recado.getFone2().toUpperCase() + "%");
		}
		if (recado.getLogradouro() != null && !recado.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + recado.getLogradouro().toUpperCase() + "%");
		}
		if (recado.getNome() != null && !recado.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + recado.getNome().toUpperCase() + "%");
		}
		if (recado.getPais() != null && !recado.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + recado.getPais().toUpperCase() + "%");
		}
		if (recado.getCnpj() != null && !recado.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + recado.getCnpj().toUpperCase() + "%");
		}
		if (recado.getSalario() != null && !recado.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + recado.getSalario().toUpperCase() + "%");
		}
		if (recado.getSexo() != null && !recado.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + recado.getSexo().toUpperCase() + "%");
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
		List<Recado> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Recado recado) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(recado);
		tx.commit();
		em.close();
	}
}
