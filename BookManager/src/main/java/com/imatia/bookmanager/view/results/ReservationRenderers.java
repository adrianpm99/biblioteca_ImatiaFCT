package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.model.entities.Reservation;

/**
 * These utils recieve a list of Reservations and then print specific data
 */

public class ReservationRenderers
{
	/**
	 * shows Reservation ID, bookId and userId 
	 */
	
	public static void renderReservationsList(List<Reservation> reservationList)
	{
		for(Reservation r: reservationList)
		{
			System.out.println("===========================================================================================\n");
			System.out.println("Id de la Reserva: "+r.getReservationId()+
								"\t|| Id del Libro: "+r.getBookId()+
								"\t|| Id del Usuario: "+r.getUserId()+"\n"); 		
		}
	}//renderReservationsList
	
}//class ReservationRenderers