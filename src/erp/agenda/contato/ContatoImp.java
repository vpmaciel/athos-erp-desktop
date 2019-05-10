package erp.agenda.contato;

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

final class ContatoImp implements ContatoDao {

	@Override
	public Contato consultarRegistro(Contato contato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contato> criteriaQuery = criteriaBuilder.createQuery(Contato.class);
		Root<Contato> rootContato = criteriaQuery.from(Contato.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		boolean naoTentityManagerCriterio = true;

		if (contato.getCnpj() != null && !contato.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !contato.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.equal(rootContato.get("cnpj"), contato.getCnpj()));
			naoTentityManagerCriterio = false;
		}
		if (contato.getCpf() != null && !contato.getCpf().equals(Mascara.getCpf().getPlaceholder())
				&& !contato.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.equal(rootContato.get("cpf"), contato.getCpf()));
			naoTentityManagerCriterio = false;
		}

		if (naoTentityManagerCriterio) {
			return new Contato();
		}

		criteriaQuery.select(rootContato).where(predicates.toArray(new Predicate[] {}));

		List<Contato> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list.size() > 0 ? list.get(0) : new Contato();
	}

	@Override
	public void deletarRegistro(Contato contato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Contato.class, contato.getId()));
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Collection<Contato> getRegistro() {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select T from Contato T order by T.nome", Contato.class);
		@SuppressWarnings("unchecked")
		List<Contato> list = query.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public Contato getRegistro(Contato contato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(Contato.class, contato.getId());
	}

	@Override
	public Collection<Contato> pesquisarRegistro(Contato contato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contato> criteriaQuery = criteriaBuilder.createQuery(Contato.class);
		Root<Contato> rootContato = criteriaQuery.from(Contato.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (contato.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootContato.get("id"), contato.getId()));
		}
		if (contato.getBairro() != null && contato.getBairro().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("bairro"), "%" + contato.getBairro() + "%"));
		}
		if (contato.getCep() != null && !contato.getCep().equals(Mascara.getCep().getPlaceholder())
				&& !contato.getCep().equals(Mascara.getCepVazio())) {
			predicates.add(criteriaBuilder.like(rootContato.get("cep"), "%" + contato.getCep() + "%"));
		}
		if (contato.getCidade() != null && contato.getCidade().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("cidade"), "%" + contato.getCidade() + "%"));
		}
		if (contato.getCnpj() != null && !contato.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
				&& !contato.getCnpj().equals(Mascara.getCnpjVazio())) {
			predicates.add(criteriaBuilder.like(rootContato.get("cnpj"), "%" + contato.getCnpj() + "%"));
		}
		if (contato.getComplemento() != null && contato.getComplemento().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("complemento"), "%" + contato.getComplemento() + "%"));
		}
		if (contato.getCpf() != null && !contato.getCpf().equals(Mascara.getCpf().getPlaceholder())
				&& !contato.getCpf().equals(Mascara.getCpfVazio())) {
			predicates.add(criteriaBuilder.like(rootContato.get("cpf"), "%" + contato.getCpf() + "%"));
		}
		if (contato.getEmail() != null && contato.getEmail().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("entityManagerail"), "%" + contato.getEmail() + "%"));
		}
		if (contato.getEmpresa() != null && contato.getEmpresa().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootContato.get("entityManagerpresa"), contato.getEmpresa()));
		}
		if (contato.getEstado() != null && contato.getEstado().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("estado"), "%" + contato.getEstado() + "%"));
		}
		if (contato.getFax() != null && !contato.getFax().equals(Mascara.getFax().getPlaceholder())
				&& !contato.getFax().equals(Mascara.getFaxVazio())) {
			predicates.add(criteriaBuilder.like(rootContato.get("fax"), "%" + contato.getFax() + "%"));
		}
		if (contato.getFone1() != null && !contato.getFone1().equals(Mascara.getFone().getPlaceholder())
				&& !contato.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootContato.get("fone1"), "%" + contato.getFone1() + "%"));
		}
		if (contato.getFone2() != null && !contato.getFone2().equals(Mascara.getFone().getPlaceholder())
				&& !contato.getFone1().equals(Mascara.getFoneVazio())) {
			predicates.add(criteriaBuilder.like(rootContato.get("fone2"), "%" + contato.getFone2() + "%"));
		}
		if (contato.getLogradouro() != null && contato.getLogradouro().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("logradouro"), "%" + contato.getLogradouro() + "%"));
		}
		if (contato.getNome() != null && contato.getNome().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("nome"), "%" + contato.getNome() + "%"));
		}
		if (contato.getPais() != null && contato.getPais().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("pais"), "%" + contato.getPais() + "%"));
		}
		if (contato.getSexo() != null && contato.getSexo().length() > 0) {
			predicates.add(criteriaBuilder.like(rootContato.get("sexo"), "%" + contato.getSexo() + "%"));
		}

		criteriaQuery.select(rootContato).where(predicates.toArray(new Predicate[] {}));

		List<Contato> list = entityManager.createQuery(criteriaQuery).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Contato contato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(contato);
		entityTransaction.commit();
		entityManager.close();
	}
}