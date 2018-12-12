package erp.imovel;

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

final class ImovelImp implements ImovelDao {

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
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Imovel> criteriaQuery = criteriaBuilder.createQuery(Imovel.class);
		Root<Imovel> rootImovel = criteriaQuery.from(Imovel.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (imovel.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootImovel.get("id"), imovel.getId()));
		}
		if (imovel.getBairro() != null && !imovel.getBairro().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("bairro"), "%" + imovel.getBairro() + "%"));
		}
		if (imovel.getBanheiro() != null && !imovel.getBanheiro().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("banheiro"), "%" + imovel.getBanheiro() + "%"));
		}
		if (imovel.getCep() != null && !imovel.getCep().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cep"), "%" + imovel.getCep() + "%"));
		}
		if (imovel.getCidade() != null && !imovel.getCidade().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cidade"), "%" + imovel.getCidade() + "%"));
		}
		if (imovel.getCnpj() != null && !imovel.getCnpj().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cnpj"), "%" + imovel.getCnpj() + "%"));
		}
		if (imovel.getComplemento() != null && !imovel.getComplemento().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("complemento"), "%" + imovel.getComplemento() + "%"));
		}
		if (imovel.getCozinha() != null && !imovel.getCozinha().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cozinha"), "%" + imovel.getCozinha() + "%"));
		}
		if (imovel.getCpfNumero() != null && !imovel.getCpfNumero().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cpfNumero"), "%" + imovel.getCpfNumero() + "%"));
		}
		if (imovel.getEmail() != null && !imovel.getEmail().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("email"), "%" + imovel.getEmail() + "%"));
		}
		if (imovel.getEstado() != null && !imovel.getEstado().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("estado"), "%" + imovel.getEstado() + "%"));
		}
		if (imovel.getFax() != null && !imovel.getFax().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("fax"), "%" + imovel.getFax() + "%"));
		}
		if (imovel.getFone1() != null && !imovel.getFone1().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("fone1"), "%" + imovel.getFone1() + "%"));
		}
		if (imovel.getFone2() != null && !imovel.getFone2().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("fone2"), "%" + imovel.getFone2() + "%"));
		}
		if (imovel.getGaragem() != null && !imovel.getGaragem().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("garagem"), "%" + imovel.getGaragem() + "%"));
		}
		if (imovel.getLogradouro() != null && !imovel.getLogradouro().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("logradouro"), "%" + imovel.getLogradouro() + "%"));
		}
		if (imovel.getNomeProprietario() != null && !imovel.getNomeProprietario().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("nomeProprietario"), "%" + imovel.getNomeProprietario() + "%"));
		}
		if (imovel.getPais() != null && !imovel.getPais().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("pais"), "%" + imovel.getPais() + "%"));
		}
		if (imovel.getPiscina() != null && !imovel.getPiscina().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("piscina"), "%" + imovel.getPiscina() + "%"));
		}
		if (imovel.getQuarto() != null && !imovel.getQuarto().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("quarto"), "%" + imovel.getQuarto() + "%"));
		}
		if (imovel.getSala() != null && !imovel.getSala().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("sala"), "%" + imovel.getSala() + "%"));
		}
		if (imovel.getSuite() != null && !imovel.getSuite().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("suite"), "%" + imovel.getSuite() + "%"));
		}
		if (imovel.getTerracao() != null && !imovel.getTerracao().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("terracao"), "%" + imovel.getTerracao() + "%"));
		}
		if (imovel.getVaranda() != null && !imovel.getVaranda().equals("")) {
			predicates.add(criteriaBuilder.like(rootImovel.get("varanda"), "%" + imovel.getVaranda() + "%"));
		}
		
		criteriaQuery.select(rootImovel).where(predicates.toArray(new Predicate[] {}));

		List<Imovel> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
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
