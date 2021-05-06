package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.AddReservationMenu;

/**
 * This is the UI for the Add Reservation menu.
 */

public class AddReservationUi {
	public static void showAddReservationUi() {
		System.out.println(
				"\n**************************\r\n" + 
				"** AÑADIR NUEVA RESERVA **\r\n" + 
				"**************************\r\n" + 
				"--------------------------------\r\n" + 
				"|| Introduzca el id del libro ||\r\n" + 
				"--------------------------------");
		
		AddReservationMenu.showAddReservationMenu();
		
	}//showAddReservationUi()
}//AddReservationUi
