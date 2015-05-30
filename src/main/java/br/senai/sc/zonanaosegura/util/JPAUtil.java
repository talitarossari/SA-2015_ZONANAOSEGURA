package br.senai.sc.zonanaosegura.util;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;

public class JPAUtil {

	private static final String ENTITY_MANAGER = "ENTITY_MANAGER";
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManager getEntityManager() {
		ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return (EntityManager) request.getAttribute(ENTITY_MANAGER);
	}

	static EntityManager createEntityManager(ServletRequest request) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		request.setAttribute(ENTITY_MANAGER, entityManager);
		
		return entityManager;
	}

	static void creteEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("zonanaosegura");		
	}

	static void entityManagerFactoryClose() {
		entityManagerFactory.close();
	}

}