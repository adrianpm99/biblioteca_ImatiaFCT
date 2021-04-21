package com.imatia.bookmanager.model.entities;

public class Copy {
	
	int id;
	int idBook;
	boolean avaiable;
	
	public Copy() {
		super();
	}

	public Copy(int id, int idBook, boolean avaiable) {
		super();
		this.id = id;
		this.idBook = idBook;
		
		this.avaiable = avaiable;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	
	public boolean isAvaiable() {
		return avaiable;
	}

	public void setAvaiable(boolean avaiable) {
		this.avaiable = avaiable;
	}

	
	

}
