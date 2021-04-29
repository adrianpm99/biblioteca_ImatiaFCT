package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.ReservationController;
import com.imatia.bookmanager.view.inputs.InputUserData;

public class AddReservationMenu {

	@SuppressWarnings("static-access")
	public static void showAddReservationMenu() {
		String id;
		do {
			id = InputUserData.checkUserInput("id", "Inserte un id valido");
		}while(id.equals(""));
		
		ReservationController rc = new ReservationController();
		rc.createNewReservation(Integer.parseInt(id));
		
	}// showAddReservationMenu()
}// class AddReservationMenu
