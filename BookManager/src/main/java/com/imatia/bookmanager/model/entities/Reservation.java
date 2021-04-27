package com.imatia.bookmanager.model.entities;

import java.time.LocalDate;

/**
 * 
 * class that defines the reservation object with its attributes,
 * constructors and getter and setter methods
 *
 */
public class Reservation {
	
	
	int reservationId;
	int copyId;
	int userId;
	boolean reservationReservated;
	LocalDate reservationDate;
	
	
	public Reservation() {
		super();
	}


	public Reservation(int reservationId, int copyId, int userId, boolean reservationReservated,
			LocalDate reservationDate) {
		super();
		this.reservationId = reservationId;
		this.copyId = copyId;
		this.userId = userId;
		this.reservationReservated = reservationReservated;
		this.reservationDate = reservationDate;
	}


	public int getReservationId() {
		return reservationId;
	}


	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}


	public int getCopyId() {
		return copyId;
	}


	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public boolean isReservationReservated() {
		return reservationReservated;
	}


	public void setReservationReservated(boolean reservationReservated) {
		this.reservationReservated = reservationReservated;
	}


	public LocalDate getReservationDate() {
		return reservationDate;
	}


	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	
	
	
	
	
	

}
