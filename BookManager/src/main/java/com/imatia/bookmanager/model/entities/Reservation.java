package com.imatia.bookmanager.model.entities;

/**
 * 
 * class that defines the reservation object with its attributes, constructors
 * and getter and setter methods
 *
 */
public class Reservation {

	int reservationId;
	int bookId;
	int userId;

	public Reservation() {

	}

	public Reservation(int reservationId, int bookId, int userId) {

		this.reservationId = reservationId;
		this.bookId = bookId;
		this.userId = userId;

	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
