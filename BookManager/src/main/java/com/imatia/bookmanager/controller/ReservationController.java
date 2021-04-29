package com.imatia.bookmanager.controller;

import java.util.ArrayList;

import com.imatia.bookmanager.model.data.ReservationDao;
import com.imatia.bookmanager.view.results.ReservationDetails;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.ReservationUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;


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
		 * to check out if there is any reservation of that book.*/
		boolean reservationExist;
		ArrayList<String> copyDataList;
		String userId;
				
		reservationExist= rd.checkReservationExist(bookId);
		if(reservationExist==true)
		{
			System.out.println("No se puede realizar la reserva.\n"
							+ "El libro ya está reservado por otra persona.\n");
			
			ReservationUi.showReservationUi();
		}
		else if(reservationExist==false)
		{
			//At this point, there's no previous reservation of the book, 
			//so proceed with creating reservation process
			copyDataList= rd.getAvailableCopies(bookId);
			if (copyDataList.isEmpty())
			{
				System.out.println("ESTA VACIO!");
				//Reservation can be done!
				//Only rest to ask for the user id
				System.out.println("Introduzca el id del ususario: ");
				do 
				{
					userId = InputUserData.checkUserInput("id", "Inserte un id valido (entero positivo)");
				}while(userId.equals(""));
				
				//Insert the reservation on the bbdd
				//rd.addReservation(bookId, Integer.parseInt(userId)); NOT IMPLEMENTED YET
			}
			else
			{
				System.out.println("No se puede realizar la reserva.\n"
				+ "El libro tiene todavía los siguientes ejemplares disponibles:\n");
				for(String s: copyDataList) System.out.println(s);
				System.out.println("\nTiene que pedir un préstamo.\n");
				
				StartMenuUI.showStartMenuUi();
			}
		}//else if
	}//createNewReservation()
	
	/**
	 * Get the reservationData
	 * @param bookId
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
