package br.org.emil.import_stock_date.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.org.emil.import_stock_date.entity.Cotacao;
import br.org.emil.import_stock_date.entity.Operacao;

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
	
	public static void merge(Object obj) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(obj);			
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} 
	}
	
	public static List<Operacao> loadOpenOperations() {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		return em.createNamedQuery(Operacao.FIND_OPEN_OPERATIONS).getResultList();
	}
	
	public static Cotacao findVenda(Operacao operacao) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query query = em.createNamedQuery(Cotacao.FIND_VENDA);
		query.setParameter("dtOperacao", operacao.getEntrada());
		query.setParameter("ativo", operacao.getAtivo());
		query.setParameter("alvo", operacao.getAlvo());
		query.setParameter("loss", operacao.getStopLoss());
		query.setMaxResults(1);
		List<Cotacao> cotacoes = query.getResultList();
		if (cotacoes != null && !cotacoes.isEmpty()) {
			return cotacoes.get(0);
		} else {
			return null;
		}
	}
	
	public static void close() {
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
