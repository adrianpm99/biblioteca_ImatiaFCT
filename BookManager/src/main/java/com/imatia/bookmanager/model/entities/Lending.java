package com.imatia.bookmanager.model.entities;

import java.time.LocalDate;

/**
 * class that defines the Lending object with its attributes, 
 * constructors and getter and setter methods
 */
public class Lending
{
	int lendingId;
	int userId;
	LocalDate lendingDate;
	LocalDate lendingDeadLine;
	LocalDate lendingReturnDate;
	String lendingNotes;
	
		
	public Lending() {
		super();
	}
	

	public Lending(int lendingId, int userId, LocalDate lendingDate, LocalDate lendingDeadLine) {
		super();
		this.lendingId = lendingId;
		this.userId = userId;
		this.lendingDate = lendingDate;
		this.lendingDeadLine = lendingDeadLine;
	}


	public Lending(int lendingId, int userId, LocalDate lendingDate, LocalDate lendingDeadLine,
			LocalDate lendingReturnDate) {
		super();
		this.lendingId = lendingId;
		this.userId = userId;
		this.lendingDate = lendingDate;
		this.lendingDeadLine = lendingDeadLine;
		this.lendingReturnDate = lendingReturnDate;
	}
	
	
	public Lending(int lendingId, int userId, LocalDate lendingDate, LocalDate lendingDeadLine,
			LocalDate lendingReturnDate, String lendingNotes) {
		super();
		this.lendingId = lendingId;
		this.userId = userId;
		this.lendingDate = lendingDate;
		this.lendingDeadLine = lendingDeadLine;
		this.lendingReturnDate = lendingReturnDate;
		this.lendingNotes= lendingNotes;
	}


	public int getLendingId() {
		return lendingId;
	}


	public void setLendingId(int lendingId) {
		this.lendingId = lendingId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public LocalDate getLendingDate() {
		return lendingDate;
	}


	public void setLendingDate(LocalDate lendingDate) {
		this.lendingDate = lendingDate;
	}


	public LocalDate getLendingDeadLine() {
		return lendingDeadLine;
	}


	public void setLendingDeadLine(LocalDate lendingDeadLine) {
		this.lendingDeadLine = lendingDeadLine;
	}


	public LocalDate getLendingReturnDate() {
		return lendingReturnDate;
	}


	public void setLendingReturnDate(LocalDate lendingReturnDate) {
		this.lendingReturnDate = lendingReturnDate;
	}


	public String getLendingNotes() {
		return lendingNotes;
	}


	public void setLendingNotes(String lendingNotes) {
		this.lendingNotes = lendingNotes;
	}
	
}//class Lending