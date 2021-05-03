package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.model.entities.Reservation;

/*
 * method which receives a list of reservations
 * and prints its data
 */
public class ReservationRenderers
{
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