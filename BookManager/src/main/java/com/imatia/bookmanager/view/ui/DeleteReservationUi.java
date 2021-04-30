package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.DeleteReservationMenu;

/**
 * This is the ui to show when the user selects to cancel a reservation
 */
public class DeleteReservationUi
{
	public static void showDeleteReservationUi()
	{
		System.out.println(
				"\n**********************\r\n" + 
				"** CANCELAR RESERVA **\r\n" + 
				"**********************\r\n" + 
				"-------------------------------------------------------\r\n" + 
				"|| Introduzca el id de la reserva que desea cancelar ||\r\n" + 
				"-------------------------------------------------------");
		DeleteReservationMenu.showDeleteReservationMenu();
	}//showDeleteReservationUi()
}//class DeleteReservationUi