package com.imatia.bookmanager.controller;

import java.util.ArrayList;

import com.imatia.bookmanager.model.data.ReservationDao;
import com.imatia.bookmanager.view.results.ReservationDetails;
import com.imatia.bookmanager.view.ui.AddReservationUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

//import java.util.ArrayList;
//import java.util.List;

//import com.imatia.bookmanager.model.data.ReservationDao;
//import com.imatia.bookmanager.model.entities.Reservation;

/**
 * class to implement the methods to connect views with data
 * @author Grupo2FCTImatia
 *
 */
public class ReservationController {
	
	ReservationDao rd = new ReservationDao();
	
	
	public void createNewReservation(int bookId) //bookId asked before on the menu
	{
		/* In order to create a new reservation, first it is necessary
		 * to check if is there any reservation of that book.*/
		boolean reservationExist;
		
		//ReservationUi.showReservationUi();
		
		reservationExist= rd.checkReservationExist(bookId);
		if(reservationExist==true)
		{
			System.out.println("No se puede realizar la reserva.\n"
							+ "El libro ya está reservado por otra persona.\n");
			//ReservationUi.showReservationUi();
		}
		else if(reservationExist==false)
		{
			//proceed with creating reservation process (not implemented yet)
		}
	}//createNewReservation()
	
	/**
	 * Get the reservationData
	 * @param rd
	 */
	public void getReservationData(int id) {
		
		ReservationDao rd = new ReservationDao();
		ArrayList<String> al;
		al = rd.getReservationAdditionalData(id);
		ReservationDetails.showReservationDetails(al);
	}
	
	
	
	
	
//	public Reservation getReservationById(int reservationId) {
//		
//		Reservation reservation = rd.getReservationById(reservationId);
//		return reservation;
//	}

	/**
	 * method to get a list of reservations filter by idCopy
	 * @param idCopy
	 * @return reservationList
	 */
	/*public List<Reservation> getReservationByIdCopy(String idCopy) {

		List<Reservation> reservationList = rd.getReservationByIdCopy(idCopy);
		return reservationList;
	}*/
	
	/**
	 * method to insert a reservation in database
	 * @param reservation
	 */
	/*public void addReservation(Reservation reservation) {
		
		rd.addReservation(reservation);
	}*/
	
	/**
	 * method to delete a reservation
	 * @param id
	 */
	/*public void deleteReservation(int id) {
		rd.deleteReservation(id);
	}*/
}
