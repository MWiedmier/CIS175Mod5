/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 18, 2024
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.FishTank;

/**
 * 
 */
public class FishTankHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Module3Wiedmier"); 
	public void insertNewFishTank(FishTank ft) { 
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		em.persist(ft); 
		em.getTransaction().commit(); 
		em.close(); 
	}
	public List<FishTank> getLists(){
		EntityManager em = emfactory.createEntityManager(); 
		List<FishTank> allTanks = em.createQuery("SELECT t FROM FishTank t").getResultList(); 
		return allTanks;
	}
	/**
	 * @param tempId
	 * @return
	 */
	public FishTank searchForFishTanksById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		FishTank found = em.find(FishTank.class, tempId); 
		em.close(); 
		return found;
	}
	/**
	 * @param listToDelete
	 */
	public void deleteTank(FishTank toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<FishTank> typedQuery = em.createQuery("select tank from FishTank tank where tank.id = :selectedId", FishTank.class); 
		// Substitute parameter with actual data from the toDelete item 
		typedQuery.setParameter("selectedId", toDelete.getId()); 
		// we only want one result 
		typedQuery.setMaxResults(1); 
		// get the result and save it into a new list item 
		FishTank result = typedQuery.getSingleResult(); 
		// remove it 
		em.remove(result); 
		em.getTransaction().commit(); 
		em.close();
	}
	/**
	 * @param listToUpdate
	 */
	public void updateTank(FishTank toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		em.merge(toEdit); 
		em.getTransaction().commit(); 
		em.close();
	}
}
