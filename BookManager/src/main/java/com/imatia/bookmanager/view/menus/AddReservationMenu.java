package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.ReservationController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.ReservationUi;

/**
 * Class to show the add reservation menu
 * 
 * @author Grupo2FCTImatia
 */

public class AddReservationMenu {

	public static void showAddReservationMenu() {

		ReservationController rc = new ReservationController();

		Book book = null;
		String id;

		do {

			// Ask for the bookId
			id = InputUserData.checkUserInput("id", "Inserte un id valido");

		} while (id.equals(""));

		// Insert the book with the bookId
		book = new BookController().getBookById(Integer.parseInt(id));

		// Check if the book exists
		if (book == null) {

			System.out.println("No existe ningún libro con el id facilitado");

			// Go to the ReservationUi
			ReservationUi.showReservationUi();

		} else {

			// Add a new Reservation to the database
			// Rest of checks inside
			rc.createNewReservation(Integer.parseInt(id));
		}

	}// showAddReservationMenu()

}// class AddReservationMenu
