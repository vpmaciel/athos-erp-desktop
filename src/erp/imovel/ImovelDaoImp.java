package erp.imovel;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arquitetura.JPA;

final class ImovelDaoImp implements ImovelDao {

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
		stringBuilder.append(" order by C.nomeProprietario");
		PesquisaRegistro = stringBuilder.toString();
		return PesquisaRegistro;
	}

	@Override
	public void deletarRegistro(Imovel imovel) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Imovel.class, imovel.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Imovel getRegistro(Imovel imovel) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Imovel.class, imovel.getId());
	}

	@Override
	public Collection<Imovel> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.imovel.Imovel C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Imovel> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Imovel> pesquisarRegistro(Imovel imovel) {
		StringBuilder qsb = new StringBuilder();
		qsb.setLength(0);
		qsb = new StringBuilder();
		qsb.append("select C from erp.imovel.Imovel C where");
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		if (imovel.getId() != null) {
			qsb.append(" C.id = :id and");
			parametros.put("id", imovel.getId());
		}
		if (imovel.getBairro() != null && !imovel.getBairro().trim().equals("")) {
			qsb.append(" C.bairro like :bairro and");
			parametros.put("bairro", "%" + imovel.getBairro() + "%");
		}
		if (imovel.getBanheiro() != null && !imovel.getBanheiro().trim().equals("")) {
			qsb.append(" C.banheiro like :banheiro and");
			parametros.put("banheiro", "%" + imovel.getBanheiro() + "%");
		}
		if (imovel.getSuite() != null && !imovel.getSuite().trim().equals("")) {
			qsb.append(" C.suite like :suite and");
			parametros.put("suite", "%" + imovel.getSuite() + "%");
		}
		if (imovel.getCozinha() != null && !imovel.getCozinha().trim().equals("")) {
			qsb.append(" C.cozinha like :cozinha and");
			parametros.put("cozinha", "%" + imovel.getCozinha() + "%");
		}
		if (imovel.getCep() != null && !imovel.getCep().trim().equals("")) {
			qsb.append(" C.cep like :cep and");
			parametros.put("cep", "%" + imovel.getCep() + "%");
		}
		if (imovel.getCidade() != null && !imovel.getCidade().trim().equals("")) {
			qsb.append(" C.cidade like :cidade and");
			parametros.put("cidade", "%" + imovel.getCidade() + "%");
		}
		if (imovel.getComplemento() != null && !imovel.getComplemento().trim().equals("")) {
			qsb.append(" C.complemento like :complemento and");
			parametros.put("complemento", "%" + imovel.getComplemento() + "%");
		}
		if (imovel.getCpfNumero() != null && !imovel.getCpfNumero().trim().equals("")) {
			qsb.append(" C.cpfNumero like :cpfNumero and");
			parametros.put("cpfNumero", "%" + imovel.getCpfNumero() + "%");
		}
		if (imovel.getEmail() != null && !imovel.getEmail().trim().equals("")) {
			qsb.append(" C.email like :email and");
			parametros.put("email", "%" + imovel.getEmail() + "%");
		}
		if (imovel.getVaranda() != null && !imovel.getVaranda().trim().equals("")) {
			qsb.append(" C.varanda like :varanda and");
			parametros.put("varanda", "%" + imovel.getVaranda() + "%");
		}
		if (imovel.getEstado() != null && !imovel.getEstado().trim().equals("")) {
			qsb.append(" C.estado like :estado and");
			parametros.put("estado", "%" + imovel.getEstado() + "%");
		}
		if (imovel.getFax() != null && !imovel.getFax().trim().equals("")) {
			qsb.append(" C.fax like :fax and");
			parametros.put("fax", "%" + imovel.getFax() + "%");
		}
		if (imovel.getFone1() != null && !imovel.getFone1().trim().equals("")) {
			qsb.append(" C.fone1 like :fone1 and");
			parametros.put("fone1", "%" + imovel.getFone1() + "%");
		}
		if (imovel.getFone2() != null && !imovel.getFone2().trim().equals("")) {
			qsb.append(" C.fone2 like :fone2 and");
			parametros.put("fone2", "%" + imovel.getFone2() + "%");
		}
		if (imovel.getLogradouro() != null && !imovel.getLogradouro().trim().equals("")) {
			qsb.append(" C.logradouro like :logradouro and");
			parametros.put("logradouro", "%" + imovel.getLogradouro() + "%");
		}
		if (imovel.getNomeProprietario() != null && !imovel.getNomeProprietario().trim().equals("")) {
			qsb.append(" C.nomeProprietario like :nomeProprietario and");
			parametros.put("nomeFantasia", "%" + imovel.getNomeProprietario() + "%");
		}
		if (imovel.getPais() != null && !imovel.getPais().trim().equals("")) {
			qsb.append(" C.pais like :pais and");
			parametros.put("pais", "%" + imovel.getPais() + "%");
		}
		if (imovel.getCnpj() != null && !imovel.getCnpj().trim().equals("")) {
			qsb.append(" C.cnpj like :cnpj and");
			parametros.put("cnpj", "%" + imovel.getCnpj() + "%");
		}
		if (imovel.getGaragem() != null && !imovel.getGaragem().trim().equals("")) {
			qsb.append(" C.garagem like :garagem and");
			parametros.put("garagem", "%" + imovel.getGaragem() + "%");
		}
		if (imovel.getPiscina() != null && !imovel.getPiscina().trim().equals("")) {
			qsb.append(" C.piscina like :piscina and");
			parametros.put("piscina", "%" + imovel.getPiscina() + "%");
		}
		if (imovel.getTerracao() != null && !imovel.getTerracao().trim().equals("")) {
			qsb.append(" C.terraco like :terraco and");
			parametros.put("terraco", "%" + imovel.getTerracao() + "%");
		}
		if (imovel.getSala() != null && !imovel.getSala().trim().equals("")) {
			qsb.append(" C.sala like :sala and");
			parametros.put("sala", "%" + imovel.getSala() + "%");
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
		List<Imovel> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public void salvarRegistro(Imovel imovel) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(imovel);
		tx.commit();
		em.close();
	}
}
