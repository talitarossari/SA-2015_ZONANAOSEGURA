package br.senai.sc.zonanaosegura.util;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;


public class JPAUtil_Test {

	private static final String ENTITY_MANAGER = "ENTITY_MANAGER";
	public static EntityManagerFactory entityManagerFactory;

	public static EntityManager getEntityManager() {
		ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return (EntityManager) request.getAttribute(ENTITY_MANAGER);
	}

	static EntityManager createEntityManager(ServletRequest request) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		request.setAttribute(ENTITY_MANAGER, entityManager);
		
		return entityManager;
	}

	public static void createEntityManagerFactory(String persistenceUnit) {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);		
		}
	}
	
	public static void createEntityManagerFactory() {
		createEntityManagerFactory("zonanaosegura");		
	}

	public static void entityManagerFactoryClose() {
		entityManagerFactory.close();
	}

}