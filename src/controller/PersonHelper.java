package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Person;
import model.bookList;

public class PersonHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertPerson(Person p)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Person>showAllPersons()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Person>allPersons = em.createQuery("SELECT p FROM Person p").getResultList();
		return allPersons;
	}
	public Person searchForPersonByName(String PersonName)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Person>typedQuery = em.createQuery("select p from Person p where p.PersonName = :selectedName", Person.class);
		typedQuery.setParameter("selectedName", PersonName);
		typedQuery.setMaxResults(1);
		
		Person found = typedQuery.getSingleResult();
		em.close();
		return found;	
	}
	
	
}
