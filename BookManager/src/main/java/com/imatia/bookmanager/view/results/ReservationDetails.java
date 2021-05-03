package com.imatia.bookmanager.view.results;

import java.util.ArrayList;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.Reservation;
import com.imatia.bookmanager.view.menus.ReservationDetailsMenu;
/*
 * class to show the Reservation details
 */
public class ReservationDetails {
	
	/**
	 * method to print a Reservation details, receiving a ArrayList of Strings
	 * @param al
	 */
	public static void showReservationDetails(ArrayList<String> al) {
	
		System.out.println(
	
			"************************\r\n" + 
			"** EXISTE UNA RESERVA **\r\n" + 
			"************************\r\n" +
			"|| Id Reserva: "+al.get(0)+"\r\n" + 
			"||	\r\n" + 
			"|| Id Libro: "+al.get(1)+"\r\n" + 
			"||	\r\n" + 
			"|| Titulo: "+al.get(2)+"\r\n" + 
			"||	\r\n" + 
			"|| Id Usuario: "+al.get(3)+"\r\n" + 
			"||	\r\n" + 
			"|| Nombre: "+al.get(4)+"\r\n" + 
			"||	\r\n" + 
			"|| Apellidos: "+al.get(5)+"\r\n" +
			"================================================\r\n");

	}//ShowReservationDetails()
	
	/**
	 * method to print a reservation details, receiving a Reservation
	 * @param res
	 */
	public static void showReservationDetails(Reservation res) {
		
		System.out.println(
	
			"************************\r\n" + 
			"** DETALLES RESERVA **\r\n" + 
			"************************\r\n" +
			"|| Id Reserva: "+res.getReservationId()+"\r\n" + 
			"||	\r\n" + 
			"|| Id Libro: "+res.getBookId()+"\r\n" + 
			"||	\r\n" + 
			"|| Titulo: "+new BookController().getBookById(res.getBookId()).getTitle()+"\r\n" + 
			"||	\r\n" + 
			"|| Id Usuario: "+res.getUserId()+"\r\n" + 
			"||	\r\n" + 
			"|| Nombre: "+new UserController().getUserById(res.getUserId()).getUserName()+"\r\n" + 
			"||	\r\n" + 
			"|| Apellidos: "+new UserController().getUserById(res.getUserId()).getUserSurname()+"\r\n" +
			"================================================\r\n");
		
		ReservationDetailsMenu.showReservationDetailsMenu();

	}//ShowReservationDetails()
}//class ReservationDetails

