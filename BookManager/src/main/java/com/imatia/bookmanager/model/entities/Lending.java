package com.imatia.bookmanager.model.entities;

import java.time.LocalDate;

/**
 * Class that defines the Lending object with its attributes, constructors and
 * getter and setter methods
 * 
 * @author Grupo2FCTImatia
 */

public class Lending {

	int lendingId;
	int userId;
	LocalDate lendingDate;
	LocalDate lendingDeadLine;
	LocalDate lendingReturnDate;
	String lendingNotes;

	public Lending() {
		super();
	}// Lending()

	/**
	 * Called by showAddLendingMenu
	 */
	
	public Lending(int lendingId, int userId, LocalDate lendingDate, LocalDate lendingDeadLine,
			LocalDate lendingReturnDate, String lendingNotes) {

		super();
		this.lendingId = lendingId;
		this.userId = userId;
		this.lendingDate = lendingDate;
		this.lendingDeadLine = lendingDeadLine;
		this.lendingReturnDate = lendingReturnDate;
		this.lendingNotes = lendingNotes;

	}// Lending()

	/**
	 * Called by getLendingBy..., gets an existing Lending in the DB
	 */
	
	public Lending(int lendingId, int userId, LocalDate lendingDate, LocalDate lendingDeadLine, String lendingNotes) {

		super();
		this.lendingId = lendingId;
		this.userId = userId;
		this.lendingDate = lendingDate;
		this.lendingDeadLine = lendingDeadLine;
		this.lendingNotes = lendingNotes;

	}// Lending()

	public int getLendingId() {
		return lendingId;
	}// getLendingId()

	public void setLendingId(int lendingId) {
		this.lendingId = lendingId;
	}// setLendingId()

	public int getUserId() {
		return userId;
	}// getUserId()

	public void setUserId(int userId) {
		this.userId = userId;
	}// setUserId()

	public LocalDate getLendingDate() {
		return lendingDate;
	}// getLendingDate()

	public void setLendingDate(LocalDate lendingDate) {
		this.lendingDate = lendingDate;
	}// setLendingDate()

	public LocalDate getLendingDeadLine() {
		return lendingDeadLine;
	}// getLendingDeadLine()

	public void setLendingDeadLine(LocalDate lendingDeadLine) {
		this.lendingDeadLine = lendingDeadLine;
	}// setLendingDeadLine()

	public LocalDate getLendingReturnDate() {
		return lendingReturnDate;
	}// getLendingReturnDate()

	public void setLendingReturnDate(LocalDate lendingReturnDate) {
		this.lendingReturnDate = lendingReturnDate;
	}// setLendingReturnDate()

	public String getLendingNotes() {
		return lendingNotes;
	}// getLendingNotes()

	public void setLendingNotes(String lendingNotes) {
		this.lendingNotes = lendingNotes;
	}// setLendingNotes()

}// class Lending