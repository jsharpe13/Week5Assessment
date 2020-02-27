package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CheckOutList;
import model.bookList;

public class CheckOutListHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertNewListDetails(CheckOutList c)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CheckOutList>getLists()
	{
		EntityManager em = emfactory.createEntityManager();
		List<CheckOutList>allDetails = em.createQuery("SELECT d FROM CheckOutList d").getResultList();
		return allDetails;
	}
	
	public CheckOutList searchForListById(Integer tempId)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CheckOutList found = em.find(CheckOutList.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteItem(CheckOutList listToDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CheckOutList>typedQuery = em.createQuery("select d from CheckOutList d where d.id= :selectedid", CheckOutList.class);
		
		typedQuery.setParameter("selectedid", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		CheckOutList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateList(CheckOutList toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
