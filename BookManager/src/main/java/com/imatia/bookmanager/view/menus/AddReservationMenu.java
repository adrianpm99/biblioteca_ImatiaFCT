package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.ReservationController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.ReservationUi;

/*
 * class to show the add reservation menu
 */
public class AddReservationMenu {


	public static void showAddReservationMenu() {
		
		String id;
		
		do {
			id = InputUserData.checkUserInput("id", "Inserte un id valido");
		}while(id.equals(""));
		
		ReservationController rc = new ReservationController();
		Book book = new BookController().getBookById(Integer.parseInt(id));
		if(book == null) {
			System.out.println("No existe ningún libro con el id facilitado");
			ReservationUi.showReservationUi();
		}else {
			rc.createNewReservation(Integer.parseInt(id));
		}
		
	}// showAddReservationMenu()
}// class AddReservationMenu
