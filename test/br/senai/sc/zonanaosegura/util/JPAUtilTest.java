package br.senai.sc.zonanaosegura.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.senai.sc.zonanaosegura.configuration.JUnitRunner;


@RunWith(JUnitRunner.class)
public class JPAUtilTest {

	@Test
	public void testJPAUtilNotNull() {
		assertNotNull(new JPAUtil());
	}
	
	@Test
	public void testLoadEntityManagerFactory() {
		assertEquals("zonanaosegura", 
				JPAUtil_Test.entityManagerFactory.getProperties().get(
						"hibernate.ejb.persistenceUnitName").toString());
	}
}

