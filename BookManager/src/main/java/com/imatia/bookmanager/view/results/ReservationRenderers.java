package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.model.entities.Reservation;

/*
 * this is the class that receiving a list of reservation
 * print specific data
 */
public class ReservationRenderers {
	public static void renderListReservations(List<Reservation> reservationList)
	{
		for(Reservation r: reservationList)
		{
			System.out.println("===========================================================================================\n");
			System.out.println("Id Reserva: "+r.getReservationId()+
								"\t|| Id Usuario: "+r.getUserId()+"\n"); 
					
		}
	}//renderListUsers

}
