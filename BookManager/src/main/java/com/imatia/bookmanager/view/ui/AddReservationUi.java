package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.AddReservationMenu;

//import com.imatia.bookmanager.view.menus.AddReservationMenu;

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
