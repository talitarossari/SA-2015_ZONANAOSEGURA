package br.senai.sc.zonanaosegura.configuration;

import br.senai.sc.zonanaosegura.util.JPAUtil_Test;

public class EntityManagerTestLoader {

	private static final String ZONA_NAO_SEGURA = "zonanaosegura";

	public static void load() {
		JPAUtil_Test.createEntityManagerFactory(ZONA_NAO_SEGURA);
	}
}
