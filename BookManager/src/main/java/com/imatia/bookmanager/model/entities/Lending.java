package com.imatia.bookmanager.model.entities;

import java.time.LocalDate;

public class Lending {
	
	

	int id;
	int idCopy;
	int idUser;
	LocalDate lendingDate;
	LocalDate lendingDeadLine;
	
		
	public Lending() {
		super();
	}


	public Lending(int id, int idCopy, int idUser, LocalDate lendingDate, LocalDate lendingDeadLine) {
		super();
		this.id = id;
		this.idCopy = idCopy;
		this.idUser = idUser;
		this.lendingDate = lendingDate;
		this.lendingDeadLine = lendingDeadLine;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdCopy() {
		return idCopy;
	}


	public void setIdCopy(int idCopy) {
		this.idCopy = idCopy;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
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


	

}
