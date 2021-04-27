package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.ReservationMenu;

public class ReservationUi {
	public static void showReservationUi()
	{
		System.out.println(
				"**************\r\n" + 
				"** RESERVAS **\r\n" + 
				"**************\r\n" + 
				"------------------------------------------------------\r\n" + 
				"|| 1- Añadir Reserva || 0- Volver al menu principal ||\r\n" + 
				"------------------------------------------------------");
		ReservationMenu.showReservationOptions();
	}//showReservationUiUi()
}//class ReservationUi
