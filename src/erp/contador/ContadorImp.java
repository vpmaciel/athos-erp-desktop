package erp.contador;

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

import arquitetura.Jpa;
import arquitetura.validacao.Mascara;

final class ContadorImp implements ContadorDao {

	@Override
	public void deletarRegistro(Contador contador) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Contador.class, contador.getId()));
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
	public Collection<Contador> getRegistro() {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Contador> contadorList = null;

		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery("select T from Contador T order by T.nome", Contador.class);
			contadorList = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return contadorList;
	}

	@Override
	public Contador getRegistro(Contador contador) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			contador = entityManager.find(Contador.class, contador.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return contador;
	}

	@Override
	public Collection<Contador> pesquisarRegistro(Contador contador) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		List<Contador> contadorList = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Contador> criteriaQuery = criteriaBuilder.createQuery(Contador.class);
			Root<Contador> rootContador = criteriaQuery.from(Contador.class);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			if (contador.getId() != null) {
				predicateList.add(criteriaBuilder.equal(rootContador.get("id"), contador.getId()));
			}
			if (contador.getCnpj() != null && !contador.getCnpj().equals(Mascara.getCnpj().getPlaceholder())
					&& !contador.getCnpj().equals(Mascara.getCnpjVazio())) {
				predicateList.add(criteriaBuilder.like(rootContador.get("cnpj"), "%" + contador.getCnpj() + "%"));
			}
			if (contador.getCpf() != null && !contador.getCpf().equals(Mascara.getCpf().getPlaceholder())
					&& !contador.getCpf().equals(Mascara.getCpfVazio())) {
				predicateList.add(criteriaBuilder.like(rootContador.get("cpf"), "%" + contador.getCpf() + "%"));
			}
			if (contador.getCrc() != null && contador.getCrc().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootContador.get("crc"), "%" + contador.getCrc() + "%"));
			}
			if (contador.getEmail() != null && contador.getEmail().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootContador.get("email"), "%" + contador.getEmail() + "%"));
			}
			if (contador.getFax() != null && !contador.getFax().equals(Mascara.getFax().getPlaceholder())
					&& !contador.getFax().equals(Mascara.getFaxVazio())) {
				predicateList.add(criteriaBuilder.like(rootContador.get("fax"), "%" + contador.getFax() + "%"));
			}
			if (contador.getFone1() != null && !contador.getFone1().equals(Mascara.getFone().getPlaceholder())
					&& !contador.getFone1().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootContador.get("fone1"), "%" + contador.getFone1() + "%"));
			}
			if (contador.getFone2() != null && !contador.getFone2().equals(Mascara.getFone().getPlaceholder())
					&& !contador.getFone2().equals(Mascara.getFoneVazio())) {
				predicateList.add(criteriaBuilder.like(rootContador.get("fone2"), "%" + contador.getFone2() + "%"));
			}
			if (contador.getNome() != null && contador.getNome().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootContador.get("nome"), "%" + contador.getNome() + "%"));
			}
			if (contador.getSite() != null && contador.getSite().length() > 0) {
				predicateList.add(criteriaBuilder.like(rootContador.get("site"), "%" + contador.getSite() + "%"));
			}

			criteriaQuery.select(rootContador).where(predicateList.toArray(new Predicate[] {}));
			contadorList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return contadorList;
	}

	@Override
	public void salvarRegistro(Contador contador) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = Jpa.getEntityManagerFactory().createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(contador);
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