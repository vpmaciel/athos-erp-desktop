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

final class ContatoIMP implements ContatoDAO {

	@Override
	public void deletarRegistro(Contato contato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Contato.class, contato.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public Contato getRegistro(Contato contato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		return em.find(Contato.class, contato.getId());
	}

	@Override
	public Collection<Contato> getRegistro() {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from erp.agenda.contato.Contato C order by C.nome");
		@SuppressWarnings("unchecked")
		List<Contato> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@Override
	public Collection<Contato> pesquisarRegistro(Contato contato) {
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contato> criteriaQuery = criteriaBuilder.createQuery(Contato.class);
		Root<Contato> rootContato = criteriaQuery.from(Contato.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (contato.getId() != null) {
			predicates.add(criteriaBuilder.equal(rootContato.get("id"), contato.getId()));
		}
		if (contato.getBairro() != null && !contato.getBairro().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("bairro"), "%" + contato.getBairro() + "%"));
		}
		if (contato.getCep() != null && !contato.getCep().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("cep"), "%" + contato.getCep() + "%"));
		}
		if (contato.getCidade() != null && !contato.getCidade().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("cidade"), "%" + contato.getCidade() + "%"));
		}
		if (contato.getCnpj() != null && !contato.getCnpj().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("cnpj"), "%" + contato.getCnpj() + "%"));
		}
		if (contato.getComplemento() != null && !contato.getComplemento().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("complemento"), "%" + contato.getComplemento() + "%"));
		}
		if (contato.getCpfNumero() != null && !contato.getCpfNumero().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("cpfNumero"), "%" + contato.getCpfNumero() + "%"));
		}
		if (contato.getEmail() != null && !contato.getEmail().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("email"), "%" + contato.getEmail() + "%"));
		}
		if (contato.getEmpresa() != null && contato.getEmpresa().getId() != null) {
			predicates.add(criteriaBuilder.equal(rootContato.get("empresa"), contato.getEmpresa()));
		}
		if (contato.getEstado() != null && !contato.getEstado().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("estado"), "%" + contato.getEstado() + "%"));
		}
		if (contato.getFax() != null && !contato.getFax().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("fax"), "%" + contato.getFax() + "%"));
		}
		if (contato.getFone1() != null && !contato.getFone1().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("fone1"), "%" + contato.getFone1() + "%"));
		}
		if (contato.getFone2() != null && !contato.getFone2().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("fone2"), "%" + contato.getFone2() + "%"));
		}
		if (contato.getLogradouro() != null && !contato.getLogradouro().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("logradouro"), "%" + contato.getLogradouro() + "%"));
		}
		if (contato.getNome() != null && !contato.getNome().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("nome"), "%" + contato.getNome() + "%"));
		}
		if (contato.getPais() != null && !contato.getPais().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("pais"), "%" + contato.getPais() + "%"));
		}
		if (contato.getSexo() != null && !contato.getSexo().equals("")) {
			predicates.add(criteriaBuilder.like(rootContato.get("sexo"), "%" + contato.getSexo() + "%"));
		}
		
		criteriaQuery.select(rootContato).where(predicates.toArray(new Predicate[] {}));

		List<Contato> list = entityManager.createQuery(criteriaQuery).getResultList();
		tx.commit();
		entityManager.close();
		return list;
	}

	@Override
	public void salvarRegistro(Contato contato) {
		EntityManager em = JPA.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(contato);
		tx.commit();
		em.close();
	}
}
