package erp.fornecedor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import erp.aop.JPA;

final class FornecedorDaoImp implements FornecedorDao {

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
		stringBuilder.append(" order by C.nomeFantasia");
		PesquisaRegistro = stringBuilder.toString();
		return PesquisaRegistro;
	}

	@Override
	public void deletarRegistro(Fornecedor fornecedor) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Fornecedor.class, fornecedor.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Fornecedor getRegistro(Fornecedor fornecedor) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Fornecedor.class, fornecedor.getId());
	}

	@Override
	public Collection<Fornecedor> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.fornecedor.Fornecedor C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Fornecedor> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Fornecedor> pesquisarRegistro(Fornecedor fornecedor) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.fornecedor.Fornecedor C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		if (fornecedor.getId() != null) {
			qsb.append(" C.id = :id and");
			parametros.put("id", fornecedor.getId());
		}
		if (fornecedor.getBairro() != null && !fornecedor.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + fornecedor.getBairro() + "%");
		}
		if (fornecedor.getInscricaoEstadual() != null && !fornecedor.getInscricaoEstadual().trim().equals("")) {
			qsb.append(" C.cargo like :cargo and");
			parametros.put("cargo", "%" + fornecedor.getInscricaoEstadual() + "%");
		}
		if (fornecedor.getInscricaoMunicipal() != null && !fornecedor.getInscricaoMunicipal().trim().equals("")) {
			qsb.append(" C.inscricaoMunicipal like :inscricaoMunicipal and");
			parametros.put("inscricaoMunicipal", "%" + fornecedor.getInscricaoMunicipal() + "%");
		}
		if (fornecedor.getNumeroFuncionarios() != null && !fornecedor.getNumeroFuncionarios().trim().equals("")) {
			qsb.append(" C.numeroFuncionarios like :numeroFuncionarios and");
			parametros.put("numeroFuncionarios", "%" + fornecedor.getNumeroFuncionarios() + "%");
		}
		if (fornecedor.getCep() != null && !fornecedor.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + fornecedor.getCep() + "%");
		}
		if (fornecedor.getCidade() != null && !fornecedor.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + fornecedor.getCidade() + "%");
		}
		if (fornecedor.getComplemento() != null && !fornecedor.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + fornecedor.getComplemento() + "%");
		}
		if (fornecedor.getCpfNumero() != null && !fornecedor.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + fornecedor.getCpfNumero() + "%");
		}
		if (fornecedor.getEmail() != null && !fornecedor.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + fornecedor.getEmail() + "%");
		}
		if (fornecedor.getCapitalSocial() != null && !fornecedor.getCapitalSocial().trim().equals("")) {
			qsb.append(" C.capitalSocial like :capitalSocial and");
			parametros.put("capitalSocial", "%" + fornecedor.getCapitalSocial() + "%");
		}
		if (fornecedor.getEstado() != null && !fornecedor.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + fornecedor.getEstado() + "%");
		}
		if (fornecedor.getRazaoSocial() != null && !fornecedor.getRazaoSocial().trim().equals("")) {
			qsb.append(" C.razaoSocial like :razaoSocial and");
			parametros.put("razaoSocial", "%" + fornecedor.getRazaoSocial() + "%");
		}
		if (fornecedor.getFax() != null && !fornecedor.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + fornecedor.getFax() + "%");
		}
		if (fornecedor.getFone1() != null && !fornecedor.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + fornecedor.getFone1() + "%");
		}
		if (fornecedor.getFone2() != null && !fornecedor.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + fornecedor.getFone2() + "%");
		}
		if (fornecedor.getLogradouro() != null && !fornecedor.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + fornecedor.getLogradouro() + "%");
		}
		if (fornecedor.getNomeFantasia() != null && !fornecedor.getNomeFantasia().trim().equals("")) {
			qsb.append(" C.nomeFantasia like :nomeFantasia and");
			parametros.put("nomeFantasia", "%" + fornecedor.getNomeFantasia() + "%");
		}
		if (fornecedor.getPais() != null && !fornecedor.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + fornecedor.getPais() + "%");
		}
		if (fornecedor.getCnpj() != null && !fornecedor.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + fornecedor.getCnpj() + "%");
		}
		if (fornecedor.getTipoEmpresa() != null && !fornecedor.getTipoEmpresa().trim().equals("")) {
			qsb.append(" C.tipoEmpresa like :tipoEmpresa and");
			parametros.put("tipoEmpresa", "%" + fornecedor.getTipoEmpresa() + "%");
		}
		if (fornecedor.getFaturamentoMensal() != null && !fornecedor.getFaturamentoMensal().trim().equals("")) {
			qsb.append(" C.faturamentoMensal like :faturamentoMensal and");
			parametros.put("faturamentoMensal", "%" + fornecedor.getFaturamentoMensal() + "%");
		}
		if (fornecedor.getDataFundacao() != null && !fornecedor.getDataFundacao().trim().equals("")) {
			qsb.append(" C.dataFundacao like :dataFundacao and");
			parametros.put("dataFundacao", "%" + fornecedor.getDataFundacao() + "%");
		}
		if (fornecedor.getRamoAtividade() != null && !fornecedor.getRamoAtividade().trim().equals("")) {
			qsb.append(" C.ramoAtividade like :ramoAtividade and");
			parametros.put("ramoAtividade", "%" + fornecedor.getRamoAtividade() + "%");
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
		List<Fornecedor> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Fornecedor fornecedor) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(fornecedor);
		tx.commit();
		em.close();
	}
}
