package com.imatia.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.ReservationDao;
import com.imatia.bookmanager.view.results.ReservationDetails;
import com.imatia.bookmanager.model.entities.Reservation;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;
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
		boolean lendingBookExist;
		boolean reservationExist;
		ArrayList<String> copyDataList;
		String userId;
		
		lendingBookExist = rd.checkLendingBookExist(bookId);
		reservationExist= rd.checkReservationExist(bookId);
		
		
		if(reservationExist==true)
		{
			System.out.println("No se puede realizar la reserva.\n"
							+ "El libro ya está reservado por otra persona.\n");
			
			ReservationUi.showReservationUi();
		}
		else if(!lendingBookExist) 
		{
			//Get Copies to show
			copyDataList= rd.getAvailableCopiesAlternative(bookId);
			System.out.println("No se puede realizar la reserva.\n"
							+ "El libro esta disponible para su prestamo.\n");
			//Show copies
			for(String s: copyDataList) System.out.println(s);
			System.out.println("\nTiene que pedir un préstamo.\n");
			//Go to leading menu
			LendingsUi.showLendingsUi();
		}
		else if(reservationExist==false)
		{
			//At this point, there's no previous reservation of the book, 
			//so proceed with creating reservation process
			copyDataList= rd.getAvailableCopies(bookId);
			if (copyDataList.isEmpty())
			{
				//Reservation can be done!
				//Only rest to ask for the user id
				System.out.println("Introduzca el id del ususario: ");
				do 
				{
					userId = InputUserData.checkUserInput("id", "Inserte un id valido (entero positivo)");
					if(userId.equals("")) System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
				// check User exist
					UserController uc = new UserController();
					if (!uc.checkUserId(Integer.parseInt(userId))) {
						System.out.println("Este usuario no existe. Introduzca un usuario válido");
						userId= "";
					}
				}while(userId.equals(""));
				
				//Insert the reservation on the bbdd
				Reservation reserv= new Reservation(1, bookId, Integer.parseInt(userId));
				rd.addReservation(reserv);
				
				System.out.println("La reserva se ha realizado con exito.");
				
				//Back to the main menu
				StartMenuUI.showStartMenuUi();
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
	public void getReservationData(int id)
	{	
		ReservationDao rd = new ReservationDao();
		ArrayList<String> al;
		al = rd.getReservationAdditionalData(id);
		ReservationDetails.showReservationDetails(al);
	}//getReservationData()
	
	
	
	/**
	 * method to delete a reservation
	 * @param id
	 */
	public void deleteReservation(int reservationId)
	{
		rd.deleteReservation(reservationId);
	}//deleteReservation()
	
	/**
	 * method to get a reservation by id
	 * @param id
	 */
	public Reservation getReservationById(int id) {
		Reservation reservation = new Reservation();
		reservation = rd.getReservationById(id);
		return reservation;
	}//getReservationById
	
	/**
	 * method to get a reservation list by idBook
	 * @param id
	 * @return reservationList
	 */
	public List<Reservation> getReservationsByIdBook(int id) {
		
		List<Reservation> reservationList = rd.getReservationsByIdBook(id);
		
		return reservationList;
	}//getReservationListByIdBook
		
}//class ReservationController
