/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 18, 2024
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

/**
 * 
 */
public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Module3Wiedmier"); 
	public void insertOwner(Owner o) { 
	EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		em.persist(o); 
		em.getTransaction().commit(); 
		em.close(); 
	} 
	public List<Owner> showAllOwners() { 
		EntityManager em = emfactory.createEntityManager(); 
		List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList(); 
		return allOwners; 
	}
	/**
	 * @param shopperName
	 * @return
	 */
	public Owner findOwner(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.ownerName = :selectedName", Owner.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp); 
		typedQuery.setMaxResults(1); 
		Owner foundOwner;
		
		try { 
			foundOwner = typedQuery.getSingleResult(); 
		} catch (NoResultException ex) { 
			foundOwner = new Owner(nameToLookUp); 
		} 
		em.close(); 
		return foundOwner;
	}
}
