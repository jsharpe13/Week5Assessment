package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.bookList;

public class BookHelper 
{
	static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("Week3Assessment");

	public void insertBook(bookList li)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<bookList>showAllItems()
	{
		EntityManager em = emfactory.createEntityManager();
		List<bookList>allItems=em.createQuery("SELECT i FROM bookList i").getResultList();
		return allItems;
	}
	
	public void removeBook(bookList delete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<bookList> typedQuery = em.createQuery("select list from bookList list where list.title = :selectedTitle and list.author = :selectedAuthor", bookList.class);
	
		typedQuery.setParameter("selectedTitle", delete.getTitle());
		typedQuery.setParameter("selectedAuthor", delete.getAuthor());
		
		typedQuery.setMaxResults(1);
		
		bookList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public bookList searchForBookById(int BookID) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		bookList found = em.find(bookList.class, BookID);
		em.close();
		
		return found;
	}
	public List<bookList>searchForBookByTitle(String titleName)
	{
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<bookList> typedQuery = em.createQuery("select li from bookList li where li.title=:selectedTitle", bookList.class);
		typedQuery.setParameter("selectedTitle", titleName);
		
		List<bookList>foundBooks=typedQuery.getResultList();
		em.close();
		
		return foundBooks;
	}
	public List<bookList> searchForBookByAuthor(String name) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<bookList> typedQuery = em.createQuery("select li from bookList li where li.author=:selectedAuthor", bookList.class);
		typedQuery.setParameter("selectedAuthor", name);
		
		List<bookList> foundName = typedQuery.getResultList();
		em.close();
		
		return foundName;
	}
	public List<bookList> searchForBookByYear(int BookYear) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<bookList> typedQuery = em.createQuery("select li from bookList li where li.year = :selectedYear", bookList.class);
		typedQuery.setParameter("selectedYear", BookYear);
		
		List<bookList>found = typedQuery.getResultList();
		em.close();
		
		return found;
	}
	
	
	public void updateBook(bookList edit) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(edit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp()
	{
		emfactory.close();
	}
	
}
