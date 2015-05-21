package br.senai.sc.zonanaosegura.dao;

import javax.persistence.EntityManager;

import br.senai.sc.zonanaosegura.util.JPAUtil;

public abstract class Dao {

	protected EntityManager getEntityManager() {
		return JPAUtil.getEntityManager();
	}

}