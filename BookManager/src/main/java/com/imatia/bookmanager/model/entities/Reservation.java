package com.imatia.bookmanager.model.entities;

/**
 * Class that defines the Reservation object with its attributes, constructors
 * and getter and setter methods
 *
 * @author Grupo2FCTImatia
 */

public class Reservation {

	int reservationId;
	int bookId;
	int userId;

	public Reservation() {
	}// Reservation()

	/**
	 * Called by createNewReservation (with the checkIfReservatedBook method), and getReservationBy...,
	 * either creates or searches for a reservation in the DB
	 */
	
	public Reservation(int reservationId, int bookId, int userId) {

		this.reservationId = reservationId;
		this.bookId = bookId;
		this.userId = userId;

	}// Reservation()

	public int getReservationId() {
		return reservationId;
	}// getReservationId()

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}// setReservationId()

	public int getBookId() {
		return bookId;
	}// getBookId()

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}// setBookId()

	public int getUserId() {
		return userId;
	}// getUserId()

	public void setUserId(int userId) {
		this.userId = userId;
	}// setUserId()

}// class Reservation
