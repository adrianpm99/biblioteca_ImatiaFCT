
package com.imatia.bookmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.LendingDao;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.model.entities.Reservation;

/**
 * class to implement the methods to connect views with data (regarding Lendings)
 * 
 * @author Grupo2FCTImatia
 *
 */

public class LendingController {
	
	LendingDao ld = new LendingDao();
	
	/**
	 * method to add a copy lending to the database 
	 * 
	 * @param lending, listIdCopy
	 * @return error
	 */
	
	public String addLending(Lending lending, ArrayList<Integer> listIdCopy) {
		
		String error = ld.addLending(lending, listIdCopy);
		return error;
	}//addLending
	
	/**
	 * method to delete a copy lending from the database
	 * 
	 * @param lending, copy
	 */
	
	public void deleteLending(Lending lending, Copy copy) {
		
		ld.deleteLending(lending, copy);
	}//deleteLending
	
	/**
	 * method to get a copy lending from the database by its id
	 * @param id
	 * @return lending
	 */
	
	public Lending getLendingById(int id) {
		
		Lending lending = ld.getLendingById(id);
		return lending;
	}//getLendingById
	
	/**
	 * method to get a list of copy lendings filtered by the users id
	 * 
	 * @param UserId
	 * @return lendingList
	 */
	
	public List<Lending> getLendingByUserId(int id) {
		
		List<Lending> lendingList = ld.getLendingByUserId(id);
		return lendingList;
	}//getLendingByUserId
	
	/**
	 * method to get a list of lendings filtered by its deadline
	 * 
	 * @param secondDate, LendingDeadLine
	 * @return lendingList
	 */
	
	public List<Lending> getLendingByDeadLine(String firstDate, String secondDate) {
		
		List<Lending> lendingList = ld.getLendingByDeadLine(firstDate, secondDate);
		return lendingList;
	}//getLendingByDeadLine	
	
	/**
	 * method to modify a lending's return date, also allowing to add 
	 * some optional comments, then giving a notice to the user if there is
	 * a reservation on the returned book
	 * @param  lendingId, lendingReturnDate, lendingNotes
	 */
	
	public void modifyLendingReturnDate(int id, LocalDate lendingReturnDate, String lendingNotes) {
		
		ReservationController rc = new ReservationController();
		
		Lending lending = ld.getLendingById(id);
		
		//change lendingReturnDate
		if(lending.getLendingReturnDate() == null) {
			ld.modifyLendingReturnDate(id, lendingReturnDate);
		
		//add lendingNotes
		ld.addLendingNotes(id, lendingNotes);
						
		//return a reservation list
		ArrayList<Reservation> reservationList = ld.checkIfReservatedBook(id); //LendingID
	
			for (Reservation r:reservationList) {
				rc.getReservationData(r.getBookId());
			
				rc.deleteReservation(r.getReservationId()) ;
			}	
		}
		else {
			System.out.println("El prestamo con id " + id + " ya está cerrado");
			}
	}//modifyLendingReturnDate()	
	
}//class LendingController