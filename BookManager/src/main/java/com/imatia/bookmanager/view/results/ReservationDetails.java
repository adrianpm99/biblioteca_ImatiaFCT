package com.imatia.bookmanager.view.results;

import java.util.ArrayList;

public class ReservationDetails {
	
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
}//class ReservationDetails

