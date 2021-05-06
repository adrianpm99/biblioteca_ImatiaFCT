package com.imatia.bookmanager.model.entities;

/**
 * Class that defines the Shelving object with its attributes, constructors
 * and getter and setter methods
 *
 * @author Grupo2FCTImatia
 */

public class Shelving {

	int shelvingId;
	int shelvingPublicNumber;
	
	public Shelving() {
	}// Shelving()

	/**
	 * Called by getShelvingBy..., collects data on an already existing Shelving in the DB 
	 */
	
	public Shelving(int shelvingId, int shelvingPublicNumber) {
		
		super();
		this.shelvingId = shelvingId;
		this.shelvingPublicNumber = shelvingPublicNumber;
		
	}// Shelving()

	public int getShelvingId() {
		return shelvingId;
	}// getShelvingId()

	public void setShelvingId(int shelvingId) {
		this.shelvingId = shelvingId;
	}// setShelvingId()

	public int getShelvingPublicNumber() {
		return shelvingPublicNumber;
	}// getShelvingPublicNumber()

	public void setShelvingNumber(int shelvingPublicNumber) {
		this.shelvingPublicNumber = shelvingPublicNumber;
	}// setShelvingPublicNumber()
	
}//class Shelving
