package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.SearchReservationMenu;

/*
 * this is the class to show the search Reservation Ui
 */
public class SearchReservationUi
{
	public static void showSearchReservationUi()
	{
		System.out.println(
				
				"\n*********************\r\n" + 
				"** BUSCAR RESERVAS **\r\n" + 
				"*********************\r\n" + 
				"---------------------------------------------------------------------------------\r\n" + 
				"|| 1- Buscar por libro || 2- Buscar por usuario || 0- Volver al menu principal ||\r\n" + 
				"---------------------------------------------------------------------------------");
		
		SearchReservationMenu.showSeachReservationMenuOptions();
	}//showSearchReservationUi()
}//class SearchReservationUi