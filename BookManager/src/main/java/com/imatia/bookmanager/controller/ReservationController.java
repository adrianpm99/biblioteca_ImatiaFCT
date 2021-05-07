package com.imatia.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.ReservationDao;
import com.imatia.bookmanager.view.results.ReservationDetails;
import com.imatia.bookmanager.model.entities.Reservation;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;


/**
 * class to implement the methods to connect views with data (regarding Reservations)
 * @author Grupo2FCTImatia
 *
 */

public class ReservationController {
	
	ReservationDao rd = new ReservationDao();
	
	/**
	 * method to create a new reservation by bookId
	 * 
	 * @param bookId
	 */
	
	public void createNewReservation(int bookId) //bookId asked before on the menu
	{
		boolean lendingBookExist;
		
		ArrayList<String> copyDataList;
		String userId;
		
		lendingBookExist = rd.checkLendingBookExist(bookId);
		
		if(!lendingBookExist) 
		{
		//	 System.out.println("CASO 1: ninguna copia prestada nunca");
			//Get Copies to show
			copyDataList= rd.getAvailableCopiesAlternative(bookId);
			System.out.println("No se puede realizar la reserva.\n"
							+ "El libro esta disponible para su prestamo.\n"
							+ "Copias disponibles : \n");
			//Show copies
			for(String s: copyDataList) System.out.println(s);
			System.out.println("\nTiene que pedir un préstamo.\n");
			//Go to leading menu
			LendingsUi.showLendingsUi();
		}//if
		else
		{
		// here you check if there is any copy without ever lending
		   if (rd.checkLendingAnyCopyBookExist(bookId)) { 
		//	   System.out.println("CASO 2: alguna copia prestada alguna vez, y otras sin prestar nunca");
			  
			 //Get Copies to show
				copyDataList= rd.getAvailableCopiesAlternative(bookId);
				System.out.println("No se puede realizar la reserva.\n"
								+ "El libro esta disponible para su prestamo.\n"
								+ "Copias disponibles : \n");
				//Show copies
				for(String s: copyDataList) System.out.println(s);
				System.out.println("\nTiene que pedir un préstamo.\n");
				LendingsUi.showLendingsUi();
		   }else {	   
			//At this point, there's no previous reservation of the book, 
			//so it proceeds with creating reservation process
			copyDataList= rd.getAvailableCopies(bookId);
			if (copyDataList.isEmpty())
			{
		//		System.out.println("CASO 3: todas las copias prestadas y todas devueltas");
				//Reservation can be done!
				//Only rest to ask for the user id
				System.out.println("Introduzca el id del ususario: ");
				do 
				{
					userId = InputUserData.checkUserInput("id", "Inserte un id valido (entero positivo)");
					if(userId.equals("")) {
						System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
					}else {
					// check User exist
						UserController uc = new UserController();
						if (!uc.checkUserId(Integer.parseInt(userId))) {
							System.out.println("Este usuario no existe. Introduzca un usuario válido");
							userId= "";
						}
					}
				}while(userId.equals(""));
				
				//Insert the reservation on the bbdd
				Reservation reserv= new Reservation(1, bookId, Integer.parseInt(userId));
				rd.addReservation(reserv);
				
				System.out.println("La reserva se ha realizado con exito.");
				
				//Back to the main menu
				StartMenuUI.showStartMenuUi();
			}else{
		//			System.out.println("CASO 4: todas las copias prestadas y alguna se ha vuelto a prestar");
					System.out.println("No se puede realizar la reserva.\n"
							+ "El libro esta disponible para su prestamo.\n"
							+ "Copias disponibles : \n");
					//Show copies
					for(String s: copyDataList) System.out.println(s);
					System.out.println("\nTiene que pedir un préstamo.\n");
					LendingsUi.showLendingsUi();
			}
		   }	
			
		}//else
	}//createNewReservation()	
	
	/**
	 * Get the reservationData
	 * 
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
	 * 
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
	
	/**
	 * method to get a reservation list by idUser
	 * 
	 * @param user's id
	 * @return reservationList
	 */
	
	public List<Reservation> getReservationsByIdUser(int id)
	{	
		List<Reservation> reservationList = rd.getReservationsByIdUser(id);	
		return reservationList;
	}//getReservationListByIdUser
		
	
}//class ReservationController