/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 18, 2024
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue
	private int id;
	private String ownerName;
	
	//Constructors
	/**
	 * No arg Constructor
	 */
	public Owner() {
		super();
	}
	/**
	 * @param ownerName
	 */
	public Owner(String ownerName) {
		super();
		this.ownerName = ownerName;
	}
	/**
	 * @param id
	 * @param ownerName
	 */
	public Owner(int id, String ownerName) {
		super();
		this.id = id;
		this.ownerName = ownerName;
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
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	//Helper Methods
	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerName=" + ownerName + "]";
	}
	
}
