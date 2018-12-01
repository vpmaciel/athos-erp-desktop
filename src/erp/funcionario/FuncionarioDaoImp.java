package erp.funcionario;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class FuncionarioDaoImp implements FuncionarioDao {

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
	public void deletarRegistro(Funcionario funcionario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Funcionario.class, funcionario.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Funcionario getRegistro(Funcionario funcionario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Funcionario.class, funcionario.getId());
	}

	@Override
	public Collection<Funcionario> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.funcionario.Funcionario C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Funcionario> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Funcionario> pesquisarRegistro(Funcionario funcionario) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.funcionario.Funcionario C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		if (funcionario.getId() != null) {
			qsb.append(" C.id = :id and");
			parametros.put("id", funcionario.getId());
		}
		if (funcionario.getDeficiencia() != null && !funcionario.getDeficiencia().trim().equals("")) {
			qsb.append(" C.deficiencia like :deficiencia and");
			parametros.put("deficiencia", "%" + funcionario.getDeficiencia() + "%");
		}
		if (funcionario.getEscolaridade() != null && !funcionario.getEscolaridade().trim().equals("")) {
			qsb.append(" C.escolaridade like :escolaridade and");
			parametros.put("escolaridade", "%" + funcionario.getEscolaridade() + "%");
		}
		if (funcionario.getNacionalidade() != null && !funcionario.getNacionalidade().trim().equals("")) {
			qsb.append(" C.nacionalidade like :nacionalidade and");
			parametros.put("nacionalidade", "%" + funcionario.getNacionalidade() + "%");
		}
		if (funcionario.getCor() != null && !funcionario.getCor().trim().equals("")) {
			qsb.append(" C.cor = :cor and");
			parametros.put("cor", funcionario.getCor());
		}
		if (funcionario.getCnpj() != null && !funcionario.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + funcionario.getCnpj() + "%");
		}
		if (funcionario.getConjuge() != null && !funcionario.getConjuge().trim().equals("")) {
			qsb.append(" C.conjuge like :conjuge and");
			parametros.put("conjuge", "%" + funcionario.getConjuge() + "%");
		}
		if (funcionario.getCargo() != null && !funcionario.getCargo().trim().equals("")) {
			qsb.append(" C.cargo like :cargo and");
			parametros.put("cargo", "%" + funcionario.getCargo() + "%");
		}
		if (funcionario.getCategoria() != null && !funcionario.getCategoria().trim().equals("")) {
			qsb.append(" C.categoria like :categoria and");
			parametros.put("categoria", "%" + funcionario.getCategoria() + "%");
		}
		if (funcionario.getCentroCusto() != null) {
			qsb.append(" C.centroCusto = :centroCusto and");
			parametros.put("centroCusto", funcionario.getCentroCusto());
		}
		if (funcionario.getCnhCategoria() != null && !funcionario.getCnhCategoria().trim().equals("")) {
			qsb.append(" C.cnhCategoria like : cnhCategoria and");
			parametros.put(" cnhCategoria", "%" + funcionario.getCnhCategoria() + "%");
		}
		if (funcionario.getCpfNumero() != null && !funcionario.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + funcionario.getCpfNumero() + "%");
		}
		if (funcionario.getCtpsNumero() != null && !funcionario.getCtpsNumero().trim().equals("")) {
			qsb.append(" C.ctpsNumero like :ctpsNumero and");
			parametros.put("ctpsNumero", "%" + funcionario.getCtpsNumero() + "%");
		}
		if (funcionario.getDepartamento() != null && !funcionario.getDepartamento().trim().equals("")) {
			qsb.append(" C.departamento like :departamento and");
			parametros.put("departamento", "%" + funcionario.getDepartamento() + "%");
		}
		if (funcionario.getEmail() != null && !funcionario.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + funcionario.getEmail() + "%");
		}
		if (funcionario.getEmpresa() != null && !funcionario.getEmpresa().trim().equals("")) {
			qsb.append(" C.empresa like :empresa and");
			parametros.put("empresa", "%" + funcionario.getEmpresa() + "%");
		}
		if (funcionario.getEstadoCivil() != null && !funcionario.getEstadoCivil().trim().equals("")) {
			qsb.append(" C.estadoCivil like :estadoCivil and");
			parametros.put("estadoCivil", "%" + funcionario.getEstadoCivil() + "%");
		}
		if (funcionario.getFax() != null && !funcionario.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + funcionario.getFax() + "%");
		}
		if (funcionario.getFilhos() != null && !funcionario.getFilhos().trim().equals("")) {
			qsb.append(" C.filhos like :filhos and");
			parametros.put("filhos", "%" + funcionario.getFilhos() + "%");
		}
		if (funcionario.getFone1() != null && !funcionario.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + funcionario.getFone1() + "%");
		}
		if (funcionario.getFone2() != null && !funcionario.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + funcionario.getFone2() + "%");
		}
		if (funcionario.getGerente() != null && !funcionario.getGerente().trim().equals("")) {
			qsb.append(" C.gerente like :gerente and");
			parametros.put("gerente", "%" + funcionario.getGerente() + "%");
		}
		if (funcionario.getMatricula() != null && !funcionario.getMatricula().trim().equals("")) {
			qsb.append(" C.matricula like :matricula and");
			parametros.put("matricula", "%" + funcionario.getMatricula() + "%");
		}
		if (funcionario.getNome() != null && !funcionario.getNome().trim().equals("")) {
			qsb.append(" C.nome like :nome and");
			parametros.put("nome", "%" + funcionario.getNome() + "%");
		}
		if (funcionario.getPisNumero() != null && !funcionario.getPisNumero().trim().equals("")) {
			qsb.append(" C.pisNumero like :pisNumero and");
			parametros.put("pisNumero", "%" + funcionario.getPisNumero() + "%");
		}
		if (funcionario.getRgNumero() != null && !funcionario.getRgNumero().trim().equals("")) {
			qsb.append(" C.rgNumero like :rgNumero and");
			parametros.put("rgNumero", "%" + funcionario.getRgNumero() + "%");
		}
		if (funcionario.getRgOrgaoEmissor() != null && !funcionario.getRgOrgaoEmissor().trim().equals("")) {
			qsb.append(" C.rgOrgaoEmissor like :rgOrgaoEmissor and");
			parametros.put("rgOrgaoEmissor", "%" + funcionario.getRgOrgaoEmissor() + "%");
		}
		if (funcionario.getSalario() != null && !funcionario.getSalario().trim().equals("")) {
			qsb.append(" C.salario like :salario and");
			parametros.put("salario", "%" + funcionario.getSalario() + "%");
		}
		if (funcionario.getSexo() != null && !funcionario.getSexo().trim().equals("")) {
			qsb.append(" C.sexo like :sexo and");
			parametros.put("sexo", "%" + funcionario.getSexo() + "%");
		}
		if (funcionario.getTurno() != null && !funcionario.getTurno().trim().equals("")) {
			qsb.append(" C.turno like :turno and");
			parametros.put("turno", "%" + funcionario.getTurno() + "%");
		}
		if (funcionario.getEstado() != null && !funcionario.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + funcionario.getEstado() + "%");
		}
		if (funcionario.getCidade() != null && !funcionario.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + funcionario.getCidade() + "%");
		}
		if (funcionario.getBairro() != null && !funcionario.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + funcionario.getBairro() + "%");
		}
		if (funcionario.getLogradouro() != null && !funcionario.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + funcionario.getLogradouro() + "%");
		}
		if (funcionario.getComplemento() != null && !funcionario.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + funcionario.getComplemento() + "%");
		}
		if (funcionario.getCep() != null && !funcionario.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + funcionario.getCep() + "%");
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
		List<Funcionario> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Funcionario funcionario) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(funcionario);
		tx.commit();
		em.close();
	}
}
