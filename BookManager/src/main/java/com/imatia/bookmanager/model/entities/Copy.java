package com.imatia.bookmanager.model.entities;

/**
 * Class that defines the Copy object with its attributes, constructors and
 * getter and setter methods
 *
 * @author Grupo2FCTImatia
 */

public class Copy {

	int copyId;
	int bookId;
	String copyNotes;

	public Copy() {
		super();
	}// Copy()

	public Copy(int copyId, int bookId, String copyNotes) {
		
		super();
		this.copyId = copyId;
		this.bookId = bookId;
		this.copyNotes = copyNotes;

	}// Copy()

	public Copy(int copyId, String copyNotes) {
		
		this.copyId = copyId;
		this.copyNotes = copyNotes;
		
	}// Copy()

	public int getCopyId() {
		return copyId;
	}// getCopyId()

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}// setCopyId()

	public int getBookId() {
		return bookId;
	}// getBookId()

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}// setBookId()

	public String getcopyNotes() {
		return copyNotes;
	}// getcopyNotes()

	public void setcopyNotes(String copyNotes) {
		this.copyNotes = copyNotes;
	}// setcopyNotes()

}//class Copy
