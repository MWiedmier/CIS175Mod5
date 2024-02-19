/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 18, 2024
 */

import java.util.List;
import controller.OwnerHelper;
import model.Owner;

/**
 * 
 */
public class OwnerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub



		Owner bill = new Owner("Bill"); 
		   
		OwnerHelper sh = new OwnerHelper(); 
		   
		  sh.insertOwner(bill); 
		   
		  List<Owner> allOwners = sh.showAllOwners(); 
		  for(Owner a: allOwners) { 
		   System.out.println(a.toString()); 
		  }
	}

}
