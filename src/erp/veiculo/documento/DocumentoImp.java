package erp.veiculo.documento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import arquitetura.JPA;
import arquitetura.validacao.Mascara;

final class DocumentoImp implements DocumentoDao {

	@Override
	public void deletarRegistro(Documento documento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Documento.class, documento.getId()));
			entityTransaction.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			entityTransaction.rollback();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Documento> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Documento> documentoList = null;

		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Documento T order by T.funcionario",
					Documento.class);
			documentoList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return documentoList;
	}

	@Override
	public Documento getRegistro(Documento documento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			documento = entityManager.find(Documento.class, documento.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return documento;
	}

	@Override
	public Collection<Documento> pesquisarRegistro(Documento documento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Documento> documentoList = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Documento> criteriaQuery = criteriaBuilder.createQuery(Documento.class);
			Root<Documento> rootDocumento = criteriaQuery.from(Documento.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (documento.getAnoDevolucaoDocumento() != null
					&& !documento.getAnoDevolucaoDocumento().equals(Mascara.getAno().getPlaceholder())
					&& !documento.getAnoDevolucaoDocumento().equals(Mascara.getAnoVazio())) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("anoDevolucaoDocumento"),
						"%" + documento.getAnoDevolucaoDocumento() + "%"));
			}
			if (documento.getAnoRecebimentoDocumento() != null
					&& !documento.getAnoRecebimentoDocumento().equals(Mascara.getAno().getPlaceholder())
					&& !documento.getAnoRecebimentoDocumento().equals(Mascara.getAnoVazio())) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("anoRecebimentoDocumento"),
						"%" + documento.getAnoDevolucaoDocumento() + "%"));
			}
			if (documento.getCnpjRecebedorDocumento() != null
					&& !documento.getCnpjRecebedorDocumento().equals(Mascara.getCnpj().getPlaceholder())
					&& !documento.getCnpjRecebedorDocumento().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("cnpjRecebedorDocumento"),
						"%" + documento.getCnpjRecebedorDocumento() + "%"));
			}
			if (documento.getCpfRecebedorDocumento() != null
					&& !documento.getCpfRecebedorDocumento().equals(Mascara.getCpf().getPlaceholder())
					&& !documento.getCpfRecebedorDocumento().equals(Mascara.getCpfVazio())) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("cpfRecebedorDocumento"),
						"%" + documento.getCpfRecebedorDocumento() + "%"));
			}
			if (documento.getDiaDevolucaoDocumento() != null && documento.getDiaDevolucaoDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.equal(rootDocumento.get("diaDevolucaoDocumento"),
						"%" + documento.getDiaDevolucaoDocumento() + "%"));
			}
			if (documento.getDiaRecebimentoDocumento() != null && documento.getDiaRecebimentoDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.equal(rootDocumento.get("diaRecebimentoDocumento"),
						"%" + documento.getDiaRecebimentoDocumento() + "%"));
			}
			if (documento.getLocalDocumento() != null && documento.getLocalDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("localDocumento"),
						"%" + documento.getLocalDocumento() + "%"));
			}
			if (documento.getMesDevolucaoDocumento() != null && documento.getMesDevolucaoDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("mesDevolucaoDocumento"),
						"%" + documento.getMesDevolucaoDocumento() + "%"));
			}
			if (documento.getMesRecebimentoDocumento() != null && documento.getMesRecebimentoDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("mesRecebimentoDocumento"),
						"%" + documento.getMesRecebimentoDocumento() + "%"));
			}
			if (documento.getNomeRecebedorDocumento() != null && documento.getNomeRecebedorDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("nomeRecebedorDocumento"),
						"%" + documento.getNomeRecebedorDocumento() + "%"));
			}
			if (documento.getRgNumeroRecebedorDocumento() != null
					&& documento.getRgNumeroRecebedorDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("rgNumeroRecebedorDocumento"),
						"%" + documento.getRgNumeroRecebedorDocumento() + "%"));
			}
			if (documento.getRgOrgaoEmisssorRecebedorDocumento() != null
					&& documento.getRgOrgaoEmisssorRecebedorDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("rgOrgaoEmisssorRecebedorDocumento"),
						"%" + documento.getRgOrgaoEmisssorRecebedorDocumento() + "%"));
			}
			if (documento.getSituacaoDocumento() != null && documento.getSituacaoDocumento().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootDocumento.get("situacaoDocumento"),
						"%" + documento.getSituacaoDocumento() + "%"));
			}

			criteriaQuery.select(rootDocumento).where(predicateList.toArray(new Predicate[] {}));
			documentoList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return documentoList;
	}

	@Override
	public void salvarRegistro(Documento documento) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = JPA.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(documento);
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
}