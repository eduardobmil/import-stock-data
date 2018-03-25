package br.org.emil.import_stock_date.business;

import java.util.List;

import javax.persistence.EntityManager;

public class Transaction {
	public static void saveList(List<? extends Object> list) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
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
		} finally {
			em.close();
		}
		PersistenceManager.INSTANCE.close();
	}
}
