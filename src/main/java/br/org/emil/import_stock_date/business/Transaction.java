package br.org.emil.import_stock_date.business;

import java.util.List;

import javax.persistence.EntityManager;

public class Transaction {
	private static EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	
	
	public static void saveList(List<? extends Object> list) {
		if (!em.isOpen()) {
			em = PersistenceManager.INSTANCE.getEntityManager();
		}
		em.getTransaction().begin();
		try {
			for (Object obj : list) {
				em.persist(obj);
			}
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} 
	}
	
	public static void save(Object obj) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		try {			
			em.persist(obj);			
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} 
	}
	
	public static void close() {
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
