package erp.agenda.tarefa;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import erp.aop.JPA;

final class TarefaDaoImp implements TarefaDao {

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
	public void deletarRegistro(Tarefa tarefa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Tarefa.class, tarefa.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Tarefa getRegistro(Tarefa tarefa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Tarefa.class, tarefa.getId());
	}

	@Override
	public Collection<Tarefa> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.tarefa.Tarefa C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Tarefa> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Tarefa> pesquisarRegistro(Tarefa tarefa) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.agenda.tarefa.Tarefa C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (tarefa.getId() != null && !tarefa.getId().equals("")) {
			qsb.append(" C.id = :id and");
			parametros.put("id", tarefa.getId());
		}
		if (tarefa.getBairro() != null && !tarefa.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + tarefa.getBairro().toUpperCase() + "%");
		}
		if (tarefa.getCep() != null && !tarefa.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + tarefa.getCep().toUpperCase() + "%");
		}
		if (tarefa.getCidade() != null && !tarefa.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + tarefa.getCidade().toUpperCase() + "%");
		}
		if (tarefa.getComplemento() != null && !tarefa.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + tarefa.getComplemento().toUpperCase() + "%");
		}
		if (tarefa.getCpfNumero() != null && !tarefa.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + tarefa.getCpfNumero().toUpperCase() + "%");
		}
		if (tarefa.getEmail() != null && !tarefa.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + tarefa.getEmail().toUpperCase() + "%");
		}
		if (tarefa.getEmpresa() != null) {
			qsb.append(" C.empresa = :empresa and");
			parametros.put("empresa", tarefa.getEmpresa() + "%");
		}
		if (tarefa.getEstado() != null && !tarefa.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + tarefa.getEstado().toUpperCase() + "%");
		}
		if (tarefa.getFax() != null && !tarefa.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + tarefa.getFax().toUpperCase() + "%");
		}
		if (tarefa.getFone1() != null && !tarefa.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + tarefa.getFone1().toUpperCase() + "%");
		}
		if (tarefa.getFone2() != null && !tarefa.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + tarefa.getFone2().toUpperCase() + "%");
		}
		if (tarefa.getLogradouro() != null && !tarefa.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + tarefa.getLogradouro().toUpperCase() + "%");
		}
		if (tarefa.getNome() != null && !tarefa.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + tarefa.getNome().toUpperCase() + "%");
		}
		if (tarefa.getPais() != null && !tarefa.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + tarefa.getPais().toUpperCase() + "%");
		}
		if (tarefa.getCnpj() != null && !tarefa.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + tarefa.getCnpj().toUpperCase() + "%");
		}
		if (tarefa.getSalario() != null && !tarefa.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + tarefa.getSalario().toUpperCase() + "%");
		}
		if (tarefa.getSexo() != null && !tarefa.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + tarefa.getSexo().toUpperCase() + "%");
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
		List<Tarefa> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Tarefa tarefa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(tarefa);
		tx.commit();
		em.close();
	}
}
