/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 18, 2024
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class for FishTank holds info of owner and fish
 */
@Entity
public class FishTank {
	@Id
	@GeneratedValue
	private int id; 
	private String fishTankName; 
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Owner owner; 
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Fish> listOfFish;
	
	//Constructors
	/**
	 * No arg Constructor
	 */
	public FishTank() {
		super();
	}
	/**
	 * @param fishTankName
	 * @param owner
	 */
	public FishTank(String fishTankName, Owner owner) {
		super();
		this.fishTankName = fishTankName;
		this.owner = owner;
	}
	/**
	 * @param fishTankName
	 * @param owner
	 * @param listOfFish
	 */
	public FishTank(String fishTankName, Owner owner, List<Fish> listOfFish) {
		super();
		this.fishTankName = fishTankName;
		this.owner = owner;
		this.listOfFish = listOfFish;
	}
	/**
	 * @param id
	 * @param fishTankName
	 * @param owner
	 * @param listOfFish
	 */
	public FishTank(int id, String fishTankName, Owner owner, List<Fish> listOfFish) {
		super();
		this.id = id;
		this.fishTankName = fishTankName;
		this.owner = owner;
		this.listOfFish = listOfFish;
	}
	
	//Getters and Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fishTankName
	 */
	public String getFishTankName() {
		return fishTankName;
	}
	/**
	 * @param fishTankName the fishTankName to set
	 */
	public void setFishTankName(String fishTankName) {
		this.fishTankName = fishTankName;
	}
	/**
	 * @return the owner
	 */
	public Owner getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	/**
	 * @return the listOfFish
	 */
	public List<Fish> getListOfFish() {
		return listOfFish;
	}
	/**
	 * @param listOfFish the listOfFish to set
	 */
	public void setListOfFish(List<Fish> listOfFish) {
		this.listOfFish = listOfFish;
	}
	@Override
	public String toString() {
		return "FishTank [id=" + id + ", fishTankName=" + fishTankName + ", owner=" + owner + ", listOfFish="
				+ listOfFish + "]";
	}
}
