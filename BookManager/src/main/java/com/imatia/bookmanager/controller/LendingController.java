
package com.imatia.bookmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.LendingDao;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.model.entities.Reservation;


public class LendingController {
	LendingDao ld = new LendingDao();
	
	public String addLending(Lending lending, ArrayList<Integer> listIdCopy) {
		
		String error = ld.addLending(lending, listIdCopy);
		return error;
	}
	
	public void deleteLending(Lending lending, Copy copy) {
		
		ld.deleteLending(lending, copy);
	}
	
	public Lending getLendingById(int id) {
		
		Lending lending = ld.getLendingById(id);
		return lending;
	}
	
	/**
	 * method to get a list of lendings filter by UserId
	 * @param UserId
	 * @return lendingList
	 */
	public List<Lending> getLendingByUserId(int id) {
		
		List<Lending> lendingList = ld.getLendingByUserId(id);
		return lendingList;
	}
	
	/**
	 * method to get a list of lendings filter by LendingDeadLine
	 * @param LendingDeadLine
	 * @return lendingList
	 */
	public List<Lending> getLendingByDeadLine(String date) {
		
		List<Lending> lendingList = ld.getLendingByDeadLine(date);
		return lendingList;
	}
	
	
	
	/**
	 * methodthat closes a loan by modifying its lendingReturnDate and gives a notice to the user
	 * if there is a reservation on the returned book
	 * @param  lendingId, LendingDeadLine
	 * 
	 */
	public void modifyLendingReturnDate(int id, LocalDate lendingReturnDate) {
		
		ReservationController rc = new ReservationController();
		
		Lending lending = ld.getLendingById(id);
		
		if(lending.getLendingReturnDate() == null) {
			ld.modifyLendingReturndDate(id, lendingReturnDate);
			// at the time of repaying a loan, it is checked if there are reservations about
			// each book of each issue of that loan
			// if there is, a message is sent on the screen indicating the user
			// I had it reserved and the book and the reservation is deleted
			
			//tendria que devolver una lista de reservas, una por cada ejemplar del prestamo
			// devuelve un objeto reserva con información del usuario y el libro
			// a continuación se borra la reserva de la que ya tenemos reservationId
			Reservation reservation = ld.checkIfReservatedBook(id); //LendingID
			if (reservation != null) { //  there are reservation
				rc.getReservationData(reservation.getBookId());
				
			//	System.out.println("Avisar al usuario "+ reservation.getUserId() 
			//			+ " que tiene una reserva del libro "+ reservation.getBookId()
			//			+ " que acaba de ser devuelto");
				 //rc.deleteReservation(reservation.getReservationId) ;
				
			}
			
			
		}
		else {
			System.out.println("El prestamo con id " + id + " ya está cerrado");
			}
	}
	
	
	
}

