package com.imatia.bookmanager.model.entities;

/**
 * 
 * class that defines the Copy object with its attributes, 
 * constructors and getter and setter methods
 *
 */
public class Copy {
	
<<<<<<< HEAD
	int id;
	int idBook;
	boolean avaliable;
=======
	int copyId;
	int bookId;
	boolean copyAvaiable;
	
	
>>>>>>> branch 'Development' of https://github.com/adrianpm99/biblioteca_ImatiaFCT
	
	public Copy() {
		super();
	}



	public Copy(int copyId, int bookId, boolean copyAvaiable) {
		super();
<<<<<<< HEAD
		this.id = id;
		this.idBook = idBook;
		
		this.avaliable = avaiable;
=======
		this.copyId = copyId;
		this.bookId = bookId;
		this.copyAvaiable = copyAvaiable;
	}



	public int getCopyId() {
		return copyId;
	}



	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public boolean isCopyAvaiable() {
		return copyAvaiable;
	}



	public void setCopyAvaiable(boolean copyAvaiable) {
		this.copyAvaiable = copyAvaiable;
>>>>>>> branch 'Development' of https://github.com/adrianpm99/biblioteca_ImatiaFCT
	}
	
<<<<<<< HEAD
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

=======
>>>>>>> branch 'Development' of https://github.com/adrianpm99/biblioteca_ImatiaFCT
	
	

}
