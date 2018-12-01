package erp.empresa;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class EmpresaDaoImp implements EmpresaDao {

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
	public void deletarRegistro(Empresa empresa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Empresa.class, empresa.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Empresa getRegistro(Empresa empresa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Empresa.class, empresa.getId());
	}

	@Override
	public Collection<Empresa> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.empresa.Empresa C order by C.nomeFantasia");
		@SuppressWarnings("unchecked")
		List<Empresa> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Empresa> pesquisarRegistro(Empresa empresa) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.empresa.Empresa C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		if (empresa.getId() != null) {
			qsb.append(" C.id = :id and");
			parametros.put("id", empresa.getId());
		}
		if (empresa.getBairro() != null && !empresa.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + empresa.getBairro() + "%");
		}
		if (empresa.getInscricaoEstadual() != null && !empresa.getInscricaoEstadual().trim().equals("")) {
			qsb.append(" C.inscricaoEstadual like :inscricaoEstadual and");
			parametros.put("inscricaoEstadual", "%" + empresa.getInscricaoEstadual() + "%");
		}
		if (empresa.getInscricaoMunicipal() != null && !empresa.getInscricaoMunicipal().trim().equals("")) {
			qsb.append(" C.inscricaoMunicipal like :inscricaoMunicipal and");
			parametros.put("inscricaoMunicipal", "%" + empresa.getInscricaoMunicipal() + "%");
		}
		if (empresa.getNumeroFuncionarios() != null && !empresa.getNumeroFuncionarios().trim().equals("")) {
			qsb.append(" C.numeroFuncionarios like :numeroFuncionarios and");
			parametros.put("numeroFuncionarios", "%" + empresa.getNumeroFuncionarios() + "%");
		}
		if (empresa.getCep() != null && !empresa.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + empresa.getCep() + "%");
		}
		if (empresa.getCidade() != null && !empresa.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + empresa.getCidade() + "%");
		}
		if (empresa.getComplemento() != null && !empresa.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + empresa.getComplemento() + "%");
		}
		if (empresa.getCpfNumero() != null && !empresa.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + empresa.getCpfNumero() + "%");
		}
		if (empresa.getEmail() != null && !empresa.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + empresa.getEmail() + "%");
		}
		if (empresa.getCapitalSocial() != null && !empresa.getCapitalSocial().trim().equals("")) {
			qsb.append(" C.capitalSocial like :capitalSocial and");
			parametros.put("capitalSocial", "%" + empresa.getCapitalSocial() + "%");
		}
		if (empresa.getEstado() != null && !empresa.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + empresa.getEstado() + "%");
		}
		if (empresa.getRazaoSocial() != null && !empresa.getRazaoSocial().trim().equals("")) {
			qsb.append(" C.razaoSocial like :razaoSocial and");
			parametros.put("razaoSocial", "%" + empresa.getRazaoSocial() + "%");
		}
		if (empresa.getFax() != null && !empresa.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + empresa.getFax() + "%");
		}
		if (empresa.getFone1() != null && !empresa.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + empresa.getFone1() + "%");
		}
		if (empresa.getFone2() != null && !empresa.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + empresa.getFone2() + "%");
		}
		if (empresa.getLogradouro() != null && !empresa.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + empresa.getLogradouro() + "%");
		}
		if (empresa.getNomeFantasia() != null && !empresa.getNomeFantasia().trim().equals("")) {
			qsb.append(" C.nomeFantasia like :nomeFantasia and");
			parametros.put("nomeFantasia", "%" + empresa.getNomeFantasia() + "%");
		}
		if (empresa.getPais() != null && !empresa.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + empresa.getPais() + "%");
		}
		if (empresa.getCnpj() != null && !empresa.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + empresa.getCnpj() + "%");
		}
		if (empresa.getTipoEmpresa() != null && !empresa.getTipoEmpresa().trim().equals("")) {
			qsb.append(" C.tipoEmpresa like :tipoEmpresa and");
			parametros.put("tipoEmpresa", "%" + empresa.getTipoEmpresa() + "%");
		}
		if (empresa.getFaturamentoMensal() != null && !empresa.getFaturamentoMensal().trim().equals("")) {
			qsb.append(" C.faturamentoMensal like :faturamentoMensal and");
			parametros.put("faturamentoMensal", "%" + empresa.getFaturamentoMensal() + "%");
		}
		if (empresa.getDataFundacao() != null && !empresa.getDataFundacao().trim().equals("")) {
			qsb.append(" C.dataFundacao like :dataFundacao and");
			parametros.put("dataFundacao", "%" + empresa.getDataFundacao() + "%");
		}
		if (empresa.getRamoAtividade() != null && !empresa.getRamoAtividade().trim().equals("")) {
			qsb.append(" C.ramoAtividade like :ramoAtividade and");
			parametros.put("ramoAtividade", "%" + empresa.getRamoAtividade() + "%");
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
		List<Empresa> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Empresa empresa) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(empresa);
		tx.commit();
		em.close();
	}
}
