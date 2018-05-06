package br.org.emil.import_stock_date.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
	INSTANCE;
	private EntityManagerFactory emFactory;
	
	private EntityManager em;

	private PersistenceManager() {
		// "jpa-example" was the value of the name attribute of the
		// persistence-unit element.
		emFactory = Persistence.createEntityManagerFactory("ifr2-ds");
	}

	public EntityManager getEntityManager() {
		if (em == null) {
			em = emFactory.createEntityManager();
		}
		return em;
	}

	public void close() {
		emFactory.close();
	}
}