package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;

public class AddReservationMenu {

	public static void showAddReservationMenu() {
		String id;
		do {
			id = InputUserData.checkUserInput("id", "Inserte un id valido)");
		}while(id.equals(""));
		//ReservationController.(id);
		
	}// showAddReservationMenu()
}// class AddReservationMenu
