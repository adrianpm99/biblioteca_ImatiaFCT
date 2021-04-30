package com.imatia.bookmanager.model.entities;

/**
 * 
 * class that defines the Copy object with its attributes, constructors and
 * getter and setter methods
 *
 */
public class Copy {

	int copyId;
	int bookId;


	public Copy() {
		super();
	}

	public Copy(int copyId, int bookId) {
		super();
		this.copyId = copyId;
		this.bookId = bookId;
		
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

}
