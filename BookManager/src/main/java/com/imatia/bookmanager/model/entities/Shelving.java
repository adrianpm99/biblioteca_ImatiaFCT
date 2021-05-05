package com.imatia.bookmanager.model.entities;

public class Shelving {

	int shelvingId;
	int shelvingPublicNumber;
	
	public Shelving() {
		
	}

	public Shelving(int shelvingId, int shelvingPublicNumber) {
		super();
		this.shelvingId = shelvingId;
		this.shelvingPublicNumber = shelvingPublicNumber;
	}

	public Shelving(int shelvingPublicNumber) {
		super();
		this.shelvingPublicNumber = shelvingPublicNumber;
	}

	public int getShelvingId() {
		return shelvingId;
	}

	public void setShelvingId(int shelvingId) {
		this.shelvingId = shelvingId;
	}

	public int getShelvingPublicNumber() {
		return shelvingPublicNumber;
	}

	public void setShelvingNumber(int shelvingPublicNumber) {
		this.shelvingPublicNumber = shelvingPublicNumber;
	}
	
}
