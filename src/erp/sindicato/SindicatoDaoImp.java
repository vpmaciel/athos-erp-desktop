package erp.sindicato;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class SindicatoDaoImp implements SindicatoDao {

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
	public void deletarRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Sindicato.class, sindicato.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Sindicato getRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Sindicato.class, sindicato.getId());
	}

	@Override
	public Collection<Sindicato> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.sindicato.Sindicato C order by C.nomeFantasia");
		@SuppressWarnings("unchecked")
		List<Sindicato> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Sindicato> pesquisarRegistro(Sindicato sindicato) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.sindicato.Sindicato C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (sindicato.getId() != null) {
			qsb.append(" C.id = :id and");
			parametros.put("id", sindicato.getId());
		}
		if (sindicato.getBairro() != null && !sindicato.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + sindicato.getBairro() + "%");
		}
		if (sindicato.getInscricaoEstadual() != null && !sindicato.getInscricaoEstadual().trim().equals("")) {
			qsb.append(" C.incricaoEstadual like :incricaoEstadual and");
			parametros.put("incricaoEstadual", "%" + sindicato.getInscricaoEstadual() + "%");
		}
		if (sindicato.getInscricaoMunicipal() != null && !sindicato.getInscricaoMunicipal().trim().equals("")) {
			qsb.append(" C.inscricaoMunicipal like :inscricaoMunicipal and");
			parametros.put("inscricaoMunicipal", "%" + sindicato.getInscricaoMunicipal() + "%");
		}
		if (sindicato.getNumeroFuncionarios() != null && !sindicato.getNumeroFuncionarios().trim().equals("")) {
			qsb.append(" C.numeroFuncionarios like :numeroFuncionarios and");
			parametros.put("numeroFuncionarios", "%" + sindicato.getNumeroFuncionarios() + "%");
		}
		if (sindicato.getCep() != null && !sindicato.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + sindicato.getCep() + "%");
		}
		if (sindicato.getCidade() != null && !sindicato.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + sindicato.getCidade() + "%");
		}
		if (sindicato.getComplemento() != null && !sindicato.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + sindicato.getComplemento() + "%");
		}
		if (sindicato.getCpfNumero() != null && !sindicato.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + sindicato.getCpfNumero() + "%");
		}
		if (sindicato.getEmail() != null && !sindicato.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + sindicato.getEmail() + "%");
		}
		if (sindicato.getCapitalSocial() != null && !sindicato.getCapitalSocial().trim().equals("")) {
			qsb.append(" C.capitalSocial like :capitalSocial and");
			parametros.put("capitalSocial", "%" + sindicato.getCapitalSocial() + "%");
		}
		if (sindicato.getEstado() != null && !sindicato.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + sindicato.getEstado() + "%");
		}
		if (sindicato.getRazaoSocial() != null && !sindicato.getRazaoSocial().trim().equals("")) {
			qsb.append(" C.razaoSocial like :razaoSocial and");
			parametros.put("razaoSocial", "%" + sindicato.getRazaoSocial() + "%");
		}
		if (sindicato.getFax() != null && !sindicato.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + sindicato.getFax() + "%");
		}
		if (sindicato.getFone1() != null && !sindicato.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + sindicato.getFone1() + "%");
		}
		if (sindicato.getFone2() != null && !sindicato.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + sindicato.getFone2() + "%");
		}
		if (sindicato.getLogradouro() != null && !sindicato.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + sindicato.getLogradouro() + "%");
		}
		if (sindicato.getNomeFantasia() != null && !sindicato.getNomeFantasia().trim().equals("")) {
			qsb.append(" C.nomeFantasia like :nomeFantasia and");
			parametros.put("nomeFantasia", "%" + sindicato.getNomeFantasia() + "%");
		}
		if (sindicato.getPais() != null && !sindicato.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + sindicato.getPais() + "%");
		}
		if (sindicato.getCnpj() != null && !sindicato.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + sindicato.getCnpj() + "%");
		}
		if (sindicato.getTipoSindicato() != null && !sindicato.getTipoSindicato().trim().equals("")) {
			qsb.append(" C.tipoSindicato like :tipoSindicato and");
			parametros.put("tipoSindicato", "%" + sindicato.getTipoSindicato() + "%");
		}
		if (sindicato.getFaturamentoMensal() != null && !sindicato.getFaturamentoMensal().trim().equals("")) {
			qsb.append(" C.faturamentoMensal like :faturamentoMensal and");
			parametros.put("faturamentoMensal", "%" + sindicato.getFaturamentoMensal() + "%");
		}
		if (sindicato.getDataFundacao() != null && !sindicato.getDataFundacao().trim().equals("")) {
			qsb.append(" C.dataFundacao like :dataFundacao and");
			parametros.put("dataFundacao", "%" + sindicato.getDataFundacao() + "%");
		}
		if (sindicato.getRamoAtividade() != null && !sindicato.getRamoAtividade().trim().equals("")) {
			qsb.append(" C.ramoAtividade like :ramoAtividade and");
			parametros.put("ramoAtividade", "%" + sindicato.getRamoAtividade() + "%");
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
		List<Sindicato> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Sindicato sindicato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(sindicato);
		tx.commit();
		em.close();
	}
}
