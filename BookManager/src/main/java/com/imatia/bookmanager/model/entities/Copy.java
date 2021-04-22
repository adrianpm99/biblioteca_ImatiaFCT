package com.imatia.bookmanager.model.entities;

/**
 * 
 * class that defines the Copy object with its attributes, 
 * constructors and getter and setter methods
 *
 */
public class Copy {
	
	int id;
	int idBook;
	boolean avaliable;
	
	public Copy() {
		super();
	}

	public Copy(int id, int idBook, boolean avaiable) {
		super();
		this.id = id;
		this.idBook = idBook;
		
		this.avaliable = avaiable;
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

	
	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaiable) {
		this.avaliable = avaiable;
	}

	
	

}
