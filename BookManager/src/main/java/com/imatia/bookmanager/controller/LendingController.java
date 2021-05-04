
package com.imatia.bookmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.LendingDao;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.model.entities.Reservation;

/**
 * class to implements the methods to connect views with data
 * @author Grupo2FCTImatia
 *
 */
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
	 * @param secondDate 
	 * @param LendingDeadLine
	 * @return lendingList
	 */
	public List<Lending> getLendingByDeadLine(String firstDate, String secondDate) {
		
		List<Lending> lendingList = ld.getLendingByDeadLine(firstDate, secondDate);
		return lendingList;
	}
	
	
	
	/**
	 * method that closes a loan by modifying its lendingReturnDate and gives a notice to the user
	 * if there is a reservation on the returned book
	 * @param  lendingId, LendingDeadLine
	 * 
	 */
	public void modifyLendingReturnDate(int id, LocalDate lendingReturnDate) {
		
		ReservationController rc = new ReservationController();
		
		Lending lending = ld.getLendingById(id);
		
		if(lending.getLendingReturnDate() == null) {
			ld.modifyLendingReturndDate(id, lendingReturnDate);
						
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
	}
	
	
	
}

