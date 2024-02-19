/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 18, 2024
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.FishTankHelper;
import model.FishTank;
import model.Fish;
import model.Owner;

/**
 * 
 */
public class FishTankTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner cameron = new Owner("Cameron"); 
		FishTankHelper ldh = new FishTankHelper();
		
		Fish redFish = new Fish("RedFish", 1);
		Fish blueFish = new Fish("BlueFish", 2);
		
		List<Fish> cameronsFish = new ArrayList<Fish>();
		cameronsFish.add(redFish);
		cameronsFish.add(blueFish);

		FishTank cameronsList = new FishTank("Cameron's Fish Tank", cameron);
		cameronsList.setListOfFish(cameronsFish);
		
		ldh.insertNewFishTank(cameronsList);

		List<FishTank> allLists = ldh.getLists(); 
		for (FishTank a : allLists) { 
			System.out.println(a.toString()); 
		}
	}

}
