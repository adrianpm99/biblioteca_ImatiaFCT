package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.ReservationMenu;

/**
 * Reservations Menu, to add a reservation, cancel it, or go back.
 */
public class ReservationUi
{
	public static void showReservationUi()
	{
		System.out.println(
				"\n**************\r\n" + 
				"** RESERVAS **\r\n" + 
				"**************\r\n" + 
				"---------------------------------------------------------------------------------------------------\r\n" + 
				"|| 1- Añadir Reserva || 2- Cancelar Reserva || 3- Buscar Reservas || 0- Volver al menu principal ||\r\n" + 
				"---------------------------------------------------------------------------------------------------");
		
		ReservationMenu.showReservationOptions();
	}//showReservationUiUi()
}//class ReservationUi
