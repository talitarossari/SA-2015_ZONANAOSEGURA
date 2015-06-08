package br.senai.sc.zonanaosegura.dao.test;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import br.senai.sc.zonanaosegura.util.JPAUtil_Test;


public class DAOImplements<T> implements DAO_Test<T>{
	
	private static Logger logger;
	private Class<T> klass;
	public EntityManager em;
	
	public DAOImplements(Class<T> klass) {
		this.klass = klass;
		checkIntitymanageFactory();
	}
	
	private void checkIntitymanageFactory() {
		if (JPAUtil_Test.entityManagerFactory == null) {
			JPAUtil_Test.createEntityManagerFactory();
		}
	}
	
	private void checkEntityManager() {
		if (em == null || !em.isOpen()) {
			em = JPAUtil_Test.getEntityManager();
		}
	}

	@Override
	public void save(T t) {
		try {
			checkEntityManager();
			this.em.getTransaction().begin();
			this.em.persist(t);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			logger.severe(e.getMessage());
		} finally {
			this.em.close();
			this.em = null;
		}
	}

	@Override
	public void update(T t) {
		try {
			checkEntityManager();
			this.em.getTransaction().begin();
			this.em.merge(t);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			logger.severe(e.getMessage());
		} finally {
			this.em.close();
			this.em = null;
		}
		
	}

	@Override
	public void delete(T t) {
		try {
			checkEntityManager();
			this.em.getTransaction().begin();
			this.em.remove(t);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			logger.severe(e.getMessage());
		} finally {
			this.em.close();
			this.em = null;
		}
	}

	@Override
	public void deleteAll(List<T> t) {
		try {
			checkEntityManager();
			this.em.getTransaction().begin();
			for (T obj : t) {
				this.em.remove(obj);
				this.em.getTransaction().commit();
			}
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			logger.severe(e.getMessage());
		} finally {
			this.em.close();
			this.em = null;
		}
	}

	@Override
	public T findAllById(Integer id) {
		T result = null;
		try {
			checkEntityManager();
			result = this.em.find(klass, id);
		} catch (Exception e) {
			logger.severe(e.getMessage());
		} finally {
			this.em.close();
			this.em = null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> result = null;
		try {
			checkEntityManager();
			//TODO: Fazer busca generic
			result = this.em.createNamedQuery("").getResultList();
		} catch (Exception e) {
			logger.severe(e.getMessage());
		} finally {
			this.em.close();
			this.em = null;
		}
		return result;
	}

}