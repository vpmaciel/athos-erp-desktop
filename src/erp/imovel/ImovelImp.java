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
import arquitetura.validacao.Mascara;

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

		if (naoEstaVazio(imovel.getId())) {
			predicates.add(criteriaBuilder.equal(rootImovel.get("id"), imovel.getId()));
		}
		if (naoEstaVazio(imovel.getBairro())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("bairro"), "%" + imovel.getBairro() + "%"));
		}
		if (naoEstaVazio(imovel.getBanheiro())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("banheiro"), "%" + imovel.getBanheiro() + "%"));
		}
		if (imovel.getCep() != null && !imovel.getCep().equals(Mascara.getCep().getPlaceholder()) && !imovel.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cep"), "%" + imovel.getCep() + "%"));
		}
		if (naoEstaVazio(imovel.getCidade())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cidade"), "%" + imovel.getCidade() + "%"));
		}
		if (imovel.getCnpj() != null && !imovel.getCnpj().equals(Mascara.getCnpj().getPlaceholder()) && !imovel.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cnpj"), "%" + imovel.getCnpj() + "%"));
		}
		if (naoEstaVazio(imovel.getComplemento())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("complemento"), "%" + imovel.getComplemento() + "%"));
		}
		if (naoEstaVazio(imovel.getCozinha())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cozinha"), "%" + imovel.getCozinha() + "%"));
		}
		if (imovel.getCpf() != null && !imovel.getCpf().equals(Mascara.getCpf().getPlaceholder()) && !imovel.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("cpfNumero"), "%" + imovel.getCpf() + "%"));
		}
		if (naoEstaVazio(imovel.getEmail())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("email"), "%" + imovel.getEmail() + "%"));
		}
		if (naoEstaVazio(imovel.getEstado())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("estado"), "%" + imovel.getEstado() + "%"));
		}
		if (imovel.getFax() != null && !imovel.getFax().equals(Mascara.getFax().getPlaceholder()) && !imovel.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("fax"), "%" + imovel.getFax() + "%"));
		}
		if (imovel.getFone1() != null && !imovel.getFone1().equals(Mascara.getFone().getPlaceholder()) && !imovel.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("fone1"), "%" + imovel.getFone1() + "%"));
		}
		if (imovel.getFone2() != null && !imovel.getFone2().equals(Mascara.getFone().getPlaceholder()) && !imovel.getFone2().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("fone2"), "%" + imovel.getFone2() + "%"));
		}
		if (naoEstaVazio(imovel.getGaragem())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("garagem"), "%" + imovel.getGaragem() + "%"));
		}
		if (naoEstaVazio(imovel.getLogradouro())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("logradouro"), "%" + imovel.getLogradouro() + "%"));
		}
		if (naoEstaVazio(imovel.getNomeProprietario())) {
			predicates.add(
					criteriaBuilder.like(rootImovel.get("nomeProprietario"), "%" + imovel.getNomeProprietario() + "%"));
		}
		if (naoEstaVazio(imovel.getPais())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("pais"), "%" + imovel.getPais() + "%"));
		}
		if (naoEstaVazio(imovel.getPiscina())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("piscina"), "%" + imovel.getPiscina() + "%"));
		}
		if (naoEstaVazio(imovel.getQuarto())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("quarto"), "%" + imovel.getQuarto() + "%"));
		}
		if (naoEstaVazio(imovel.getSala())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("sala"), "%" + imovel.getSala() + "%"));
		}
		if (naoEstaVazio(imovel.getSuite())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("suite"), "%" + imovel.getSuite() + "%"));
		}
		if (naoEstaVazio(imovel.getTerracao())) {
			predicates.add(criteriaBuilder.like(rootImovel.get("terracao"), "%" + imovel.getTerracao() + "%"));
		}
		if (naoEstaVazio(imovel.getVaranda())) {
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
	
	private boolean naoEstaVazio(Object objeto) {
		if (objeto == null) {
			return false;
		}
		if (objeto.toString().equals("")) {
			return false;
		}
		return true;
	}
}
