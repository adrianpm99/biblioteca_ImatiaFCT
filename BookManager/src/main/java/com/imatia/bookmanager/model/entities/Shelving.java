package com.imatia.bookmanager.model.entities;

public class Shelving {

	int shelvingId;
	int shelvingNumber;
	
	public Shelving() {
		
	}

	public Shelving(int shelvingId, int shelvingNumber) {
		super();
		this.shelvingId = shelvingId;
		this.shelvingNumber = shelvingNumber;
	}

	public Shelving(int shelvingNumber) {
		super();
		this.shelvingNumber = shelvingNumber;
	}

	public int getShelvingId() {
		return shelvingId;
	}

	public void setShelvingId(int shelvingId) {
		this.shelvingId = shelvingId;
	}

	public int getShelvingNumber() {
		return shelvingNumber;
	}

	public void setShelvingNumber(int shelvingNumber) {
		this.shelvingNumber = shelvingNumber;
	}
	
}
